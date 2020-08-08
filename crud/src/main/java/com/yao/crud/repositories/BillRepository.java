package com.yao.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yao.crud.domain.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

}
