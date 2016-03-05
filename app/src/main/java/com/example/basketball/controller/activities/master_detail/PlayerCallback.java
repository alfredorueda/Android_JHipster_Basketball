package com.example.basketball.controller.activities.master_detail;

import com.example.basketball.model.Player;

import java.util.List;

public interface PlayerCallback {
    void onSuccess(List<Player> playerList);

    void onFailure(Throwable t);
}
