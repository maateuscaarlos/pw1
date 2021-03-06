package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.Ativo;
import br.edu.ifpb.pw1.projeto.model.Disponibilidade;

import java.util.List;
import java.util.Optional;

public interface AtivoDAO {

    public Ativo CadastrarAtivo(Ativo ativo, Long idCarteira) throws Exception;

    public void removerAtivo(Long id) throws Exception;

    public Optional<Ativo> buscarAtivo(Long id) throws Exception;

    public void updtadeDisponibilidade(Ativo ativo) throws Exception;

    public List<Ativo> buscarTodos(Long idCarteira, Disponibilidade disponibilidade)throws Exception;

}
