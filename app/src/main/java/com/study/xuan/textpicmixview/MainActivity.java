package com.study.xuan.textpicmixview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.study.xuan.lib.TextPicMixView;

public class MainActivity extends Activity {
    private TextPicMixView mixList;
    private ImageView ivAddPic;
    private ImageView ivAddText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mixList = findViewById(R.id.mix_list);
        ivAddPic = findViewById(R.id.iv_add_pic);
        ivAddText = findViewById(R.id.iv_add_text);

        ivAddPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mixList.addPic();
            }
        });
        ivAddText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mixList.addText();
            }
        });
    }
}
