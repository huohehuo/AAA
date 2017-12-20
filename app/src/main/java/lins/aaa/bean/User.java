package lins.aaa.bean;

import cn.bmob.v3.BmobUser;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Administrator on 2017/12/7.
 */
@Entity
public class User extends BmobUser{
    @Id
    long id;
    String name;
    String sex;
    String age;
    String city;
    String note;
    String icon_pic;

    public User(){}
    public User(String name,String pwd){

    }
    public User(String name, String sex, String age, String city, String note, String icon_pic) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.city = city;
        this.note = note;
        this.icon_pic = icon_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIcon_pic() {
        return icon_pic;
    }

    public void setIcon_pic(String icon_pic) {
        this.icon_pic = icon_pic;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", city='" + city + '\'' +
                ", note='" + note + '\'' +
                ", icon_pic='" + icon_pic + '\'' +
                '}';
    }
}
