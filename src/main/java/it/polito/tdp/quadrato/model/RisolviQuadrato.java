package it.polito.tdp.quadrato.model;

import java.util.*;

public class RisolviQuadrato {
	
	private int N;// lato quadrato
	private int N2;// numero caselle
	private int magica;// costante magica
	private List<List<Integer>> soluzioni;
	
	public RisolviQuadrato(int N) {
		this.N=N;
		this.N2=N*N;
		this.magica=N*(N2+1)/2;
	}
	//calcola quadrati magici
		public List<List<Integer>> quadrati() {
			int livello=0;
			List<Integer> parziale= new ArrayList<Integer>();
			this.soluzioni= new ArrayList<List<Integer>>();
			cerca(parziale,livello);
			
		return soluzioni;
	}
		
	//ricorsiva privata 
		private void cerca(List<Integer>parziale,int livello) {
			if(livello==N2) {
				//caso terminale
				if(controlla(parziale)) {
					//è magico 
					System.out.println(parziale);
					soluzioni.add(new ArrayList<>(parziale));
					
					}
				return;
			}
			//controlli intermedi 
			if(livello%N==0 && livello!=0) {
				if(!controllaRiga(parziale,livello/N-1))
					return ;
			}
			
			//caso intermedio 
			for(int valori=1;valori<=N2;valori++) {
				if(!parziale.contains(valori)) {
					parziale.add(valori);
					cerca(parziale,livello+1);
					parziale.remove(parziale.size()-1);
				}
				
			}
			
			
		}
	
	
	
	
	private boolean controlla(List<Integer> parziale) {
		if(parziale.size()!= this.N*this.N) 
			throw new IllegalArgumentException("Numero elementi insufficenti");
		
		//somma delle righe 
		for(int riga=0; riga<this.N;riga++) {
			int somma=0;
			for(int col=0;col<this.N;col++) {
				somma+=parziale.get(riga*this.N+col);
			}
			if(somma!=magica)
				return false;
			}
		//somma colonne
		for(int col=0;col<this.N;col++) {
			int somma=0;
			for(int riga=0; riga<this.N;riga++) {
				somma+=parziale.get(riga*this.N+col);
			}
			if(somma!= magica)
				return false;
		}
		
			// diagonale principale
				int somma = 0;
				for(int riga=0; riga<this.N; riga++) {
					somma += parziale.get(riga*this.N+riga) ;
				}
				if(somma!=this.magica)
					return false ;
				
				// diagonale inversa
				somma = 0;
				for(int riga=0; riga<this.N; riga++) {
					somma += parziale.get(riga*this.N+(this.N-1-riga)) ;
				}
				if(somma!=this.magica)
					return false ;

				return true ;
		
		
	}
	
	private boolean controllaRiga(List<Integer>parziale, int numeroRiga) {
		int somma=0;
		for( int col=0;col<N;col++) {
			somma+=parziale.get(numeroRiga*N+col);
		
		}
		return (somma==magica);
	}	
	
	
}
