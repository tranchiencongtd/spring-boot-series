package dev.congtc.hibernate;

import dev.congtc.hibernate.entity.User;
import dev.congtc.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class UserConsoleApp implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public UserConsoleApp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Chào mừng bạn đến với ứng dụng CRUD User trên terminal!");

        while (!exit) {
            System.out.println("\nChọn thao tác:");
            System.out.println("1. Thêm User");
            System.out.println("2. Sửa User");
            System.out.println("3. Xóa User");
            System.out.println("4. Xem User");
            System.out.println("5. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    updateUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    viewUser(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        scanner.close();
    }

    private void addUser(Scanner scanner) {
        System.out.println("Thêm User mới:");
        System.out.print("Tên: ");
        String tenUser = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        User user = new User();
        user.setTenUser(tenUser);
        user.setDiaChi(diaChi);
        user.setSoDienThoai(soDienThoai);
        user.setEmail(email);

        User savedUser = userService.addUser(user);
        System.out.println("User đã được thêm: " + savedUser);
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Nhập ID của User cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            System.out.print("Tên (" + existingUser.getTenUser() + "): ");
            String tenUser = scanner.nextLine();
            System.out.print("Địa chỉ (" + existingUser.getDiaChi() + "): ");
            String diaChi = scanner.nextLine();
            System.out.print("Số điện thoại (" + existingUser.getSoDienThoai() + "): ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Email (" + existingUser.getEmail() + "): ");
            String email = scanner.nextLine();

            if (!tenUser.isEmpty()) existingUser.setTenUser(tenUser);
            if (!diaChi.isEmpty()) existingUser.setDiaChi(diaChi);
            if (!soDienThoai.isEmpty()) existingUser.setSoDienThoai(soDienThoai);
            if (!email.isEmpty()) existingUser.setEmail(email);

            User updatedUser = userService.updateUser(id, existingUser);
            System.out.println("User đã được cập nhật: " + updatedUser);
        } else {
            System.out.println("User với ID " + id + " không tồn tại.");
        }
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Nhập ID của User cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            userService.deleteUser(id);
            System.out.println("User đã được xóa.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewUser(Scanner scanner) {
        System.out.print("Nhập ID của User cần xem: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            System.out.println("Thông tin User: " + optionalUser.get());
        } else {
            System.out.println("User với ID " + id + " không tồn tại.");
        }
    }
}