package lins.aaa.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Administrator on 2018/1/7.
 */

@Entity
public class AdressBean {

    @Id
    long id;
    String adress_name;
    String adress_pic;
    String adress_title;
    public AdressBean(){}

    public AdressBean(String adress_name, String adress_pic, String adress_title) {
        this.adress_name = adress_name;
        this.adress_pic = adress_pic;
        this.adress_title = adress_title;
    }

    public String getAdress_name() {
        return adress_name;
    }

    public void setAdress_name(String adress_name) {
        this.adress_name = adress_name;
    }

    public String getAdress_pic() {
        return adress_pic;
    }

    public void setAdress_pic(String adress_pic) {
        this.adress_pic = adress_pic;
    }

    public String getAdress_title() {
        return adress_title;
    }

    public void setAdress_title(String adress_title) {
        this.adress_title = adress_title;
    }
}
