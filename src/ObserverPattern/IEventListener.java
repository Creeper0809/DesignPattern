package ObserverPattern;

public interface IEventListener<T> {
    void OnEvent( T eventType );
}
