package thigk2.NguyenGiaKhiem.service;

import thigk2.NguyenGiaKhiem.model.TinTuc;
import thigk2.NguyenGiaKhiem.reponsitory.TinTucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TinTucService {
    @Autowired
    private TinTucRepository repo;

    public List<TinTuc> getAllTinTuc() { return repo.findAll(); }
    public void save(TinTuc tinTuc) { repo.save(tinTuc); }
    public TinTuc getById(Integer id) { return repo.findById(id).orElse(null); }
    public void delete(Integer id) { repo.deleteById(id); }
}
