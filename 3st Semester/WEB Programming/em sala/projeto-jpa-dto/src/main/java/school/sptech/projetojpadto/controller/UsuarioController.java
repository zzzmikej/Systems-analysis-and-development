package school.sptech.projetojpadto.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetojpadto.dto.UsuarioCriacaoDto;
import school.sptech.projetojpadto.dto.UsuarioListagemDto;
import school.sptech.projetojpadto.dto.UsuarioMapper;
import school.sptech.projetojpadto.entity.Usuario;
import school.sptech.projetojpadto.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    /*
        Injeção de dependência é quando um objeto recebe as coisas que ele precisa para funcionar,
        em vez de criar essas coisas por si só.
        É como receber um pacote pronto, em vez de ter que fazer tudo desde o início.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioListagemDto> criar( // alterar o tipo de retorno para UsuarioListagemDto
            @RequestBody @Valid UsuarioCriacaoDto novoUsuario) {

        // Estrutura de Mapeamento - lib mapstruct

        /*
         Chegou DTO na requisição, preciso converter para entidade...
         pois, só assim, é possível salvar no banco.
        */
        Usuario usuario = UsuarioMapper.toEntity(novoUsuario);

        // Após salvar, o banco retorna uma entidade, só que agora com id.
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        /*
          Eu preciso pegar o que retornou do banco e devolver pra quem chamou...
          só que, não posso devolver a senha, e a entidade não pode ser devolvida na controller.
         */
        UsuarioListagemDto listagemDto = UsuarioMapper.toDto(usuarioSalvo);

        // Retornando uma resposta de sucesso com o DTO de listagem e código de status 201
        return ResponseEntity.status(201).body(listagemDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListagemDto> buscaPorId(@PathVariable int id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        /*
          Eu preciso pegar o que retornou do banco e devolver pra quem chamou...
          só que, não posso devolver a senha ou algum atributo que não atenda, e a entidade não pode ser devolvida na controller.
         */
        UsuarioListagemDto dto = UsuarioMapper.toDto(usuarioOpt.get());
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDto>> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        /*
          Eu preciso pegar o que retornou do banco e devolver pra quem chamou...
          só que, não posso devolver a senha ou algum atributo que não atenda, e a entidade não pode ser devolvida na controller.
         */
        List<UsuarioListagemDto> listaAuxiliar = UsuarioMapper.toDto(usuarios);
        return ResponseEntity.status(200).body(listaAuxiliar);
    }
}
