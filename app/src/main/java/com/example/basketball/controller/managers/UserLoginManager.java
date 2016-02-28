package com.example.basketball.controller.managers;

import android.content.Context;
import android.util.Log;

import com.example.basketball.controller.activities.login.LoginCallback;
import com.example.basketball.model.UserToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginManager {
    private static UserLoginManager ourInstance;
    private UserToken userToken;
    private Context context;

    public static UserLoginManager getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new UserLoginManager(context);
        }

        ourInstance.context = context;
        return ourInstance;
    }

    private UserLoginManager(Context context) {
        this.context = context;
    }

    public synchronized void performLogin(String username, String password, final LoginCallback loginCallback){
        Call<UserToken> call =  UserTokenManager.getInstance(context).getUserToken(username, password);

        call.enqueue(new Callback<UserToken>() {
            @Override
            public void onResponse(Call<UserToken> call, Response<UserToken> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                userToken = response.body();
                loginCallback.onSuccess(userToken);
            }

            @Override
            public void onFailure(Call<UserToken> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                loginCallback.onFailure(t);
            }
        });
    }

    public UserToken getUserToken(){
        return userToken;
    }
}