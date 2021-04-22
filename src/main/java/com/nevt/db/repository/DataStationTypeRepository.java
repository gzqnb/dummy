package com.nevt.db.repository;

import com.nevt.db.repository.entity.DataStationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (DataStationType)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:03
 */
public interface DataStationTypeRepository extends JpaRepository<DataStationType, Integer>,
        JpaSpecificationExecutor<DataStationType> {

    @Query(value ="select max(t.id) from DataStationType t")
    Integer getMaxId();

}