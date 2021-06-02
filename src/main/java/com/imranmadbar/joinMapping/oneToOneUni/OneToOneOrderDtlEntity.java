package com.imranmadbar.joinMapping.oneToOneUni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_one_order_dtl")
public class OneToOneOrderDtlEntity implements Serializable {

	private static final long serialVersionUID = 5167955767935040554L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDtlId;

	private String productName;

	private Long productPrice;


}