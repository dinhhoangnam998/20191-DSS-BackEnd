package com.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.NguyenLieu;

public interface NguyenLieuR  extends JpaRepository<NguyenLieu, Integer> {

	NguyenLieu findByTen(String string);


}
