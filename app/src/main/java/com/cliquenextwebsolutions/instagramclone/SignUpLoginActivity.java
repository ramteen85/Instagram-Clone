package com.cliquenextwebsolutions.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText editUsernameRegister, editPasswordRegister, editUsernameLogin, editPasswordLogin;
    private Button regBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login_activity);

        editUsernameLogin = findViewById(R.id.editUsernameLogin);
        editUsernameRegister = findViewById(R.id.editUsername);
        editPasswordLogin = findViewById(R.id.editPasswordLogin);
        editPasswordRegister = findViewById(R.id.editPassword);
        regBtn = findViewById(R.id.regBtn);
        loginBtn = findViewById(R.id.loginBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParseUser appUser = new ParseUser();
                appUser.setUsername(editUsernameRegister.getText().toString());
                appUser.setPassword(editPasswordRegister.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null) {
                            FancyToast.makeText(SignUpLoginActivity.this, appUser.get("username") + " has registered successfully!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(SignUpLoginActivity.this,  "Error: " + e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(editUsernameLogin.getText().toString(), editPasswordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null && e == null) {
                            FancyToast.makeText(SignUpLoginActivity.this,  user.get("username") + " Logged in!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(SignUpLoginActivity.this,  "Error: " + e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

    }
}
