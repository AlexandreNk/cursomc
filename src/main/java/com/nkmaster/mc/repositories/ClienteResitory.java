package com.nkmaster.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkmaster.mc.domain.Cliente;

@Repository
public interface ClienteResitory extends JpaRepository<Cliente, Integer> {

}
