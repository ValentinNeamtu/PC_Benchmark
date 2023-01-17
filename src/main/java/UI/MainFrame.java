package UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JFrame frame = new JFrame();

    public MainFrame(){
        ImageIcon img = new ImageIcon("C:\\Users\\Valentin\\Desktop\\facultate AN 3\\SSC\\PROIECT\\BenchmarkPC\\img\\img.png");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("PC BENCHMARK");
        frame.setIconImage(img.getImage());
        frame.setLayout(null);
    }

    public JFrame getFrame() {
        return frame;
    }
}
