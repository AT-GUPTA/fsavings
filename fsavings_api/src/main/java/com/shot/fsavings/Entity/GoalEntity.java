package com.shot.fsavings.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GoalEntity {
    @Id
    @Column
    private Long id;

    @Column
    private Long savings;

    @Column
    private Long wants;

    @Column
    private Long needs;
}
