package Model;

public class CPU {
    private String name;
    private int physicalProc;
    private int logicalProc;
    private double maxFreq;


    public CPU(String name, int physicalProc, int logicalProc, double maxFreq) {
        this.name = name;
        this.physicalProc = physicalProc;
        this.logicalProc = logicalProc;
        this.maxFreq = maxFreq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysicalProc() {
        return physicalProc;
    }

    public void setPhysicalProc(int physicalProc) {
        this.physicalProc = physicalProc;
    }

    public int getLogicalProc() {
        return logicalProc;
    }

    public void setLogicalProc(int logicalProc) {
        this.logicalProc = logicalProc;
    }

    public double getMaxFreq() {
        return maxFreq;
    }

    public void setMaxFreq(int maxFreq) {
        this.maxFreq = maxFreq;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", physicalProc=" + physicalProc +
                ", logicalProc=" + logicalProc +
                ", maxFreq=" + maxFreq +
                '}';
    }
}
