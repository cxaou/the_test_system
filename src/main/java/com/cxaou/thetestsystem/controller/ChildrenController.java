package com.cxaou.thetestsystem.controller;


import com.cxaou.thetestsystem.pojo.Children;
import com.cxaou.thetestsystem.pojo.ChildrenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/children")
public class ChildrenController {


    @Autowired
    private Children children;


    @GetMapping("/{identity}")
    public List<ChildrenDto> getChildren(@PathVariable("identity") Integer identity) {
        List<ChildrenDto> commonChildren = children.getCommonChildren();
        List<ChildrenDto> childrenDtoList = new ArrayList<>();
        if (identity == 0) { //身份 0 admin 1 教师 2 学生
            childrenDtoList = children.getAdminChildren();
        } else if (identity == 1) {
            childrenDtoList = children.getTeacherChildren();
        } else if (identity == 2) {
            childrenDtoList = children.getStudentChildren();
        } else {
            return null;
        }
        childrenDtoList.addAll(commonChildren);
        return childrenDtoList;
    }
}
