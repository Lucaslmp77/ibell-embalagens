package br.com.uniamerica.ibellembalagens.Entity;

import java.time.LocalDateTime;

public abstract class AbstractEntity {
    private Long id;
    private Boolean active;
    private LocalDateTime register;
    private LocalDateTime update;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getRegister() {
        return register;
    }

    public void setRegister(LocalDateTime register) {
        this.register = register;
    }

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }
}
