package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Language {
    @Id
    @Column(name = "language_id", nullable = false)
    private Integer languageId;
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @OneToMany(mappedBy = "languageByLanguageId")
    private Collection<Film> filmsByLanguageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(languageId, language.languageId) &&
                Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, name);
    }
}
