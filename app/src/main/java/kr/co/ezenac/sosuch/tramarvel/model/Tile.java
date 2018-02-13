package kr.co.ezenac.sosuch.tramarvel.model;

import android.widget.ImageView;

/**
 * Created by Administrator on 2018-02-09.
 */

public class Tile {
    private Integer id;
    private String city_name;
    private String product_name;
    private Integer product_price;
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Tile() {
    }
}
