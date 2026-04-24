package thigk2.NguyenGiaKhiem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.NguyenGiaKhiem.entity.Tin;
import java.util.List;

public interface TinRepository extends JpaRepository<Tin, Long> {
    
    List<Tin> findByTheLoaiTin_Id(Long theLoaiId); 
}