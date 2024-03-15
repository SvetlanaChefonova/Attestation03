package attestation03.hospitalregistry.dto;

import attestation03.hospitalregistry.model.Hospitals;
import attestation03.hospitalregistry.model.Visits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitsDto {
    private Long id;
    private String dataTimeOfTheVisit;



    public static VisitsDto from(Visits visits) {
        return VisitsDto.builder()
                .id(visits.getId())
                .dataTimeOfTheVisit(visits.getDataTimeOfTheVisit())
                .build();
    }

    public static List<VisitsDto> from(List<Visits> visits) {
        return visits.stream().map(VisitsDto::from).collect(Collectors.toList());
    }
}
