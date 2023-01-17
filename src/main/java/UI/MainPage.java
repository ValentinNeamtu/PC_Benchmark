package UI;

import Model.CPU;
import Model.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    //private JFrame frame = new JFrame();
    private JPanel contentPanel = new JPanel();
    private JButton btnCpu = new JButton();
    private JButton btnMemory = new JButton();
    private JButton btnSpeed = new JButton();


    public MainPage(CPU cpu, Memory mem, JFrame mainFrame){
        contentPanel.setSize(500, 500);
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.BLACK);

        btnCpu.setText("CPU INFO");
        btnCpu.setBounds(150, 50, 200, 100);
        btnCpu.setBackground(Color.BLACK);
        btnCpu.setForeground(Color.GREEN);
        btnCpu.setContentAreaFilled(false);
        btnCpu.setFont(new Font("Calibri", Font.BOLD, 25));
        btnCpu.setFocusPainted(false);
        btnCpu.setBorder(null);
        btnCpu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.remove(contentPanel);
                CPUPage cpuPage = new CPUPage(cpu, mem, mainFrame);
                mainFrame.add(cpuPage.getContentPanel());
                mainFrame.repaint();
            }
        });
        contentPanel.add(btnCpu);

        btnMemory.setText("Memory INFO");
        btnMemory.setBounds(150, 200, 200, 100);
        btnMemory.setBackground(Color.BLACK);
        btnMemory.setForeground(Color.GREEN);
        //button.setFont(new Font("Arial", Font.PLAIN, 40));
        btnMemory.setFont(new Font("Calibri", Font.BOLD, 25));
        btnMemory.setContentAreaFilled(false);
        btnMemory.setBorder(null);
        btnMemory.setFocusPainted(false);
        btnMemory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemoryPage memoryPage = new MemoryPage(cpu, mem, mainFrame);
                mainFrame.remove(contentPanel);
                mainFrame.add(memoryPage.getContenPanel());
                mainFrame.repaint();
            }
        });
        contentPanel.add(btnMemory);

        btnSpeed.setText("Test SSD SPEED");
        btnSpeed.setBackground(Color.BLACK);
        btnSpeed.setForeground(Color.GREEN);
        btnSpeed.setFont(new Font("Calibri", Font.BOLD, 25));
        btnSpeed.setBounds(150, 350, 200, 100);
        btnSpeed.setContentAreaFilled(false);
        btnSpeed.setBorder(null);
        btnSpeed.setFocusPainted(false);
        btnSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.remove(contentPanel);
                SpeedPage speedPage = new SpeedPage(cpu, mem, mainFrame);
                mainFrame.add(speedPage.getContentPanel());
                mainFrame.repaint();
            }
        });
        contentPanel.add(btnSpeed);
    }

    public JPanel getContentPanel(){
        return contentPanel;
    }
}
