package kr.co.ezenac.sosuch.tramarvel.model;

/**
 * Created by Administrator on 2018-02-05.
 */

public class Dice {
    private Integer number_1;
    private Integer number_2;
    private Integer count = 0;
    // count 는 주사위 던짓 횟수

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getNumber_1() {
        return number_1;
    }

    public void setNumber_1(Integer number_1) {
        this.number_1 = number_1;
    }

    public Integer getNumber_2() {
        return number_2;
    }

    public void setNumber_2(Integer number_2) {
        this.number_2 = number_2;
    }

    public Dice() {
    }

    public void throwDice_2() {
        number_1 = (int)(Math.random() * 6) +1;
        number_2 = (int)(Math.random() * 6) +1;
        count++;
    }

}
