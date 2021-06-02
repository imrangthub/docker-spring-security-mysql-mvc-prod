package com.imranmadbar.joinMapping.oneToManyUnidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_many_order_uni_dtl")
public class OneToManyOrderDtlUnidirectionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDtlId;

	private String productName;

	private Long productPrice;

}