package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;


public class FicherosEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		try {
//			String path = "numeros.txt";
//			File afile = new File(path);
//			FileWriter fw;
//			fw = new FileWriter(afile,true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			for(int i=0; i<60000;i++){
//				bw.write(""+i);
//				bw.newLine();
//			}
//			bw.flush();
//			bw.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		try {
//
//			String pathLectura = "ejemplo1.txt";
//			File aFicheroLectura = new File(pathLectura);
//			FileReader fr;
//			fr = new FileReader(aFicheroLectura);
//			BufferedReader br = new BufferedReader(fr);
//			String linea = br.readLine();
//			while(linea!=null)
//			{
//				String[] lineaDividida = linea.split(";");
//				String usuario = lineaDividida[0];
//				String password = lineaDividida[1];
//				
//				System.out.println("Usuario con user: "+usuario+" y password: "+password);
//				linea = br.readLine();
//			}
//			
//			br.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		HashMap<String, String> hashMapDatos = new HashMap<>();
		File ficheroQueVamosALeer= new File("ejemplo1.txt");
		try {
			FileReader fr = new FileReader(ficheroQueVamosALeer);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null)
			{
				String[] lineaDividida= linea.split(";");
				String dni = lineaDividida[0];
				String nombre = lineaDividida[1];
				
				hashMapDatos.put(dni, nombre);
				
				linea = br.readLine();
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File ficheroAEscribir= new File("dni.txt");
		try {
			FileWriter fw = new FileWriter(ficheroAEscribir);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<String> it = hashMapDatos.keySet().iterator();
			
			while(it.hasNext()){
				String clave = it.next();
				String valor = hashMapDatos.get(clave);
				bw.write(clave+";"+valor);
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
