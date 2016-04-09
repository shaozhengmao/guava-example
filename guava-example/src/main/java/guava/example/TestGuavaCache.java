package guava.example;

import java.util.concurrent.Callable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TestGuavaCache {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TestLoadingCache();

	}
	
	public static void TestLoadingCache() throws Exception{
        LoadingCache<String,String> cahceBuilder=CacheBuilder
        .newBuilder()
        .build(new CacheLoader<String, String>(){
            @Override
            public String load(String key) throws Exception {        
                String strProValue="hello "+key+"!";                
                return strProValue;
            }
            
        });        
        
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("lisa value:"+cahceBuilder.get("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:"+cahceBuilder.get("harry"));
    }
	
	
	public static void testcallableCache()throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();  
        String resultVal = cache.get("jerry", new Callable<String>() {  
            public String call() {  
                String strProValue="hello "+"jerry"+"!";                
                return strProValue;
            }  
        });  
        System.out.println("jerry value : " + resultVal);
        
        resultVal = cache.get("peida", new Callable<String>() {  
            public String call() {  
                String strProValue="hello "+"peida"+"!";                
                return strProValue;
            }  
        });  
        System.out.println("peida value : " + resultVal);  
    }

}
