package com.example.demo.Services;

import com.example.demo.Entities.Dispositivos;
import com.example.demo.Repositories.DispositvosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DispositivosService {
    @Autowired
    private DispositvosRepository dispositvosRepository;

    public Dispositivos save(Dispositivos dispositivo){
        dispositvosRepository.save(dispositivo);
        return dispositivo;
    }

    public List<Dispositivos> findAll(){
        return dispositvosRepository.findAll();
    }

    public Optional<Dispositivos> findById(String id){
        return dispositvosRepository.findById(id);
    }

    public void deleteById(String id){
        dispositvosRepository.deleteById(id);
    }

}
