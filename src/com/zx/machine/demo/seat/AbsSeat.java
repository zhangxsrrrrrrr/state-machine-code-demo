package com.zx.machine.demo.seat;


import com.zx.machine.demo.Poker;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsSeat implements ISeat {
    protected long playerId;

    protected final int seatNo;

    protected final List<Poker> pokerList = new ArrayList<>();

    protected AbsSeat(int seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public long getPlayerId() {
        return this.playerId;
    }
}
