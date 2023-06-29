package com.jontxu.CallCenter.data;

import com.jontxu.CallCenter.data.employees.Agent;
import com.jontxu.CallCenter.data.employees.SeniorityLvl;

import java.util.*;

public class CallsQueue {
    private final String name;
    private final boolean isHighPrio;
    private final Queue<Call> calls;
    private final List<Agent> agents;

    public CallsQueue(String name, boolean isHighPrio) {
        this.name = name;
        this.isHighPrio = isHighPrio;
        calls = new PriorityQueue<>(Comparator.comparing(call -> call.time()));
        agents = new ArrayList<>();
    }

    public void addCallToQueue(Call call){
        calls.offer(call);
    }
    public Call getLongestWaitingCall(){
        return calls.poll();
    }

    public void addAgent(Agent agent){
        if(isHighPrio && !agent.getSeniorityLvl().equals(SeniorityLvl.LEVEL_3)){
            throw new IllegalArgumentException("High Priority Queues can only have Level 3 Agents.");
        }
        agents.add(agent);
    }
    public String getName() {
        return name;
    }

    public boolean isHighPrio() {
        return isHighPrio;
    }

    public Queue<Call> getCalls() {
        return calls;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
