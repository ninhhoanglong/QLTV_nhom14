package com.btl_nhom14.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class btl_nhom14_activityLogin extends AppCompatActivity {
    Button btn,btnDki;
    EditText email;
    EditText password;
    private btl_nhom14_MyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btl_nhom14_login);

        btn = findViewById(R.id.btDangNhap);
        btnDki = findViewById(R.id.btDangKi);
        email = findViewById(R.id.etSoLuong);
        password = findViewById(R.id.etPassword);

        db = new btl_nhom14_MyDB(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String mk = password.getText().toString();
                boolean kt = db.KiemTraDangNhap(mail,mk);
                if(kt==true)
                {
                    Toast.makeText(btl_nhom14_activityLogin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(btl_nhom14_activityLogin.this, btl_nhom14_activitymain.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(btl_nhom14_activityLogin.this, "Chưa điền đủ thông tin hoặc sai mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(btl_nhom14_activityLogin.this, btl_nhom14_activityRegister.class);
                startActivity(intent);
                finish();
            }
        });
    }
}