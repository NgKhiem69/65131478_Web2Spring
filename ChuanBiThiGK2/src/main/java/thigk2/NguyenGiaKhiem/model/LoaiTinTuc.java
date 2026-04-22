package thigk2.NguyenGiaKhiem.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_tin_tuc")
public class LoaiTinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String tenLoai;

    @OneToMany(mappedBy = "loaiTinTuc", cascade = CascadeType.ALL)
    private List<TinTuc> danhSachTinTuc;

    // Getters và Setters (hoặc dùng @Data của Lombok)
}