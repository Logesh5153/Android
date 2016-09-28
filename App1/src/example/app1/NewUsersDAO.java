package example.app1;

import java.util.List;

import com.j256.ormlite.field.DatabaseField;

/*public class NewUsersListDAO {

	public List<NewUsersDAO> newusers;

	public NewUsersListDAO(List<NewUsersDAO> newusers) {
		super();
		this.newusers = newusers;
	}

	public NewUsersListDAO() {
		// TODO Auto-generated constructor stub
	}


	public List<NewUsersDAO> getUsers() {
		return newusers;
	}

	public void setUsers(List<NewUsersDAO> newusers) {
		this.newusers = newusers;
	}
*/

	public class NewUsersDAO {

		@DatabaseField(generatedId=true)
		public int id;
		@DatabaseField
		public String name;
		@DatabaseField
		public String email;
		@DatabaseField
		public String password;
		@DatabaseField
		public String mobile;
		
		
		
		public NewUsersDAO() {
			super();
		}
		public NewUsersDAO(int id, String name, String email, String password,
				String mobile) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.mobile = mobile;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		
		

	}

