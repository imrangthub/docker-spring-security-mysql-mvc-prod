package com.imranmadbar.joinMapping.manyToOneUnidirectional;

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
@Table(name = "many_to_one_order_uni_master")
public class ManyToOneOrderOrderMasterUnidirectionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	private String orderName;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orderId")
	private List<ManyToOneOrderDtlUnidirectionalEntity> manyToOneOrderDtlList;

}