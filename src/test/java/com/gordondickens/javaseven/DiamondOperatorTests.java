package com.gordondickens.javaseven;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertNotNull;

/**
 * User: gordondickens
 * Date: 3/30/12
 * Time: 12:36 PM
 */
public class DiamondOperatorTests {
    private static final Logger logger = LoggerFactory.getLogger(DiamondOperatorTests.class);
    Map<String, List<SimpleBean>> simpleBeans = new TreeMap<>();

    @Before
    public void beforeEachTest() {
        simpleBeans = new TreeMap<>();
    }

    @Test
    public void createMap() {
        assertNotNull("Map must not be empty", simpleBeans);
        SimpleBean bean = new SimpleBean(1, "diamond test");

        List<SimpleBean> beanList = new ArrayList<>();

        beanList.add(bean);
        beanList.add(bean.copy(bean, 2));
        beanList.add(bean.copy(bean, 3));

        simpleBeans.put("test1", beanList);
        assertNotNull("List must not be empty", beanList);
        assertNotNull("Map must not be empty", simpleBeans);

        logger.debug(simpleBeans.toString());
    }

}
