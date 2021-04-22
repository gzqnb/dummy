package com.nevt.db.repository;

import com.nevt.db.repository.entity.DataStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (DataStation)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:02
 */
public interface DataStationRepository extends JpaRepository<DataStation, Integer>,
        JpaSpecificationExecutor<DataStation> {

    @Query(value ="select max(t.id) from DataStation t")
    Integer getMaxId();

}