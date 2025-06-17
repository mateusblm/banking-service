package io.github.mateusblm.domain.http;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/situacao-cadastral")
@RegisterRestClient(configKey = "situacao-cadastral-api")
interface SituacaoCadastralHttpService {
    
    @GET
    @Path("{cnpj}")
    AgenciaHttp buscarPorCnpj(String cnpj);
}
