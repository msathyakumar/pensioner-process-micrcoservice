package com.cognizant.microservices.pensionerprocessmicrcoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.microservices.pensionerprocessmicrcoservice.models.PensionDetail;

@Repository
public interface PensionDetailRepository extends JpaRepository<PensionDetail, Integer> {

}
