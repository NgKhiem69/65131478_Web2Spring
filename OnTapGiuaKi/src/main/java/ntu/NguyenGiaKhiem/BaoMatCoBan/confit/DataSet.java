package ntu.NguyenGiaKhiem.BaoMatCoBan.confit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ntu.NguyenGiaKhiem.BaoMatCoBan.Model.Page;
import ntu.NguyenGiaKhiem.BaoMatCoBan.Model.Post;
import ntu.NguyenGiaKhiem.BaoMatCoBan.Repon.PageRepon;
import ntu.NguyenGiaKhiem.BaoMatCoBan.Repon.PostRepon;

@Component
public class DataSet implements CommandLineRunner {

    @Autowired
    private PageRepon pageRepository;

    @Autowired
    private PostRepon postRepository;

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra xem database đã có dữ liệu chưa, nếu chưa thì mới hard-code
        if (pageRepository.count() == 0) {
            Page page1 = new Page();
            page1.setPageName("Giới thiệu");
            page1.setKeyword("intro, about");
            page1.setContent("Đây là trang giới thiệu về bản thân.");
            page1.setParentPageId(0L);
            pageRepository.save(page1);

            Page page2 = new Page();
            page2.setPageName("Dự án cá nhân");
            page2.setKeyword("projects, portfolio");
            page2.setContent("Danh sách các dự án tôi đã làm.");
            page2.setParentPageId(0L);
            pageRepository.save(page2);
            
            System.out.println("Đã thêm dữ liệu mẫu cho Page!");
        }

        if (postRepository.count() == 0) {
            Post post1 = new Post();
            post1.setTitle("Hành trình học Spring Boot");
            post1.setContent("Nội dung bài viết về Spring Boot...");
            post1.setCategoryId(1L);
            postRepository.save(post1);

            Post post2 = new Post();
            post2.setTitle("Cách kết nối MySQL bằng JPA");
            post2.setContent("Hướng dẫn chi tiết cách dùng Spring Data JPA.");
            post2.setCategoryId(2L);
            postRepository.save(post2);
            
            System.out.println("Đã thêm dữ liệu mẫu cho Post!");
        }
    }
}