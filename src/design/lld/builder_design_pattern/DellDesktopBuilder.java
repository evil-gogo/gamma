package design.lld.builder_design_pattern;

public class DellDesktopBuilder extends DesktopBuilder {
    public void buildMotherboard() {
        desktop.setMotherboard("Dell Motherboard");
    }

    public void buildProcessor() {
        desktop.setProcessor("Dell Processor");
    }

    public void buildMemory() {
        desktop.setMemory("32GB DDR4 RAM");
    }

    public void buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
    }

    public void buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX 3080");
    }
}
