package com.example.codecampchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button registerBtn, uploadBtn;
    private EditText nameEditText, emailEditText, passwordEditText, reenterPasswordEditText;
    private RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    private CheckBox agreeCheckBox;
    private RadioGroup genderRadioGroup;
    private TextView txtName, txtEmail, txtPassword, txtReenterPassword;
    private ConstraintLayout parent;
    private Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        if(validateData()) {
            if(agreeCheckBox.isChecked()){
                showSnackBar();
            }else{
                Toast.makeText(this, "You must aree to my terms beesh", Toast.LENGTH_SHORT).show();
            }
        }


    }


    private void showSnackBar(){
        txtName.setVisibility(View.GONE);
        txtEmail.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);
        txtReenterPassword.setVisibility(View.GONE);

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String location = country.getSelectedItem().toString();
        String gender = "";
        switch (genderRadioGroup.getCheckedRadioButtonId()){
            case(R.id.maleRdoBtn):
                gender= "Male";
                break;
            case(R.id.femaleRdoBtn):
                gender= "Female";
                break;
            case(R.id.otherRdoBtn):
                gender= "Other";
                break;
            default:
                gender = "unknown";
                break;
        }

        String info = "Name: " + name + "\n" +
                "Email: " + email + "\n"+
                "Country: " + location ;

        Snackbar.make(this,parent,info,500).setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailEditText.setText("");
                nameEditText.setText("");
                passwordEditText.setText("");
                reenterPasswordEditText.setText("");
            }
        }).show();
    }

    private Boolean validateData() {
        if(nameEditText.getText().toString().equals("")){
            txtName.setText("Enter yor name!");
            txtName.setVisibility(View.VISIBLE);
            return false;
        }

        if(emailEditText.getText().toString().equals("")){
            txtEmail.setText("Enter yor email!");
            txtEmail.setVisibility(View.VISIBLE);
            return false;
        }

        if(passwordEditText.getText().toString().equals("")){
            txtPassword.setText("Enter yor password!");
            txtPassword.setVisibility(View.VISIBLE);
            return false;
        }

        if(reenterPasswordEditText.getText().toString().equals("")){
            txtReenterPassword.setText("Enter yor password again!");
            txtReenterPassword.setVisibility(View.VISIBLE);
            return false;
        }

        if(!reenterPasswordEditText.getText().toString().equals(passwordEditText.getText().toString())){
            txtReenterPassword.setText("Enter the same password");
            txtReenterPassword.setVisibility(View.VISIBLE);
            return false;
        }

 return true;
    }

    private void initElements() {
        registerBtn = findViewById(R.id.registerBtn);
        uploadBtn = findViewById(R.id.uploadBtn);

        parent=findViewById(R.id.parentLayout);

        country = findViewById(R.id.countrySpnnr);

        maleRadioButton = findViewById(R.id.maleRdoBtn);
        femaleRadioButton = findViewById(R.id.femaleRdoBtn);
        otherRadioButton = findViewById(R.id.otherRdoBtn);
        genderRadioGroup = findViewById(R.id.genderRdoGrp);

        nameEditText = findViewById(R.id.nameEdtTxtx);
        emailEditText = findViewById(R.id.emailEdtTxt);
        passwordEditText = findViewById(R.id.passwordEdtTxt);
        reenterPasswordEditText = findViewById(R.id.reEnterPasswordEdtTxt);

        agreeCheckBox = findViewById(R.id.agreeChkBx);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtReenterPassword = findViewById(R.id.txtReenterPassword);

    }
}