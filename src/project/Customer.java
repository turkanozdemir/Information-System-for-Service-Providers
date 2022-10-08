package project;

public abstract class Customer {
	private String CitizenshipNr;
    private String name;
    private String tel;
    private String mail;

    public Customer(String CitizenshipNr) {
        this.CitizenshipNr = CitizenshipNr;
    }

    public String getCitizenshipNr() {
        return CitizenshipNr;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public void setCitizenshipNr(String CitizenshipNr) {
        this.CitizenshipNr = CitizenshipNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
