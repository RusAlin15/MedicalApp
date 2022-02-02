package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.DentalSpecialityDTO;
import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.model.DentalSpeciality;
import net.javaguides.springboot.model.Speciality;

public class DentalSpecialityMapper extends SpecialityMapper {

	@Override
	public Speciality specialityDTO2speciality(SpecialityDTO specialityDTO) {
		Speciality speciality = new DentalSpeciality();
		speciality.setId(specialityDTO.getId());
		speciality.setSpecialityName(specialityDTO.getSpecialityName());

		return speciality;
	}

	@Override
	public SpecialityDTO speciality2SpecialityDTO(Speciality speciality) {
		SpecialityDTO specialityDTO = new DentalSpecialityDTO();
		DentalSpeciality dentalSpeciality = (DentalSpeciality) speciality;

		specialityDTO.setId(dentalSpeciality.getId());
		specialityDTO.setSpecialityName(dentalSpeciality.getSpecialityName());

		return specialityDTO;
	}

}
