package kr.co.ezenac.sosuch.tramarvel;


import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.sosuch.tramarvel.model.Character;
import kr.co.ezenac.sosuch.tramarvel.model.Dice;
import kr.co.ezenac.sosuch.tramarvel.model.Score;

public class JapanActivity extends AppCompatActivity {
    @BindView(R.id.rl_dice) RelativeLayout rl_dice;
    @BindView(R.id.img_dice1) ImageView img_dice1;
    @BindView(R.id.img_dice2) ImageView img_dice2;
    @BindView(R.id.ch_1) ImageView ch_1;
    @BindView(R.id.ch_2) ImageView ch_2;
    @BindView(R.id.ch_3) ImageView ch_3;
    @BindView(R.id.ch_4) ImageView ch_4;
    @BindView(R.id.ch_5) ImageView ch_5;
    @BindView(R.id.ch_6) ImageView ch_6;
    @BindView(R.id.ch_7) ImageView ch_7;
    @BindView(R.id.ch_8) ImageView ch_8;
    @BindView(R.id.ch_9) ImageView ch_9;
    @BindView(R.id.ch_10) ImageView ch_10;
    @BindView(R.id.ch_11) ImageView ch_11;
    @BindView(R.id.ch_12) ImageView ch_12;
    @BindView(R.id.ch_13) ImageView ch_13;
    @BindView(R.id.ch_14) ImageView ch_14;
    @BindView(R.id.ch_15) ImageView ch_15;
    @BindView(R.id.ch_16) ImageView ch_16;
    @BindView(R.id.ch_17) ImageView ch_17;
    @BindView(R.id.ch_18) ImageView ch_18;
    @BindView(R.id.ch_19) ImageView ch_19;
    @BindView(R.id.ch_20) ImageView ch_20;
    @BindView(R.id.overray1) ImageView overray1;
    @BindView(R.id.overray2) ImageView overray2;
    @BindView(R.id.overray3) ImageView overray3;
    @BindView(R.id.overray4) ImageView overray4;
    @BindView(R.id.overray5) ImageView overray5;
    @BindView(R.id.overray6) ImageView overray6;
    @BindView(R.id.overray7) ImageView overray7;
    @BindView(R.id.overray8) ImageView overray8;
    @BindView(R.id.overray9) ImageView overray9;
    @BindView(R.id.overray10) ImageView overray10;
    @BindView(R.id.overray11) ImageView overray11;
    @BindView(R.id.overray12) ImageView overray12;
    @BindView(R.id.overray13) ImageView overray13;
    @BindView(R.id.overray14) ImageView overray14;
    @BindView(R.id.overray15) ImageView overray15;
    @BindView(R.id.overray16) ImageView overray16;
    @BindView(R.id.overray17) ImageView overray17;
    @BindView(R.id.overray18) ImageView overray18;
    @BindView(R.id.overray19) ImageView overray19;
    @BindView(R.id.overray20) ImageView overray20;

    int selectedPos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);
        ButterKnife.bind(this);
        final Dice dice = new Dice();
        final Character character = new Character();
        final Score score = new Score();

        final SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        final int dice_s = sp.load(this, R.raw.dice, 1);
        final int money_s = sp.load(this, R.raw.money, 1);
        final int select_s = sp.load(this, R.raw.select, 1);

        /*final은 해당 클래스의 정보를 더 이상 바꾸지 않겠다는 선언이다. 이를 활용하지 않으면 본래의 클래스의 정보와
        다른 클래스에서 수정하는 정보가 다르기 때문에 에러가 발생한다. 그래서 final로 새로 수정하는 쪽을 클래스정보가 아닌
        일반적인 상수로 바꾸어주어 충돌이 일어나 에러가 발생하는 것을 막아주는 것이다.*/

        rl_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.play(dice_s, 1, 1, 0, 0, 1);

                dice.throwDice_2();
                int sum = dice.getNumber_1() + dice.getNumber_2();
                character.setLocation(character.getLocation()+sum);
                if (character.getLocation() > 20) {
                    character.setLocation(character.getLocation()-20);
                }
                //주사위의 합이 20을 넘으면 1부터 다시 시작하게 만들기 위해서 20을 빼준다.

                if (dice.getNumber_1() == 1) {
                    img_dice1.setBackgroundResource(R.drawable.dice_1);
                } else if (dice.getNumber_1() == 2) {
                    img_dice1.setBackgroundResource(R.drawable.dice_2);
                } else if (dice.getNumber_1() == 3) {
                    img_dice1.setBackgroundResource(R.drawable.dice_3);
                } else if (dice.getNumber_1() == 4) {
                    img_dice1.setBackgroundResource(R.drawable.dice_4);
                } else if (dice.getNumber_1() == 5) {
                    img_dice1.setBackgroundResource(R.drawable.dice_5);
                } else if (dice.getNumber_1() == 6) {
                    img_dice1.setBackgroundResource(R.drawable.dice_6);
                }

                if (dice.getNumber_2() == 1) {
                    img_dice2.setBackgroundResource(R.drawable.dice_1);
                } else if (dice.getNumber_2() == 2) {
                    img_dice2.setBackgroundResource(R.drawable.dice_2);
                } else if (dice.getNumber_2() == 3) {
                    img_dice2.setBackgroundResource(R.drawable.dice_3);
                } else if (dice.getNumber_2() == 4) {
                    img_dice2.setBackgroundResource(R.drawable.dice_4);
                } else if (dice.getNumber_2() == 5) {
                    img_dice2.setBackgroundResource(R.drawable.dice_5);
                } else if (dice.getNumber_2() == 6) {
                    img_dice2.setBackgroundResource(R.drawable.dice_6);
                }

                if (character.getLocation() == 1) {
                    ch_1.setVisibility(view.VISIBLE);
                    overray1.setVisibility(view.VISIBLE);

                    final String items[] = {"특산물1","특산물2","특산물3"};

                    android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(JapanActivity.this);
                    alertDialog.setTitle("특산물을 구매하시겠습니까?");
                    alertDialog.setSingleChoiceItems(items, selectedPos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            selectedPos = i;

                            sp.play(select_s, 1, 1, 0, 0, 1.0F);
                        }
                    });
                    alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //현금 차감, 특산물 증가
                            sp.play(money_s, 1, 1, 0, 0, 1.0F);
                        }
                    });
                    alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    alertDialog.show();

                } else {
                    ch_1.setVisibility(view.INVISIBLE);
                    overray1.setVisibility(view.INVISIBLE);

                }
                if (character.getLocation() == 2) {
                    ch_2.setVisibility(view.VISIBLE);
                    overray2.setVisibility(view.VISIBLE);

                } else {
                    ch_2.setVisibility(view.INVISIBLE);
                    overray2.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 3) {
                    ch_3.setVisibility(view.VISIBLE);
                    overray3.setVisibility(view.VISIBLE);
                } else {
                    ch_3.setVisibility(view.INVISIBLE);
                    overray3.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 4) {
                    ch_4.setVisibility(view.VISIBLE);
                    overray4.setVisibility(view.VISIBLE);
                } else {
                    ch_4.setVisibility(view.INVISIBLE);
                    overray4.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 5) {
                    ch_5.setVisibility(view.VISIBLE);
                    overray5.setVisibility(view.VISIBLE);
                } else {
                    ch_5.setVisibility(view.INVISIBLE);
                    overray5.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 6) {
                    ch_6.setVisibility(view.VISIBLE);
                    overray6.setVisibility(view.VISIBLE);
                } else {
                    ch_6.setVisibility(view.INVISIBLE);
                    overray6.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 7) {
                    ch_7.setVisibility(view.VISIBLE);
                    overray7.setVisibility(view.VISIBLE);
                } else {
                    ch_7.setVisibility(view.INVISIBLE);
                    overray7.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 8) {
                    ch_8.setVisibility(view.VISIBLE);
                    overray8.setVisibility(view.VISIBLE);
                } else {
                    ch_8.setVisibility(view.INVISIBLE);
                    overray8.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 9) {
                    ch_9.setVisibility(view.VISIBLE);
                    overray9.setVisibility(view.VISIBLE);
                } else {
                    ch_9.setVisibility(view.INVISIBLE);
                    overray9.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 10) {
                    ch_10.setVisibility(view.VISIBLE);
                    overray10.setVisibility(view.VISIBLE);
                } else {
                    ch_10.setVisibility(view.INVISIBLE);
                    overray10.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 11) {
                    ch_11.setVisibility(view.VISIBLE);
                    overray11.setVisibility(view.VISIBLE);
                } else {
                    ch_11.setVisibility(view.INVISIBLE);
                    overray11.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 12) {
                    ch_12.setVisibility(view.VISIBLE);
                    overray12.setVisibility(view.VISIBLE);
                } else {
                    ch_12.setVisibility(view.INVISIBLE);
                    overray12.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 13) {
                    ch_13.setVisibility(view.VISIBLE);
                    overray13.setVisibility(view.VISIBLE);
                } else {
                    ch_13.setVisibility(view.INVISIBLE);
                    overray13.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 14) {
                    ch_14.setVisibility(view.VISIBLE);
                    overray14.setVisibility(view.VISIBLE);
                } else {
                    ch_14.setVisibility(view.INVISIBLE);
                    overray14.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 15) {
                    ch_15.setVisibility(view.VISIBLE);
                    overray15.setVisibility(view.VISIBLE);
                } else {
                    ch_15.setVisibility(view.INVISIBLE);
                    overray15.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 16) {
                    ch_16.setVisibility(view.VISIBLE);
                    overray16.setVisibility(view.VISIBLE);
                } else {
                    ch_16.setVisibility(view.INVISIBLE);
                    overray16.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 17) {
                    ch_17.setVisibility(view.VISIBLE);
                    overray17.setVisibility(view.VISIBLE);
                } else {
                    ch_17.setVisibility(view.INVISIBLE);
                    overray17.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 18) {
                    ch_18.setVisibility(view.VISIBLE);
                    overray18.setVisibility(view.VISIBLE);
                } else {
                    ch_18.setVisibility(view.INVISIBLE);
                    overray18.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 19) {
                    ch_19.setVisibility(view.VISIBLE);
                    overray19.setVisibility(view.VISIBLE);
                } else {
                    ch_19.setVisibility(view.INVISIBLE);
                    overray19.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 20) {
                    ch_20.setVisibility(view.VISIBLE);
                    overray20.setVisibility(view.VISIBLE);
                } else {
                    ch_20.setVisibility(view.INVISIBLE);
                    overray20.setVisibility(view.INVISIBLE);
                }

                //주석


                if(score.getTotalscore() == 100) {
                    android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(JapanActivity.this);
                    alertDialog.setTitle("1번 지역 클리어!!!!" + "/n" + "다음 지역으로 넘어갑니다~~!!");

                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            sp.play(select_s, 1, 1, 0, 0, 1.0F);
                        }
                    });

                    alertDialog.show();
                }

            }
        });
    }
}
