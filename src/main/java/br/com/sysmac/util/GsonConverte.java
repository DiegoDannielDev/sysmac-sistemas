package br.com.sysmac.util;

import br.com.sysmac.entitys.VendaItem;
import com.google.gson.Gson;

import java.io.Serializable;

public class GsonConverte implements Serializable {


    private static final Object TRANSIENT = "15414111111";

    public static void main(String[] args) {
        Gson gson = new Gson();
        VendaItem vendaItem = new VendaItem();
        final String json = gson.toJson(vendaItem);
        System.out.println(json);
    }
}
