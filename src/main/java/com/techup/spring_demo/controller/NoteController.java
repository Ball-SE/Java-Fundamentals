package com.techup.spring_demo.controller;

import com.techup.spring_demo.dto.NoteRequest;
import com.techup.spring_demo.dto.NoteResponse;
import com.techup.spring_demo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

// import com.techup.spring_demo.service.SupabaseStorageService;

// หมายเหตุ: @RestController ระบุให้คลาสนี้เป็น REST Controller ใน Spring
@RestController
// หมายเหตุ: @RequestMapping กำหนด prefix ของ path สำหรับทุก endpoint ในคลาสนี้
@RequestMapping("/api/notes")
// หมายเหตุ: @RequiredArgsConstructor สร้าง constructor อัตโนมัติสำหรับฟิลด์ final เพื่อใช้ในการฉีด dependency
@RequiredArgsConstructor

public class NoteController {
    private final NoteService noteService;
    // private final SupabaseStorageService supabaseStorageService; // ✅ ฉีด service อัปโหลดเข้ามา


    // GET /api/notes → 200
    // หมายเหตุ: @GetMapping ระบุเมธอดนี้รองรับ HTTP GET เพื่อดึงรายการโน้ตทั้งหมด
    @GetMapping
    public ResponseEntity<List<NoteResponse>> getNotes() {
        return ResponseEntity.ok(noteService.getAll());
    }

    // GET /api/notes/{id} → 200 | 404
    // หมายเหตุ: @GetMapping ระบุเมธอดนี้รองรับ HTTP GET เพื่อดึงโน้ตเฉพาะตาม ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNote(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getById(id));
    }

    // POST /api/notes → 201 + Location header
    // หมายเหตุ: @PostMapping ระบุเมธอดนี้รองรับ HTTP POST เพื่อสร้างโน้ตใหม่
    @PostMapping
    public ResponseEntity<NoteResponse> create(@RequestBody NoteRequest req) {
        NoteResponse created = noteService.create(req);
        URI location = URI.create("/api/notes/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    // PUT /api/notes/{id} → 200 | 404
    // หมายเหตุ: @PutMapping ระบุเมธอดนี้รองรับ HTTP PUT เพื่ออัปเดตโน้ตที่มี ID ตามที่ระบุ
    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> update(@PathVariable Long id,
                                                @RequestBody NoteRequest req) {
        return ResponseEntity.ok(noteService.update(id, req));
    }

    // DELETE /api/notes/{id} → 204
    // หมายเหตุ: @DeleteMapping ระบุเมธอดนี้รองรับ HTTP DELETE เพื่อลบโน้ตที่มี ID ตามที่ระบุ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //     /** อัปโหลดไฟล์ แล้วผูก URL เข้ากับโน้ต */
    // @PostMapping("/{id}/upload")
    // public ResponseEntity<NoteResponse> uploadForNote(@PathVariable Long id,
    //                                                     @RequestParam("file") MultipartFile file) {
    //     String url = supabaseStorageService.uploadFile(file);
    //     NoteResponse updated = noteService.attachFileUrl(id, url);
    //     return ResponseEntity.ok(updated);
    // }
}
