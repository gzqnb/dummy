package com.nevt.db.repository;

import com.nevt.db.repository.entity.CommonProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (CommonProperty)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:49:56
 */
public interface CommonPropertyRepository extends JpaRepository<CommonProperty, Integer>,
        JpaSpecificationExecutor<CommonProperty> {

    @Query(value ="select max(t.id) from CommonProperty t")
    Integer getMaxId();

}
