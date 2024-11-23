package dev.congtc.hibernate.service;

import dev.congtc.hibernate.entity.User;

import java.util.Optional;

public interface UserService {

    // Thêm User mới
    User addUser(User user);

    // Sửa User dựa trên ID
    User updateUser(Integer id, User userDetails);

    // Xóa User dựa trên ID
    void deleteUser(Integer id);

    // Lấy User theo ID
    Optional<User> getUserById(Integer id);
}
