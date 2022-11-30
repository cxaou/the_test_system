package com.cxaou.thetestsystem.config;

import com.cxaou.thetestsystem.pojo.Children;
import com.cxaou.thetestsystem.pojo.ChildrenDto;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Children children = applicationContext.getBean(Children.class);
        List<ChildrenDto> commonChildren = children.getCommonChildren();
        children.getAdminChildren().addAll(commonChildren);
        children.getStudentChildren().addAll(commonChildren);
        children.getTeacherChildren().addAll(commonChildren);
    }
}
