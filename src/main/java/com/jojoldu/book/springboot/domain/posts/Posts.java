package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // pk의 생성 규칙. 스프링부트 2.0 버전은 IDENTITY를 해야 auto increment됨
    private Long id;

    @Column(length = 500, nullable = false)
    // 테이블 컬럼을 나타냄, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    // 옵션을 주기 위해서 사용용
   private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
