package com.mytool.beststore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.mytool.beststore.models.Room;
import com.mytool.beststore.services.RoomRepository;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public String listRooms(@RequestParam(value = "phone", required = false) String phone, Model model) {
        if (phone != null && !phone.isEmpty()) {
            model.addAttribute("rooms", roomRepository.findByPhoneNumberContaining(phone));
        } else {
            model.addAttribute("rooms", roomRepository.findAll());
        }
        return "products/index";
    }
    @PostMapping("/rooms/delete")
public String deleteRooms(@RequestParam("roomIds") List<Integer> roomIds) {
    roomRepository.deleteAllById(roomIds); // Xóa các bản ghi theo danh sách ID
    return "redirect:/rooms"; // Chuyển hướng về danh sách phòng trọ
}
    @PostMapping("/rooms/create")
    public String createRoom(@ModelAttribute Room room) {
        roomRepository.save(room); // Lưu thông tin phòng trọ vào cơ sở dữ liệu
        return "redirect:/rooms"; // Chuyển hướng về danh sách phòng trọ
    }
}