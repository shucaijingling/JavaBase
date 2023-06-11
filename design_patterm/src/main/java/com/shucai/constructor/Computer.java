package com.shucai.constructor;

public class Computer {

    /**
     * 显示器
     */
    private String disPlayer;

    /**
     * 主机
     */
    private String mainUnit;

    /**
     * 鼠标
     */
    private String mouse;

    /**
     * 键盘
     */
    private String keyboard;


    @Override
    public String toString() {
        return "Computer{" +
                "disPlayer='" + disPlayer + '\'' +
                ", mainUnit='" + mainUnit + '\'' +
                ", mouse='" + mouse + '\'' +
                ", keyboard='" + keyboard + '\'' +
                '}';
    }

    public String getDisPlayer() {
        return disPlayer;
    }

    public void setDisPlayer(String disPlayer) {
        this.disPlayer = disPlayer;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
