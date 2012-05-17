package ua.dudeweather;

import ua.dudeweather.dressup.Dude;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Form extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel timeLabel;

    WeatherChanged weatherChanged1;
    Navigator navigator1;
    Forecaster forecaster1;
    Location currentPos1;
    Weather weather1;
    Info info1;
    Dude dude = new Dude();
    boolean noPeriodN = false;
    boolean noPeriodP = false;

    int curDay = 6; int curHours = 16; int curMin = 30;
    Date curDate = new Date(2012, 5, curDay, curHours, curMin);
    SinglePeriod curPeriod;

    public Form() throws ClassNotFoundException{
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        weatherChanged1 = new WeatherChanged();
        currentPos1 = new Location();
        weather1 = new Weather(50, 15, 3, 760);


        info1 = new Info();
        try {
            info1.readWeatherInfo("D:\\weathersource.ddw");
        } catch (IOException s) {
            return;
        }
        System.out.println(info1.getKnownPeriods().size());

        int curDay = 6; int curHours = 17; int curMin = 0;
        Date curDate = new Date(2012, 5, curDay, curHours, curMin);

        try {
            curPeriod = info1.getCurrentPeriod(info1.getKnownPeriods(), curDate);
        } catch (NoSuchPeriodException e) {
            System.out.println(e.toString());
            return;
        }
        drawPeriod(curPeriod);

        dude.choose_cloth(info1.getKnownPeriods().get(curPeriod));
        dude.draw(textArea1);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });



// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    onPrevious();
                } catch (NoSuchPeriodException ex) {
                    textArea1.setText("");
                    textArea1.append("There's no information on this period");
                }
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onNext();
                } catch (NoSuchPeriodException ex) {
                    textArea1.setText("");
                    textArea1.append("There's no information on this period");
                }
            }
        });
    }

    private void onPrevious() throws NoSuchPeriodException {

        SinglePeriod prevPeriod = null;

        int n = info1.getKnownPeriods().size();
        int i = 0;

        if (noPeriodN) {
            dude.draw(textArea1);
            drawPeriod(curPeriod);
            noPeriodN = false;
            return;
        }
        
        noPeriodP = false;
        
        textArea1.setText("");
        while (i<n) {
            SinglePeriod chkPeriod = info1.getTimePeriods().get(i);
            if (chkPeriod.getTimeBegin() == curPeriod.getTimeBegin() && chkPeriod.getTimeEnd() == curPeriod.getTimeEnd()) {
                try {
                    prevPeriod = info1.getTimePeriods().get(i-1);
                } catch (IndexOutOfBoundsException e) {
                    prevPeriod = null;
                }
                break;
            }
            i++;
        }
        if (prevPeriod == null) {
            noPeriodP = true;
            timeLabel.setText("... - "+curPeriod.getTimeBegin().getHours()+":"+curPeriod.getTimeBegin().getMinutes());
            throw new NoSuchPeriodException();
        }
        curPeriod = prevPeriod;
        Weather prevWeather = info1.getKnownPeriods().get(prevPeriod);
        dude.choose_cloth(prevWeather);
        dude.draw(textArea1);
        this.drawPeriod(prevPeriod);
    }

    private void onNext() throws NoSuchPeriodException{
        SinglePeriod nextPeriod = null;

        int n = info1.getKnownPeriods().size();
        int i = 0;

        if (noPeriodP) {
            dude.draw(textArea1);
            drawPeriod(curPeriod);
            noPeriodP = false;
            return;
        }

        noPeriodN = false;

        textArea1.setText("");
        while (i<n) {
            SinglePeriod chkPeriod = info1.getTimePeriods().get(i);
            if (chkPeriod.getTimeBegin() == curPeriod.getTimeBegin() && chkPeriod.getTimeEnd() == curPeriod.getTimeEnd()) {
                try {
                    nextPeriod = info1.getTimePeriods().get(i+1);
                } catch (IndexOutOfBoundsException e) {
                    nextPeriod = null;
                }
                break;
            }
            i++;
        }
        if (nextPeriod == null) {
            noPeriodN = true;
            timeLabel.setText(curPeriod.getTimeEnd().getHours()+":"+curPeriod.getTimeEnd().getMinutes()+" - ...");
            throw new NoSuchPeriodException();
        }
        curPeriod = nextPeriod;
        Weather prevWeather = info1.getKnownPeriods().get(nextPeriod);
        dude.choose_cloth(prevWeather);
        dude.draw(textArea1);
        this.drawPeriod(nextPeriod);       
    }
    
    private void drawPeriod(SinglePeriod currentPeriod) {
        this.timeLabel.setText(String.valueOf(currentPeriod.getTimeBegin().getHours())+":"+String.valueOf(currentPeriod.getTimeBegin().getMinutes())+" - "+String.valueOf(currentPeriod.getTimeEnd().getHours())+":"+String.valueOf(currentPeriod.getTimeEnd().getMinutes()));
    }
    
    private void onOK() {
// add your code here
         dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws ClassNotFoundException{
        Form dialog = new Form();



        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
