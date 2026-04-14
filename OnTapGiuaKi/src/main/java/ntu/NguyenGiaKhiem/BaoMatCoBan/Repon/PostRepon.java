package ntu.NguyenGiaKhiem.BaoMatCoBan.Repon;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.NguyenGiaKhiem.BaoMatCoBan.Model.Post;

public interface PostRepon extends JpaRepository<Post, Long> {
}
