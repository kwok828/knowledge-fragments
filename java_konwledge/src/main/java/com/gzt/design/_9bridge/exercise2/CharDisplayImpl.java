package com.gzt.design._9bridge.exercise2;

import com.gzt.design._9bridge.DisplayImpl;

public class CharDisplayImpl extends DisplayImpl {
    private char head;
    private char body;
    private char foot;

    /**
     *
     * @param head 首部
     * @param body 中间
     * @param foot 尾部
     */
    public CharDisplayImpl(char head, char body, char foot) {
        this.head = head;
        this.body = body;
        this.foot = foot;
    }
    @Override
    public void rawOpen() {
        System.out.print(head);
    }

    @Override
    public void rawPrint() {
        System.out.print(body);
    }

    @Override
    public void rawClose() {
        System.out.println(foot);
    }
}
