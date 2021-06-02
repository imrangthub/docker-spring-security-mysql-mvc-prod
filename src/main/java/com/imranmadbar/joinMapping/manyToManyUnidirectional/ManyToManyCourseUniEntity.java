package com.imranmadbar.joinMapping.manyToManyUnidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "many_to_many_course_uni")
public class ManyToManyCourseUniEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseTitle;
	

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE", 
             joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
    private List<ManyToManyStudentUniEntity> students = new ArrayList<ManyToManyStudentUniEntity>();

}