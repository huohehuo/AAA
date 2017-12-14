package lins.aaa.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Administrator on 2017/12/7.
 */
@Entity
public class PlaceBean {
    @Id
    long id;
    String place_name;
    String place_say;
    String place_pic;
    String place_type;

    public PlaceBean(){}

    public PlaceBean(String place_name, String place_say, String place_pic, String place_type) {
        this.place_name = place_name;
        this.place_say = place_say;
        this.place_pic = place_pic;
        this.place_type = place_type;
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_say() {
        return place_say;
    }

    public void setPlace_say(String place_say) {
        this.place_say = place_say;
    }

    public String getPlace_pic() {
        return place_pic;
    }

    public void setPlace_pic(String place_pic) {
        this.place_pic = place_pic;
    }


    @Override
    public String toString() {
        return "PlaceBean{" +
                "id=" + id +
                ", place_name='" + place_name + '\'' +
                ", place_say='" + place_say + '\'' +
                ", place_pic='" + place_pic + '\'' +
                ", place_type='" + place_type + '\'' +
                '}';
    }
}
