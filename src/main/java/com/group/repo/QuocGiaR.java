package com.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.entity.QuocGia;

public interface QuocGiaR extends JpaRepository<QuocGia, Integer> {

	QuocGia findByTen(String nguonGoc);

}
