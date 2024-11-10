package com.zx.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class State {
    static State move, run, die, finish, rise, quit, current;

    // 已经复活的次数
    protected static int riseCounter = 0;

    protected final List<ActionEnum> actionList = new ArrayList<>();

    // 进入这个状态
    abstract void enter();

    // 更新状态
    abstract void update();
}

class MoveState extends State {

    @Override
    void enter() {
        // 初始化所有的操作
        actionList.add(ActionEnum.move);
        actionList.add(ActionEnum.medicine);
        actionList.add(ActionEnum.monster);
        System.out.println("进入了move的状态");
    }

    @Override
    void update() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 吃药");
            System.out.println("2 吃了怪物");
            System.out.println("3 继续移动");
            int state = scanner.nextInt();
            ActionEnum actionEnum = ActionEnum.getActionEnum(state);
            switch (actionEnum) {
                case move:
                    continue;
                case medicine:
                    System.out.println("吃药了");
                    current = run;
                    return;
                case monster:
                    System.out.println("吃了怪物");
                    current = die;
                    return;
                default:
                    System.out.println("执行了错误指令");
            }
        }
    }
}

class RunState extends State {

    @Override
    void enter() {
        // 初始化所有的操作
        actionList.add(ActionEnum.monster);
        System.out.println("进入了run的状态");
    }

    @Override
    void update() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("2 吃了怪物");
            int state = scanner.nextInt();
            ActionEnum actionEnum = ActionEnum.getActionEnum(state);
            switch (actionEnum) {
                case monster:
                    System.out.println("吃了怪物");
                    current = die;
                    return;
                default:
                    System.out.println("执行了错误指令");
            }
        }
    }
}

class DieState extends State {

    @Override
    void enter() {
        System.out.println("进入了die的状态");
    }

    @Override
    void update() {
        if (riseCounter <= 2) {
            riseCounter++;
            current = rise;
        } else {
            current = finish;
        }
    }
}

class RiseState extends State {
    @Override
    void enter() {
        actionList.add(ActionEnum.rise);
        actionList.add(ActionEnum.finish);
        System.out.println("进入了rise的状态");
    }

    @Override
    void update() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("4 复活");
            System.out.println("5 结束");
            int state = scanner.nextInt();
            ActionEnum actionEnum = ActionEnum.getActionEnum(state);
            switch (actionEnum) {
                case rise:
                    current = move;
                    return;
                case finish:
                    current = finish;
                    return;
                default:
                    System.out.println("执行了错误指令");
            }
        }
    }
}

class FinishState extends State {
    @Override
    void enter() {
        System.out.println("进入了finish的状态");
    }

    @Override
    void update() {
        current = quit;
    }
}

class QuitState extends State {

    @Override
    void enter() {
        // ....
    }

    @Override
    void update() {
        // .....
    }
}


public class StateMachine {
    public static void main(String[] args) {
        State.run = new RunState();
        State.move = new MoveState();
        State.die = new DieState();
        State.finish = new FinishState();
        State.rise = new RiseState();
        State.quit = new QuitState();

        State.current = State.move;

        while (true) {
            State.current.enter();
            State.current.update();

            if (State.current == State.quit) {
                System.out.println("游戏已经终止");
                return;
            }
        }
    }

}

