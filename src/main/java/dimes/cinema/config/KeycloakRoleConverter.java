package dimes.cinema.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// questa classe converte un JWT in una lista di permessi (GrantedAuthority) che Spring Security può capire.
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @SuppressWarnings("null")
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // prende la sezione realm_access dal token.
        @SuppressWarnings("unchecked")
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        // se non c'è la sezione realm_access o è vuota l'utente non ha ruoli.
        if (realmAccess == null || realmAccess.isEmpty()) {
            return List.of(); 
        }

        // da realm_access prende la lista dei ruoli
        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) realmAccess.get("roles");

        // trasforma ogni stringa di ruolo (es. "ROLE_ADMIN") in un oggetto SimpleGrantedAuthority che è il formato che Spring Security capisce.
        
        return roles.stream()
                
                
                
                .map(SimpleGrantedAuthority::new) 
                .collect(Collectors.toList());
    }
}