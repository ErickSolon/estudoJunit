package com.estudotests.EstudoTests.controllers;

import com.estudotests.EstudoTests.models.Pessoas;
import com.estudotests.EstudoTests.services.PessoasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
@RequiredArgsConstructor
public class PessoasController {
    private final PessoasService pessoasService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(pessoasService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoasService.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Pessoas pessoas) {
        return ResponseEntity.ok(pessoasService.save(pessoas));
    }

}
