package kr.co.ezenac.sosuch.tramarvel;


import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.sosuch.tramarvel.model.Character;
import kr.co.ezenac.sosuch.tramarvel.model.Dice;

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
    @BindView(R.id.ch_21) ImageView ch_21;
    @BindView(R.id.ch_22) ImageView ch_22;
    @BindView(R.id.ch_23) ImageView ch_23;
    @BindView(R.id.ch_24) ImageView ch_24;
    int selectedPos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);
        ButterKnife.bind(this);
        final Dice dice = new Dice();
        final Character character = new Character();

        rl_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dice.throwDice_2();
                int sum = dice.getNumber_1() + dice.getNumber_2();
                character.setLocation(character.getLocation()+sum);
                if (character.getLocation() > 24) {
                    character.setLocation(character.getLocation()-24);
                }

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

                    final String items[] = {"특산물1","특산물2","특산물3"};

                    android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(JapanActivity.this);
                    alertDialog.setTitle("특산물을 구매하시겠습니까?");
                    alertDialog.setSingleChoiceItems(items, selectedPos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            selectedPos = i;
                        }
                    });
                    alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //현금 차감, 특산물 증가
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

                }
                if (character.getLocation() == 2) {
                    ch_2.setVisibility(view.VISIBLE);
                } else {
                    ch_2.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 3) {
                    ch_3.setVisibility(view.VISIBLE);
                } else {
                    ch_3.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 4) {
                    ch_4.setVisibility(view.VISIBLE);
                } else {
                    ch_4.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 5) {
                    ch_5.setVisibility(view.VISIBLE);
                } else {
                    ch_5.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 6) {
                    ch_6.setVisibility(view.VISIBLE);
                } else {
                    ch_6.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 7) {
                    ch_7.setVisibility(view.VISIBLE);
                } else {
                    ch_7.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 8) {
                    ch_8.setVisibility(view.VISIBLE);
                } else {
                    ch_8.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 9) {
                    ch_9.setVisibility(view.VISIBLE);
                } else {
                    ch_9.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 10) {
                    ch_10.setVisibility(view.VISIBLE);
                } else {
                    ch_10.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 11) {
                    ch_11.setVisibility(view.VISIBLE);
                } else {
                    ch_11.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 12) {
                    ch_12.setVisibility(view.VISIBLE);
                } else {
                    ch_12.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 13) {
                    ch_13.setVisibility(view.VISIBLE);
                } else {
                    ch_13.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 14) {
                    ch_14.setVisibility(view.VISIBLE);
                } else {
                    ch_14.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 15) {
                    ch_15.setVisibility(view.VISIBLE);
                } else {
                    ch_15.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 16) {
                    ch_16.setVisibility(view.VISIBLE);
                } else {
                    ch_16.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 17) {
                    ch_17.setVisibility(view.VISIBLE);
                } else {
                    ch_17.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 18) {
                    ch_18.setVisibility(view.VISIBLE);
                } else {
                    ch_18.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 19) {
                    ch_19.setVisibility(view.VISIBLE);
                } else {
                    ch_19.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 20) {
                    ch_20.setVisibility(view.VISIBLE);
                } else {
                    ch_20.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 21) {
                    ch_21.setVisibility(view.VISIBLE);
                } else {
                    ch_21.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 22) {
                    ch_22.setVisibility(view.VISIBLE);
                } else {
                    ch_22.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 23) {
                    ch_23.setVisibility(view.VISIBLE);
                } else {
                    ch_23.setVisibility(view.INVISIBLE);
                }
                if (character.getLocation() == 24) {
                    ch_24.setVisibility(view.VISIBLE);
                } else {
                    ch_24.setVisibility(view.INVISIBLE);
                }
            }
        });
    }
}
