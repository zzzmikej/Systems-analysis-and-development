package school.sptech.projetojpadto.dto;

import school.sptech.projetojpadto.entity.Usuario;

import java.util.List;

// Classe responsável por mapear dados entre DTOs e entidades
public class UsuarioMapper {

    // Método para converter um DTO em uma entidade
    public static Usuario toEntity(UsuarioCriacaoDto dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setCpf(dto.getCpf());
        usuario.setDataNascimento(dto.getDataNascimento());

        return usuario;
    }

    // Método para converter uma entidade em um DTO
    public static UsuarioListagemDto toDto(Usuario entity) {
        if (entity == null) return null;

        UsuarioListagemDto listagemDto = new UsuarioListagemDto();
        listagemDto.setId(entity.getId());
        listagemDto.setNome(entity.getNome());
        listagemDto.setEmail(entity.getEmail());
        listagemDto.setCpf(entity.getCpf());
        listagemDto.setDataNascimento(entity.getDataNascimento());
        listagemDto.setDataCriacao(entity.getDataCriacao());

        return listagemDto;
    }

    // Método sobrecarregado para mapear uma lista de entidades em uma lista de DTOs
    public static List<UsuarioListagemDto> toDto(List<Usuario> entities) {
        // Aqui é utilizado um método que mapea um a um e reutilizado para poder fazer a passagem de lista sem duplicar código
        return entities.stream().map(UsuarioMapper::toDto).toList();
    }
}
