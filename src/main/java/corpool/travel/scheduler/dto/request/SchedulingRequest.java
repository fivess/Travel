package corpool.travel.scheduler.dto.request;

import corpool.travel.scheduler.model.Scheduling;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingRequest {

  @NotNull
  private Long rideId;
  @NotNull
  private LocalDateTime rideDate;


  public Scheduling toModel() {
    return Scheduling.builder()
        .rideId(this.rideId)
        .rideDate(Date.from(this.rideDate.toInstant(ZoneOffset.UTC)))
        .build();
  }

}
