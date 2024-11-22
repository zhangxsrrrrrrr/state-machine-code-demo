package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.seat.ISeat;
import com.zx.machine.demo.table.ITable;

import java.util.List;
import java.util.Scanner;

public class ReadyState extends AbsState {
    public ReadyState(ITable table, GameContext gameContext) {
        super(table, gameContext);
    }

    @Override
    public void enter() {
        System.out.println("桌子进入就绪状态，玩家可以进入了");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            long playerId = scanner.nextLong();
            boolean sitDown = this.table.sitDown(playerId);
            if (sitDown) {
                System.out.println("playerId: " + playerId + "  就坐成功");
            }

            if (finish()) {
                return;
            }
        }
    }

    @Override
    public int getCode() {
        return 101;
    }

    @Override
    public int getNextState() {
        return 102;
    }

    @Override
    public boolean finish() {
        List<ISeat> seats = this.table.getSeats();
        return seats.stream().filter(p -> p.getPlayerId() > 0).count() == 4;
    }
}
