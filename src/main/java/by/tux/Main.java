package by.tux;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Main {
    static long i = 0;
    static String alarmTime;
    volatile static public Integer alarmIsStarted = 0;
    public static void main( String[] args ) throws ParseException {
        String m = JOptionPane.showInputDialog(null,"Enter time, then App will be exit:" + "\n" + "FORMAT \"HH:mm:ss\"","",JOptionPane.QUESTION_MESSAGE);
        try {
            alarmTime = new SimpleDateFormat("HH:mm:ss").format(new SimpleDateFormat("HH:mm:ss").parse(m)).toString();
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog( null, "Error input string" + "\n" + e + "\n" + "program is exit","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        JFrame f = new JFrame("Overone Lesson 33 homework");
        f.setResizable(false);
        f.setPreferredSize(new Dimension(400, 120));
        JLabel jLabel1 = new JLabel("                              ");
        JLabel jLabel2 = new JLabel("                              ");

        f.add( new JScrollPane( jLabel1 ), BorderLayout.NORTH );
        f.add( new JScrollPane( jLabel2 ), BorderLayout.CENTER );

        JButton button = new JButton( "" );
        button.setEnabled(false);
        button.addActionListener( e->{
            JOptionPane.showMessageDialog( f, "Thanks for waking up ))" + "\n" + "Click OK for exit" ,"",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } );
        f.add( button, BorderLayout.SOUTH );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.pack();


        Timer timer = new Timer( 200, new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                String currentTime = new SimpleDateFormat("HH:mm:ss").format((new Date())).toString();
                jLabel1.setText("Current time: " + currentTime);
                jLabel2.setText("Alarm set at : " + alarmTime);
                        if ( currentTime.equals(alarmTime) && alarmIsStarted == 0 ) {
                            alarmIsStarted = 1;
                            Runnable runnable =
                                    () -> {
                                        PlayAlarm.playAudio();
                                    };
                            runnable.run();
                            button.setEnabled(true);
                            button.setText("Press the button to turn off the ALARM");
                        }
            }
        } );
        timer.setRepeats( true );
        timer.start();

        f.setVisible( true );
    }

}