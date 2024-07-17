package design.lld.observer_design_pattern;

public class ConcreteObserver implements Observer {
    private final String name;
    private final ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(name + " received update. New state is " + subject.getState());
    }
}
