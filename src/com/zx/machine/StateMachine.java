package com.zx.machine;

import com.zx.machine.demo.state.IState;
import com.zx.machine.demo.table.DemoTable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class StateMachine<TState extends IState> {

    private final Map<Integer, TState> stateMap = new ConcurrentHashMap<>();

    private DemoTable table = new DemoTable();

    private TState currentState;

    private final String machineId;

    public StateMachine() {
        machineId = UUID.randomUUID().toString();
    }

    public String getMachineId() {
        return this.machineId;
    }

    public void addState(TState state) {
        stateMap.put(state.getCode(), state);
    }

    public void switchState(int code) {
        if (!stateMap.containsKey(code)) {
            throw new RuntimeException("找不到对应的状态");
        }
        this.currentState = stateMap.get(code);
    }

    public void start(int code) {
        switchState(code);
    }

    public void update() {
        while (true) {
            currentState.enter();
            currentState.update();
            if (currentState.finish()) {
                int nextState = currentState.getNextState();
                currentState = stateMap.get(nextState);
            }
        }
    }
}

