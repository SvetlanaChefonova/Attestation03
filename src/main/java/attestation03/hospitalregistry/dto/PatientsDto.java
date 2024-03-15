package attestation03.hospitalregistry.dto;

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
public class PatientsDto {
    private Long id;
    private String lastName;
    private String name;
    private String patronymic;
    private String dateOfBirthday;
    private Long phoneNumber;
    private String placeOfWork;
    private String homeAddress;
    private String email;
    private Long policyNumber;
    private String insuranceCompany;

    public static PatientsDto from(Patients patients) {
        return PatientsDto.builder()
                .id(patients.getId())
                .lastName(patients.getLastName())
                .name(patients.getName())
                .patronymic(patients.getPatronymic())
                .dateOfBirthday(patients.getDateOfBirthday())
                .phoneNumber(patients.getPhoneNumber())
                .placeOfWork(patients.getPlaceOfWork())
                .homeAddress(patients.getHomeAddress())
                .email(patients.getEmail())
                .policyNumber(patients.getPolicyNumber())
                .insuranceCompany(patients.getInsuranceCompany())
                .build();
    }

    public static List<PatientsDto> from(List<Patients> patients) {
        return patients.stream().map(PatientsDto::from).collect(Collectors.toList());
    }

}
