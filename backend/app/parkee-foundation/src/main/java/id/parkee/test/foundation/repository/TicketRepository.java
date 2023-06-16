package id.parkee.test.foundation.repository;

import id.parkee.test.foundation.model.TicketDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDO, Integer> {
}
