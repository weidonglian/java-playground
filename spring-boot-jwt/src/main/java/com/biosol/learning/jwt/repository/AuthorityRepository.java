package com.biosol.learning.jwt.repository;

import org.springframework.data.jpa.repository.*;

import com.biosol.learning.jwt.model.*;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(String name);
}
