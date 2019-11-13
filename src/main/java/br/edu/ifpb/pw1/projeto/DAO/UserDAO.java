package br.edu.ifpb.pw1.projeto.DAO;

import br.edu.ifpb.pw1.projeto.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    public void CadastrarUser(User user) throws Exception;

    public void removerUser(Long id) throws Exception;

    public void atualizarUser(User user) throws  Exception;

    public Optional<User> buscarUser(Long id) throws Exception;

    public List<User> buscarTodos() throws Exception;

    public Optional<User> autenticarUser(String email, String senha) throws Exception;


}
