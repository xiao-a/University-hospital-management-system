package com.uhms.uhms.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
@Table(name ="t_admin")
public class AdminEntity implements Serializable {
    @Id
    @Excel(name = "id", orderNum = "0")
    private String adminId;
    @Excel(name = "姓名", orderNum = "1")
    private String name;
    @Excel(name = "性别", orderNum = "2")
    private String sex;
    @Excel(name = "年龄", orderNum = "4")
    private Integer age;
    @Excel(name = "用户名", orderNum = "5")
    private String username;
    @Excel(name = "密码", orderNum = "6")
    private String password;
    @Excel(name = "手机号码", orderNum = "7")
    private String phoneNumber;
    @Excel(name = "地址", orderNum = "8")
    private String address;
    @Excel(name = "状态", orderNum = "9")
    private String status;
    @Excel(name = "创建日期", orderNum = "10")
    private Date createDate;
    @Excel(name = "修改日期", orderNum = "11")
    private Date updateDate;
}
