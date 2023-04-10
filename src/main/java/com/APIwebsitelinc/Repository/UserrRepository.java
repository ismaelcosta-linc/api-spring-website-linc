package com.APIwebsitelinc.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.APIwebsitelinc.Model.Userr;

@Repository
public interface UserrRepository extends CrudRepository<Userr, Long>{}
