package io.github.mateusblm.controller;


import org.jboss.resteasy.reactive.RestResponse;

import io.github.mateusblm.domain.Agencia;
import io.github.mateusblm.service.AgenciaService;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/agencias")
public class AgenciaController {
    
    private AgenciaService agenciaService;
    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    public RestResponse<Void> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        this.agenciaService.cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath()); // Retorna o status 201 Created
    }

}
