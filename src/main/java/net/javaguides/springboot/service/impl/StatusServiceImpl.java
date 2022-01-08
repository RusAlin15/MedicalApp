package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Status;
import net.javaguides.springboot.repository.StatusRepository;
import net.javaguides.springboot.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	StatusRepository statusRepository;

	public StatusServiceImpl(StatusRepository statusRepository) {
		super();
		this.statusRepository = statusRepository;
	}

	@Override
	public List<Status> getAllStatuses() {
		return statusRepository.findAll();
	}

	@Override
	public Status saveStatus(Status status) {
		return statusRepository.save(status);
	}

}
