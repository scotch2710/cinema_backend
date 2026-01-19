🎬 Cinema DIMES
📖 Panoramica del Progetto

Cinema DIMES è una web application Full-Stack moderna progettata per la gestione completa di un cinema multisala. Il progetto nasce con l'obiettivo di simulare un ambiente di produzione reale, separando nettamente il backend (Spring Boot) dal frontend (Angular) e delegando la gestione della sicurezza e delle identità a un provider esterno standard di settore (Keycloak).

L'applicazione offre due esperienze distinte: un'interfaccia intuitiva per i clienti che desiderano esplorare la programmazione e acquistare biglietti, e una console di gestione avanzata per gli amministratori.
🚀 Architettura e Tecnologie

Il sistema è costruito seguendo i principi dell'architettura a microservizi (o monolite modulare), garantendo scalabilità e sicurezza.

    Frontend: Sviluppato in Angular, offre una Single Page Application (SPA) reattiva e dinamica. Interagisce con il backend tramite chiamate REST API.

    Backend: Realizzato con Spring Boot, gestisce la logica di business, la persistenza dei dati e le API.

    Sicurezza e IAM: L'autenticazione e l'autorizzazione sono gestite interamente da Keycloak tramite protocollo OIDC (OpenID Connect). Questo garantisce una gestione sicura dei token JWT e una suddivisione granulare dei ruoli (USER vs ADMIN).

✨ Funzionalità Principali
👤 Lato Utente (Pubblico)

L'interfaccia pubblica è accessibile a tutti gli utenti, con funzionalità specifiche per gli utenti registrati.

    Catalogo Film: Visualizzazione della lista dei film attualmente in programmazione e di quelli in arrivo, con dettagli su trama, cast e durata.

    Consultazione Programmazione: Possibilità di filtrare gli spettacoli disponibili selezionando giorno e orario preferito.

    Sistema di Prenotazione:

        Selezione dello spettacolo desiderato.

        Procedura guidata per la prenotazione dei biglietti.

    Area Personale:

        Registrazione e Login sicuro (gestito da Keycloak).

        Visualizzazione dello storico delle prenotazioni effettuate.

🛡️ Lato Amministratore (Backoffice)

Una dashboard protetta, accessibile esclusivamente agli utenti con ruolo ADMIN, che funge da centro di controllo per l'intero sistema.

    Gestione Film: CRUD completo (Creazione, Lettura, Aggiornamento, Cancellazione) delle schede dei film. Gli admin possono aggiungere nuove uscite o rimuovere film non più in sala.

    Pianificazione Spettacoli: Strumenti per programmare gli orari delle proiezioni, assegnando film specifici a determinati giorni e fasce orarie.

    Gestione Biglietti e Prenotazioni: Panoramica di tutte le prenotazioni attive nel sistema per monitorare l'affluenza e la disponibilità delle sale.
