package kr.co.ezenac.sosuch.tramarvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.sosuch.tramarvel.db.DbManager;
import kr.co.ezenac.sosuch.tramarvel.model.Character;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_start) Button btn_start;
    @BindView(R.id.btn_continue) Button btn_continue;
    @BindView(R.id.btn_option) Button btn_option;
    @BindView(R.id.btn_exit) Button btn_exit;

    DbManager dbManager;
    Character character = new Character();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //기능은 java에서 구현하고 화면은 setContentView로 layout파일을 띄워준다.
        ButterKnife.bind(this);

        dbManager = new DbManager(
                MainActivity.this,"TraMarvel.db",null,1);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                startActivityForResult(intent,0); // startActivity(intent)는 그냥 넘겨줄 때, startActivityForResult(intent, 0)는 넘겨준 후, 처리해서 다시 모체로 넘겨줄 때 사용한다.
                //dbManager.insertData(1,100,0,"없음"); //DBManager에 파일 입력
            }
        });  //이 클래스에 존재하는(.this) MainActivity에서 SelectActivity.class로 넘겨준다.

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* try {
                    //파일에서 읽은 데이터를 저장하기 위해서 만든 변수

                    StringBuffer data = new StringBuffer();
                    FileInputStream fis = openFileInput("myfile.txt"); //파일명
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));

                    } catch (Exception e) {
                    e.printStackTrace();
                } */
               character = dbManager.loadData();
                Intent intent = new Intent(MainActivity.this,JapanActivity.class);
                intent.putExtra("location",character.getLocation());
                intent.putExtra("money",character.getMoney());
                intent.putExtra("score",character.getScore());
                intent.putExtra("object",character.getObject());
                startActivityForResult(intent,0);
                Toast.makeText(MainActivity.this, "불러오기 완료", Toast.LENGTH_LONG).show();

            }
        });

        btn_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OptionActivity.class);
                startActivityForResult(intent,0);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
