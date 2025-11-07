package com.techup.spring_demo.entity;

import lombok.*;
import jakarta.persistence.*;

// @Data: ให้ Lombok สร้าง getter/setter, equals, hashCode และ toString อัตโนมัติ
@Data
// @NoArgsConstructor: สร้างคอนสตรักเตอร์ที่ไม่รับพารามิเตอร์
@NoArgsConstructor
// @AllArgsConstructor: สร้างคอนสตรักเตอร์ที่รับทุกฟิลด์เป็นพารามิเตอร์
@AllArgsConstructor
// @Builder: ช่วยสร้างอ็อบเจ็กต์ด้วย builder pattern
@Builder
// @Entity: บอกว่าเป็นเอนทิตีที่แม็ปกับตารางในฐานข้อมูล
@Entity
// @Table: ระบุชื่อของตารางที่ใช้แม็ปกับเอนทิตีนี้
@Table(name = "users")

public class User {

    // @Id: ระบุว่าเป็น primary key ของตาราง
    @Id
    // @GeneratedValue: กำหนดให้ฐานข้อมูลสร้างค่า primary key อัตโนมัติ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: ระบุชื่อคอลัมน์และเงื่อนไขเพิ่มเติม
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // @Column: ระบุว่าเป็นคอลัมน์รหัสผ่านและต้องไม่เป็นค่าว่าง
    @Column(name = "password", nullable = false)
    private String password;
}
