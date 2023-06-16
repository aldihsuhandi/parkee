package id.parkee.test.foundation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy")
public class DummyModel {
    @Id
    private String Id;
}
