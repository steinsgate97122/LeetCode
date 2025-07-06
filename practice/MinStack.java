package practice;

import java.util.Stack;

/*
No.155 min-stack
要求在常规Stack的基础上，还要能在常数时间内检索到最小元素，即内部除了一个Stack外还需要数据结构维护min
只维护一个min肯定不行，如果这个元素被pop，那么就不知道前一个min是什么了，所以应该是一个类似list的结构
假设存入顺序是3 2 1，那么1弹出之后min变成2，2弹出之后变成3，类似一个栈结构
如果存入顺序是1 2 3，那么min存入1就行，比栈顶元素大的就不用存了？不可能是潜在的min，小于等于栈顶的都放进去？
假设存入顺序为-2 0 -3，栈里面应该是-2 -3，如果弹出-3，那么用来维护min元素的栈也将-3弹出
 */
public class MinStack {
    private Stack<Integer> innerStack;
    private Stack<Integer> minElementStack;

    public MinStack() {
        innerStack = new Stack<>();
        minElementStack = new Stack<>();
    }

    public void push(int val) {
        innerStack.push(val);
        if (minElementStack.isEmpty() || minElementStack.peek() >= val) {
            minElementStack.push(val);
        }
    }

    public void pop() {
        int popElement = innerStack.pop();
        if (minElementStack.peek() == popElement) {
            minElementStack.pop();
        }
    }

    public int top() {
        return innerStack.peek();
    }

    public int getMin() {
        return minElementStack.peek();
    }
}
