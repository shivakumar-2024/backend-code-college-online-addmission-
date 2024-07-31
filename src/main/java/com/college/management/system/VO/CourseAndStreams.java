package com.college.management.system.VO;

import java.util.List;

import com.college.management.system.entity.BtechStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseAndStreams {
    private List<CoursesVO> coursesVO;
    private List<BtechStream> streams;

    public CourseAndStreams(List<CoursesVO> coursesVO, List<BtechStream> streams) {
        this.coursesVO = coursesVO;
        this.streams = streams;
    }
}