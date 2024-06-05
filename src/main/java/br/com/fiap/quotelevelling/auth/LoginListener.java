package br.com.fiap.quotelevelling.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import br.com.fiap.quotelevelling.user.User;
import br.com.fiap.quotelevelling.user.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginListener implements ApplicationListener <AuthenticationSuccessEvent>{

    @Autowired
    UserRepository repository;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        OAuth2User principal = (OAuth2User) event.getAuthentication().getPrincipal();
        String email = principal.getAttribute("email");

        var user = repository.findByEmail(email);
        if (user.isEmpty()){
            var newUser = new User(principal);
            repository.save(newUser);
        }

        log.info("Login Realizado com sucesso: " + principal);
    }
    
}
