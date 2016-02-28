package com.example.basketball.controller.activities.login;

import com.example.basketball.model.UserToken;

public interface LoginCallback {
    void onSuccess(UserToken userToken);
    void onFailure(Throwable t);
}
