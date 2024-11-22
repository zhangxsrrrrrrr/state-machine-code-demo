package com.zx.machine.demo.seat;

import com.zx.machine.demo.Poker;

public interface ISeat {
    void accept(Poker poker);

    void payPoker();

    boolean sitDown(long playerId);

    int leftPokerNum();

    long getPlayerId();

    void clean();
}
