package com.exemplostestesunitarios.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DummyServiceTest {

    @InjectMocks
    private DummyService service;

    @Test
    public void sucesso() {
        assertDoesNotThrow(() -> service.exec());
    }
}
