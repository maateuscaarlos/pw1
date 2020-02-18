package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.Transacao;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;
import java.util.Optional;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class TransacaoDAOMongo implements TransacaoDAO {
    @Override
    public void cadastrarTransacao(Transacao transacao) throws Exception {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings
                        .getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        try (MongoClient mongoClient = MongoClients.create(settings)) {

            MongoDatabase banco = mongoClient.getDatabase("SimuladorInvestimentos");
            MongoCollection<Transacao> transacoes = banco.getCollection("transacoes", Transacao.class);
            transacoes.insertOne(transacao);
        }
    }

    @Override
    public void removerTransacao(Long id) throws Exception {

    }

    @Override
    public Optional<Transacao> buscarTransacao(Long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Transacao> buscarTodos(Long idUser) throws Exception {
//
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings
//                        .getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .codecRegistry(pojoCodecRegistry)
//                .build();
//        try (MongoClient mongoClient = MongoClients.create(settings)) {
//
//            MongoDatabase banco = mongoClient.getDatabase("SimuladorInvestimentos");
//            MongoCollection<Transacao> transacoes = banco.getCollection("transacoes", Transacao.class);
//
//            transacoes.find(("age", 30)).forEach(printBlock);
        return null;
    }
}
