package one.digitalinnovation.personApi.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	
	private Long id;
	
	@NotEmpty
	@Size
	private String firstName;
	
	
}
