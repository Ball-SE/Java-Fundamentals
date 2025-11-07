package com.techup.spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;

// @Data: ให้ Lombok สร้าง getter/setter, equals, hashCode และ toString อัตโนมัติ
@Data
// @NoArgsConstructor: สร้างคอนสตรักเตอร์แบบไม่รับพารามิเตอร์
@NoArgsConstructor
// @AllArgsConstructor: สร้างคอนสตรักเตอร์ที่รับทุกฟิลด์เป็นพารามิเตอร์
@AllArgsConstructor
// @Builder: ช่วยสร้างอ็อบเจ็กต์ด้วย builder pattern
@Builder
// @Entity: กำหนดให้คลาสนี้เป็นเอนทิตีที่แม็ปกับตารางในฐานข้อมูล
@Entity
// @Table: ระบุชื่อตารางที่ใช้แม็ปกับเอนทิตีนี้
@Table(name = "notes")

public class Note {
    
    // @Id: ระบุว่าเป็น primary key ของตาราง
    @Id
    // @GeneratedValue: ให้ฐานข้อมูลสร้างค่า primary key อัตโนมัติ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // @Column: ระบุคอลัมน์ title และกำหนดว่าต้องไม่เป็นค่าว่าง
    @Column(nullable = false)
    private String title;
    
    // @Column: แม็ปกับคอลัมน์แบบ TEXT สำหรับเก็บเนื้อหาโน้ต
    @Column(columnDefinition = "TEXT")
    private String content;

    // @Column: ระบุชื่อคอลัมน์ image_url สำหรับเก็บ URL ของรูปภาพ
    @Column(name = "image_url")
    private String imageUrl;
}
