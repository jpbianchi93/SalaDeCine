package ar.edu.unahur.salaDeCine;

public class SalaDeCine {
	private Integer cantidadDeFilas = 0;
	private Integer cantidadDeButacasTotales = 0;
	
	private Integer cantidadDeColumnas = 0;
	private Boolean[][] butacas = new Boolean[cantidadDeFilas][cantidadDeColumnas];
	
	public SalaDeCine(Integer nFilas , Integer nButacas) {
		this.cantidadDeFilas = nFilas;
		this.cantidadDeButacasTotales = nButacas;
		this.cantidadDeColumnas = cantidadDeButacasTotales/cantidadDeFilas;
		this.butacas = new Boolean[cantidadDeFilas][cantidadDeColumnas];
	}
	
	private Boolean estaVaciaLaFilaN(Integer nFila) {
	    Boolean estado = true;
	    for (int nButaca = 0 ; nButaca < cantidadDeColumnas; nButaca++) {
	        if (butacas[nFila][nButaca] != null && butacas[nFila][nButaca]) {
	            estado = false;
	        }
	    }
	    return estado;
	}


	public Boolean estaVacia() {
		Boolean estado = true;
		for (int nFila = 0 ; nFila < cantidadDeFilas; nFila++) {
			if (!estaVaciaLaFilaN(nFila)) {
				estado = false;
			}
		}
		return estado;
	}
	
	public Boolean estaOcupadaLaButaca(Integer nFila , Integer nButaca) {
		Boolean estado = true;
		if (!(butacas[nFila][nButaca] != null && butacas[nFila][nButaca])) {
            estado = false;
		}
		return estado;
	}
	
	public void ocuparButaca(Integer nFila , Integer nButaca) {
		if (!estaOcupadaLaButaca(nFila , nButaca)) {
			butacas[nFila][nButaca] = true;
		}
	}
	
	private Integer contarButacasOcupadasPorFila(Integer nFila) {
		Integer butacasOcupadas = 0;
		for (int nButaca = 0 ; nButaca < cantidadDeColumnas ; nButaca ++) {
			if (estaOcupadaLaButaca(nFila , nButaca)) {
				butacasOcupadas ++;
			}
		}
		return butacasOcupadas;
	}
	
	public Integer cantidadTotalDeButacasOcupadas() {
		Integer butacasOcupadas = 0;
		for (int nFila = 0 ; nFila < cantidadDeFilas ; nFila ++) {
			butacasOcupadas += contarButacasOcupadasPorFila(nFila);
		}
		return butacasOcupadas;
	}
	
	private Boolean hayEspacioParaXPersonasEnUnaFila(Integer cantidadDePersonas , Integer nFila) {
		Integer butacasLibresContiguas = 0;
		Integer nButaca = 0;
		while (butacasLibresContiguas < cantidadDePersonas && nButaca < cantidadDeColumnas) {
			if (!estaOcupadaLaButaca(nFila , nButaca)) {
				butacasLibresContiguas ++;
			}
			else {
				butacasLibresContiguas = 0;
			}
			nButaca ++;
		}
		return butacasLibresContiguas>=cantidadDePersonas;
	}
	
	public Boolean hayEspacioPara(Integer cantidadDePersonas) {
		Integer nFila = 0;
		while (!hayEspacioParaXPersonasEnUnaFila(cantidadDePersonas , nFila) && nFila < cantidadDeFilas) {
			nFila ++;
		}
		return hayEspacioParaXPersonasEnUnaFila(cantidadDePersonas , nFila);
		
	}
	
	public void verSala() {
	    for (int i = 0; i < cantidadDeFilas; i++) {
	        for (int j = 0; j < cantidadDeColumnas; j++) {
	            if (butacas[i][j] == null || !butacas[i][j]) {
	                System.out.print("L ");
	            } else {
	                System.out.print("O ");
	            }
	        }
	        System.out.println();
	    }
	}

}
