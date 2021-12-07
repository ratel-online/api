package com.isnico.api.model;

import lombok.Data;

@Data
public class Context {

    private static final ThreadLocal<Context> CONTEXTS = new ThreadLocal<>();

    private Long id;

    private String username;

    public static void set(Context ctx){
        CONTEXTS.set(ctx);
    }

    public static void clear(){
        CONTEXTS.remove();
    }

    public static Context get(){
        return CONTEXTS.get();
    }

}
