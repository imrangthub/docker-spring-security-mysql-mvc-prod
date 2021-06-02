package com.imranmadbar.joinMapping.manyToManyBidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "many_to_many_course_bidir")
public class ManyToManyCourseBidirEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseTitle;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "STUDENT_COURSE_BIDIR", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID") })
	private Set<ManyToManyStudentBirdirEntity> students = new HashSet<>();

}