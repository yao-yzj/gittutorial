package com.yao.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yao.crud.domain.BillItem;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem,String>{

}
