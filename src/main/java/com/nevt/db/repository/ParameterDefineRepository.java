package com.nevt.db.repository;

import com.nevt.db.repository.entity.ParameterDefine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * (ParameterDefine)表数据库访问层
 *
 * @author lihuang
 * @since 2020-01-04 15:30
 */
public interface ParameterDefineRepository extends JpaRepository<ParameterDefine, Integer>,
        JpaSpecificationExecutor<ParameterDefine> {

    @Query(value = "select max(t.id) from ParameterDefine t")
    Integer getMaxId();

    @Query(value = "select pd.name,pd.shortName from ParameterDefine pd left join Device d on d.deviceTypeId = pd.deviceTypeId where d.dataStationId = ?1")
    List<String> getHBaseColumns(Integer dataStationId);

}