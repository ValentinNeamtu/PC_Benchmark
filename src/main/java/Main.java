import Model.CPU;
import Model.Memory;
import UI.CPUPage;
import UI.MainFrame;
import UI.MainPage;
import oshi.driver.windows.perfmon.MemoryInformation;
import oshi.hardware.CentralProcessor;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.PhysicalMemory;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
public class Main {

    public static void main(String[] args){
        CentralProcessor cpu = new SystemInfo().getHardware().getProcessor();
        String name = cpu.getProcessorIdentifier().getName();
        int physicalCore = cpu.getPhysicalProcessorCount();
        int logicalCore = cpu.getLogicalProcessorCount();
        double maxFreq = (cpu.getMaxFreq()/100000000)/10.0;
        //PROCESSOR CREATION
        CPU proc = new CPU(name, physicalCore, logicalCore, maxFreq);

        GlobalMemory gMem = new SystemInfo().getHardware().getMemory();
        PhysicalMemory phMem = gMem.getPhysicalMemory().get(0);
        Memory mem = new Memory(phMem.getManufacturer(), phMem.getClockSpeed(), gMem.getTotal(), phMem.getMemoryType());

        MainFrame mainFrame = new MainFrame();
        MainPage mainPage = new MainPage(proc, mem, mainFrame.getFrame());
        mainFrame.getFrame().add(mainPage.getContentPanel());
        mainFrame.getFrame().setVisible(true);


        //cpuPage.getFrame().setVisible(true);
    }

}
