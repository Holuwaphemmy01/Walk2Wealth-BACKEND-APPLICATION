package com.Walk2Wealth.Walk2Wealth_Backend.users.service.userDetailService;

import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.UserPrincipal;
import com.Walk2Wealth.Walk2Wealth_Backend.users.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        System.out.println(user.getEmail());
        if (user == null) {
            logger.warn("User not found with username: {}", username);
            throw new UsernameNotFoundException(username);
        }
        logger.debug("User found: {}", user.getUserName());

        return new UserPrincipal(user);
    }


}
