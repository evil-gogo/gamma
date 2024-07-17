package design.lld.observer_design_pattern;

public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer1", subject);
        ConcreteObserver observer2 = new ConcreteObserver("Observer2", subject);

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState(10);
        subject.setState(20);

        subject.detach(observer2);
        subject.setState(30);
    }
}

