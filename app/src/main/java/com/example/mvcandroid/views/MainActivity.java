package com.example.mvcandroid.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvcandroid.R;
import com.example.mvcandroid.controllers.LoginController;
import com.example.mvcandroid.models.User;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText username;
    EditText password;
    Button login;
    LoginController loginController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);
        loginController = new LoginController(this);


        login.setOnClickListener(view ->
        {

            User user = new User();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            loginController.doLogin(user);

        });
    }

    @Override
    public void onSuccess() {

        Toast.makeText(this, "Login Succeed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }
}
