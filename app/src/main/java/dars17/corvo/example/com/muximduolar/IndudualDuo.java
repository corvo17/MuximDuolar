package dars17.corvo.example.com.muximduolar;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

import java.util.Objects;

public class IndudualDuo extends AppCompatActivity {
    private Toolbar toolbar;
    public static final String THEME_KEY = "themeKey";
    private MediaPlayer myMediaPlay;
    private int pause;
    private TextView textView;
    private TextView arabText;
    private float textSize = 16;
    private float talafuzTVS = 16;
    private ImageView playImage;
    private float arabTextSize = 22;
    private TextView talafuzTV;
    private TextView contentTV;
    private TextView TV;
    private ConstraintLayout individualActivity;
    private ImageView IVFaded;
    private ImageView IVBrown;
    private ImageView IVBlack;
    private SharedPreferences backColor;
    private SharedPreferences.Editor editor;
    private int media;
    private ImageView imgView;
    private String dalil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idividual_activity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textView = findViewById(R.id.textView5);
        arabText = findViewById(R.id.arabTV);
        playImage = findViewById(R.id.playImage);
        talafuzTV = findViewById(R.id.textView3);
        contentTV = findViewById(R.id.textView2);
        TV = findViewById(R.id.textView);
        imgView = findViewById(R.id.imageView3);
        individualActivity = findViewById(R.id.individualActivity);
        setItems();
      //  Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        myMediaPlay = MediaPlayer.create(this, media);
        pause = 0;
        saveTheme();

    }

    private void setItems() {
        Intent intent = getIntent();
        String[] myString = intent.getStringArrayExtra("myString");

        int img = Integer.parseInt(myString[1]);
         media = Integer.parseInt(myString[5]);
         dalil = myString[4];
        TV.setText(myString[0]);
        imgView.setImageResource(img);
        contentTV.setText(myString[2]);
        arabText.setText(myString[3]);
        talafuzTV.setText(myString[6]);
        textView.setText(myString[7]);


    }

    private void saveTheme() {
        backColor = getSharedPreferences(THEME_KEY, MODE_PRIVATE);
        int value = backColor.getInt("KEY", 0);
        int value2 = backColor.getInt("KEY_TV", R.color.black1);
        float value3 = backColor.getFloat("KEY_TVS1",textSize);
        float value4 = backColor.getFloat("KEY_TVS2",textSize);
        float value5 = backColor.getFloat("KEY_TVS3",textSize);
        if (value == 0) {
            editor = backColor.edit();
            editor.putInt("KEY", R.color.white);
            editor.apply();
        }
        individualActivity.setBackgroundColor(getResources().getColor(backColor.getInt("KEY", R.color.white)));
        contentTV.setTextColor(getResources().getColor(backColor.getInt("KEY_TV",value2)));
        arabText.setTextColor(getResources().getColor(backColor.getInt("KEY_TV",value2)));
        textView.setTextColor(getResources().getColor(backColor.getInt("KEY_TV",value2)));
        TV.setTextColor(getResources().getColor(backColor.getInt("KEY_TV",value2)));

        contentTV.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
        textView.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
        arabText.setTextSize(backColor.getFloat("KEY_TVS2",arabTextSize));
        talafuzTV.setTextSize(backColor.getFloat("KEY_TVS3",talafuzTVS));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            finish();
        }
        if (item.getItemId() == R.id.DupIndividual) {
            BottomSheetDialog myDialog = new BottomSheetDialog(this);
            View view = LayoutInflater.from(this).inflate(R.layout.dialog_item, null);
            IVFaded = view.findViewById(R.id.IVFaded);
            IVBrown = view.findViewById(R.id.IVBrown);
            IVBlack = view.findViewById(R.id.IVBlack);
            myDialog.setContentView(view);
            myDialog.show();
        }
        return true;
    }

    public void playClick(View view) {
        if (myMediaPlay.isPlaying()) {
            pause = myMediaPlay.getCurrentPosition();
            myMediaPlay.pause();
            playImage.setImageResource(R.drawable.ic_play);

        } else {
            myMediaPlay.seekTo(pause);
            myMediaPlay.start();
            playImage.setImageResource(R.drawable.ic_plause);
        }
    }

    public void myAdding(View view) {
        if (textSize <= 30) {
            textSize = backColor.getFloat("KEY_TVS1",textSize);
            textSize++;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS1",textSize);
            editor.apply();

        }
        textView.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
        contentTV.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
    }

    public void myMinus(View view) {
        if (textSize >= 10) {
            textSize = backColor.getFloat("KEY_TVS1",textSize);
            textSize--;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS1",textSize);
            editor.apply();
        }
        textView.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
        contentTV.setTextSize(backColor.getFloat("KEY_TVS1",textSize));
    }

    public void myArabAdding(View view) {
        if (arabTextSize <= 30) {
            arabTextSize = backColor.getFloat("KEY_TVS2",arabTextSize);
            arabTextSize++;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS2",arabTextSize);
            editor.apply();

        }
        arabText.setTextSize(arabTextSize);
    }

    public void myArabMinus(View view) {
        if (arabTextSize >= 10) {
            arabTextSize = backColor.getFloat("KEY_TVS2",arabTextSize);
            arabTextSize--;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS2",arabTextSize);
            editor.apply();
        }
        arabText.setTextSize(arabTextSize);
    }

    public void myGreenPlus(View view) {
        if (talafuzTVS <= 30) {
            talafuzTVS = backColor.getFloat("KEY_TVS3",talafuzTVS);
            talafuzTVS++;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS3",talafuzTVS);
            editor.apply();

        }
        talafuzTV.setTextSize(talafuzTVS);
    }

    public void myGreenMinus(View view) {
        if (talafuzTVS >= 10) {
            talafuzTVS = backColor.getFloat("KEY_TVS3",talafuzTVS);
            talafuzTVS--;
            editor = backColor.edit();
            editor.putFloat("KEY_TVS3",talafuzTVS);
            editor.apply();
        }
        talafuzTV.setTextSize(talafuzTVS);
    }

    public void backgroundChange(View view) {
        if (view.getId() == IVFaded.getId()) {
            editor = backColor.edit();
            editor.putInt("KEY", R.color.faded);
            editor.putInt("KEY_TV",R.color.black1);
            editor.apply();
            individualActivity.setBackgroundColor(getResources().getColor(R.color.faded));
            contentTV.setTextColor(getResources().getColor(R.color.black1));
            arabText.setTextColor(getResources().getColor(R.color.black1));
            textView.setTextColor(getResources().getColor(R.color.black1));
            TV.setTextColor(getResources().getColor(R.color.black1));

        }
        if (view.getId() == IVBrown.getId()) {
            editor = backColor.edit();
            editor.putInt("KEY", R.color.brown);
            editor.putInt("KEY_TV",R.color.black1);
            editor.apply();
            individualActivity.setBackgroundColor(getResources().getColor(R.color.brown));
            contentTV.setTextColor(getResources().getColor(R.color.black1));
            arabText.setTextColor(getResources().getColor(R.color.black1));
            textView.setTextColor(getResources().getColor(R.color.black1));
            TV.setTextColor(getResources().getColor(R.color.black1));
        }
        if (view.getId() == IVBlack.getId()) {
            editor = backColor.edit();
            editor.putInt("KEY", R.color.black);
            editor.putInt("KEY_TV",R.color.white);
            editor.apply();
            individualActivity.setBackgroundColor(getResources().getColor(R.color.black));
            contentTV.setTextColor(getResources().getColor(R.color.white));
            arabText.setTextColor(getResources().getColor(R.color.white));
            textView.setTextColor(getResources().getColor(R.color.white));
            TV.setTextColor(getResources().getColor(R.color.white));
        }
    }

   /* public void textTypeChange(View view) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1){
        if (view.getId() == textType2.getId()) {
                textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                contentTV.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                Toast.makeText(this, "Justificationtrue", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == textType1.getId()) {
                contentTV.setJustificationMode(Layout.JUSTIFICATION_MODE_NONE);
                textView.setJustificationMode(Layout.JUSTIFICATION_MODE_NONE);
                textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                contentTV.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                Toast.makeText(this, "LeftSraight true ", Toast.LENGTH_SHORT).show();

        }
            if (view.getId() == textType3.getId()) {

                textView.setJustificationMode(Layout.JUSTIFICATION_MODE_NONE);
                contentTV.setJustificationMode(Layout.JUSTIFICATION_MODE_NONE);
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                contentTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show();

            }
            }

        }*/

    public void dalilClick(View view) {
        Dialog dalilD = new Dialog(this);
        View view1 = LayoutInflater.from(this).inflate(R.layout.dalil_dialog,null);
        JustifiedTextView tv = view1.findViewById(R.id.dalil);
        tv.setText(dalil);
        dalilD.setContentView(view1);
        dalilD.show();
        Window window = dalilD.getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
    }
}
