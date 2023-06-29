package com.jontxu.CallCenter.logic;

import com.jontxu.CallCenter.data.CallsQueue;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CallCenter {

    public List<CallsQueue> findQueuesWithMostCallsWaiting(List<CallsQueue> callsQueues){
        Map<CallsQueue, Integer> queueCounts = collectQueuesWithAmountOfCalls(callsQueues);
        int maxCount = getMaxCountOfCalls(queueCounts);
        
        return filterQueuesWithSameAmountOfCalls(queueCounts, maxCount);
    }

    private List<CallsQueue> filterQueuesWithSameAmountOfCalls(Map<CallsQueue, Integer> queueCounts, int maxCount) {
        return queueCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    private Integer getMaxCountOfCalls(Map<CallsQueue, Integer> queueCounts) {
        return queueCounts.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private Map<CallsQueue, Integer> collectQueuesWithAmountOfCalls(List<CallsQueue> callsQueues) {
        return callsQueues.stream()
                .collect(Collectors.toMap(callsQueue -> callsQueue, callsQueue -> callsQueue.getCalls().size()));
    }
}
