package com.nevt.db.repository;

import com.nevt.db.repository.entity.CommonPropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (CommonPropertyValue)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:02
 */
public interface CommonPropertyValueRepository extends JpaRepository<CommonPropertyValue, Integer>,
        JpaSpecificationExecutor<CommonPropertyValue> {

    @Query(value = "select max(t.id) from CommonPropertyValue t")
    Integer getMaxId();
}