package ru.serverflot.mapi.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_history")
public class History extends AuditModel {
    @Id
    @GeneratedValue(generator = "tab_history_generator")
    @SequenceGenerator(
            name = "tab_history_generator",
            sequenceName = "tab_history_sequence",
            initialValue = 1
    )
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
