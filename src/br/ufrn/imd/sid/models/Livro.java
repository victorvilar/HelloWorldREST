package br.ufrn.imd.sid.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Livro {
	private int id;
	private String titulo;
	private int anoDePublicacao;
	private int numeroDePaginas;
	private double preco;
	private ArrayList<Autor> autores;

	public Livro() {
		super();
	}

	public Livro(int id, String titulo, int anoDePublicacao, int numeroDePaginas, double preco,
			ArrayList<Autor> autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anoDePublicacao = anoDePublicacao;
		this.numeroDePaginas = numeroDePaginas;
		this.preco = preco;
		this.autores = autores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

}
