package bookmytable.dto;

public class AdminDTO extends AccountTypeDTO {

	public AdminDTO() {

	}

	public AdminDTO(String name, String email, String password, long id) {
		super(name, email, password, id);
	}
}
