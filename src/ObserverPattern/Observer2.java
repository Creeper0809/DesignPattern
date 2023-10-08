package ObserverPattern;

public class Observer2 implements IEventListener<Subject> {
    public void register(Subject e){
        EventManager.addListener(e,this);
    }
    public void deregister(Subject e){
        EventManager.removeListener(e,this);
    }
    @Override
    public void OnEvent(Subject subject) {
        switch (subject.e){
            case DIE -> System.out.println(this.getClass() + ": 죽었다!");
            case LIFE -> System.out.println(this.getClass() + ": 살았다!");
        }
    }
}
