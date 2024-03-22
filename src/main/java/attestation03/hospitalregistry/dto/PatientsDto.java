package attestation03.hospitalregistry.dto;

import attestation03.hospitalregistry.model.Patients;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PatientsDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(min=2)
    private String lastName;
    @NotNull
    @Size(min=2)
    private String name;
    @NotNull
    @Size(min=2)
    private String patronymic;


    public static PatientsDto from(Patients patients) {
        return PatientsDto.builder()
                .id(patients.getId())
                .lastName(patients.getLastName())
                .name(patients.getName())
                .patronymic(patients.getPatronymic())
                .build();
    }

    public static List<PatientsDto> from(List<Patients> patients) {
        return patients.stream().map(PatientsDto::from).collect(Collectors.toList());
    }

}
