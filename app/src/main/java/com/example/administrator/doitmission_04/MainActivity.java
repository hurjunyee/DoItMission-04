package com.example.administrator.doitmission_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 1001;

    Button loginBtn;
    EditText editId, editPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editId.getText().toString().equals("") || editPwd.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "ID 혹은 비밀번호 입력 확인", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent mIntent = new Intent(getApplicationContext(), MenuActivity.class);
                mIntent.putExtra("id", editId.getText().toString());
                mIntent.putExtra("pwd", editPwd.getText().toString());

                startActivityForResult(mIntent, REQUEST_CODE_MENU);
            }
        });

        editId = (EditText) findViewById(R.id.edit_id);

        editPwd = (EditText) findViewById(R.id.edit_pwd);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String buttonName;

        if(data != null) {
            if (requestCode == REQUEST_CODE_MENU) {
                if (resultCode == RESULT_OK) {
                    buttonName = data.getStringExtra("clickedName");
                    Toast.makeText(getApplicationContext(), buttonName, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
