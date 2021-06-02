package com.imranmadbar.joinMapping.oneToManyBidirectional;

import java.util.List;

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
@Table(name = "one_to_many_order_master")
public class OneToManyOrderMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orderId")
	private List<OneToManyOrderDtlEntity> oneToManyOrderDtlList;

}