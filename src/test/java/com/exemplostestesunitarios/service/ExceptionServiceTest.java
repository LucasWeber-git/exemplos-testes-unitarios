package com.exemplostestesunitarios.service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerErrorException;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionServiceTest {

    @InjectMocks
    private ExceptionService service;

    @Mock
    private DummyService dummyService;

    @Test
    public void sucesso() {
        final HttpClientErrorException hcee = assertThrows(HttpClientErrorException.class,
            () -> service.throwException());

        verify(dummyService).exec();

        assertEquals(NOT_FOUND, hcee.getStatusCode());
        assertEquals("Não encontrado", hcee.getStatusText());
    }

    @Test
    public void erro_dummyService_mockSimples() {
        doThrow(ServerErrorException.class).when(dummyService).exec();

        assertThrows(ServerErrorException.class, () -> service.throwException());

        verify(dummyService).exec();
    }

    @Test
    public void erro_dummyService_mockCompleto() {
        final String errorMessage = randomAlphanumeric(16);

        doThrow(new HttpClientErrorException(BAD_REQUEST, errorMessage)).when(dummyService).exec();

        final HttpClientErrorException hcee = assertThrows(HttpClientErrorException.class,
            () -> service.throwException());

        verify(dummyService).exec();

        assertEquals(BAD_REQUEST, hcee.getStatusCode());
        assertEquals(errorMessage, hcee.getStatusText());
    }
}
