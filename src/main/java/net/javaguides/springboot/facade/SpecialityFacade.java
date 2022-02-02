package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.dto.mapper.SpecialityMapper;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.service.SpecialityService;

@Component
public class SpecialityFacade {
	@Autowired
	private SpecialityMapper specialityMapper;

	@Autowired
	private SpecialityService specialityService;

	public SpecialityDTO saveSpeciality(SpecialityDTO specialityDTO) {
		Speciality speciality = specialityMapper.specialityDTO2speciality(specialityDTO);
		return specialityMapper.speciality2SpecialityDTO(specialityService.saveSpeciality(speciality));
	}

	public SpecialityDTO updateSpeciality(long specialityId, SpecialityDTO specialityDTO) {
		Speciality speciality = specialityMapper.specialityDTO2speciality(specialityDTO);
		return specialityMapper.speciality2SpecialityDTO(specialityService.updateSpeciality(specialityId, speciality));
	}

	public SpecialityDTO getSpecialityById(long specialityId) {
		return specialityMapper.speciality2SpecialityDTO(specialityService.getSpecialityById(specialityId));
	}

	public List<SpecialityDTO> getAllSpecialities() {
		return specialityMapper.specialityList2SpecialityDTOList(specialityService.getAllSpecialities());
	}

	public void deleteSpecialityById(long specialityId) {
		specialityService.deleteSpecialityById(specialityId);
	}

	public void deleteAllSpecialities() {
		specialityService.deleteAllSpecialities();

	}
}
