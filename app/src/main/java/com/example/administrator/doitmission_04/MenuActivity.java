package com.example.administrator.doitmission_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_GOGAEK = 2001;
    public static final int REQUEST_CODE_MAECHUL = 2002;
    public static final int REQUEST_CODE_SANGPUM = 2003;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent mIntent = getIntent();
        String id = mIntent.getStringExtra("id");
        String pwd = mIntent.getStringExtra("pwd");

        Toast.makeText(getApplicationContext(), "id : " + id + ", pwd : " + pwd, Toast.LENGTH_SHORT).show();

        btn0 = (Button) findViewById(R.id.btn_menuLogin);

        btn1 = (Button) findViewById(R.id.btn_gogaek);

        btn2 = (Button) findViewById(R.id.btn_maechul);

        btn3 = (Button) findViewById(R.id.btn_sangpum);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_menuLogin:
//                mIntent = new Intent(getApplicationContext(), MainActivity.class);
                Intent mIntent = new Intent();
                mIntent.putExtra("clickedName", "Back from menu");
                setResult(Activity.RESULT_OK, mIntent);
                finish();
                break;

            case R.id.btn_gogaek:
                Intent gogaekIntent = new Intent(getApplicationContext(), GogaekActivity.class);
                gogaekIntent.putExtra("clickedName", btn1.getText().toString());
                startActivityForResult(gogaekIntent, REQUEST_CODE_GOGAEK);
                break;

            case R.id.btn_maechul:
                Intent maechulIntent = new Intent(getApplicationContext(), MaechulActivity.class);
                maechulIntent.putExtra("clickedName", btn2.getText().toString());
                startActivityForResult(maechulIntent, REQUEST_CODE_MAECHUL);
                break;

            case R.id.btn_sangpum:
                Intent sangpumIntent = new Intent(getApplicationContext(), SangpumActivity.class);
                sangpumIntent.putExtra("clickedName", btn3.getText().toString());
                startActivityForResult(sangpumIntent, REQUEST_CODE_SANGPUM);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            if(requestCode == REQUEST_CODE_GOGAEK) {
                Toast.makeText(getApplicationContext(), data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
            } else if(requestCode == REQUEST_CODE_MAECHUL) {
                Toast.makeText(getApplicationContext(), data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
            } else if(requestCode == REQUEST_CODE_SANGPUM) {
                Toast.makeText(getApplicationContext(), data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
