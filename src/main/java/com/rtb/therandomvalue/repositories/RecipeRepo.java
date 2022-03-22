package com.rtb.therandomvalue.repositories;

import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<RecipeBO, Long> {
}
