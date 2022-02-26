package com.rtb.therandomvalue.repositories;

import com.rtb.therandomvalue.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
