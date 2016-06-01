package com.example.administrator.doitmission_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GogaekActivity extends AppCompatActivity {
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gogaek);

        Intent rIntent = getIntent();
        String title = rIntent.getStringExtra("clickedName");
        Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();

        btnMenu = (Button) findViewById(R.id.btn_menuGogaek);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.putExtra("back", "Back from Gogaek activity");
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });
    }
}
