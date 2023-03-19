package com.btl_nhom14.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class btl_nhom14_activityRegister extends AppCompatActivity {

    btl_nhom14_MyDB db;
    EditText username,password,repassword,phone,id;
    Button buttonThoat, buttonDongY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btl_nhom14_register);
        buttonThoat = findViewById(R.id.btnThoat);
        buttonDongY = findViewById(R.id.btnDongY);

        username = findViewById(R.id.etEmail);
        password = findViewById(R.id.etMatKhau);
        repassword = findViewById(R.id.etMatKhau2);
        phone = findViewById(R.id.etSdt);
        id = findViewById(R.id.etCccd);

        db = new btl_nhom14_MyDB(this);
        buttonDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String phone1 = phone.getText().toString();
                String id1 = id.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals("")||phone1.equals("")||id1.equals("")){
                    Toast.makeText(btl_nhom14_activityRegister.this, "Bạn đã nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(repass)){
                        boolean check = db.KiemTraUser(user);
                        if(check == false){
                            boolean insert = db.addAccount(user,pass,phone1,id1);
                            if(insert == true){
                                Toast.makeText(btl_nhom14_activityRegister.this, "Đăng kí tài khoản thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(btl_nhom14_activityRegister.this, "Tên tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
//
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(btl_nhom14_activityRegister.this, btl_nhom14_activityLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}