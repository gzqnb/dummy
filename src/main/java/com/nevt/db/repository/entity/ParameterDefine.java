package com.nevt.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (ParameterDefine)实体类
 *
 * @author makejava
 * @since 2020-12-28 15:50:04
 */
@Data
@Entity
@Table(name = "parameter_define")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class ParameterDefine implements Serializable {

    private static final long serialVersionUID = -99439238342908127L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "description")
    private String description;

    @Column(name = "device_type_id")
    private Integer deviceTypeId;

}