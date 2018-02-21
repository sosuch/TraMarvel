package kr.co.ezenac.sosuch.tramarvel.model;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-02-09.
 */

public class Tile {
    private Integer id;
    private String city_name;
    private String product_name;
    private Integer product_score;
    private Integer product_price;
    private String picture;

    public Tile(Integer id, String city_name, String product_name, Integer product_score, Integer product_price, String picture) {
        this.id = id;
        this.city_name = city_name;
        this.product_name = product_name;
        this.product_score = product_score;
        this.product_price = product_price;
        this.picture = picture;
    }

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

    public Integer getProduct_score() {
        return product_score;
    }

    public void setProduct_score(Integer product_score) {
        this.product_score = product_score;
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

}
