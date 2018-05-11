package com.biosol.learning.jwt.service;

import java.util.*;

import com.biosol.learning.jwt.model.*;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);

}
