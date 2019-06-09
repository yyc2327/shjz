package com.copasso.lifeAccounting.model.bean.remote;

import cn.bmob.v3.BmobUser;
/**
 * 设置用户信息image/gender/age
 */
public class MyUser extends BmobUser {

    private String image;
    private String gender;//性别
    private String age;

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
