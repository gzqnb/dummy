package com.nevt.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (SpecialPropertyValue)实体类
 *
 * @author makejava
 * @since 2020-12-28 15:50:05
 */
@Data
@Entity
@Table(name = "special_property_value")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class SpecialPropertyValue implements Serializable {

    private static final long serialVersionUID = -89431314908631250L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "special_property_id")
    private Integer specialPropertyId;

    @Column(name = "data_station_id")
    private Integer dataStationId;

}