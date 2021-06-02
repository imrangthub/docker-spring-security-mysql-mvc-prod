package com.imranmadbar.joinMapping.manyToManyBidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "many_to_many_student_bidir")
public class ManyToManyStudentBirdirEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String studentName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ManyToManyCourseBidirEntity> courses = new HashSet<>();

}