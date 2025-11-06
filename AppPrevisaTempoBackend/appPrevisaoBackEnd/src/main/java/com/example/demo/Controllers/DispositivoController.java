package com.example.demo.Controllers;

import com.example.demo.Entities.Dispositivos;
import com.example.demo.Services.DispositivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("dispositivos")
public class DispositivoController {
    @Autowired
    private DispositivosService dispositivosService;

    @PostMapping
    public ResponseEntity<Dispositivos> salvar(@RequestBody Dispositivos dispositivo) {
        return ResponseEntity.ok(dispositivosService.save(dispositivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivos> atualizar(@PathVariable("id") String id, @RequestBody Dispositivos dispositivo) {
        Optional<Dispositivos> existente = dispositivosService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        dispositivo.setId(id); // Garante que o ID usado é o da URL
        return ResponseEntity.ok(dispositivosService.save(dispositivo));
    }


    @GetMapping
    public ResponseEntity<List<Dispositivos>> listar() {
        return ResponseEntity.ok(dispositivosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivos> listarPorId(@PathVariable String id) {
        return dispositivosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        dispositivosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
