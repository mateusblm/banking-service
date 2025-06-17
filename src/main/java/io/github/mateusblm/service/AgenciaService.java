package io.github.mateusblm.service;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.github.mateusblm.domain.Agencia;
import io.github.mateusblm.domain.http.AgenciaHttp;
import io.github.mateusblm.domain.http.SituacaoCadastral;
import io.github.mateusblm.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import io.github.mateusblm.service.http.SituacaoCadastralHttpService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Quarkus gerencie essa classe para que eu possa injetar ela em outros lugares
// Essa anotação faz com que o Quarkus crie uma instância dessa classe e
// a mantenha viva durante todo o ciclo de vida da aplicação, permitindo que eu a injete em outros componentes do Quarkus, como recursos REST, serviços, etc.
// Isso é útil para serviços que precisam manter estado ou realizar operações de longa duração, como conexões a bancos de dados ou chamadas a APIs externas.
public class AgenciaService {

    @RestClient // Injetando o cliente HTTP que foi registrado no Quarkus
    private SituacaoCadastralHttpService situacaoCadastralHttpService;

    private List<Agencia> agencias = new ArrayList<>();

    public void cadastrar(Agencia agencia) {
        AgenciaHttp agenciaHttp = 
            situacaoCadastralHttpService.buscarPorCnpj(agencia.getCnpj());

        agenciaHttp.getSituacaoCadastral();
        if(agenciaHttp.getSituacaoCadastral().equals(SituacaoCadastral.ATIVA)) {
            agencias.add(agencia);
        } else {
            throw new AgenciaNaoAtivaOuNaoEncontradaException();
        }
    }
}
