package UI;

import Model.CPU;
import Model.Memory;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;

import static java.lang.Thread.sleep;

public class SpeedPage implements Runnable {
    //NECESSARY VARIABLES
    public volatile int times = 0;
    public volatile int poz = 2;
    //private Thread threadSSD = new Thread();

    //SWING COMPONENTS
    private JProgressBar progressSSD = new JProgressBar();
    private JProgressBar progressALU = new JProgressBar();
    private JPanel contentPanel = new JPanel();
    private JLabel SSDResult = new JLabel();
    private JLabel ALUResult = new JLabel();
    private JLabel hello = new JLabel();
    private JButton btnStartSSD = new JButton();
    private JButton btnStartALU = new JButton();
    private JButton btnBack = new JButton();

    private Thread t1 = new Thread();
    private Thread t2 = new Thread();
    private Thread t3 = new Thread();
    private Thread t4 = new Thread();

    public SpeedPage (CPU cpu, Memory mem, JFrame mainFrame){

        contentPanel.setSize(500, 500);
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setBounds(0, 0, 500, 500);
        contentPanel.setLayout(null);

        hello.setBounds(150, 15, 300, 50);
        hello.setText("SSD Speed test page");
        hello.setForeground(Color.GREEN);
        hello.setFont(new Font("Calibri", Font.BOLD, 25));
        hello.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPanel.add(hello);

        progressSSD.setBounds(50, 175, 250, 25);
        progressSSD.setMaximum(10);
        progressSSD.setMinimum(0);
        progressSSD.setStringPainted(true);
        progressSSD.setString("PROGRESS");
        progressSSD.setValue(0);
        progressSSD.setBackground(Color.BLACK);
        progressSSD.setForeground(Color.GREEN);
        progressSSD.setUI((ProgressBarUI) BasicProgressBarUI.createUI(progressSSD));
        progressSSD.setBorder(null);
        progressSSD.setOrientation(SwingConstants.HORIZONTAL);
        contentPanel.add(progressSSD);

        progressALU.setBounds(50, 350, 250, 25);
        progressALU.setMaximum(500000);
        progressALU.setMinimum(1);
        progressALU.setStringPainted(true);
        progressALU.setString("PROGRESS");
        progressALU.setValue(1);
        progressALU.setBackground(Color.BLACK);
        progressALU.setForeground(Color.GREEN);
        progressALU.setUI((ProgressBarUI) BasicProgressBarUI.createUI(progressALU));
        progressALU.setBorder(null);
        progressALU.setOrientation(SwingConstants.HORIZONTAL);
        contentPanel.add(progressALU);

        SSDResult.setBounds(325, 180, 150, 25);
        SSDResult.setText("NAN");
        SSDResult.setHorizontalTextPosition(SwingConstants.CENTER);
        SSDResult.setFont(new Font("Calibri", Font.BOLD, 15));
        SSDResult.setForeground(Color.GREEN);
        contentPanel.add(SSDResult);

        ALUResult.setBounds(325, 350, 150, 25);
        ALUResult.setText("NAN");
        ALUResult.setHorizontalTextPosition(SwingConstants.CENTER);
        ALUResult.setFont(new Font("Calibri", Font.BOLD, 15));
        ALUResult.setForeground(Color.GREEN);
        contentPanel.add(ALUResult);

        btnStartSSD.setText("Test SSD");
        btnStartSSD.setBounds(200, 125, 100, 25);
        btnStartSSD.setBackground(Color.BLACK);
        btnStartSSD.setForeground(Color.GREEN);
        btnStartSSD.setContentAreaFilled(false);
        btnStartSSD.setFont(new Font("Calibri", Font.BOLD, 25));
        btnStartSSD.setFocusPainted(false);
        btnStartSSD.setBorder(null);
        btnStartSSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SpeedPage thread = new moveFile();
                //THREAD care sa porneasca si thread care sa faca update
                //new Thread(new SpeedPage(cpu, mem)).start();
                t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        moveFile();
                        try {
                            sleep(1500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        progressSSD.setString("Progress");
                        progressSSD.setValue(0);
                    }
                });

                t1.start();
            }
        });
        contentPanel.add(btnStartSSD);

        btnStartALU.setText("Test ALU");
        btnStartALU.setBounds(200, 295, 100, 25);
        btnStartALU.setBackground(Color.BLACK);
        btnStartALU.setForeground(Color.GREEN);
        btnStartALU.setContentAreaFilled(false);
        btnStartALU.setFont(new Font("Calibri", Font.BOLD, 25));
        btnStartALU.setFocusPainted(false);
        btnStartALU.setBorder(null);
        btnStartALU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doAlu();
                        try{
                            sleep(1500);
                        }catch (InterruptedException exc){
                            throw new RuntimeException();
                        }
                        progressALU.setString("Progress");
                        progressALU.setValue(2);
                    }
                });

                t3.start();
            }
        });
        contentPanel.add(btnStartALU);


        btnBack.setText("Back");
        btnBack.setBounds(400, 425, 75, 25);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.GREEN);
        btnBack.setContentAreaFilled(false);
        btnBack.setFont(new Font("Calibri", Font.BOLD, 25));
        btnBack.setFocusPainted(false);
        btnBack.setBorder(null);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t1.stop();//it is safe to kill the threads because of the
                t2.stop();//fact that we dispose of the page so the threads are no longer
                t3.stop();//of use to us
                t4.stop();

                mainFrame.remove(contentPanel);
                MainPage mainPage = new MainPage(cpu, mem, mainFrame);
                mainFrame.add(mainPage.getContentPanel());
                mainFrame.repaint();
            }
        });
        contentPanel.add(btnBack);
    }

    public void moveFile(){
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(times != 0){
                    progressSSD.setValue(10 - times);
                    progressSSD.setString((10 - times) + " out of " + 10 + " done");
                    contentPanel.repaint();
                }
            }
        });

        t2.start();

        progressSSD.setValue(0);

        double seconds = 0.0;
        times = 10;
        while(times != 0){


            long start = System.nanoTime();
            try{
                File original = new File(
                        "put yout path");
                File copied = new File(
                        "put your path");
                FileUtils.copyFile(original, copied);

            }catch (IOException ex){
                System.out.println("ERROR while copying the file");
            }
            times--;
            long finish = System.nanoTime();
            long actualTime = finish - start;
            seconds = ((int)(actualTime/10000000))/100.0 + seconds;
        }

        seconds = seconds / 10.0;
        DecimalFormat dc = new DecimalFormat("0.00");
        SSDResult.setText(dc.format(seconds) + "  seconds / 1GB");
        progressSSD.setValue(10 - times);
        progressSSD.setString((10 - times) + " out of " + 10 + " done");
        contentPanel.repaint();
        System.out.printf("it took me %.2f seconds to move a 1GB FILE", seconds);
        //System.out.println("it took me " + seconds + " seconds");
    }

    public void doAlu(){

        t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(poz <= 500000){
                    progressALU.setValue(poz);
                    DecimalFormat dc = new DecimalFormat("0.00");
                    progressALU.setString(dc.format( (poz * 100) / 500000.0 ) + " % ");
                    contentPanel.repaint();
                }
                poz = 0;

            }
        });

        t4.start();

        long start = System.nanoTime();

        //generate the 500000th element of Fibonacci
        BigInteger ter1 = new BigInteger("0");
        BigInteger ter2 = new BigInteger("1");

        while(poz <= 500000){
            BigInteger result = new BigInteger(ter1.add(ter2).toByteArray());//we make de adition
            ter1 = ter2;
            ter2 = result;
            poz++;
        }
        poz = 2;
        long finish = System.nanoTime();
        long actualTime = finish - start;
        double seconds = ((int)(actualTime/10000000))/100.0;
        DecimalFormat dc = new DecimalFormat("0.00");
        ALUResult.setText(dc.format(seconds) + " seconds for ALU");
    }

    public JPanel getContentPanel(){
        return contentPanel;
    }

    @Override
    public void run() {
        //the new thread will have only one scope, tu run the moveFile method
        moveFile();
    }
}
