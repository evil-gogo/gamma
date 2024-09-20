package design.lld.facade_design_pattern;

public class ComputerSystemFacade {
    private final CPU cpu;
    private final Memory memory;
    private final GPU gpu;
    private final DiskDrive diskDrive;
    private final NetworkInterface networkInterface;

    public ComputerSystemFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.gpu = new GPU();
        this.diskDrive = new DiskDrive();
        this.networkInterface = new NetworkInterface();
    }

    public void startComputer() {
        System.out.println("Starting the computer...");
        cpu.powerOn();
        memory.initialize();
        gpu.enableGraphics();
        diskDrive.bootFromDisk();
        networkInterface.connectToNetwork();
        cpu.executeInstructions();
        System.out.println("Computer is ready to use.");
    }
}
