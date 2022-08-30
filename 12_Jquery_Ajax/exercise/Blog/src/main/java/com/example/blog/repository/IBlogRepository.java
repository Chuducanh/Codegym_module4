package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blogg b where b.name like ?1 or b.creator like ?1",nativeQuery = true)
    List<Blog> findByName(String name);
}
