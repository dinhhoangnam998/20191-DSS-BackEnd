package com.group.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "monAn", fetch = FetchType.EAGER)
	private List<MonAnNguyenLieu> monAnNguyenLieus;

	@Override
	public String toString() {
		return ten;
	}
	
	
}
