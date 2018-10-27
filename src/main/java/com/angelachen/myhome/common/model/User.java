package com.angelachen.myhome.common.model;

import com.angelachen.myhome.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kartist 2018/10/4 7:57
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    /**
     * 标识是否允许进入后台
     */
    private boolean showBack = false;

    public User() {
    }

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.password = userEntity.getPassword();
        this.showBack = userEntity.getShowBack();
    }


}
