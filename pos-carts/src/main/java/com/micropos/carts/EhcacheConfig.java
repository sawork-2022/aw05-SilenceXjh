package com.micropos.carts;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhcacheConfig {

  @Bean
  public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
    return new EhCacheCacheManager(bean.getObject());
  }

  @Bean
  public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
    EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    cacheManagerFactoryBean.setShared(true);
    return cacheManagerFactoryBean;
  }

}
