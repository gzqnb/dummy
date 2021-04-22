package com.nevt.service;

import com.nevt.db.repository.*;
import com.nevt.db.repository.entity.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DBService {

    @Resource
    private DataStationTypeRepository dataStationTypeRepository;

    @Resource
    DataStationRepository dataStationRepository;

    @Resource
    CommonPropertyValueRepository commonPropertyValueRepository;

    @Resource
    SpecialPropertyValueRepository specialPropertyValueRepository;

    @Resource
    private ParameterDefineRepository parameterDefineRepository;

    /**
     * 添加数据站点
     *
     * @param dataStation              数据站点基本参数，需包含data_station_type_id
     * @param commonPropertyValues     数据站点是公共属性,需包含property_id
     * @param specialPropertyValueList 数据站点自有属性,需包含special_property_id
     */

    @Transactional
    public void addDataStation(@NotNull DataStation dataStation,@NotNull List<CommonPropertyValue> commonPropertyValues,
                               @NotNull List<SpecialPropertyValue> specialPropertyValueList) {
        int id = dataStationRepository.getMaxId() == null ? 2000001 : dataStationRepository.getMaxId() + 1;
        dataStation.setId(id);
        DataStation dataStationSave = dataStationRepository.save(dataStation);
        for (CommonPropertyValue commonPropertyValue : commonPropertyValues) {
            commonPropertyValue.setDataStationId(dataStationSave.getId());
            commonPropertyValueRepository.save(commonPropertyValue);
        }

        for (SpecialPropertyValue specialPropertyValue : specialPropertyValueList) {
            specialPropertyValue.setDataStationId(dataStationSave.getId());
            specialPropertyValueRepository.save(specialPropertyValue);
        }

    }


    /**
     * 根据data_station的ID，获取parameter_define的 name 和 short_name的List集合
     *
     * @param dataStationId data_station表的ID
     * @return List<String> parameter_define name,short_name字段集合
     * @author lihuang
     */
    public List<String> getParameterNameList(Integer dataStationId) {
        return parameterDefineRepository.getHBaseColumns(dataStationId);
    }

    /**
     * 根据data_station输入参数名称，获取相应HBase列名称
     *
     * @param parameterNameList data_station输入参数名称列表
     * @return Map<data_station输入参数名称, HBase中列表名称>
     * @author lihuang
     */
    public Map<String, String> getHBaseColumns(@NotNull List<String> parameterNameList) {
        Map<String, String> result = new HashMap<>();
        for (String hBaseColumn : parameterNameList) {
            String[] split = hBaseColumn.split(",");
            //split[0] name;split[1] short_name
            result.put(split[0], split[1]);
        }
        return result;
    }

}
