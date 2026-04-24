package thigk2.NguyenGiaKhiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.NguyenGiaKhiem.entity.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
    
    NguoiDung findByUsernameAndPassword(String username, String password);
}
