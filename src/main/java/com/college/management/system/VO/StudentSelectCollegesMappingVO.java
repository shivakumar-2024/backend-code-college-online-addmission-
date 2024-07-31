package com.college.management.system.VO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentSelectCollegesMappingVO {
private Long userId;

private List<Long> collegeIds;

}
