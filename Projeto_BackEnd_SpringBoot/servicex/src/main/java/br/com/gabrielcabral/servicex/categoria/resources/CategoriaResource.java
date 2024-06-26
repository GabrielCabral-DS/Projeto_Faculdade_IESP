package br.com.gabrielcabral.servicex.categoria.resources;

import br.com.gabrielcabral.servicex.categoria.domain.Categoria;
import br.com.gabrielcabral.servicex.categoria.domain.CategoriaDTO;
import br.com.gabrielcabral.servicex.categoria.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> cadastrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.fromDTO(categoriaDTO);
        categoria = categoriaService.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(categoria.getIdCategoria()).toUri();
        return  ResponseEntity.created(uri).build();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        List<Categoria> listaCategorias = categoriaService.listarCategorias();
        List<CategoriaDTO> listaDTO = listaCategorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer idCategoria) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(idCategoria);
        return ResponseEntity.ok().body(categoria);
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<Categoria> atualizarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Integer idCategoria) {
        Categoria categoria = categoriaService.fromDTO(categoriaDTO);
        categoria.setIdCategoria(idCategoria);
        categoria = categoriaService.atualizarCategoria(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer idCategoria) {
        categoriaService.deletarCategoria(idCategoria);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
