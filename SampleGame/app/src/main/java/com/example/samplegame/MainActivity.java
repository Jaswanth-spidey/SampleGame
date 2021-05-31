package com.example.samplegame;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class MainActivity extends AppCompatActivity {

    TextView upFront;
    TextView upBack;
    TextView downFront;
    TextView downBack;
    int position1=0;
    int position2 = 0;
    ConstraintLayout up_back_layout;
    ConstraintLayout down_back_layout;
    int unicode = 0x1F60A;
    Button containedButton;
    MenuItem instructions;
    Button inst_er;
    static final int DAY_VIEW_MODE = 0;
    static final int WEEK_VIEW_MODE = 1;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upFront = findViewById(R.id.front_up_card);
        upBack = findViewById(R.id.back_up_card);
        downFront = findViewById(R.id.front_down_card);
        downBack = findViewById(R.id.back_down_card);
        EasyFlipView upeasyFlipView = findViewById(R.id.up_card);
        EasyFlipView downeasyFlipView = findViewById(R.id.down_card);
        instructions = findViewById(R.id.moreVertical);
        inst_er = findViewById(R.id.inst_er);

        upFront.setText(getString(R.string.que_up_one));
        downFront.setText(getString(R.string.que_down_one));
        containedButton = findViewById(R.id.containedButton);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            containedButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.yellow));
        }
        upeasyFlipView.setFlipOnTouch(true);
        downeasyFlipView.setFlipOnTouch(true);

        up_back_layout = findViewById(R.id.up_back_layout);
        down_back_layout = findViewById(R.id.down_back_layout);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                inst_er.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.yellow));
            }
            inst_er.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            });
        }



        upeasyFlipView.setOnFlipListener((flipView, newCurrentSide) -> {

            upeasyFlipView.setFlipDuration(350);
            if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
            {
                downeasyFlipView.flipTheView();
                upeasyFlipView.setAutoFlipBack(true);
                upeasyFlipView.setAutoFlipBackTime(2000);
            }
            if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
            {
                downeasyFlipView.flipTheView();
            }

            switch(position1) {
                case 0:
                    //Turn Back
                    upBack.setText(getString(R.string.per_up_one));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setBackgroundColor(Color.rgb(253,58,58));
                    downBack.setText(getString(R.string.per_down_one));

                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }

                    position1++;
                    break;
                case 1:
                    upFront.setText(getString(R.string.que_up_two));
                    downFront.setText(getString(R.string.que_down_two));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 2:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_two));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setText(getString(R.string.per_down_two));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 3:
                    //Turn Front
                    upFront.setText(getString(R.string.que_up_three));
                    downFront.setText(getString(R.string.que_down_three));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 4:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_three));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setText(getString(R.string.per_down_three));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 5:
                    //Turn Front
                    upFront.setText(getString(R.string.que_up_four));
                    downFront.setText(getString(R.string.que_down_four));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 6:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_four));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setText(getString(R.string.per_down_four));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 7:
                    //Turn front
                    upFront.setText(getString(R.string.que_up_five));
                    downFront.setText(getString(R.string.que_down_five));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 8:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_five));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setText(getString(R.string.per_down_five));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 9:
                    //Turn Front
                    upFront.setText(getString(R.string.que_up_six));
                    downFront.setText(getString(R.string.que_down_six));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 10:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_six));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    downBack.setText(getString(R.string.per_down_six));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 11:
                    //Turn Front (7)
                    upFront.setText(getString(R.string.que_up_seven));
                    downFront.setText(getString(R.string.que_down_seven));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 12:
                    //Turn Back (7)
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_seven));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    downBack.setText(getString(R.string.per_down_seven));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 13:
                    //Turn front (8)
                    upFront.setText(getString(R.string.que_up_eight));
                    downFront.setText(getString(R.string.que_down_eight));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 14:
                    //Turn Back (8)
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_eight));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    downBack.setText(getString(R.string.per_down_eight));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 15:
                    //Turn Front (9)
                    upFront.setText(getString(R.string.que_up_nine));
                    downFront.setText(getString(R.string.que_down_nine));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 16:
                    //Turn Back (9)
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_nine));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    downBack.setText(getString(R.string.per_down_nine));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 17:
                    //Turn Front (10)
                    upFront.setText(getString(R.string.que_up_ten));
                    downFront.setText(getString(R.string.que_down_ten));
                    //Turn Front
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    position1++;
                    break;
                case 18:
                    //Turn back (11)
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_ten));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    downBack.setText(getString(R.string.per_down_ten));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        //downeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;
                case 19:
                    //Turn Front
                    upFront.setText("End of questions "+getEmojiByUnicode(unicode));
                    downFront.setText("End of questions "+getEmojiByUnicode(unicode));
                    if(upeasyFlipView.isFrontSide() && downeasyFlipView.isBackSide())
                    {
                        downeasyFlipView.flipTheView();
                        break;
                    }
                    Toast.makeText(this, ""+getString(R.string.insts_end), Toast.LENGTH_LONG).show();
                    position1++;
                    break;
                case 20:
                    //Turn Back
                    upBack.setBackgroundColor(Color.rgb(0,0,255));
                    upBack.setText("End of questions "+getEmojiByUnicode(unicode));
                    downBack.setBackgroundColor(Color.rgb(0,0,255));
                    downBack.setText("End of questions "+getEmojiByUnicode(unicode));
                    if(upeasyFlipView.isBackSide() && downeasyFlipView.isFrontSide())
                    {
                        downeasyFlipView.flipTheView();
                        upeasyFlipView.setAutoFlipBack(true);
                        upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position1++;
                    break;

            }

        });

        downeasyFlipView.setOnFlipListener((flipView, newCurrentSide) -> {
            downeasyFlipView.setFlipDuration(350);
            if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
            {
                upeasyFlipView.flipTheView();
                downeasyFlipView.setAutoFlipBack(true);
                downeasyFlipView.setAutoFlipBackTime(2000);
            }
            if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
            {
                upeasyFlipView.flipTheView();
            }

            switch(position2) {
                case 0:
                    //Turn Back
                    downBack.setText(getString(R.string.per_down_one));
                    downBack.setBackgroundColor(Color.rgb(253,58,58));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_one));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                    }
                    position2++;
                    break;
                case 1:
                    //Turn Front
                    downFront.setText(getString(R.string.que_down_two));
                    upFront.setText(getString(R.string.que_up_two));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 2:
                    //Turn Back
                    downBack.setText(getString(R.string.per_down_two));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_two));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 3:
                    //Turn Front (3)
                    downFront.setText(getString(R.string.que_down_three));
                    upFront.setText(getString(R.string.que_up_three));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 4:
                    //Turn Back (3)
                    downBack.setText(getString(R.string.per_down_three));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_three));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 5:
                    //Turn Front (4)
                    downFront.setText(getString(R.string.que_down_four));
                    upFront.setText(getString(R.string.que_up_four));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 6:
                    //Turn Back (4)
                    downBack.setText(getString(R.string.per_down_four));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_four));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 7:
                    //Turn Front (5)
                    downFront.setText(getString(R.string.que_down_five));
                    upFront.setText(getString(R.string.que_up_five));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 8:
                    //Turn Back (5)
                    downBack.setText(getString(R.string.per_down_five));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_five));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 9:
                    //Turn Front (6)
                    downFront.setText(getString(R.string.que_down_six));
                    upFront.setText(getString(R.string.que_up_six));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 10:
                    //Turn Back (6)
                    downBack.setText(getString(R.string.per_down_six));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_six));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 11:
                    //Turn front (7)
                    downFront.setText(getString(R.string.que_down_seven));
                    upFront.setText(getString(R.string.que_up_seven));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 12:
                    //Turn Back (7)
                    downBack.setText(getString(R.string.per_down_seven));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_seven));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 13:
                    //Turn Front (8)
                    downFront.setText(getString(R.string.que_down_eight));
                    upFront.setText(getString(R.string.que_up_eight));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 14:
                    //Turn Back (8)
                    downBack.setText(getString(R.string.per_down_eight));
                    downBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setText(getString(R.string.per_up_eight));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 15:
                    //Turn Front (9)
                    downFront.setText(getString(R.string.que_down_nine));
                    upFront.setText(getString(R.string.que_up_nine));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 16:
                    //Turn Back (9)
                    downBack.setText(getString(R.string.per_down_nine));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_nine));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 17:
                    //Turn Front (10)
                    downFront.setText(getString(R.string.que_down_ten));
                    upFront.setText(getString(R.string.que_up_ten));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    position2++;
                    break;
                case 18:
                    //Turn Back (10)
                    downBack.setText(getString(R.string.per_down_ten));
                    downBack.setBackgroundColor(Color.rgb(255,0,0));
                    upBack.setBackgroundColor(Color.rgb(123,197,45));
                    upBack.setText(getString(R.string.per_up_ten));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;
                case 19:
                    //Turn Front
                    downFront.setText("End of questions"+getEmojiByUnicode(unicode));
                    upFront.setText("End of questions "+getEmojiByUnicode(unicode));
                    if (downeasyFlipView.isFrontSide() && upeasyFlipView.isBackSide())
                    {
                        upeasyFlipView.flipTheView();
                        break;
                    }
                    Toast.makeText(this, ""+getString(R.string.insts_end), Toast.LENGTH_LONG).show();
                    position2++;
                    break;
                case 20:
                    //Turn Back
                    downBack.setText("End of questions "+getEmojiByUnicode(unicode));
                    downBack.setBackgroundColor(Color.rgb(0,0,255));
                    upBack.setBackgroundColor(Color.rgb(0,0,255));
                    upBack.setText("End of questions "+getEmojiByUnicode(unicode));
                    if (downeasyFlipView.isBackSide() && upeasyFlipView.isFrontSide())
                    {
                        upeasyFlipView.flipTheView();
                        downeasyFlipView.setAutoFlipBack(true);
                        downeasyFlipView.setAutoFlipBackTime(2000);
                        //upeasyFlipView.setAutoFlipBackTime(2000);
                        break;
                    }
                    position2++;
                    break;

            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.three_dots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.moreVertical:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                //About US
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}