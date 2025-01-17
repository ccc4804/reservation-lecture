package com.hhplus.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user_lecture_history")
@ToString
@NoArgsConstructor
public class UserLectureHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", insertable = false, nullable = false)
    private Long uid;

    // lectureSchedule, user는 동시성 테스트를 위해서 unique, 복합키 설정하지 않음.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_schedule_uid")
    private LectureSchedule lectureSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public UserLectureHistory(LectureSchedule lectureSchedule, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.lectureSchedule = lectureSchedule;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
