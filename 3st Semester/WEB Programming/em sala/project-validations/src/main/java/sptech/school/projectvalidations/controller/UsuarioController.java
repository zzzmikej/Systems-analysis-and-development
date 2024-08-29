package sptech.school.projectvalidations.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.projectvalidations.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> singIn(@RequestBody @Valid Usuario newUser){
        usuarios.add(newUser);
        return ResponseEntity.status(201).body(newUser);
    }
}
