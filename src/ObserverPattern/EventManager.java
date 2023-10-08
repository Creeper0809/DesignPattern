package ObserverPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {
    public enum EventType{
        CLASS,
        INSTANCE
    }
    private static HashMap<Object, List<IEventListener>> subscribersList = new HashMap<>();
    public static <EventType> void addListener(Object eventType, IEventListener<EventType> listener){
        if(!subscribersList.containsKey(eventType))
            subscribersList.put(eventType,new ArrayList<>());
        if(!subscriptionExists(eventType,listener)){
            subscribersList.get(eventType).add(listener);
            System.out.println(listener.getClass() + ":구독");
        }
    }
    public static <EventType> void removeListener(Object eventType, IEventListener<EventType> listener){
        if(!subscribersList.containsKey(eventType))
            return;
        if(!subscriptionExists(eventType,listener))
            return;
        List<IEventListener> subscriberList = subscribersList.get(eventType);
        for(int i = 0;i<subscriberList.size();i++){
            if(subscriberList.get(i) == listener){
                subscriberList.remove(i);
                System.out.println(listener.getClass() + ":구독 취소");
                if(subscriberList.size() == 0)
                    subscribersList.remove(eventType);
                return;
            }
        }
    }
    public static <EventType> void triggerEvent(EventType newEvent, EventManager.EventType type){
        List<IEventListener> list = null;
        switch (type){
            case CLASS -> {
                Class c = newEvent.getClass();
                if (subscribersList.containsKey(c)){
                    System.out.println("클래스 단위의 이벤트 발생");
                    list = subscribersList.get(c);
                }
            }
            case INSTANCE -> {
                if(subscribersList.containsKey(newEvent)){
                    System.out.println("객체 단위의 이벤트 발생");
                    list = subscribersList.get(newEvent);
                }
            }
        }
        if(list == null) return;
        for (IEventListener<EventType> o : list)
        {
            o.OnEvent(newEvent);
        }
    }
    private static boolean subscriptionExists(Object type,IEventListener receiver){
        List<IEventListener> list;
        if(!subscribersList.containsKey(type))
            return false;
        list = subscribersList.get(type);
        for(IEventListener i : list){
            if(i == receiver)
                return true;
        }
        return false;
    }
}
