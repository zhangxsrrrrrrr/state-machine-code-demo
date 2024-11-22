package com.zx.machine.demo.table;

import com.zx.machine.demo.seat.ISeat;

import java.util.List;

public interface ITable {
    boolean full();

    boolean sitDown(long playerId);

    List<ISeat> getSeats();

    void buildSeats(List<ISeat> seatList);
}
