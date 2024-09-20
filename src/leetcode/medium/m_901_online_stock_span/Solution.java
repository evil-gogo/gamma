package leetcode.medium.m_901_online_stock_span;

//https://leetcode.com/problems/online-stock-span/description/

import java.util.Stack;

class StockSpan {
    int price;
    int span;

    public StockSpan(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class StockSpanner {
    Stack<StockSpan> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new StockSpan(price, span));
        return span;
    }

    public static void main(String[] args) {
        String[] sequence = {"StockSpanner", "next", "next", "next", "next", "next", "next", "next"};
        int[][] input = {{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}};

        StockSpanner obj = null;

        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "StockSpanner":
                    obj = new StockSpanner();
                    inputIndex++;
                    break;
                case "next":
                    assert obj != null;
                    int param_1 = obj.next(input[inputIndex][0]);
                    System.out.println(param_1);
                    inputIndex++;
                    break;
            }
        }
    }
}

