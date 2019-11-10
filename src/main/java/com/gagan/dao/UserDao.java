package com.gagan.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gagan.model.User;
/**
 * 
 * @author Gagan
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
