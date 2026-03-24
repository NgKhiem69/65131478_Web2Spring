package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.model.Page;
import demo.model.Post;
import demo.repository.PageRepository;
import demo.repository.PostRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private PostRepository postRepository;

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