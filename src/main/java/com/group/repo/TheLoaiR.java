package com.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.TheLoai;

public interface TheLoaiR extends JpaRepository<TheLoai, Integer> {

	TheLoai findByTen(String loai);

}
