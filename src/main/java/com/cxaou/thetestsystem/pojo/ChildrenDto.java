package com.cxaou.thetestsystem.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ChildrenDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 路由id
     */
    private Integer id;

    /**
     * 级数，如 1 就是1级路由， 2就是 2级路由
     */
    private Integer type;

    /**
     * 路由地址
     */
    private String url;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 父路由的id
     */
    private Integer parentId;

    /**
     * 图片
     */
    private String icon;

    /**
     *  子路由
     */
   private List<Map<String,Object>> children;


}
