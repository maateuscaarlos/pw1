package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.AtivoJson;
import br.edu.ifpb.pw1.projeto.model.NomeAtivo;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

public class ConexaoJsonApi {
    private static final String KEY_API = "1PPGNW6UVGB0N89L";
    private String KEY_ATIVO ;
    private String NOME_ATIVO;


    public ConexaoJsonApi() {

    }

    public List<AtivoJson> buscarAtivos() throws IOException {
        List<AtivoJson> ativoJsons =  new ArrayList<>();
        List<NomeAtivo> nomeAtivos = Arrays.asList(NomeAtivo.values());

        AtivoJson ativoJson= null;
        for (int i = 0; i < nomeAtivos.size(); i++){
             KEY_ATIVO=nomeAtivos.get(i).getNome();
             NOME_ATIVO = nomeAtivos.get(i).name();

            URL url = new URL("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="+KEY_ATIVO+"&apikey="+KEY_API);
            Scanner scanner;
            scanner = new Scanner(url.openStream());
            String json = scanner.next();
            while (scanner.hasNext()) json += " "+scanner.next();
            JSONObject jsonObject = new JSONObject(json);


            JSONObject entrando = jsonObject.getJSONObject("Global Quote");

            ativoJson = new AtivoJson();
            ativoJson.setNameAtivo(NOME_ATIVO);
            ativoJson.setSymbol(entrando.getString("01. symbol"));
            ativoJson.setOpen(entrando.getBigDecimal("02. open"));
            ativoJson.setHigh(entrando.getBigDecimal("03. high"));
            ativoJson.setLow(entrando.getBigDecimal("04. low"));
            ativoJson.setPrice(entrando.getBigDecimal("05. price"));
            ativoJson.setVolume(entrando.getLong("06. volume"));
            ativoJson.setLatestTradingDay(entrando.getString("07. latest trading day"));
            ativoJson.setPreviousClose(entrando.getBigDecimal("08. previous close"));
            ativoJson.setChange(entrando.getBigDecimal("09. change"));
            ativoJson.setChangePercen(entrando.getString("10. change percent"));

            ativoJsons.add(ativoJson);

        }

        return ativoJsons;
    }

    public Optional<AtivoJson> buscarAtivoJson(List<AtivoJson> ativosJsons, String id){
         return ativosJsons.stream().filter( ativoJson -> ativoJson.getSymbol().equals(id)).findFirst();
    }

}
