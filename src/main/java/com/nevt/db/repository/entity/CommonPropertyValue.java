package com.nevt.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (CommonPropertyValue)实体类
 *
 * @author makejava
 * @since 2020-12-28 15:50:02
 */
@Data
@Entity
@Table(name = "common_property_value")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class CommonPropertyValue implements Serializable {
    private static final long serialVersionUID = 503236806956050609L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "property_id")
    private Integer propertyId;

    @Column(name = "data_station_id")
    private Integer dataStationId;

}