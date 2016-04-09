package guava.example;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月16日上午9:54:26
 */
public class TestGuavaEventBus {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");
        /*EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
        ;*/
        
        MultipleListener multiListener = new MultipleListener();  
        
        eventBus.register(multiListener);  
        
        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));  
        eventBus.post(new Integer(300));  
        eventBus.post(new Long(800)); 
        eventBus.post(new Long(800990));  
        eventBus.post(new Long(800882934));  
       
        System.out.println("LastInteger:"+multiListener.getLastInteger());
        System.out.println("LastLong:"+multiListener.getLastLong());
    }
    
    /**
     *<P>
     * Description:消息封装类
     * </p>
     * @author zhengmiao
     * @version 1.0
     * @Date 2015年7月16日
     */
    static class TestEvent {
        private final int message;
        public TestEvent(int message) {        
            this.message = message;
            System.out.println("event message:"+message);
        }
        public int getMessage() {
            return message;
        }
    }
    
    static class NumberListener {  
        
        private Number lastMessage;  
       
        @Subscribe  
        public void listen(Number integer) {  
            lastMessage = integer; 
            System.out.println("Message:"+lastMessage);
        }  
       
        public Number getLastMessage() {  
            return lastMessage;  
        }  
    }  
    
    /**
     * 
     *<P>
     * Description:消息接收类
     * </p>
     * @author zhengmiao
     * @version 1.0
     * @Date 2015年7月16日
     */
    static class EventListener {
        public int lastMessage = 0;

        @Subscribe
        public void listen(TestEvent event) {
            lastMessage = event.getMessage();
            System.out.println("Message:"+lastMessage);
        }

        public int getLastMessage() {      
            return lastMessage;
        }
    }
    
    /**
     * 
     *<P>
     * Description: 多消息接受
     * </p>
     * @author zhengmiao
     * @version 1.0
     * @Date 2015年7月16日
     */
    static class MultipleListener {
        public Integer lastInteger;  
        public Long lastLong;  
       
        @Subscribe  
        public void listenInteger(Integer event) {  
            lastInteger = event; 
            System.out.println("event Integer:"+lastInteger);
        }  
       
        @Subscribe  
        public void listenLong(Long event) {  
            lastLong = event; 
            System.out.println("event Long:"+lastLong);
        }  
       
        public Integer getLastInteger() {  
            return lastInteger;  
        }  
       
        public Long getLastLong() {  
            return lastLong;  
        }  
    }
}
