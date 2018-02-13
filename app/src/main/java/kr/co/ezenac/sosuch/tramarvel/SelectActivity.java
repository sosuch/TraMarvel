package kr.co.ezenac.sosuch.tramarvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectActivity extends AppCompatActivity {
    @BindView(R.id.select_page) RelativeLayout select_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select); //화면에는 layout의 activity_select를 띄워주고, 기능은 여기서 구현
        ButterKnife.bind(this);

        select_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                //activity_select에서 화면전체에 아이디를 select_page로 주었다.
                Intent intent = new Intent(SelectActivity.this,JapanActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
