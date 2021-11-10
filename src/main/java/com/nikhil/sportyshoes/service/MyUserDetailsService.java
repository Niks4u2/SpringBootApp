package com.nikhil.sportyshoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nikhil.sportyshoes.model.MyUserDetails;
import com.nikhil.sportyshoes.model.User;
import com.nikhil.sportyshoes.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+email));
		UserDetails details = user.map(MyUserDetails::new).get();
		if(details.getAuthorities().stream()
      .anyMatch(a -> a.getAuthority().equals("ADMIN")))
			System.out.println("admin role");
		return details;
	}
	
	

}
