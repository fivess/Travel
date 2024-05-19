package corpool.travel.scheduler.controller;

import corpool.travel.scheduler.dto.request.SchedulingRequest;
import corpool.travel.scheduler.dto.response.SchedulingDto;
import corpool.travel.scheduler.service.SchedulingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/scheduling")
@RestController
@RequiredArgsConstructor
public class SchedulingController {

  private final SchedulingService schedulingService;


  @GetMapping("/{id}/ride/{rideId}")
  public ResponseEntity<SchedulingDto> findSchedulingId(@PathVariable("id") final Long schedulingId, @PathVariable final Long rideId) {
    return schedulingService.getScheduling(schedulingId, rideId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/ride/{rideId}")
  public Page<SchedulingDto> getallScheduling(@PathVariable final Long rideId,
                                              final Pageable pageable) {
    return schedulingService.findSchedulings(rideId, pageable);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public SchedulingDto createScheduling(@RequestBody @Valid final SchedulingRequest schedulingRequest) {
    return schedulingService.createScheduling(schedulingRequest);
  }

  @PostMapping("/{id}/passanger/{passangerId}")
  public ResponseEntity<SchedulingDto> addPassanger(@PathVariable("id") final Long schedulingId, @PathVariable final Long passangerId) {
    return schedulingService.addPassanger(schedulingId, passangerId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}/passanger/{passangerId}")
  public ResponseEntity<SchedulingDto> removePassanger(@PathVariable("id") final Long schedulingId, @PathVariable final Long passangerId) {
    return schedulingService.removePassanger(schedulingId, passangerId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }


  @DeleteMapping("/{id}/ride/{rideId}/")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteScheduling(@PathVariable("id") final Long schedulingId, @PathVariable final Long rideId) {
    schedulingService.deleteScheduling(schedulingId, rideId);
  }
}
