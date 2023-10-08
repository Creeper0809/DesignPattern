package ObserverPattern;

enum Event {
    DIE,
    LIFE
}
public class Subject {
    public Event e;

    public Subject(Event event) {
        this.e = event;
    }
    public static void trigger(Event event) {
        Subject e = new Subject(event);
        EventManager.triggerEvent(e, EventManager.EventType.CLASS);
    }
    public void trigger(){
        EventManager.triggerEvent(this, EventManager.EventType.INSTANCE);
    }
}
