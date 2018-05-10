package com.biosol.learning.repository;

import org.springframework.data.jpa.repository.*;

import com.biosol.learning.model.*;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(String name);
}
