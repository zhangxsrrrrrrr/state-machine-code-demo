package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.seat.DemoSeat;
import com.zx.machine.demo.seat.ISeat;
import com.zx.machine.demo.table.ITable;

import java.util.ArrayList;

public class WaitState extends AbsState {
    public WaitState(ITable table, GameContext context) {
        super(table, context);
    }

    // region 状态的核心


    @Override
    public void enter() {
        System.out.println("进入等待状态，等待玩家进入桌子");

        // 对桌子进行初始化
        ArrayList<ISeat> seats = new ArrayList<>();
        seats.add(new DemoSeat(0));
        seats.add(new DemoSeat(1));
        seats.add(new DemoSeat(2));
        seats.add(new DemoSeat(3));
        this.table.buildSeats(seats);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean finish() {
        return this.table.getSeats().size() == 4;
    }

    // endregion

    @Override
    public int getCode() {
        return 100;
    }

    @Override
    public int getNextState() {
        return 101;
    }

}
