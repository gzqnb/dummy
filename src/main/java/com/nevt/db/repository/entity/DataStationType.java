package com.nevt.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (DataStationType)实体类
 *
 * @author makejava
 * @since 2020-12-28 15:50:03
 */
@Data
@Entity
@Table(name = "data_station_type")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class DataStationType implements Serializable {
    private static final long serialVersionUID = 334112408709896997L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "column_family")
    private String columnFamily;

    @Column(name = "data_station_type_id")
    private String dataStationTypeId;


}