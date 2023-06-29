package com.jontxu.CallCenter.data;

import com.jontxu.CallCenter.data.employees.Agent;

import java.time.LocalDateTime;

public record Call(LocalDateTime time, boolean wasAccepted, Agent agent) {
}
