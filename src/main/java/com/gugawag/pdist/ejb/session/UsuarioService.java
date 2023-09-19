package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.ArrayList;
import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;
    //private UsuarioService mensagemService;

    // Aqui para listar a mensagem também
    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);

        if (id == 4) {
//            Mensagem mensagem = new Mensagem();
//            mensagem.setTexto("Mensagem u4");
            Mensagem mensagem = new Mensagem(id, "Mensagem u4");
            this.mensagemDAO.inserir(mensagem);
        }
        if (id == 5){
            Mensagem mensagem = new Mensagem(id, "Mensagem u5");
            this.mensagemDAO.inserir(mensagem);
            throw new RuntimeException();
        }
    }

    /* public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    } */

    public List<Object> listarUsuariosEMensagens() {
        List<Object> result = new ArrayList<>();
        List<Usuario> usuarios = usuarioDAO.listar();
        List<Mensagem> mensagens = mensagemDAO.listar();
        result.addAll(usuarios);
        result.addAll(mensagens);
        return result;
    }
}