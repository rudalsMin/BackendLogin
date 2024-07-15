package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface BookInfoRepository extends JpaRepository<bookinfo, Long> {
	@Transactional
	void deleteById(Long id);
	List<bookinfo> findByNameContains(String search);
}
