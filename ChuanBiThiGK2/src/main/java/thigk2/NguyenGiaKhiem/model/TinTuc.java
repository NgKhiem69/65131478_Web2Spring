package thigk2.NguyenGiaKhiem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tin_tuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String tieuDe;
    
    @Column(columnDefinition = "TEXT")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "loai_tin_tuc_id")
    private LoaiTinTuc loaiTinTuc;

    // Getters và Setters
}