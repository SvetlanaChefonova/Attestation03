package attestation03.hospitalregistry.dto;

import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.model.Hospitals;
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
public class HospitalsDto {
    private Long id;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhone;



    public static HospitalsDto from(Hospitals hospitals) {
        return HospitalsDto.builder()
                .id(hospitals.getId())
                .hospitalName(hospitals.getHospitalName())
                .hospitalAddress(hospitals.getHospitalAddress())
                .hospitalPhone(String.valueOf(hospitals.getHospitalPhone()))
                .build();
    }

    public static List<HospitalsDto> from(List<Hospitals> hospitals) {
        return hospitals.stream().map(HospitalsDto::from).toList();
    }
}
