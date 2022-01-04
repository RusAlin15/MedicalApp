package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.MorbidityCode;

public interface MorbidityCodeService {

	MorbidityCode saveMorbidityCode(MorbidityCode morbidityCode);

	List<MorbidityCode> getAllMorbidityCodes();

}
