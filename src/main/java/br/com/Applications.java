package br.com;

import br.com.util.AppContext;
import br.com.view.Splash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {
    private static Splash splash = new Splash();

    public static void main(String[] args) {
        AppContext instance = AppContext.getInstance();
        instance.setContext(SpringApplication.run(Applications.class, args));
        Splash.iniciarTela();
    }
}
