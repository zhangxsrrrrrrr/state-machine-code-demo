package com.zx.machine.demo.state;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.table.ITable;

public abstract class AbsState implements IState {
    protected final ITable table;

    protected final GameContext gameContext;

    public AbsState(ITable table, GameContext gameContext) {
        this.table = table;
        this.gameContext = gameContext;
    }
}
