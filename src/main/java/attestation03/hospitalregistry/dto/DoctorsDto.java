package attestation03.hospitalregistry.dto;

import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.model.Patients;
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
public class DoctorsDto {
    private Long id;
    private String lastName;
    private String name;
    private String patronymic;
    private String specialization;
    private Integer cabinetNumber ;


    public static DoctorsDto from(Doctors doctors) {
        return DoctorsDto.builder()
                .id(doctors.getId())
                .lastName(doctors.getLastName())
                .name(doctors.getName())
                .patronymic(doctors.getPatronymic())
                .specialization(doctors.getSpecialization())
                .cabinetNumber(doctors.getCabinetNumber())
                .build();
    }

    public static List<DoctorsDto> from(List<Doctors> doctors) {
        return doctors.stream().map(DoctorsDto::from).collect(Collectors.toList());
    }
}
