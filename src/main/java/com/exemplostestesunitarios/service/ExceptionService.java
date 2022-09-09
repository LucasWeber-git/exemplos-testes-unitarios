package com.exemplostestesunitarios.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExceptionService {

    private final DummyService dummyService;

    public void throwException() {
        dummyService.exec();
        throw new HttpClientErrorException(NOT_FOUND, "Não encontrado");
    }
}
