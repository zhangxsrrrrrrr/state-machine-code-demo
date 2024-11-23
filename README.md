# 棋牌状态机

状态机的核心部分：状态，输入，和转移；
> **源状态**、**转换行为**、**目标状态**

在这个demo里面状态是需要去继承`com.zx.machine.demo.state.AbsState`这个抽象类，
这个抽象类实现了`com.zx.machine.demo.state.IState`

这个状态的核心部分对应的 **接口** 的如下：
1. 状态：就是整个接口，
2. 输入：`update` 对应着输入，在这个方法中可以获取到对应的指令对**持有物**进行操作
3. 转移：`finish` 、`enter`、`getNextState`；判断是否结束，根据这个状态中的逻辑找出下一个状态，
然后进入这个状态；



   
这个demo的状态切换


[WaitState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FWaitState.java) ----> [ReadyState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FReadyState.java) ----> [PlayState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FPlayState.java)  ---->  [SettleState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FSettleState.java)

--->[ReadyState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FReadyState.java)

---->[FinishState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FFinishState.java)


下面两个状态的源状态都是[SettleState.java](src%2Fcom%2Fzx%2Fmachine%2Fdemo%2Fstate%2FSettleState.java)判断选择一个切换过来的