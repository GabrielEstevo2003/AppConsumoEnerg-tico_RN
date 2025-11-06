package com.example.demo.Repositories;

import com.example.demo.Entities.Dispositivos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispositvosRepository extends MongoRepository<Dispositivos, String> {}
