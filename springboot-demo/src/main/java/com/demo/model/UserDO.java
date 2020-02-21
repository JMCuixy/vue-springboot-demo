package com.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@Data
public class UserDO implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private String sex;
    private String address;
    private Date createOn;
    private String createBy;
    private Date updateOn;
    private String updateBy;
}

