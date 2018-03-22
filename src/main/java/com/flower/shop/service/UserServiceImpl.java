package com.flower.shop.service;

import com.flower.shop.entity.User;
import com.flower.shop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UsersRepository userRepository;

    @Autowired
    public UserServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return user;
    }

    public User find(String userName) {
        return userRepository.findOneByUsername(userName);
    }

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public void removeById(int id) {
        userRepository.delete(id);
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    public User findByNickName(String name) {
        return userRepository.findByUsername(name);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAllSorted(Sort sort) {
        return userRepository.findAll(sort);
    }

    public Page<User> findAllPageble(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
