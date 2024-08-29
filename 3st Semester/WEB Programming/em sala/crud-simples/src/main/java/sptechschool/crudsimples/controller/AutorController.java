package sptechschool.crudsimples.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptechschool.crudsimples.service.AutorService;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService service;

}
