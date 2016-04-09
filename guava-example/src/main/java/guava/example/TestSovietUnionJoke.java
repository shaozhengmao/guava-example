package guava.example;
import java.util.concurrent.TimeUnit;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author shaozhengmao
 */
public class TestSovietUnionJoke {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus("sovietUnionJoke");
        KGBListener kbgListener = new KGBListener();
        OldMan oldMan = new OldMan();
        eventBus.register(kbgListener);
        if(oldMan.isFallIntoTheWater()){
            eventBus.post(oldMan.help());
            TimeUnit.SECONDS.sleep(5);
            eventBus.post(oldMan.hitBrezhnev());
        }
    }
    
    static class OldMan{
        static final Help HELP = new Help("help!!!");
        static final HitBrezhnev HitBREZHNEV = new HitBrezhnev("hit Brezhnev!!!");
        public boolean isFallIntoTheWater(){
            return true;
        }
        
        public Help help(){
            return HELP;
        }
        
        public HitBrezhnev hitBrezhnev(){
            return HitBREZHNEV;
        }
    }
    
    static class Help {
        private final String message;
        public Help(String message) {        
            this.message = message;
            System.out.println("Help message:"+message);
        }
        public String getMessage() {
            return message;
        }
    }
    
    static class HitBrezhnev {
        private final String message;
        public HitBrezhnev(String message) {        
            this.message = message;
            System.out.println("HitBrezhnev message:"+message);
        }
        public String getMessage() {
            return message;
        }
    }
    
    static class KGBListener {
       
        @Subscribe  
        public void listenHelp(Help event) {  
            System.out.println("the kgb receive the message:"+event.getMessage()+",but ignore.");
        }  
       
        @Subscribe  
        public void listenHitBrezhnev(HitBrezhnev event) {  
            System.out.println("the kgb receive the message:"+event.getMessage()+", then arrest this oldMan.");
        }  
    }
    
}

