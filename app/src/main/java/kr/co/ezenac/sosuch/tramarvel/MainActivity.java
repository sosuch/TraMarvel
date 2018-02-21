package kr.co.ezenac.sosuch.tramarvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_start) Button btn_start;
    @BindView(R.id.btn_continue) Button btn_continue;
    @BindView(R.id.btn_option) Button btn_option;
    @BindView(R.id.btn_exit) Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //기능은 java에서 구현하고 화면은 setContentView로 layout파일을 띄워준다.
        ButterKnife.bind(this);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                startActivityForResult(intent,0); // startActivity(intent)는 그냥 넘겨줄 때, startActivityForResult(intent, 0)는 넘겨준 후, 처리해서 다시 모체로 넘겨줄 때 사용한다.
            }
        });  //이 클래스에 존재하는(.this) MainActivity에서 SelectActivity.class로 넘겨준다.

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);

                //로딩을 위한 로직 필요

                startActivityForResult(intent,0);
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
