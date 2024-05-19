package corpool.travel.scheduler.repository;

import corpool.travel.scheduler.model.Scheduling;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

  Optional<Scheduling> findByIdAndRideId(Long schedulingId, Long rideId);


  Page<Scheduling> findAllByRideId(Long rideId, Pageable pageable);

  void deleteByIdAndRideId(Long schedulingId, Long rideId);


}
