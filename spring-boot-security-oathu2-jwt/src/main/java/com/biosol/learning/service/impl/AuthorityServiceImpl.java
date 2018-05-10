package com.biosol.learning.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.biosol.learning.model.*;
import com.biosol.learning.repository.*;
import com.biosol.learning.service.*;

@Service
public class AuthorityServiceImpl implements AuthorityService {

  @Autowired
  private AuthorityRepository authorityRepository;

  @Override
  public List<Authority> findById(Long id) {
    Optional<Authority> auth = this.authorityRepository.findById(id);
    List<Authority> auths = new ArrayList<>();
    if (auth.isPresent())
    	auths.add(auth.get());
    return auths;
  }

  @Override
  public List<Authority> findByname(String name) {
    // TODO Auto-generated method stub
    Authority auth = this.authorityRepository.findByName(name);
    List<Authority> auths = new ArrayList<>();
    auths.add(auth);
    return auths;
  }

}
