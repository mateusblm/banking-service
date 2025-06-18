package io.github.mateusblm.controller;


import org.jboss.resteasy.reactive.RestResponse;

import io.github.mateusblm.domain.Agencia;
import io.github.mateusblm.service.AgenciaService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/agencias")
public class AgenciaController {
    
    private AgenciaService agenciaService;
    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }


    @POST
    public RestResponse<Void> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        this.agenciaService.cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath()); // Retorna o status 201 Created
    }

    @GET
    @Path("/{id}")
    public RestResponse<Agencia> buscarPorId(Integer id) {
        Agencia agencia = this.agenciaService.buscarPorId(id);
        return RestResponse.ok(agencia); // Retorna o status 200 OK
    }

    @DELETE
    @Path("/{id}")
    // O método deletar recebe um ID de agência e chama o serviço para deletar a agência correspondente.
    // Ele retorna uma resposta sem conteúdo (204 No Content) para indicar que a operação foi bem-sucedida.
    // O uso de @Path("/{id}") indica que o ID da agência será passado na URL da requisição.
    public RestResponse<Void> deletar(Integer id) {
        this.agenciaService.deletar(id);
        return RestResponse.noContent(); // Retorna o status 204 No Content
    }

    @PUT
    public RestResponse<Void> alterar(Agencia agencia) {
        this.agenciaService.alterar(agencia);
        return RestResponse.noContent(); // Retorna o status 204 No Content 

    }

}
