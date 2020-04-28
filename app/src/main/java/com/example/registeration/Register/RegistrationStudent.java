package com.example.registeration.Register;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registeration.MainActivity;
import com.example.registeration.R;
import com.example.registeration.studentdata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationStudent extends AppCompatActivity {

    Button btn;
    private Button btnMainMenu;

    EditText name,pass,ph,email;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_student);

        name=(EditText)findViewById(R.id.studentname);

        pass=(EditText)findViewById(R.id.studentpass);

        ph=(EditText)findViewById(R.id.studentphno);

        email=(EditText)findViewById(R.id.studentemail);
        btn=findViewById(R.id.btnregisterstudent);

        btnMainMenu=findViewById(R.id.btnMainMenu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studname,studpass,studph,studemail;

                studname=name.getText().toString();

                studpass=pass.getText().toString();

                studph=ph.getText().toString();

                studemail=email.getText().toString();

                studentdata s=new studentdata(studname,studpass,studph,studemail);

                databaseReference.push().setValue(s);
                Toast.makeText(RegistrationStudent.this,"inserted data",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegistrationStudent.this, MainActivity.class);
                startActivity(intent);


            }
        });

        databaseReference= FirebaseDatabase.getInstance().getReference().child("studentlogin");


        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationStudent.this,MainActivity.class));
            }
        });
    }
}
