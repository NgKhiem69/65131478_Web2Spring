package thigk2.NguyenGiaKhiem.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "the_loai_tin")
public class TheLoaiTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tenTheLoai;

    @OneToMany(mappedBy = "theLoaiTin", cascade = CascadeType.ALL)
    private List<Tin> danhSachTin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<Tin> getDanhSachTin() {
		return danhSachTin;
	}

	public void setDanhSachTin(List<Tin> danhSachTin) {
		this.danhSachTin = danhSachTin;
	}

    
    
}