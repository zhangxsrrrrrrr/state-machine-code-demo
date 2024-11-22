package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.table.ITable;

public class FinishState extends AbsState{
    public FinishState(ITable table, GameContext gameContext) {
        super(table, gameContext);
    }

    @Override
    public void enter() {
        // 清理操作
        System.out.println("开始清扫桌子");
    }

    @Override
    public void update() {
        System.exit(1);
    }

    @Override
    public int getCode() {
        return 104;
    }

    @Override
    public int getNextState() {
        return 0;
    }

    @Override
    public boolean finish() {
        return false;
    }
}
