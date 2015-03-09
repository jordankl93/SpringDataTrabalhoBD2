package com.trab2.model;

/**
 *
 * @author Jordan
 */
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
// Esse tipo de herança junta as propriedades do da classe pai com as da classe filho.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Id {

    @javax.persistence.Id
    @Column
    // Gera um Id automaticamente
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
