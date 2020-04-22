package it.polito.tdp.quadrato.model;

import java.util.*;

public class TestQuadrato {

	public static void main(String[] args) {
		RisolviQuadrato rs=new RisolviQuadrato(4);
		
		List<List<Integer>> soluzioni= rs.quadrati();
		
		for(List<Integer> sol: soluzioni) {
			System.out.println(sol);
		}
		

	}

}
