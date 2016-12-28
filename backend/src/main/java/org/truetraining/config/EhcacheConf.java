package org.truetraining.config;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Service
public class EhcacheConf {

    private final ObjectProvider<MBeanServer> mBeanServerProvider;

    private final CacheManager cacheManager;

    public EhcacheConf(ObjectProvider<MBeanServer> mBeanServerProvider,
                       CacheManager cacheManager) {
        this.mBeanServerProvider = mBeanServerProvider;
        this.cacheManager = cacheManager;
    }

    @PostConstruct
    public void initializeJmx() {
        MBeanServer mBeanServer = mBeanServerProvider.getIfAvailable();
        // You might decide to register on the platform mbean server here or not
        // even bother to inject the mbean server
        if (mBeanServer != null) {
            ManagementService.registerMBeans(cacheManager, mBeanServer,
                    true, true, true, true, true);
        }
    }

}
