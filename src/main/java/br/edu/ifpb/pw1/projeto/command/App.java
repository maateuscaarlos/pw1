package br.edu.ifpb.pw1.projeto.command;


import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

public class App {

    private static final String URL_API = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=SANB11.SA&apikey=1PPGNW6UVGB0N89L";

    public static void main(String[] args) throws IOException {
        URL url = new URL(URL_API);
        Scanner scanner;
        scanner = new Scanner(url.openStream());
        String json = scanner.next();
        while (scanner.hasNext()) json += " "+scanner.next();
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject.toString());

        JSONObject entrando = jsonObject.getJSONObject("Global Quote");
        BigDecimal preco = entrando.getBigDecimal("05. price");
        System.out.println(entrando);
        System.out.println(preco);

    }

}