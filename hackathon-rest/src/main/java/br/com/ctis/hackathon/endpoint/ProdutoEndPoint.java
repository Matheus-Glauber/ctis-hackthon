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

import br.com.ctis.hackathon.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Path("produtos")
@Tag(name = "Produto", description = "Recursos para testes da aplicação")
public interface ProdutoEndPoint {
	
	@GET
	@Produces("application/json")
	@Operation(description = "Lista as Produtos cadastradas no sistema", summary = "Listar Produto's", 
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
	@Operation(description = "Recurso para cadastro de uma nova Produto no sistema", summary = "Adicionar nova Produto", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
	    }
	  )
	Response cadastrar(@RequestBody(description = "Objeto Produto que será adicionado", required = true, content = @Content(schema = @Schema(implementation = ProdutoDTO.class))) @Valid ProdutoDTO produtoDTO);
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Recupera Produto pelo Id", summary = "Recuperar Produtos", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response buscarProdutoPorId(@PathParam(value="id") Long id);

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Exclui Produto pelo Id", summary = "Excluir Produtos", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response excluiProdutoPorId(@PathParam(value="id")Long id);
	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Exclui Produto pelo Id", summary = "Excluir Produtos", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response atualizar(@RequestBody(description = "Objeto Produto que será adicionado", required = true, content = @Content(schema = @Schema(implementation = ProdutoDTO.class))) @Valid ProdutoDTO produtoDTO);
	
}