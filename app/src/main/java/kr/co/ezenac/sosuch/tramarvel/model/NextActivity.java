package kr.co.ezenac.sosuch.tramarvel.model;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import kr.co.ezenac.sosuch.tramarvel.JapanActivity2;
import kr.co.ezenac.sosuch.tramarvel.MainActivity;
import kr.co.ezenac.sosuch.tramarvel.OptionActivity;
import kr.co.ezenac.sosuch.tramarvel.R;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ImageView image_gif = (ImageView)findViewById(R.id.image_gif);
        RelativeLayout move_next = (RelativeLayout)findViewById(R.id.move_next);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(image_gif);
        Glide.with(this).load(R.raw.anigif).into(imageViewTarget);

        move_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this,JapanActivity2.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
