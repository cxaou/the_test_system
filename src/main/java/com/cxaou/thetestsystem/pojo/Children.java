package com.cxaou.thetestsystem.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "children")
@Data
public class Children  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公共的
     */
    public List<ChildrenDto> commonChildren;

    /**
     * admin
     */
    public List<ChildrenDto> adminChildren;

    /**
     * 学生
     */
    public List<ChildrenDto> studentChildren;

    /**
     * 教师
     */
    public List<ChildrenDto> teacherChildren;


}
