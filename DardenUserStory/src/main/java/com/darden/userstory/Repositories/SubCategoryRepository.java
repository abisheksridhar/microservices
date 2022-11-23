package com.darden.userstory.Repositories;

import com.darden.userstory.Entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
