package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.ClinicSpecialityDTO;
import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.model.SurgerySpeciality;

public class SurgerySpecialityMapper extends SpecialityMapper {

	@Override
	public Speciality specialityDTO2speciality(SpecialityDTO specialityDTO) {
		Speciality speciality = new SurgerySpeciality();
		speciality.setId(specialityDTO.getId());
		speciality.setSpecialityName(specialityDTO.getSpecialityName());

		return speciality;
	}

	@Override
	public SpecialityDTO speciality2SpecialityDTO(Speciality speciality) {
		SpecialityDTO specialityDTO = new ClinicSpecialityDTO();
		SurgerySpeciality surgerySpeciality = (SurgerySpeciality) speciality;

		specialityDTO.setId(surgerySpeciality.getId());
		specialityDTO.setSpecialityName(surgerySpeciality.getSpecialityName());

		return specialityDTO;
	}
}
