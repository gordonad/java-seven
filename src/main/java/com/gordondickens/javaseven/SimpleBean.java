package com.gordondickens.javaseven;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * User: gordondickens
 * Date: 3/30/12
 * Time: 12:32 PM
 */
public class SimpleBean {

    private String comment;
    private Integer id;
    private Integer original = null;

    public static SimpleBean copy(SimpleBean simpleBean, Integer newId) {
        SimpleBean bean = new SimpleBean(newId, simpleBean.getComment(), simpleBean.getId());
        return bean;
    }

    private SimpleBean() {
    }

    private SimpleBean(Integer id, String comment, Integer copy) {
        this.id = id;
        this.comment = comment;
    }

    public SimpleBean(Integer id, String comment) {
        this(id, comment, null);
    }

    public String getComment() {
        return comment;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
