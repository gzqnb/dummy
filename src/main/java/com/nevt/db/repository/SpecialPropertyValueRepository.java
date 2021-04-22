package com.nevt.db.repository;

import com.nevt.db.repository.entity.SpecialPropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (SpecialPropertyValue)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:05
 */
public interface SpecialPropertyValueRepository extends JpaRepository<SpecialPropertyValue, Integer>,
        JpaSpecificationExecutor<SpecialPropertyValue> {

    @Query(value = "select max(t.id) from SpecialPropertyValue t")
    Integer getMaxId();

}