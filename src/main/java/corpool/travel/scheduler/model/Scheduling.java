package corpool.travel.scheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scheduling")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scheduling {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "ride_id", nullable = false)
  private Long rideId;


  @Column(name = "ride_date", nullable = false)
  private Date rideDate;

  @Column(name = "passanger_id")
  @ElementCollection
  @Builder.Default
  private Set<Long> passangerId = new HashSet<>();


}
