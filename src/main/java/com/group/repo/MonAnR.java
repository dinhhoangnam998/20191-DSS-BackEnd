package com.group.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.MonAn;
import com.group.model.QuocGia;
import com.group.model.TheLoai;

public interface MonAnR extends JpaRepository<MonAn, Integer> {

	List<MonAn> findByTheLoaiAndNguonGocAndGiaGreaterThanEqualAndGiaLessThanEqual(TheLoai theLoai, QuocGia nguonGoc,
			int giaNhoNhat, int giaLonNhat);

	List<MonAn> findByGiaGreaterThanEqualAndGiaLessThanEqual(int giaNhoNhat, int giaLonNhat);

	List<MonAn> findByNguonGocAndGiaGreaterThanEqualAndGiaLessThanEqual(QuocGia nguonGoc, int giaNhoNhat,
			int giaLonNhat);

	List<MonAn> findByTheLoaiAndGiaGreaterThanEqualAndGiaLessThanEqual(TheLoai theLoai, int giaNhoNhat, int giaLonNhat);

}
