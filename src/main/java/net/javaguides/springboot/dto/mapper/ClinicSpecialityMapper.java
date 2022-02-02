package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.ClinicSpecialityDTO;
import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.model.ClinicSpeciality;
import net.javaguides.springboot.model.Speciality;

public class ClinicSpecialityMapper extends SpecialityMapper {

	@Override
	public Speciality specialityDTO2speciality(SpecialityDTO specialityDTO) {
		Speciality speciality = new ClinicSpeciality();

		speciality.setId(specialityDTO.getId());
		speciality.setSpecialityName(specialityDTO.getSpecialityName());

		return speciality;
	}

	@Override
	public SpecialityDTO speciality2SpecialityDTO(Speciality speciality) {
		SpecialityDTO specialityDTO = new ClinicSpecialityDTO();
		ClinicSpeciality clinicSpeciality = (ClinicSpeciality) speciality;

		specialityDTO.setId(clinicSpeciality.getId());
		specialityDTO.setSpecialityName(clinicSpeciality.getSpecialityName());

		return specialityDTO;
	}

}
