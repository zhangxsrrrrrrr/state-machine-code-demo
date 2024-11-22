package com.zx.machine.demo.seat;

import com.zx.machine.demo.Poker;

public class DemoSeat extends AbsSeat {

    public DemoSeat(int seatNo) {
        super(seatNo);
    }

    @Override
    public void accept(Poker poker) {
        this.pokerList.add(poker);
    }

    @Override
    public void payPoker() {
        this.pokerList.remove(0);
    }

    @Override
    public boolean sitDown(long playerId) {
        if (this.playerId != 0) {
            return false;
        }

        this.playerId = playerId;
        return true;
    }

    @Override
    public int leftPokerNum() {
        return this.pokerList.size();
    }

    @Override
    public void clean() {
        this.pokerList.clear();
    }
}
