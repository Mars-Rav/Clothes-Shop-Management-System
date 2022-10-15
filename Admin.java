record Admin(int id, String username, String phoneNo, String password, int salary) {

	public Admin {
		
		if(id < 100 || id > 999) {
			throw new IllegalArgumentException("The ID has to be exactly 3 digits");
		}

		if(username.length() < 5) {
			throw new IllegalArgumentException("Username has to be atleast 5 characters.");
		}
				
		if(phoneNo.length() > 11 || phoneNo.length() < 11) {
			throw new IllegalArgumentException("Phone number has to be exactly 11 digits.");
		}

		if (password.length() < 5) {
			throw new IllegalArgumentException("Password has to be atleast 5 characters.");
		}

		if (salary < 0) {
			throw new IllegalArgumentException("Salary Cannot be Negative.");
		}
			
		
	}

}