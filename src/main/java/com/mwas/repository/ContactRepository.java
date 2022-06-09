package com.mwas.repository;


import com.mwas.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mwas.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
