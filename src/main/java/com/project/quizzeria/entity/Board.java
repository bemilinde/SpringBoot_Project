package com.project.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(value = { AuditingEntityListener.class })
@ToString(exclude = {"member"})
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    @Column(length = 100, nullable = false)
    private String category;

    @ColumnDefault("0")
    @Column(length = 10)
    private Long views;

    @ColumnDefault("0")
    @Column(length = 10)
    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;



    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }

    public void increaseViews() {
        this.views += 1;
    }

    public void increaseLikes() {
        this.likes += 1;
        this.views -= 1;
    }



}