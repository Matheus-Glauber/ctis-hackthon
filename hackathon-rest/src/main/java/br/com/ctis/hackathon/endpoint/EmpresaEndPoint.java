package br.com.ctis.hackathon.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Path("empresas")
@Tag(name = "Empresa", description = "Recursos para testes da aplicação")
public interface EmpresaEndPoint {
	
	@GET
	@Produces("application/json")
	@Operation(description = "Lista as Empresas cadastradas no sistema", summary = "Listar Empresa's", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response listar();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para cadastro de uma nova Empresa no sistema", summary = "Adicionar nova Empresa", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
	    }
	  )
	Response cadastrar(@RequestBody(description = "Objeto Empresa que será adicionado", required = true, content = @Content(schema = @Schema(implementation = EmpresaDTO.class))) @Valid EmpresaDTO empresaDTO);
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Recupera Empresa pelo Id", summary = "Recuperar Empresas", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response buscarEmpresaPorId(@PathParam(value="id") Long id);
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Exclui Empresa pelo Id", summary = "Excluir Empresas", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response excluiEmpresaPorId(@PathParam(value="id")Long id);
	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Atualiza empresa Id", summary = "Atualizar Empresas", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response atualizar( @PathParam(value="id") Long id,@RequestBody(description = "Objeto Empresa que será atualizado", required = true, content = @Content(schema = @Schema(implementation = EmpresaDTO.class))) @Valid EmpresaDTO empresaDTO);

}
