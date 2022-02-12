package com.rtb.therandomvalue.repositories;

import com.rtb.therandomvalue.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
