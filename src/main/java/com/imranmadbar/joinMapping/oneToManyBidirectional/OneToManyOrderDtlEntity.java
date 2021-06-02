package com.imranmadbar.joinMapping.oneToManyBidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_many_order_dtl")
public class OneToManyOrderDtlEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDtlId;

	private String productName;

	private Long productPrice;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "orderId")
	private OneToManyOrderMasterEntity oneToManyOrderMaster;

}