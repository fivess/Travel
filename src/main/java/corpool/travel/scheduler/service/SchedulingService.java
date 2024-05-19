package corpool.travel.scheduler.service;

import corpool.travel.scheduler.dto.request.SchedulingRequest;
import corpool.travel.scheduler.dto.response.SchedulingDto;
import corpool.travel.scheduler.repository.SchedulingRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchedulingService {

  private final SchedulingRepository schedulingRepository;


  public Optional<SchedulingDto> getScheduling(final Long schedulingId, final Long rideId) {
    return schedulingRepository.findByIdAndRideId(schedulingId, rideId)
        .map(SchedulingDto::from);
  }

  public Page<SchedulingDto> findSchedulings(final Long rideId, final Pageable pageable) {
    return schedulingRepository.findAllByRideId(rideId, pageable)
        .map(SchedulingDto::from);
  }

  public SchedulingDto createScheduling(final SchedulingRequest schedulingRequest) {
    return SchedulingDto.from(schedulingRepository.save(schedulingRequest.toModel()));
  }

  @Transactional
  public Optional<SchedulingDto> addPassanger(final Long schedulingId, final Long passangerId) {
    return schedulingRepository
        .findById(schedulingId)
        .map(scheduling -> {
          scheduling.getPassangerId().add(passangerId);
          return SchedulingDto.from(schedulingRepository.save(scheduling));
        });

  }

  @Transactional
  public Optional<SchedulingDto> removePassanger(final Long schedulingId, final Long passangerId) {
    return schedulingRepository
        .findById(schedulingId)
        .map(scheduling -> {
          scheduling.getPassangerId().remove(passangerId);
          return SchedulingDto.from(schedulingRepository.save(scheduling));
        });
  }

  @Transactional
  public void deleteScheduling(final Long schedulingId, final Long rideId) {
    schedulingRepository.deleteByIdAndRideId(schedulingId, rideId);

  }
}
