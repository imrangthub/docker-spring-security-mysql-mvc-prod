package com.imranmadbar.joinMapping.oneToOneBiDir;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "one_to_one_order_master_bidir")
public class OneToOneBiDirOrderMasterEntity implements Serializable {

	private static final long serialVersionUID = 516795767935040554L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	private String name;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "oneToOneBiDirOrderMaster")
	@JsonManagedReference
	private OneToOneBiDirOrderDtlEntity oneToOneOrderDtl;

}