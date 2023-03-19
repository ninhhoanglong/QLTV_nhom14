package com.btl_nhom14.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class btl_nhom14_activityUpdate extends AppCompatActivity {
    private EditText etMa,etTen,etLoai,etTacGia,etSoLuong,etGia;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btl_nhom14_update);
        anhXa();
        btnUpdate.setOnClickListener(view -> {
            if(btnUpdate.getText().toString().equals("UPDATE SÁCH")) {
                etTen.setEnabled(true);
                etLoai.setEnabled(true);
                etTacGia.setEnabled(true);
                etSoLuong.setEnabled(true);
                etGia.setEnabled(true);
                btnUpdate.setText("LƯU THÔNG TIN");
            }else if(btnUpdate.getText().toString().equals("LƯU THÔNG TIN")){
                String ten = etTen.getText().toString();
                String ma = etMa.getText().toString();
                String loai = etLoai.getText().toString();
                String tacgia = etTacGia.getText().toString();
                String soluong = etSoLuong.getText().toString();
                String gia = etGia.getText().toString();
                if(ten.isEmpty() || ma.isEmpty() || loai.isEmpty() ||tacgia.isEmpty() ||
                        soluong.isEmpty() ||gia.isEmpty() ) {
                    Toast.makeText(getApplicationContext(),"Không được bỏ trống thông tin nào",Toast.LENGTH_SHORT).show();
                }else{
                    btl_nhom14_Sach khachHANG = new btl_nhom14_Sach(ma,ten,loai,tacgia
                            ,Long.valueOf(soluong),Long.valueOf(gia));
                    btl_nhom14_DatabaseApp.getInstance(getApplicationContext()).getSachDao()
                            .updateSach(khachHANG);
                    Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                    btnUpdate.setText("UPDATE SÁCH");
                    etTen.setEnabled(false);
                    etLoai.setEnabled(false);
                    etTacGia.setEnabled(false);
                    etSoLuong.setEnabled(false);
                    etGia.setEnabled(false);
                }
            }
        });
    }

    private void anhXa() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        btl_nhom14_Sach sach = (btl_nhom14_Sach) bundle.getSerializable("SACH");
        etTen = findViewById(R.id.etTenSU);
        etTen.setText(sach.getTenSach());

        etMa = findViewById(R.id.etmaSU);
        etMa.setText(sach.getMaSach());

        etLoai = findViewById(R.id.etLoaiU);
        etLoai.setText(sach.getLoaiSach());

        etTacGia = findViewById(R.id.etTacU);
        etTacGia.setText(sach.getTacGia());

        etSoLuong = findViewById(R.id.etSoU);
        etSoLuong.setText(sach.getSoLuong()+"");

        etGia = findViewById(R.id.etGiaU);
        etGia.setText(sach.getGiaban()+"");

        btnUpdate = findViewById(R.id.btnUpdate);
    }
}