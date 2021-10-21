package com.example.mvcandroid.controllers;

import com.example.mvcandroid.models.User;
import com.example.mvcandroid.views.ILoginView;

public class LoginController implements ILoginController{
    private ILoginView view;

    public LoginController(ILoginView view) {this.view = view;}

    @Override
    public void doLogin(User user) {

        if (user == null)
        {view.onError("Please fill user information.");
        return;}
        if (!user.isValid())
        {view.onError("Please enter username and password(min len = 8).");
        return;}
        view.onSuccess();

    }
}
