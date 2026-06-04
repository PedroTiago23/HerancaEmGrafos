package HerancaEmGrafos;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public void removerVertice(String vertice){
        if(!existeVertice(vertice)){
            return;
        }

        List<String> vizinhos = adjacencias.get(vertice);
        
        for(String vizinho : vizinhos){
            adjacencias.get(vizinho).remove(vertice);
        }

        adjacencias.remove(vertice);
    }

    @Override
    public void adicionarAresta(String origem, String destino) {
        adicionarVertice(origem);
        adicionarVertice(destino);
        
        if (!existeAresta(origem, destino)) {
            adjacencias.get(origem).add(destino);
            adjacencias.get(destino).add(origem); 
        }
    }
    
    @Override
    public void removerAresta(String origem, String destino){
        if(!existeAresta(origem, destino)){
            return;
        }

         adjacencias.get(origem).remove(destino);
         adjacencias.get(destino).remove(origem);
    }

    @Override
    public boolean existeVertice(String vertice){
        return adjacencias.containsKey(vertice);
    }

    @Override
    public boolean existeAresta(String origem, String destino){
        return existeVertice(origem) && adjacencias.get(origem).contains(destino);
    }

    @Override
    public int grau(String vertice){
        if(!existeVertice(vertice)){
            return 0;
        }

        return adjacencias.get(vertice).size();
    }

    @Override
    public int ordem(){
        return adjacencias.size();
    }

    @Override
    public int tamanho(){
        int contador = 0;
        
        for (List<String> listaDeVizinhos : adjacencias.values()) {
            contador += listaDeVizinhos.size();
        }
    
        return contador/2;
    }
    
    @Override
    public String toString(){
        List<String> linhasArestas = new ArrayList<>();

        for (String v1 : adjacencias.keySet()) {
            for (String v2 : adjacencias.get(v1)) {
                if(v1.compareTo(v2) < 0){
                    linhasArestas.add("  \"" + v1 + "\" -- \"" + v2 + "\";");
                }
                
            }
        }

        Collections.sort(linhasArestas);

        StringBuilder resultado = new StringBuilder();
        resultado.append("graph {\n");
        
        for (String linha : linhasArestas) {
            resultado.append(linha).append("\n");
        }
        
        resultado.append("}");

        return resultado.toString();
    }
}