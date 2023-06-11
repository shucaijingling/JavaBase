package com.shucai.constructor;


public class ComputerBuilder {

    private Computer computer = new Computer();

    public void installDisPlayer(String disPlayer) {
        computer.setDisPlayer(disPlayer);
    }

    public void installMainUnit(String mainUnit) {
        computer.setMainUnit(mainUnit);
    }

    public void installMouse(String mouse) {
        computer.setMouse(mouse);
    }

    public void installKeyBoard(String keyboard) {
        computer.setKeyboard(keyboard);
    }

    public Computer getComputer() {
        return computer;
    }
}
