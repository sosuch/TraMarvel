package kr.co.ezenac.sosuch.tramarvel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.sosuch.tramarvel.db.DbManager;
import kr.co.ezenac.sosuch.tramarvel.model.Character;
import kr.co.ezenac.sosuch.tramarvel.model.Dice;
import kr.co.ezenac.sosuch.tramarvel.model.NextActivity;
import kr.co.ezenac.sosuch.tramarvel.model.Score;
import kr.co.ezenac.sosuch.tramarvel.model.Tile;

public class JapanActivity extends AppCompatActivity {
    @BindView(R.id.rl_dice) RelativeLayout rl_dice;
    @BindView(R.id.img_dice1) ImageView img_dice1;
    @BindView(R.id.img_dice2) ImageView img_dice2;
    @BindView(R.id.txt_money) TextView txt_money;
    @BindView(R.id.txt_score) TextView txt_score;
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
    @BindView(R.id.speaker_On) ImageView speaker_On;
    @BindView(R.id.move_Bar) SeekBar move_Bar;
    @BindView(R.id.bSave) Button bSave;

    ImageView[] chs;
    ImageView[] overrays;
    DbManager dbManager;
    Intent intent;
    Integer ctn_location;
    Integer ctn_money;
    Integer ctn_score;
    String ctn_object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);

        ButterKnife.bind(this);
        final Dice dice = new Dice();
        final Character character = new Character();
        final Score score = new Score();

        /* 볼륨조절 */
        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        /* 볼륨조절 */

        /* 이어하기 기능 */
        intent = getIntent();
        ctn_location = intent.getIntExtra("location",1);
        ctn_money = intent.getIntExtra("money",100);
        ctn_score = intent.getIntExtra("score",0);
        ctn_object = intent.getStringExtra("object");

        character.setLocation(ctn_location);
        character.setMoney(ctn_money);
        character.setScore(ctn_score);
        character.setObject(ctn_object);
        /* 이어하기 기능 */

        /* DB 기능 */
        dbManager = new DbManager(
                JapanActivity.this,"TraMarvel.db",null,1);
        /* DB 기능 */

        final Tile tile1 = new Tile(1, "도쿄", "와규", 5, 10, "icons");

        /* 음향효과 */
        final SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        final int dice_s = sp.load(this, R.raw.dice, 1);
        final int money_s = sp.load(this, R.raw.money, 1);
        final int select_s = sp.load(this, R.raw.select, 1);
        /* 음향효과 */

        chs = new ImageView[20];
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

        overrays = new ImageView[20];
        overrays[0] = overray1;
        overrays[1] = overray2;
        overrays[2] = overray3;
        overrays[3] = overray4;
        overrays[4] = overray5;
        overrays[5] = overray6;
        overrays[6] = overray7;
        overrays[7] = overray8;
        overrays[8] = overray9;
        overrays[9] = overray10;
        overrays[10] = overray11;
        overrays[11] = overray12;
        overrays[12] = overray13;
        overrays[13] = overray14;
        overrays[14] = overray15;
        overrays[15] = overray16;
        overrays[16] = overray17;
        overrays[17] = overray18;
        overrays[18] = overray19;
        overrays[19] = overray20;

        visibleCh(character.getLocation());
        visibleOverrray(character.getLocation());

        Log.d("ssc","dbL : " + character.getLocation());
        Log.d("ssc","dbM : " + character.getMoney());
        Log.d("ssc","dbS : " + character.getScore());
        Log.d("ssc","dbO : " + character.getObject());

        rl_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.play(dice_s, 1, 1, 0, 0, 1);

                dice.throwDice_2();
                int sum = dice.getNumber_1() + dice.getNumber_2();
                character.setLocation(character.getLocation() + sum);
                if (character.getLocation() > 20) {
                    character.setLocation(character.getLocation() - 20);
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

                    android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(JapanActivity.this);
                    alertDialog.setTitle("와규를 구입하시겠습니까?");

                    alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            character.setMoney(character.getMoney() - tile1.getProduct_price());
                            character.setScore(character.getScore() + tile1.getProduct_score());
                            txt_money.setText(character.getMoney().toString());
                            txt_score.setText(character.getScore().toString());
                            sp.play(money_s, 1, 1, 0, 0, 1.0F);

                            isCompleteStage(character.getScore());
                        }
                    });
                    alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    alertDialog.show();

                } else {

                }

                visibleCh(character.getLocation());
                visibleOverrray(character.getLocation());

            }
        });

        move_Bar.setMax(nMax);
        move_Bar.setProgress(nCurrentVolumn);
        move_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                if (progress == 0) {
                    speaker_On.setBackgroundResource(R.drawable.volume_mute);
                } else {
                    speaker_On.setBackgroundResource(R.drawable.volume);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dbManager.saveData(character.getLocation(),character.getMoney(),character.getScore(),character.getObject());
            Toast.makeText(JapanActivity.this, "저장 완료", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void visibleCh(int index) {
        for (int i = 0; i <chs.length; i++) {
            chs[i].setVisibility((View.INVISIBLE));
        }
        chs[index-1].setVisibility(View.VISIBLE);
    }

    public void visibleOverrray(int index) {
        for (int i = 0; i <chs.length; i++) {
            chs[i].setVisibility((View.INVISIBLE));
        }
        chs[index-1].setVisibility(View.VISIBLE);
    }

    public void isCompleteStage(int score){
        final SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        final int select_s = sp.load(this, R.raw.select, 1);
        if (score >= 5) {
            android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(JapanActivity.this);
            alertDialog.setTitle("1번 지역 클리어!!!!" + "\n" + "다음 지역으로 넘어갑니다~~!!");

            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sp.play(select_s, 1, 1, 0, 0, 1.0F);

                    Intent intent = new Intent(JapanActivity.this, NextActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            alertDialog.show();
        }
    }
}
