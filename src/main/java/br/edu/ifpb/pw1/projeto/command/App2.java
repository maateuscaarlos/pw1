package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.ConexaoJsonApi;
import br.edu.ifpb.pw1.projeto.model.AtivoJson;
import br.edu.ifpb.pw1.projeto.model.Transacao;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App2 {
    public static void main(String[] args) throws IOException {
        Block<Transacao> printBlock = new Block<Transacao>() {
            @Override
            public void apply(final Transacao transacao) {
                System.out.println(transacao);
            }
        };


            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings
                            .getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();
            try (MongoClient mongoClient = MongoClients.create(settings)) {

                MongoDatabase banco = mongoClient.getDatabase("SimuladorInvestimentos");
                MongoCollection<Transacao> transacoes = banco.getCollection("transacoes", Transacao.class);
                transacoes.find().forEach(printBlock);
            }
    }
}
