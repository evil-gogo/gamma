package design.lld.builder_design_pattern;

public class DesktopDirector {
    public Desktop buildDesktop(DesktopBuilder builder) {
        builder.buildMotherboard();
        builder.buildProcessor();
        builder.buildMemory();
        builder.buildStorage();
        builder.buildGraphicsCard();
        return builder.getDesktop();
    }
}
