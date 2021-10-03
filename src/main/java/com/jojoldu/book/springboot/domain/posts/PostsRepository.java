package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Dao라 불리는 DB Layer 접근자 - repository, Entity 클래스와 PK 타입을 적어주면 자동 CRUD 완성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p order by p.id DESC")
    List<Posts> findAllDesc();
}
