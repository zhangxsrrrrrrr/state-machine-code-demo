package com.zx.machine.demo.table;

import com.zx.machine.demo.seat.DemoSeat;
import com.zx.machine.demo.seat.ISeat;

import java.util.ArrayList;
import java.util.List;

public class DemoTable implements ITable {

    private List<ISeat> seatList;

    @Override
    public boolean full() {
        long count = seatList.stream().filter(p -> p.getPlayerId() > 0).count();
        return count == 4;
    }

    @Override
    public synchronized boolean sitDown(long playerId) {
        if (full()) {
            return false;
        }

        // 找位置坐下
        for (ISeat seat : seatList) {
            boolean sitDown = seat.sitDown(playerId);
            if (sitDown) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<ISeat> getSeats() {
        return this.seatList;
    }

    @Override
    public void buildSeats(List<ISeat> seatList) {
        this.seatList = seatList;
    }
}
