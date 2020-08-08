package com.yao.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yao.crud.domain.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent,String> {

}
