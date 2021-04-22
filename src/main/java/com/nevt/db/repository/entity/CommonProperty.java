package com.nevt.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (CommonProperty)实体类
 *
 * @author makejava
 * @since 2020-12-28 15:49:53
 */
@Data
@Entity
@Table(name = "common_property")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class CommonProperty implements Serializable {
    private static final long serialVersionUID = -14500190118908461L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "data_type")
    private String dataType;

    @Column(name = "data_station_type_id")
    private Integer dataStationTypeId;

}