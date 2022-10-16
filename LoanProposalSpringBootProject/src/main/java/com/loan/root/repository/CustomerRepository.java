package com.loan.root.repository;

import org.springframework.data.repository.CrudRepository;

import com.loan.root.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
