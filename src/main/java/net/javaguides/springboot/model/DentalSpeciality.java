package net.javaguides.springboot.model;

import javax.persistence.Entity;

/****
 { "speciality": "Ortodonţie şi ortopedie dento-facială",
  "specialityType":"DentalSpeciality" }
 
  { "speciality": "Endodonţie", "specialityType":"DentalSpeciality" }
  
  { "speciality": "Parodontologie", "specialityType":"DentalSpeciality" }
  
  { "speciality": "Pedodonţie", "specialityType":"DentalSpeciality" }
  
  { "speciality": "Protetică dentară", "specialityType":"DentalSpeciality" }
  
 */

import lombok.Data;

@Data
@Entity
public class DentalSpeciality extends Speciality {

	public DentalSpeciality() {
		super();
	}

}
