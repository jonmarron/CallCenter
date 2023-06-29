package com.jontxu.CallCenter.data.employees;

public class Agent extends Employee {
    private SeniorityLvl seniorityLvl;
    public Agent(int id, String name) {
        super(id, name);
        seniorityLvl = SeniorityLvl.LEVEL_1;
    }

    public SeniorityLvl getSeniorityLvl() {
        return seniorityLvl;
    }

    public void setSeniorityLvl(SeniorityLvl seniorityLvl) {
        this.seniorityLvl = seniorityLvl;
    }
}
