package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Getter @Setter
    @Column(name = "register", nullable = false)
    private LocalDateTime register;

    @Getter @Setter
    @Column(name = "update", nullable = true)
    private LocalDateTime update;

    @PrePersist
    public void dateRegister() {
        this.setRegister(LocalDateTime.now());
        this.setActive(true);
    }

    @PreUpdate
    public void dateUpdate() {
        this.setUpdate(LocalDateTime.now());
    }
}
