package it.unisa.is20.piantalashop.model.beans;

public class Product {
	
	private int idprodotto;
	private String nomeprodotto;
	private float prezzo;
	private String descrizione;
	private float disponibilità;
	private String path;
	private int idagricoltore;
	private int idcategoria;
	//
	public int getId() {
		return idprodotto;
	}
	public void setId(int idprodotto) {
		this.idprodotto = idprodotto;
	}
	//
	public String getNome() {
		return nomeprodotto;
	}
	public void setNome(String nomeprodotto) {
		this.nomeprodotto = nomeprodotto;
	}
	//
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	//
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	//
	public float getDisponibilità() {
		return disponibilità;
	}
	public void setDisponibilità(float disponibilità) {
		this.disponibilità = disponibilità;
	}
	//
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	//
	public int getIdAgricoltore() {
		return idagricoltore;
	}
	public void setIdAgricoltore(int idagricoltore) {
		this.idagricoltore = idagricoltore;
	}
	//
	public int getIdCategoria() {
		return idcategoria;
	}
	public void setIdCategoria(int idcategoria ) {
		this.idcategoria = idcategoria;
	}
}