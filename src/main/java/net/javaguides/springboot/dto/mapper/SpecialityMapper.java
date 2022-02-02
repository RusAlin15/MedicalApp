package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.model.Speciality;

@Primary
@Service
@Transactional
public abstract class SpecialityMapper {

	public abstract Speciality specialityDTO2speciality(SpecialityDTO specialityDTO);

	public abstract SpecialityDTO speciality2SpecialityDTO(Speciality saveSpeciality);

	public List<SpecialityDTO> specialityList2SpecialityDTOList(List<Speciality> allSpecialities) {
		return allSpecialities.stream().map(this::speciality2SpecialityDTO).collect(Collectors.toList());
	}
}
