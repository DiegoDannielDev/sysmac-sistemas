package br.com.util;

import org.springframework.context.ApplicationContext;

public class AppContext {
    private ApplicationContext context;

    private static AppContext INSTANCE;

    private AppContext() {
    }

    public static AppContext getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppContext();
        }
        return INSTANCE;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ApplicationContext getContext() {
        return context;
    }
}
