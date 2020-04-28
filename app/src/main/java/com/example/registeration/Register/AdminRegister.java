package com.example.registeration.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registeration.MainActivity;
import com.example.registeration.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminRegister extends AppCompatActivity {
    private EditText etadminname;
    private EditText etadminpassword;
    private EditText etadminmobilenumber;
    private EditText etadminemail;
    private Button btnregisterAdmin;
    private Button btnMainMenu;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        etadminname=findViewById(R.id.etadminname);
        etadminpassword=findViewById(R.id.etadminpassword);
        etadminmobilenumber=findViewById(R.id.etadminmobilenumber);
        etadminemail=findViewById(R.id.etadminemail);
        btnregisterAdmin=findViewById(R.id.btnregisterAdmin);
        btnMainMenu=findViewById(R.id.btnMainMenu);




        btnregisterAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DATABASE OF ADMIN

                String adminname,adminpass,adminph,adminemail;

                adminname=etadminname.getText().toString();

                adminpass=etadminpassword.getText().toString();

                adminph=etadminmobilenumber.getText().toString();

                adminemail=etadminemail.getText().toString();

                admindata a=new admindata(adminname,adminpass,adminph,adminemail);

                databaseReference.push().setValue(a);

                Toast.makeText(AdminRegister.this,"inserted data",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(AdminRegister.this, MainActivity.class);
                startActivity(intent);

            }
        });

        databaseReference= FirebaseDatabase.getInstance().getReference().child("adminlogin");

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminRegister.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
