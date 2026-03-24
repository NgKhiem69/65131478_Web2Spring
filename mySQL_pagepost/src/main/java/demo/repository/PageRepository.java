package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Page;

public interface PageRepository extends JpaRepository<Page, Long> {
}