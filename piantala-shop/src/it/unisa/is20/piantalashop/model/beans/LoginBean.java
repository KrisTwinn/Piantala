package it.unisa.is20.piantalashop.model.beans;

public class LoginBean {
	private int id;
	private String nome;
	private String cognome;
	private String dnascita;
	private String indirizzo;
	private String città;
	private int cap;
	private String cellulare;
	private String email;
	private String password;
	private String ruolo;
	

	public String getRuolo() {
		return ruolo;
		}
		public void setRuolo(String ruolo) {
			this.ruolo = ruolo;
		}
		
	public int getId() {
	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getDnascita() {
		return dnascita;
	}
	public void setDnascita(String dnascita) {
		this.dnascita = dnascita;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
}

