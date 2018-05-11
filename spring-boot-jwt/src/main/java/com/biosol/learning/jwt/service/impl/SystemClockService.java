package com.biosol.learning.jwt.service.impl;
import java.util.*;

import org.springframework.stereotype.*;

import com.biosol.learning.jwt.service.*;

/**
 * Clock implementation that defers to the system clock. Should be used
 * outside of tests.
 */
@Service
public class SystemClockService implements ClockService {
    @Override
    public long millis() {
        return System.currentTimeMillis();
    }

    @Override
    public Date date() {
        return new Date();
    }
}