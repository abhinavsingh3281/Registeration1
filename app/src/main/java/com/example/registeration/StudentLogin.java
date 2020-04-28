package com.example.registeration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentLogin extends AppCompatActivity {

    private EditText etemaillogin,etpasswordlogin;

    private Button btnpreviousmenustudent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);


        etemaillogin=findViewById(R.id.etemaillogin);
        etpasswordlogin=findViewById(R.id.etpasswordlogin);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("https://registeration-master.firebaseio.com/studentlogin");






                btnpreviousmenustudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentLogin.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
