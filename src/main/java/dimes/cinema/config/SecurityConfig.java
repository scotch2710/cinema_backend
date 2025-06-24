package dimes.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration // Indica a Spring che questa è una classe di configurazione
@EnableWebSecurity // Abilita la configurazione di sicurezza web di Spring
@EnableMethodSecurity // Abilita la sicurezza a livello di metodo (per far funzionare @PreAuthorize)
public class SecurityConfig {

    @Bean // Definisce un "Bean", un oggetto gestito da Spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 1. Disabilita CSRF: non necessario per API REST stateless
            .csrf(csrf -> csrf.disable())

            // 2. Configura le regole di autorizzazione per le richieste HTTP
            .authorizeHttpRequests(auth -> auth
                // Permetti a CHIUNQUE (permitAll) di fare richieste GET a questi specifici endpoint.
                // QUESTA È LA RIGA CHE RISOLVE IL TUO PROBLEMA!
                .requestMatchers(HttpMethod.GET, "/api/films", "/api/spettacoli").permitAll()

                // Per QUALSIASI ALTRA richiesta (anyRequest), l'utente deve essere autenticato.
                .anyRequest().authenticated()
            )

            // 3. Configura il server come un "Resource Server" OAuth2
            // Questo gli dice di aspettarsi un token JWT e di validarlo
            // usando l'issuer-uri che hai nel file application.properties.
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

        return http.build();
    }
}