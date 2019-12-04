package com.group.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Proxy(lazy = false)
public class MonAn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ten;
	private String mota;
	private int gia;
	private int doCay;
	private int doNgot;
	private int doDinhDuong;
	private int doPhoBien;

	@ManyToOne
	private QuocGia nguonGoc;
	@ManyToOne
	private TheLoai theLoai;
}
