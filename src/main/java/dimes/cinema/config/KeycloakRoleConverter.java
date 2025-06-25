package dimes.cinema.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Questa classe ha un solo compito: convertire un JWT in una lista di permessi (GrantedAuthority)
// che Spring Security può capire.
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @SuppressWarnings("null")
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // 1. Prende la sezione "realm_access" dal token.
        @SuppressWarnings("unchecked")
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        // Se non c'è la sezione realm_access o è vuota, l'utente non ha ruoli.
        if (realmAccess == null || realmAccess.isEmpty()) {
            return List.of(); // Restituisce una lista vuota
        }

        // 2. Da "realm_access", prende la lista dei "roles".
        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) realmAccess.get("roles");

        // 3. Trasforma ogni stringa di ruolo (es. "ROLE_ADMIN") in un oggetto SimpleGrantedAuthority
        //    che è il formato che Spring Security capisce.
        return roles.stream()
                //.map(roleName -> "ROLE_" + roleName) // Aggiunge il prefisso ROLE_ se non l'hai già fatto in Keycloak
                // SE HAI GIÀ RINOMINATO IL RUOLO IN 'ROLE_ADMIN' in Keycloak, USA QUESTA RIGA INVECE:
                // .map(SimpleGrantedAuthority::new) 
                .map(SimpleGrantedAuthority::new) // <-- USA QUESTA SE HAI GIÀ IL PREFISSO NEL NOME DEL RUOLO
                .collect(Collectors.toList());
    }
}