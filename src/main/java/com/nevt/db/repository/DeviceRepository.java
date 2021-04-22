package com.nevt.db.repository;

import com.nevt.db.repository.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * (Device)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 15:50:03
 */
public interface DeviceRepository extends JpaRepository<Device, Integer>,
        JpaSpecificationExecutor<Device> {

    @Query(value = "select max(t.id) from Device t")
    Integer getMaxId();

}