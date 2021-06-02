package com.imranmadbar.joinMapping.manyToOneBidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imranmadbar.joinMapping.oneToManyBidirectional.OneToManyOrderMasterEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "many_to_one_order_bidir_dtl")
public class ManyToOneOrderDtlBidirectionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDtlId;

	private String productName;

	private Long productPrice;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "orderId")
	private ManyToOneOrderOrderMasterBidirectionalEntity manyToOneOrderMaster;

}