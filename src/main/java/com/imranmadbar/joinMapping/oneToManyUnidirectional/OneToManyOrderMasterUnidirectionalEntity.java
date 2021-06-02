package com.imranmadbar.joinMapping.oneToManyUnidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_many_order_uni_master")
public class OneToManyOrderMasterUnidirectionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	private String name;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orderId")
    private Set<OneToManyOrderDtlUnidirectionalEntity> oneToManyOrderDtlList = new HashSet<OneToManyOrderDtlUnidirectionalEntity>();

}