package dev.congtc.hibernate.repository;

import dev.congtc.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Không cần khai báo thêm gì, JpaRepository đã hỗ trợ các phương thức CRUD cơ bản
}
