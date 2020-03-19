package com.uhms.uhms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
@Table(name = "t_bed")
public class BedEntity implements Serializable {
    @Id
    private String id;
    private String division;
    private String status;
}
