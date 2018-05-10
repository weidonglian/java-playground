package com.biosol.learning.repository;

import org.springframework.data.jpa.repository.*;

import com.biosol.learning.model.*;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}

