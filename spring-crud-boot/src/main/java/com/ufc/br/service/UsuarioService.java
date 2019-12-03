package com.ufc.br.service;

import com.ufc.br.model.Role;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(Usuario usuario) {

        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        //Com isso, sempre que uma nova pessoa se cadastrar, dizemos que seu papel é de usuário
        Role role = new Role();
        role.setPapel("ROLE_DEFAULT");

        //Como uma pessoa pode ter mais de um papel, adicionamos o novo papel ao final da lista de papeis
        List<Role> roles = usuario.getRoles();
        if(roles ==  null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public void cadastrarUsuarioAdmin(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        //Com isso, sempre que uma nova pessoa se cadastrar, dizemos que seu papel é de usuário
        Role role = new Role();
        role.setPapel("ROLE_ADMIN");

        //Como uma pessoa pode ter mais de um papel, adicionamos o novo papel ao final da lista de papeis
        List<Role> roles = usuario.getRoles();
        if(roles ==  null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public void cadastrarUsuarioAluno(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        //Com isso, sempre que uma nova pessoa se cadastrar, dizemos que seu papel é de usuário
        Role role = new Role();
        role.setPapel("ROLE_ALUNO");

        //Como uma pessoa pode ter mais de um papel, adicionamos o novo papel ao final da lista de papeis
        List<Role> roles = usuario.getRoles();
        if(roles ==  null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public void cadastrarUsuarioInstrutor(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        //Com isso, sempre que uma nova pessoa se cadastrar, dizemos que seu papel é de usuário
        Role role = new Role();
        role.setPapel("ROLE_INSTRUTOR");

        //Como uma pessoa pode ter mais de um papel, adicionamos o novo papel ao final da lista de papeis
        List<Role> roles = usuario.getRoles();
        if(roles ==  null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public void cadastrarUsuarioPiloto(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        //Com isso, sempre que uma nova pessoa se cadastrar, dizemos que seu papel é de usuário
        Role role = new Role();
        role.setPapel("ROLE_PILOTO");

        //Como uma pessoa pode ter mais de um papel, adicionamos o novo papel ao final da lista de papeis
        List<Role> roles = usuario.getRoles();
        if(roles ==  null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public Usuario findByLogin(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
