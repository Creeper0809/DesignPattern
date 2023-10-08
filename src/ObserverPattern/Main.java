package ObserverPattern;

import ObserverPattern.Observer;

public class Main {
    public static void main(String[] args) {
        Observer o = new Observer();
        Observer2 o2 = new Observer2();
        Subject.trigger(Event.LIFE);
        System.out.println("----------------------------------");
        Subject e = new Subject(Event.LIFE);
        o2.register(e);
        e.trigger();
        System.out.println("----------------------------------");
        o2.deregister(e);
        e.trigger();
    }
}
