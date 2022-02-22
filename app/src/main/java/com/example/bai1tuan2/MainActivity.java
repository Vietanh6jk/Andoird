package com.example.bai1tuan2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_TaiKhoan= findViewById(R.id.editText_TaiKhoan);
        EditText et_MatKhau = findViewById(R.id.editText_MatKhau);
        CheckBox cb_LuuTT = findViewById(R.id.checkBox_LuuTT);
        Button bt_DangNhap = findViewById(R.id.button_DangNhap);
        Button bt_Thoat = findViewById(R.id.button_Thoat);

        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(cb_LuuTT.isChecked() == true){
                    Toast toast= Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống,thông tin của bạn đã được lưu",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast= Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống,thông tin của bạn không được lưu",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });
    }
    public void OnClick(View v){
        AlertDialog.Builder builder= new AlertDialog.Builder(v.getContext());
        builder.setMessage(getResources().getString(R.string.message_dialog_exist));
        builder.setTitle(getResources().getString(R.string.message_dialog_exist_tile));
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton(getResources().getString(R.string.mesage_dialog_ok),
                new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        builder.setNegativeButton(getResources().getString(R.string.message_dialog_cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}