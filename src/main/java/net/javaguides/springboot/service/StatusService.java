package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Status;

public interface StatusService {

	List<Status> getAllStatuses();

	Status saveStatus(Status status);

}
