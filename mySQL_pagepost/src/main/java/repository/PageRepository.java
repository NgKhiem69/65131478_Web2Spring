package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Page;

public interface PageRepository extends JpaRepository<Page, Long> {
}