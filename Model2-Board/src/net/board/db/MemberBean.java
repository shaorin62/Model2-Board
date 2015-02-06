package net.board.db;

public class MemberBean {
		private String ID;
		private String PASSWORD;
		private String NAME;
		private int AGE;
		private String GENDER;
		private String EMAIL;
		
		
		public String getID() {
			return ID;
		}
		public void setID(String id) {
			ID = id;
		}
		public String getPASSWORD() {
			return PASSWORD;
		}
		public void setPASSWORD(String password) {
			PASSWORD = password;
		}
		public String getNAME() {
			return NAME;
		}
		public void setNAME(String name) {
			NAME = name;
		}
		public int getAGE() {
			return AGE;
		}
		public void setAGE(int age) {
			AGE = age;
		}
		public String getGENDER() {
			return GENDER;
		}
		public void setGENDER(String gender) {
			GENDER = gender;
		}
		public String getEMAIL() {
			return EMAIL;
		}
		public void setEMAIL(String email) {
			EMAIL = email;
		}

}
