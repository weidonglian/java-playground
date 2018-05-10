package com.biosol.learning.service;

import java.util.*;

import com.biosol.learning.model.*;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);

}
