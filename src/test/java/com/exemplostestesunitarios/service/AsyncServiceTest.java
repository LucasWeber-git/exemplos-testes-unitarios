package com.exemplostestesunitarios.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AsyncServiceTest {

    @InjectMocks
    private AsyncService asyncService;

    @Test
    public void success() {
        assertTrue(asyncService.teste());
    }
}
