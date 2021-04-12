package com.entite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface entiteRepository extends JpaRepository<entite,Long> {

}
