package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {
    @Id
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Boolean active;
    @Getter @Setter
    private LocalDateTime register;
    @Getter @Setter
    private LocalDateTime update;
}
