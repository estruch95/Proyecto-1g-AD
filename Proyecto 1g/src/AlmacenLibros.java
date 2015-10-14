import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class AlmacenLibros {
	
	//Constructor de la clase
	public AlmacenLibros() {
		// TODO Auto-generated constructor stub
		//Sin ejecución de métodos en su construcción
	}
	
	/*Método cuya función es guardar un objeto libro en un fichero de salida, recogiendo dos parámetros:
	- Libro (objeto libro)
	- String (Fichero salida)
	*/
	public void guardarLibro(Libro l, String salida){
		//Declaramos e inicializamos el ObjectOutputStream
		ObjectOutputStream out = null;
		
		//Captura de errores en encapsulado try/catch
		try {
			//Creamos el ObjectOutputStream, este recibe por parámetro un FileOutputStream (Fichero salida)
			out = new ObjectOutputStream(new FileOutputStream(salida));
			//Escribimos sobre el Stream de salida el objeto Libro
			out.writeObject(l);
			//Información por consola (Comprobación)
			System.out.println(l.getTitulo()+" guardado correctamente.");
		}
		catch (FileNotFoundException noEncontrado) {
			// TODO Auto-generated catch block
			noEncontrado.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//Llamada al método cerrar el cual se encarga de cerrar el Stream
			this.cerrar(out);
		}
	}
	
	/*Método cuya función es guardar una lista de libros en un fichero de salida, recibe por parámetro:
	- ArrayList<Libro> (Lista de libros)
	- String (Fichero salida)
	*/
	public void guardarLista(ArrayList<Libro> lista, String salida){
		//""
		ObjectOutputStream listaOut = null;
		
		//""
		try {
			//En este caso el Stream de salida recibe un ArrayList<Libro> (lista de libros)
			listaOut = new ObjectOutputStream(new FileOutputStream(salida));
			//""
			listaOut.writeObject(lista);
			//Información por consola (Comprobación)
			System.out.println("Lista: "+salida+" guardada correctamente.");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//""
			this.cerrar(listaOut);
		}
	}
	
	/*Método cuya función es recuperar un objeto Libro existente, recibe por parámetro: 
	un String (nombre fichero entrada)
	*/
	public Libro recuperarLibro(String entrada){
		//Declaramos e inicializamos un objeto de tipo Libro donde almacenaremos la entrada del libro recuperado
		Libro libroRecuperado = null;
		//Declaramos e inicializamos un ObjectInputStream )
		ObjectInputStream in = null;
		try {
			//Creamos el Stream de objetos de entrada que recibe por parámetro el libro a recuperar
			in = new ObjectInputStream(new FileInputStream(entrada));
			//Almacenamiento del libro recuperado en variable;
			libroRecuperado = (Libro) in.readObject();
			//""
			System.out.println(libroRecuperado.getTitulo()+" recuperado correctamente.");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.cerrar(in);
		}
		//El método devuelve un objeto de tipo Libro (libro recuperado)
		return libroRecuperado;
	}
	
	//Método que se encarga de cerrar con seguridad los Streams
	public void cerrar(Closeable c){
		try {
			if(c != null){
				c.close();
			}
		}
		catch (IOException errorCerrado) {
			// TODO Auto-generated catch block
			errorCerrado.printStackTrace();
			//""
			System.err.println("Error al cerrar el Stream.");
		}
	}

}
