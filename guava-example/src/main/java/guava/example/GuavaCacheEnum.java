package guava.example;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * guava cache singleton 
 * for txidmanage
 * @author zhengmiao
 *
 */
public enum GuavaCacheEnum {
	INSTANCE();
	private final  LoadingCache<String,Object> cahceBuilder=CacheBuilder
	        .newBuilder()
	        .build(new CacheLoader<String, Object>(){
	            @Override
	            public String load(String key) throws Exception {        
	                String strProValue="hello "+key+"!";                
	                return strProValue;
	            }
	            
	        });        
	
	public LoadingCache<String,Object> getLoadingCacheService(){
		return cahceBuilder;
    }
}
