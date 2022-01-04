package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.MorbidityCode;
import net.javaguides.springboot.repository.MorbidityCodeRepository;
import net.javaguides.springboot.service.MorbidityCodeService;

@Service
public class MorbidityCodeServiceImpl implements MorbidityCodeService {
	private MorbidityCodeRepository morbidityCodeRepository;

	public MorbidityCodeServiceImpl(MorbidityCodeRepository morbidityCodeRepository) {
		super();
		this.morbidityCodeRepository = morbidityCodeRepository;
	}

	@Override
	public MorbidityCode saveMorbidityCode(MorbidityCode morbidityCode) {
		return morbidityCodeRepository.save(morbidityCode);
	}

	@Override
	public List<MorbidityCode> getAllMorbidityCodes() {
		return morbidityCodeRepository.findAll();
	}

}
