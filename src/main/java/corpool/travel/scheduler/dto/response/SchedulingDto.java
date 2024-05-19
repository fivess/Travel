package corpool.travel.scheduler.dto.response;

import corpool.travel.scheduler.model.Scheduling;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchedulingDto {


  private Long id;
  private Long rideId;
  private Date rideDate;
  private Set<Long> passangerId;


  public static SchedulingDto from(Scheduling schedulingDto) {
    return SchedulingDto.builder()
        .id(schedulingDto.getId())
        .rideId(schedulingDto.getRideId())
        .rideDate(schedulingDto.getRideDate())
        .passangerId(schedulingDto.getPassangerId())
        .build();
  }
}
