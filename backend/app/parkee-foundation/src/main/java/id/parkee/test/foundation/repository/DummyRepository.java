package id.parkee.test.foundation.repository;

import id.parkee.test.foundation.model.DummyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<DummyModel, String> {
}
