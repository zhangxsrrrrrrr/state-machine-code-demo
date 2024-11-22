package com.zx.machine.demo.state;

/**
 * 状态的接口
 */
public interface IState {

    /**
     * 进入状态执行的操作，可以对一些数据进行初始化
     */
    void enter();

    /**
     * 状态里面执行操作
     */
    void update();

    /**
     * 状态与code的映射，每个状态都有不一样的code
     */
    int getCode();

    /**
     * 状态结束后的下一个状态
     */
    int getNextState();

    /**
     * 当前状态是否结束
     */
    boolean finish();
}
