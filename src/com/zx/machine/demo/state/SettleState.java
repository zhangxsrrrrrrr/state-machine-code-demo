package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.seat.ISeat;
import com.zx.machine.demo.table.ITable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SettleState extends AbsState {
    private HashMap<Long, Boolean> goOnMap = new HashMap<>();

    public SettleState(ITable table, GameContext gameContext) {
        super(table, gameContext);
    }

    @Override
    public void enter() {
        System.out.println("桌子进入结算");
    }

    @Override
    public void update() {
        // 游戏结算， 加减奖励 ... ...

        // 是否选择继续
        Scanner scanner = new Scanner(System.in);
        List<ISeat> seats = this.table.getSeats();
        for (ISeat seat : seats) {
            boolean goOn = scanner.nextInt() == 1;
            long playerId = seat.getPlayerId();
            goOnMap.put(playerId, goOn);
        }
    }

    @Override
    public int getCode() {
        return 103;
    }

    @Override
    public int getNextState() {
        Collection<Boolean> values = goOnMap.values();
        long goOnNum = values.stream().filter(p -> p.equals(Boolean.TRUE)).count();
        if (goOnNum == 4) {
            return 102;
        }
        return 104;
    }

    @Override
    public boolean finish() {
        return goOnMap.size() == 4;
    }
}
