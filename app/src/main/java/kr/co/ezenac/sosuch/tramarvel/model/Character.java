package kr.co.ezenac.sosuch.tramarvel.model;

/**
 * Created by Administrator on 2018-02-05.
 */

    public class Character {
        private Integer location = 1;
        private Integer money = 100;
        private String object;

    public Character() {
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

        public Integer getLocation() {
            return location;
        }

        public void setLocation(Integer location) {
            this.location = location;
        }
}
