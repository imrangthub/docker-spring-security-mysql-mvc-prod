package com.imranmadbar.joinMapping.oneToOneBiDir;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_one_order_dtl_bidir")
public class OneToOneBiDirOrderDtlEntity implements Serializable {

	private static final long serialVersionUID = 5167955767935040554L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDtlId;

	private String productName;

	private Long productPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	@JsonBackReference
	private OneToOneBiDirOrderMasterEntity oneToOneBiDirOrderMaster;


}