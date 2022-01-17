package com.appointment.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.appointment.appointment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>
{
}
