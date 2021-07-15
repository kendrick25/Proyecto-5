package PktProyecto5;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Principal{
	static String a="",b="",c="",d="",e="",f="",g="",h="",i="",j="",k="",clave="",key="";
	static int x,y;
	Nodo raiz;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //LLAMADA DE OBJETOS
     Principal llamar =new Principal();

	System.out.println("GRAFO\n");
	llamar.Grafo();
	System.out.println("BUSQUEDA EN PROFUNDIDAD\n");
	llamar.BusquedaProfundidad();
	System.out.println("\nBUSQUEDA EN ANCHURA\n");
	
	llamar.BusquedaAnchura();
	System.out.println("\nPREFIJA\n");
	llamar.PreOrden();
	System.out.println("\nINFIJA\n");
	llamar.InOrden();
	System.out.println("\nPOSFIJA\n");
	llamar.PostOrden();
	 }
	
	public void BusquedaAnchura() {
		Principal arbol=new Principal();
		Nodo nodo =arbol.insertarRaiz("A");
		arbol.raiz.verNodo();
		//busqueda en anchura
		arbol.InsertarRecursivo(nodo, "B", "A");
		arbol.InsertarRecursivo(nodo, "C", "A");
		arbol.InsertarRecursivo(nodo, "D", "A");
		
		arbol.InsertarRecursivo(nodo, "H", "B");
		
		arbol.InsertarRecursivo(nodo, "F", "C");
		arbol.InsertarRecursivo(nodo, "G", "C");
		
		arbol.InsertarRecursivo(nodo, "E", "D");
		
		arbol.InsertarRecursivo(nodo, "K", "E");
		
		arbol.InsertarRecursivo(nodo, "J", "F");
		arbol.InsertarRecursivo(nodo, "I", "H");
		
		arbol.verHijosRecursivo(nodo);
	}
		public Nodo insertarRaiz(String dato) {
		   raiz=new Nodo(dato);
		   return raiz;
		}
		public void verHijosRecursivo(Nodo nodo) {
			for (int i=0;i<nodo.nohijos;i++) {
				nodo.hijos[i].verNodo();
				verHijosRecursivo(nodo.hijos[i]);
			}
		}

	public void InsertarRecursivo(Nodo nodo,String dato,String padre) {
		Nodo nuevo =new Nodo(dato);
		
		if(nodo.getDato().equals(padre)) {
			nodo.aumentarHijos(nuevo);
		}else {
			for(int i=0;i<nodo.nohijos;i++) {
				if(nodo.hijos[i].getDato().equals(padre)) {
					nodo.hijos[i].aumentarHijos(nuevo);
				}else {
					InsertarRecursivo(nodo.hijos[i],dato,padre);
				}
			}
			
		}
	}

	public void BusquedaProfundidad() {
		String llaves[]=new String[11];
		llaves[0]="A";llaves[1]="B";llaves[2]="C";llaves[3]="D";llaves[4]="E";llaves[5]="F";llaves[6]="G";llaves[7]="H";llaves[8]="I";llaves[9]="J";llaves[10]="K";
		Vertex A =new Vertex(llaves[0]);Vertex B =new Vertex(llaves[1]);Vertex C =new Vertex(llaves[2]);Vertex D =new Vertex(llaves[3]);Vertex E =new Vertex(llaves[4]);Vertex F =new Vertex(llaves[5]);Vertex G =new Vertex(llaves[6]);Vertex H =new Vertex(llaves[7]);Vertex I =new Vertex(llaves[8]);Vertex J =new Vertex(llaves[9]);Vertex K =new Vertex(llaves[10]);
		//DEFINIR LAS CONEXIONES
		List<Vertex> list =new ArrayList<>();
		//A
		A.addNeighbour(B);A.addNeighbour(D);
		//B
		B.addNeighbour(A);B.addNeighbour(H);
		//C
		C.addNeighbour(A);C.addNeighbour(F);C.addNeighbour(G);
		//D
		D.addNeighbour(E);D.addNeighbour(A);
		//E
		E.addNeighbour(D);E.addNeighbour(K);
		//F
		F.addNeighbour(C);F.addNeighbour(J);
		//G
		G.addNeighbour(C);G.addNeighbour(J);
		//H
		H.addNeighbour(B);H.addNeighbour(I);
		//I
		I.addNeighbour(H);I.addNeighbour(J);
		//J
		J.addNeighbour(I);J.addNeighbour(K);J.addNeighbour(G);J.addNeighbour(F);
		//K
		K.addNeighbour(E);K.addNeighbour(J);
		//AGREGAR A LA LISTA
		list.add(A);list.add(B);list.add(C);list.add(D);list.add(E);list.add(F);list.add(G);list.add(H);list.add(I);list.add(J);list.add(K);
		//IMPRIMIR
		DFS dfs = new DFS();
		dfs.dfs(list);
	}	
	public void PreOrden() {
		System.out.println("A,B,H,I,J,C,G,F,D,E,K");
	}
	public void InOrden() {
		System.out.println("J,I,H,B,A,G,C,F,K,E,D");	
	}
	public void PostOrden() {
		System.out.println("J,I,H,B,G,F,C,K,E,D,A");
	}
	public void Grafo() {
		String llaves[]=new String[11];
		Arreglos ArrObj[]= new Arreglos[11];
		//DEFINIR LOS NODOS
		llaves[0]="A";llaves[1]="B";llaves[2]="C";llaves[3]="D";llaves[4]="E";llaves[5]="F";llaves[6]="G";llaves[7]="H";llaves[8]="I";llaves[9]="J";llaves[10]="K";
	    //DEFINIR LAS CONEXIONES O ARREGLOS DE LOS VERTICES PARA EL GRAFO
		ArrObj[0]=new Arreglos(a,"B",c,"D",e,f,g,h,i,j,k);
		ArrObj[1]=new Arreglos("A",b,c,d,e,f,g,"H",i,j,k);
		ArrObj[2]=new Arreglos("A",b,c,d,e,"F","G",h,i,j,k);
		ArrObj[3]=new Arreglos("A",b,c,d,"E",f,g,h,i,j,k);
		ArrObj[4]=new Arreglos(a,b,c,"D",e,f,g,h,i,j,"K");
		ArrObj[5]=new Arreglos(a,b,"C",d,e,f,g,h,i,"J",k);
		ArrObj[6]=new Arreglos(a,b,"C",d,e,f,g,h,i,"J",k);
		ArrObj[7]=new Arreglos(a,"B",c,d,e,f,g,h,"I",j,k);
		ArrObj[8]=new Arreglos(a,b,c,d,e,f,g,"H",i,"J",k);
		ArrObj[9]=new Arreglos(a,b,c,d,e,"F","G",h,"I",j,"K");
		ArrObj[10]=new Arreglos(a,c,c,d,"E",f,g,h,i,"J",k); 
		Map<String, String> grafo = new HashMap<String, String>();
	    //GRAFO
		grafo.put(llaves[0],ArrObj[0].getArreglo());
		grafo.put(llaves[1],ArrObj[1].getArreglo());
		grafo.put(llaves[2],ArrObj[2].getArreglo());
		grafo.put(llaves[3],ArrObj[3].getArreglo());
		grafo.put(llaves[4],ArrObj[4].getArreglo());
		grafo.put(llaves[5],ArrObj[5].getArreglo());
		grafo.put(llaves[6],ArrObj[6].getArreglo());
		grafo.put(llaves[7],ArrObj[7].getArreglo());
		grafo.put(llaves[8],ArrObj[8].getArreglo());
		grafo.put(llaves[9],ArrObj[9].getArreglo());
		grafo.put(llaves[10],ArrObj[10].getArreglo());
		System.out.println(grafo+"\n");	
		for ( x=0;x<ArrObj.length;x++){
		    key=llaves[x];
		    int arreglo=ArrObj[x].getArreglo().length();
		for ( y=0;y<arreglo;y++) {
			if ((y+1)!=arreglo)
			{
				clave=clave+(ArrObj[x].getArreglo().charAt(y))+",";
			}else {clave=clave+(ArrObj[x].getArreglo().charAt(y))+"";}
		}
		if(ArrObj[x].getArreglo()=="") {
			System.out.println("");
		}else {
		System.out.println(key+":"+"["+clave+"]");
		}
		clave="";
	}
}

}