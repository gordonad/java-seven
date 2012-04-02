package com.gordondickens.javaseven.mxbeans;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class PlatformMXBeansTests {
    private static final Logger logger = LoggerFactory.getLogger(PlatformMXBeansTests.class);

    @Test
    public void runMe() {
        RuntimeMXBean mxBean = ManagementFactory.getPlatformMXBean(RuntimeMXBean.class);

        logger.debug("JVM Name: {}", mxBean.getName());
        logger.debug("JVM Specification Name: {}", mxBean.getSpecName());
        logger.debug("JVM Specification Version: {}", mxBean.getSpecVersion());
        logger.debug("JVM Implemenation Name: {}", mxBean.getVmName());
        logger.debug("JVM Implemenation Vendor: {}", mxBean.getVmVendor());
        logger.debug("JVM Implemenation Version: {}", mxBean.getVmVersion());

        // Using the getPlatformMXBeans method        
        List<OperatingSystemMXBean> list =
                ManagementFactory.getPlatformMXBeans(OperatingSystemMXBean.class);

        logger.debug("Number of MXBeans: {}", list.size());
        for (OperatingSystemMXBean bean : list) {
            logger.debug("Operating System Name: {}", bean.getName());
            logger.debug("Operating System Architecture: {}", bean.getArch());
            logger.debug("Operating System Version: {}", bean.getVersion());
        }

    }

}
