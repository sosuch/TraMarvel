package kr.co.ezenac.sosuch.tramarvel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    @BindView(R.id.txt_player) TextView txt_player;
    @BindView(R.id.txt_money) TextView txt_money;
    @BindView(R.id.txt_object) TextView txt_object;

    ImageView[] chs;

    int selectedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);
        ButterKnife.bind(this);
        final Dice dice = new Dice();
        final Character character = new Character();

        chs = new ImageView[24];

        chs[0] = ch_1;
        chs[1] = ch_2;
        chs[2] = ch_3;
        chs[3] = ch_4;
        chs[4] = ch_5;
        chs[5] = ch_6;
        chs[6] = ch_7;
        chs[7] = ch_8;
        chs[8] = ch_9;
        chs[9] = ch_10;
        chs[10] = ch_11;
        chs[11] = ch_12;
        chs[12] = ch_13;
        chs[13] = ch_14;
        chs[14] = ch_15;
        chs[15] = ch_16;
        chs[16] = ch_17;
        chs[17] = ch_18;
        chs[18] = ch_19;
        chs[19] = ch_20;
        chs[20] = ch_21;
        chs[21] = ch_22;
        chs[22] = ch_23;
        chs[23] = ch_24;

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_layout);
        dialog.setTitle("특산물을 구입하시겠습니까?");  //custom dialog

        rl_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                character.setMoney(character.getMoney()-1);
                txt_money.setText(character.getMoney().toString());
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

                    alertDialog.setIcon(android.R.drawable.star_big_on);
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
                    visibleCh(character.getLocation());
                }
            }
        });
    }

    public void visibleCh(int index) {
        for (int i = 0 ; i < chs.length ; i++) {
            chs[i].setVisibility(View.INVISIBLE);
        }

        chs[index].setVisibility(View.VISIBLE);
    }
}