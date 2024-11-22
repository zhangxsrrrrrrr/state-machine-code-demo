package com.zx.machine;

import com.zx.machine.demo.GameContext;
import com.zx.machine.demo.state.*;
import com.zx.machine.demo.table.DemoTable;

import java.util.concurrent.ConcurrentHashMap;

public class App {
    private final static ConcurrentHashMap<String, StateMachine> machineMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        new Thread(() -> {
            DemoTable demoTable = new DemoTable();
            GameContext gameContext = new GameContext();
            StateMachine<IState> stateMachine = new StateMachine<>();

            WaitState startState = new WaitState(demoTable, gameContext);
            stateMachine.addState(startState);
            stateMachine.addState(new SettleState(demoTable, gameContext));
            stateMachine.addState(new ReadyState(demoTable, gameContext));
            stateMachine.addState(new PlayState(demoTable, gameContext));
            stateMachine.addState(new FinishState(demoTable, gameContext));

            stateMachine.start(startState.getCode());
            stateMachine.update();
        }).start();


        hung();
    }

    /**
     * 线程挂起
     */
    public static void hung() {
        try {
            synchronized (machineMap) {
                machineMap.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
