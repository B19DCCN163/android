package com.hfad.th2android.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hfad.th2android.R;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLog, btnReg;
    Context context = LoginActivity.this;
    EditText edt_tk , edt_mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        btnReg = findViewById(R.id.btnReg);
        btnLog = findViewById(R.id.btnLog);
        edt_tk = findViewById(R.id.edt_tk);
        edt_mk = findViewById(R.id.edt_mk);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }
    private  void register(){
        String tk,mk;
        tk = edt_tk.getText().toString();
        mk = edt_mk.getText().toString();
        if(TextUtils.isEmpty(tk)){
            Toast.makeText(context, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mk)){
            Toast.makeText(context, "Vui long nhap pass", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(tk,mk).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Tạo Thành Công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn tên đăng nhập khác", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void login() {
        String tk, mk;
        tk = edt_tk.getText().toString();
        mk = edt_mk.getText().toString();
        if (TextUtils.isEmpty(tk)) {
            Toast.makeText(context, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mk)) {
            Toast.makeText(context, "Vui long nhap pass", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(context, "Thông tin đăng nhập không đúng",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });
    }}