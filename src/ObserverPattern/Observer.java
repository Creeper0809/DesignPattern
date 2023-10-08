package ObserverPattern;

public class Observer implements IEventListener<Subject> {
    public Observer(){
        EventManager.addListener(Subject.class,this);
    }
    @Override
    public void OnEvent(Subject subject) {
        switch (subject.e){
            case DIE -> System.out.println(this.getClass() + ": 죽었다!");
            case LIFE -> System.out.println(this.getClass() + ": 살았다!");
        }
    }
    public void onDead(){
        EventManager.removeListener(Subject.class,this);
    }
}
