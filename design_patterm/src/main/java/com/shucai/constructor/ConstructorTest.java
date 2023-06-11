package com.shucai.constructor;

public class ConstructorTest {

    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder();
        builder.installDisPlayer("显示器");
        builder.installMainUnit("主机");
        builder.installMouse("鼠标");
        builder.installKeyBoard("键盘");
        Computer computer = builder.getComputer();
        System.out.println(computer);
    }
}
