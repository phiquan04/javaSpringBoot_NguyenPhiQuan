package com.mytool.beststore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mytool.beststore.models.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByPhoneNumberContaining(String phoneNumber); // Tìm kiếm theo số điện thoại
}