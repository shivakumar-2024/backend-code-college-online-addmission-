package com.college.management.system.VO;

import java.util.List;

import com.college.management.system.entity.Courses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCoursesAdminVO {
private String collegeCode;
private List<Long> coursesId;
}
