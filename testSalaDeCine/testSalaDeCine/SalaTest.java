package testSalaDeCine;

import ar.edu.unahur.salaDeCine.*;

public class SalaTest {
	public static void main(String[] args) {
		System.out.println("Cuando creo la sala esta esta vacia");
		// PREPARACION
		Integer nFilas = 5;
		Integer nButacas = 30;
		SalaDeCine Hoyts = new SalaDeCine(nFilas , nButacas);
		// EJECUCIÓN
		Hoyts.verSala();
		// CONSTRASTACIÓN
		
		System.out.println("Consulto si la sala esta vacia y efectivamente esta vacia");
		// PREPARACION
		// EJECUCIÓN
		System.out.println(Hoyts.estaVacia().toString());
		// CONSTRASTACIÓN
		System.out.println("Consulto si una butaca esta ocupada y esta vacia");
		System.out.println(Hoyts.estaOcupadaLaButaca(3,2).toString());
		Hoyts.ocuparButaca(4  ,  5);
		System.out.println("Consulto si una butaca esta ocupada y esta ocupada");
		System.out.println(Hoyts.estaOcupadaLaButaca(4,5).toString());
		System.out.println("Consulto cantidad de butacas ocupadas y da 2");
		Hoyts.ocuparButaca(3  ,  5);
		System.out.println(Hoyts.cantidadTotalDeButacasOcupadas().toString());
		Hoyts.verSala();
		System.out.println("Consulto si hay espacio para 5 personas y hay");
		System.out.println(Hoyts.hayEspacioPara(5).toString());
		Hoyts.ocuparButaca(0  ,  3);
		Hoyts.ocuparButaca(1  ,  3);
		Hoyts.ocuparButaca(2  ,  3);
		Hoyts.ocuparButaca(3  ,  3);
		Hoyts.ocuparButaca(4  ,  3);
		Hoyts.verSala();
		System.out.println("Consulto si hay espacio para 5 personas y no hay");
		System.out.println(Hoyts.hayEspacioPara(5).toString());




		
	}
}
