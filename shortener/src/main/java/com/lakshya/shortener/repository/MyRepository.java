package com.lakshya.shortener.repository;

import com.lakshya.shortener.entity.MyEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {

	List<MyEntity> findByShortUrl(String shortUrl);
}