package com.example.basketball.controller.managers;

import com.example.basketball.model.UserToken;

public interface LoginCallback {
    void onSuccess(UserToken userToken);
    void onFailure(Throwable t);
}
