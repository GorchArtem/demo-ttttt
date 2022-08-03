package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credential.properties")
public interface CredentialsConfig {

    String login();
    String password();
    String baseUrl();

}
