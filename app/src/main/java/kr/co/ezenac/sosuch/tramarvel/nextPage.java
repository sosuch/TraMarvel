package kr.co.ezenac.sosuch.tramarvel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-02-12.
 */

public class nextPage extends AppCompatActivity {
    @BindView(R.id.train_m) RelativeLayout train_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page); //화면에는 layout의 next_page를 띄워주고, 기능은 여기서 구현
        ButterKnife.bind(this);

        train_m.setOnClickListener(new View.OnClickListener() {      // next_page 에서 화면전체에 아이디를 train_m로 주었다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nextPage.this,JapanActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}



