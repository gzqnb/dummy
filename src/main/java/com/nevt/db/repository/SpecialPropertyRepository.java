package com.nevt.db.repository;

import com.nevt.db.repository.entity.SpecialProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (SpecialProperty)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:05
 */
public interface SpecialPropertyRepository extends JpaRepository<SpecialProperty, Integer>,
        JpaSpecificationExecutor<SpecialProperty> {

    @Query(value = "select max(t.id) from SpecialProperty t")
    Integer getMaxId();

}