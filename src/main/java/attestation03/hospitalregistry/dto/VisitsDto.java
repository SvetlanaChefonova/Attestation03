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
    private String patientLastName;
    private String patientName;
    private String patientPatronymic;
    private String doctorLastName;
    private String doctorName;
    private String doctorPatronymic;
    private String doctorSpecialization;
    private String hospitalName;




    public static VisitsDto from(Visits visits) {
        return VisitsDto.builder()
                .id(visits.getId())
                .dataTimeOfTheVisit(visits.getDataTimeOfTheVisit())
                .patientLastName(visits.getPatients().getLastName())
                .patientName(visits.getPatients().getName())
                .patientPatronymic(visits.getPatients().getPatronymic())
                .doctorLastName(visits.getDoctors().getLastName())
                .doctorName(visits.getDoctors().getName())
                .doctorPatronymic(visits.getDoctors().getPatronymic())
                .doctorSpecialization(visits.getDoctors().getSpecialization())
                .hospitalName(visits.getHospitals().getHospitalName())
                .build();
    }

    public static List<VisitsDto> from(List<Visits> visits) {
        return visits.stream().map(VisitsDto::from).toList();
    }
}
