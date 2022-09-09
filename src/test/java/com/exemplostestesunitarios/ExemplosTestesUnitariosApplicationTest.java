package com.exemplostestesunitarios;

import org.junit.jupiter.api.Test;

class ExemplosTestesUnitariosApplicationTest {

    @Test
    public void assertConfig() {
        new ExemplosTestesUnitariosApplication().main(new String[]{"--spring.profiles.active=test"});
    }
}
