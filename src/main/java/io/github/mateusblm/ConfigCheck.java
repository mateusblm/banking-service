package io.github.mateusblm;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ConfigCheck {

    @ConfigProperty(name = "my.test.property")
    String testValue;

    @PostConstruct
    void init() {
        System.out.println(">>> CONFIGURACAO TESTE: " + testValue);
    }
}