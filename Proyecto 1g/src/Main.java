import java.util.ArrayList;


public class Main {
	//Atributos de tipo libro (Declarados posteriormente)
	private static Libro libro1;
	private static Libro libro2;
	private static Libro libro3;
	
	//Atributo de tipo almacenLibros
	private static AlmacenLibros almLibros;
	
	public static void main(String[] args) {
		//Creación de nuevos objetos de tipo libro.
		libro1 = new Libro("Mis razones", "Ivan", 1995, "Anaya", 365);
		libro2 = new Libro("Las rosas que el viento se llevo", "Paco", 1987, "Anaya", 560);
		libro3 = new Libro("Peter Pan", "Joaquin", 1997, "Anaya", 329);
		
		//Creacion de un nuevo objeto de tipo almacenLibros.
		almLibros = new AlmacenLibros();
		
		//OPCIONES DISPONIBLES SOBRE EL OBJETO LIBRO:
		//GUARDAR (Ejemplos)
		almLibros.guardarLibro(libro3, "libro3Guardado.txt");
		almLibros.guardarLibro(libro1, "libro3Guardado.txt");
		
		//RECUPERAR
		almLibros.recuperarLibro("libro3Guardado.txt");
		
		//GUARDAR LISTAS DE LIBROS 
		//GENERAMOS LISTA (ArrayList<Libro>)
		ArrayList<Libro> listaDeLibros = new ArrayList<Libro>();
		listaDeLibros.add(libro1);
		listaDeLibros.add(libro2);
		listaDeLibros.add(libro3);
		
		almLibros.guardarLista(listaDeLibros, "listaLibros.txt");
		
		//MODIFICACIÓN DE TÍTULO Y/O AUTOR
		libro1.setTitulo("Nuevo titulo");
		libro1.setAutor("Nuevo autor");
		
		/*Si queremos guardar un conjunto de libros en un mismo fichero de salida uilizaremos guardarLista(),
		en cambio si deseamos guardar un libro en un fichero individual o separado utilizaremos guardarLibro()*/
		
		
		
		
		
		
		
		
		
	}

}
