package UI;

import Model.CPU;
import Model.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryPage extends JFrame {
    //MODEL COMPONENTS
    private CPU cpu;


    //SWING COMPONENTS
    private JLabel memName = new JLabel();
    private JLabel memFreq = new JLabel();
    private JLabel memCapa = new JLabel();
    private JLabel memType = new JLabel();

    private JLabel nameTxt = new JLabel();
    private JLabel freqTxt = new JLabel();
    private JPanel contentPanel = new JPanel();
    private JLabel typeTxt = new JLabel();
    private JLabel capaTxt = new JLabel();

    private JButton btnBack = new JButton("BACK");

    public MemoryPage(CPU cpu, Memory mem, JFrame mainFrame){
        this.cpu = cpu;
        this.setLayout(null);

        contentPanel.setLayout(null);
        contentPanel.setSize(500, 500);
        contentPanel.setBackground(Color.BLACK);

        memName.setBounds(10, 60, 250,  50);
        memName.setText("Manufacturer of RAM MEMORY : ");
        memName.setFont(new Font("Calibri", Font.BOLD, 15));
        memName.setForeground(Color.GREEN);
        contentPanel.add(memName);

        nameTxt.setText(mem.getName());
        nameTxt.setBounds(260, 60, 250, 50);
        nameTxt.setForeground(Color.GREEN);
        nameTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        contentPanel.add(nameTxt);

        memFreq.setBounds(10, 130, 250, 50);
        memFreq.setFont(new Font("Calibri", Font.BOLD, 15));
        memFreq.setForeground(Color.GREEN);
        memFreq.setText("Memory frequency is : ");
        contentPanel.add(memFreq);


        freqTxt.setBounds(260, 130, 250, 50);
        freqTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        freqTxt.setForeground(Color.GREEN);
        freqTxt.setText(mem.getFreq()/1000000  + " MHz");
        contentPanel.add(freqTxt);

        memCapa.setText("RAM memory capacity is :  ");
        memCapa.setFont(new Font("Calibri", Font.BOLD, 15));
        memCapa.setForeground(Color.GREEN);
        memCapa.setBounds(10, 200, 250, 50);
        contentPanel.add(memCapa);

        //String capacity = String.valueOf(mem.getCapacity());
        capaTxt.setText(String.format("%.1f GB", mem.getCapacity()/ (1024.0 * 1024.0 * 1024.0)));
        capaTxt.setBounds(260, 200, 250, 50);
        capaTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        capaTxt.setForeground(Color.GREEN);
        contentPanel.add(capaTxt);

        memType.setBounds(10, 270, 250, 50);
        memType.setText("Nr. of physical cores : ");
        memType.setFont(new Font("Calibri", Font.BOLD, 15));
        memType.setForeground(Color.GREEN);
        contentPanel.add(memType);

        String type;
        if(mem.getType().equals("Unknown"))
            type = "DDR5";
        else
            type = mem.getType();
        typeTxt.setText(type);
        typeTxt.setFont(new Font("Calibri", Font.BOLD, 15));
        typeTxt.setForeground(Color.GREEN);
        typeTxt.setBounds(260, 270, 250, 50);
        contentPanel.add(typeTxt);

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
                MainPage mainPage = new MainPage(cpu, mem, mainFrame);
                mainFrame.remove(contentPanel);
                mainFrame.add(mainPage.getContentPanel());
                mainFrame.repaint();
            }
        });



    }

    public JPanel getContenPanel(){
        return contentPanel;
    }
}
