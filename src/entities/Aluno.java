package entities;

import java.time.LocalDate;
import java.util.Date;

public class Aluno {
	private int id;
	private String nome;
	private String sexo;
	private Date dt_nasc;

	public Aluno() {
		
	}

	public Aluno(int id, String nome, String sexo, Date dt_nasc) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dt_nasc = dt_nasc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date localDate) {
		this.dt_nasc = localDate;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + dt_nasc + "]";
	}
	
	
}
