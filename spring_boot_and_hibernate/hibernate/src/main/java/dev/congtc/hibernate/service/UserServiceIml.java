package dev.congtc.hibernate.service;

import dev.congtc.hibernate.entity.User;
import dev.congtc.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setTenUser(userDetails.getTenUser());
            user.setDiaChi(userDetails.getDiaChi());
            user.setSoDienThoai(userDetails.getSoDienThoai());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User không tồn tại với ID: " + id);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User không tồn tại với ID: " + id);
        }
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}