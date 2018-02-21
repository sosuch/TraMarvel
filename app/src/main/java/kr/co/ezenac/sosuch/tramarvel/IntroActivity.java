package kr.co.ezenac.sosuch.tramarvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends AppCompatActivity {
    @BindView(R.id.intro_page) RelativeLayout intro_page; //ButterKnife활용을 위해 bindView처리

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //상속을 받아서 onCreate에서 다시 구현
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);

        intro_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

//인트로 페이지를 클릭하면 mainActivity로 넘어간다.