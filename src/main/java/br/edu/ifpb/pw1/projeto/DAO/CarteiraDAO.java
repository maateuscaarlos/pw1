package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.Carteira;

import java.util.Optional;

public interface CarteiraDAO {

    public Carteira cadastrarCarteira() throws Exception;

    public void removerCarteira(Long id) throws Exception;

    public Optional<Carteira> buscarCarteira(Long id) throws Exception;

    public void reinicarSaldo(Long id)throws Exception;

    public void atualizarSaldo(Carteira carteira)throws Exception;
}
