package com.yologger.local_cache.cache;

import com.yologger.local_cache.service.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class MemberCacheEventLogger implements CacheEventListener<Long, MemberDTO> {
    @Override
    public void onEvent(CacheEvent<? extends Long, ? extends MemberDTO> event) {
        log.info("cache event logger message. getKey: {} / getOldValue: {} / getNewValue:{}", event.getKey(), event.getOldValue(), event.getNewValue());
    }
}

