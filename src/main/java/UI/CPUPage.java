package UI;

import Model.CPU;
import Model.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPUPage extends JPanel{
    //MODEL COMPONENTS
    private CPU cpu;


    //SWING COMPONENTS
    //private JFrame frame = new JFrame();
    private JLabel cpuName = new JLabel();
    private JLabel cpuFreq = new JLabel();
    private JLabel cpuLogic = new JLabel();
    private JLabel cpuPhys = new JLabel();

    private JLabel nameTxt = new JLabel();
    private JLabel freqTxt = new JLabel();
    private JPanel contentPanel = new JPanel();
    private JLabel logicTxt = new JLabel();
    private JLabel physTxt = new JLabel();

    private JButton btnBack = new JButton("BACK");

    public CPUPage(CPU cpu, Memory mem, JFrame mainFrame){
        this.cpu = cpu;
        this.setLayout(null);

        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setSize(500, 500);

        cpuName.setBounds(10, 60, 250,  50);
        cpuName.setForeground(Color.GREEN);
        cpuName.setFont(new Font("Calibri", Font.BOLD, 15));
        cpuName.setText("Central Processing Unit (CPU) : ");
        contentPanel.add(cpuName);

        nameTxt.setText(cpu.getName());
        nameTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        nameTxt.setForeground(Color.GREEN);
        nameTxt.setBounds(230, 60, 250, 50);
        contentPanel.add(nameTxt);

        cpuFreq.setBounds(10, 130, 250, 50);
        cpuFreq.setFont(new Font("Calibri", Font.BOLD, 15));
        cpuFreq.setForeground(Color.GREEN);
        cpuFreq.setText("CPU max frequency (GHz) :");
        contentPanel.add(cpuFreq);

        freqTxt.setBounds(230, 130, 250, 50);
        freqTxt.setForeground(Color.GREEN);
        freqTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        freqTxt.setText(String.valueOf(cpu.getMaxFreq()) + " GHz");
        contentPanel.add(freqTxt);

        cpuLogic.setText("Nr. of logical cores : ");
        cpuLogic.setForeground(Color.GREEN);
        cpuLogic.setFont(new Font("Calibri", Font.BOLD, 15));
        cpuLogic.setBounds(10, 200, 250, 50);
        contentPanel.add(cpuLogic);

        logicTxt.setText(String.valueOf(cpu.getLogicalProc()) + " logical processors");
        logicTxt.setBounds(230, 200, 250, 50);
        logicTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        logicTxt.setForeground(Color.GREEN);
        contentPanel.add(logicTxt);

        cpuPhys.setBounds(10, 270, 250, 50);
        cpuPhys.setText("Nr. of physical cores : ");
        cpuPhys.setFont(new Font("Calibri", Font.BOLD, 15));
        cpuPhys.setForeground(Color.GREEN);
        contentPanel.add(cpuPhys);

        physTxt.setText(String.valueOf(cpu.getPhysicalProc()) + " physical cores");
        physTxt.setBounds(230, 270, 250, 50);
        physTxt.setForeground(Color.GREEN);
        physTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        contentPanel.add(physTxt);

        btnBack.setBounds(200, 400, 100, 25);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.GREEN);
        btnBack.setContentAreaFilled(false);
        btnBack.setFont(new Font("Calibri", Font.BOLD, 25));
        btnBack.setFocusPainted(false);
        btnBack.setBorder(null);
        contentPanel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.remove(contentPanel);
                MainPage mainPage = new MainPage(cpu, mem, mainFrame);
                mainFrame.add(mainPage.getContentPanel());
                mainFrame.repaint();
            }
        });



    }

    public JPanel getContentPanel(){
        return contentPanel;
    }


}
