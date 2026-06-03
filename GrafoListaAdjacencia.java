package HerancaEmGrafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoListaAdjacencia extends Grafo {
    private Map<String, List<String>> adjacencias;

    public GrafoListaAdjacencia() {
        this.adjacencias = new HashMap<>();
    }

    @Override
    public void adicionarVertice(String vertice) {
        if (!existeVertice(vertice)) {
            adjacencias.put(vertice, new ArrayList<>());
        }
    }

    public void removerVertice(String vertice){

    };

    @Override
    public void adicionarAresta(String origem, String destino) {
        adicionarVertice(origem);
        adicionarVertice(destino);
        
        if (!existeAresta(origem, destino)) {
            adjacencias.get(origem).add(destino);
            adjacencias.get(destino).add(origem); 
        }
    }
    
    public void removerAresta(String origem, String destino){

    };

    
    public boolean existeVertice(String vertice){
        return adjacencias.containsKey(vertice);
    };

    @Override
    public boolean existeAresta(String origem, String destino){
        return existeVertice(origem) && adjacencias.get(origem).contains(destino);
    };

    
    public int grau(String vertice){
        return 0;
    };

   
    public int ordem(){
        return 0;
    };

    
    public int tamanho(){
        return 0;
    };
    
    @Override
    public String toString(){
        return "";
    };




}