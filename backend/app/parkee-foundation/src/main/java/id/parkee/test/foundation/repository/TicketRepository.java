package id.parkee.test.foundation.repository;

import id.parkee.test.foundation.model.TicketDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketDO, Integer> {
    @Query("SELECT t FROM TicketDO t WHERE t.areaCode = :areaCode AND t.plateNumber = :plateNumber AND t.plateCode = :plateCode")
    Optional<TicketDO> findByPlateCombination(String areaCode, String plateNumber, String plateCode);
}
