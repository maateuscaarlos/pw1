package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.Transacao;

import java.util.List;
import java.util.Optional;

public interface TransacaoDAO {

    public void cadastrarTransacao(Transacao transacao) throws Exception;

    public void removerTransacao(Long id) throws Exception;

    public Optional<Transacao> buscarTransacao(Long id) throws Exception;

    public List<Transacao> buscarTodos(Long idUser) throws Exception;
}
