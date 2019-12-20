package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.ConexaoJsonApi;
import br.edu.ifpb.pw1.projeto.model.AtivoJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) throws IOException {
        ConexaoJsonApi conexaoJsonApi = new ConexaoJsonApi();
        List<AtivoJson> ativoJsons = new ArrayList<>();
        ativoJsons= conexaoJsonApi.buscarAtivos();
        System.out.println(ativoJsons);
    }
}
