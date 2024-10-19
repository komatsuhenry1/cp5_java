package com.example.brinquedos.service;

import com.example.brinquedos.entity.User;
import com.example.brinquedos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Implementação do método loadUserByUsername da interface UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // Busca o usuário pelo nome de usuário
        if (user != null) { // Verifica se o usuário não é nulo
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername()) // Obtém o nome de usuário
                    .password(user.getPassword()) // Obtém a senha
                    .authorities(new ArrayList<>()) // Adicione suas authorities aqui se necessário
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username); // Lança exceção se não encontrado
        }
    }

    // Métodos adicionais para manipulação de usuários
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
