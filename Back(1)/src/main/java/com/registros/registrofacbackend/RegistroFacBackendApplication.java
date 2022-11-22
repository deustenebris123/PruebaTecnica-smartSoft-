package com.registros.registrofacbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Este proyecto tiene el objetivo de registrar una factura junto con sus caracteristicas
 * @author Edison Mauricio Torres
 * @version: 22/11/2022
 */
@SpringBootApplication
@EnableConfigurationProperties
public class RegistroFacBackendApplication {
//creacion de la clase main donde se podra correr el
    public static void main(String[] args) {
        SpringApplication.run(RegistroFacBackendApplication.class, args);

    }

}
