package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.CategoriaDTO;
import application.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public Iterable<CategoriaDTO> getAll() {
        return categoriaService.getAll();
    }


    @Operation(summary = "Cria uma nova categoria",
        description = "Retorna o objeto categoria criado",
        deprecated = false)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "403", description = "Acesso Não Autorizado"),
        @ApiResponse(responseCode = "200", description = "Categoria Criada Com Sucesso")
    })
    @PostMapping
    public CategoriaDTO insert(@RequestBody CategoriaDTO categoria) {
        return categoriaService.insert(categoria);
    }
}
