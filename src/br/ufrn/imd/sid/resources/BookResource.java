package br.ufrn.imd.sid.resources;

import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import br.ufrn.imd.sid.models.Livro;

public class BookResource {

	private ArrayList<Livro> livros;

	public BookResource() {
		super();
		this.livros = new ArrayList<Livro>();
		Livro l1 = new Livro(1, "Sitio do Picapau", 1960, 450, 25.4, null);
		this.livros.add(l1);
	}
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData){
		String result = "RESTService Successfully started...";
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Livro> getAllBooks() {
		System.out.println("Data Received: " + this.livros.size());
		return this.livros;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livro getAula(@PathParam("id") int id) {
		for(Livro livro : this.livros){
			if(livro.getId() == id){
				System.out.println("Achou.");
				return livro;
			}
		}
		return null;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Livro> addBook(MultivaluedMap<String, String> booksParams){
		String titulo = booksParams.getFirst("titulo");
		int anoDePublicacao = Integer.parseInt(booksParams.getFirst("ano"));
		int numeroDePaginas = Integer.parseInt(booksParams.getFirst("pag"));
		Double preco = Double.parseDouble(booksParams.getFirst("preco"));
		
		Livro livro = new Livro(0, titulo, anoDePublicacao, numeroDePaginas, preco, null);
		
		this.livros.add(livro);
		System.out.println("Storing posted " + titulo + " " + anoDePublicacao + " " + numeroDePaginas + " " + preco);
		System.out.println("Quantidade livros: " + this.livros.size());
		return this.livros;
	}
}
