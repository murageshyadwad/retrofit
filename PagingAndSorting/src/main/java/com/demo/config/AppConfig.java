package com.demo.config;


import java.util.concurrent.TimeUnit;



import javax.cache.CacheManager;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;



import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class AppConfig {

	public class CaffeineConfiguration {
	    @SuppressWarnings("unchecked")
	    public CacheManager cacheManager(Object CaffeineCacheBuilder) {
	    	CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
	    	caffeineCacheManager.setCaffeine((Caffeine<Object, Object>) CaffeineCacheBuilder);
	    	return cacheManager(CaffeineCacheBuilder);
	    	}

	    	@NonNull Caffeine<Object, Object> CaffeineCacheBuilder(){
	    	return Caffeine.newBuilder()
	    	.initialCapacity(100)
	    	.maximumSize(500)
	    	.expireAfterAccess(10,TimeUnit.MINUTES)
	    	.recordStats();
}
	}}
