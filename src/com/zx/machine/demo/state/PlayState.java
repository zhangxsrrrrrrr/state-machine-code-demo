package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.Poker;
import com.zx.machine.demo.seat.ISeat;
import com.zx.machine.demo.table.ITable;

import java.util.List;

public class PlayState extends AbsState{
    public PlayState(ITable table, GameContext gameContext) {
        super(table, gameContext);
    }

    @Override
    public void enter() {
        System.out.println("桌子进入了开始游戏状态");

        List<ISeat> seats = this.table.getSeats();
        // 手牌清除
        for (ISeat seat : seats) {
            seat.clean();
        }

        // 发牌
        for (int i = 1; i <= 20; i++) {
            ISeat seat = seats.get(i % 4);
            seat.accept(new Poker(i));
        }
    }

    @Override
    public void update() {
        // 出牌
        while (true) {
            List<ISeat> seats = this.table.getSeats();
            for (ISeat seat : seats) {
                if (finish()) {
                    return;
                }
                seat.payPoker();
            }
        }
    }

    @Override
    public int getCode() {
        return 102;
    }

    @Override
    public int getNextState() {
        return 103;
    }

    @Override
    public boolean finish() {
        // 有人手牌打完了
        List<ISeat> seats = this.table.getSeats();
        for (ISeat seat : seats) {
            if (seat.leftPokerNum() == 0) {
                return true;
            }
        }
        return false;
    }
}
