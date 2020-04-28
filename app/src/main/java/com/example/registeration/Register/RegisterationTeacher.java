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

public class RegisterationTeacher extends AppCompatActivity {
    private EditText name,pass,ph,email;
    private Button btnregisterteacher;
    private Button btnMainMenu;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_teacher);

        name = findViewById(R.id.etteachername);
       pass = findViewById(R.id.etteacherpassword);
        ph = findViewById(R.id.etteachermobilenumber);
       email = findViewById(R.id.etteacheremail);
        btnregisterteacher = findViewById(R.id.btnregisterteacher);
        btnMainMenu = findViewById(R.id.btnMainMenu);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teacherlogin");

        btnregisterteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teachername,teacherpass,teacherph,teachermail;

                teachername=name.getText().toString();

                teacherpass=pass.getText().toString();

                teacherph=ph.getText().toString();

                teachermail=email.getText().toString();
                teacherdata t=new teacherdata(teachername,teacherpass,teacherph,teachermail);
                databaseReference.push().setValue(t);
                Toast.makeText(RegisterationTeacher.this,"inserted data",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegisterationTeacher.this, MainActivity.class);
                startActivity(intent);

            }
        });


        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterationTeacher.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
