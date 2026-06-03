package HerancaEmGrafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrafoMatrizAdjacencia extends Grafo {
    
    private List<String> vertices;
    
    private List<List<Boolean>> matriz; 

    public GrafoMatrizAdjacencia() {
        this.vertices = new ArrayList<>();
        this.matriz = new ArrayList<>();
    }

    @Override
    public void adicionarVertice(String vertice) {

        if (!existeVertice(vertice)) {
            
            vertices.add(vertice);
            
            
            List<Boolean> novaLinha = new ArrayList<>();
            for (int i = 0; i < vertices.size(); i++) {
                novaLinha.add(false); 
            }
            matriz.add(novaLinha);
            
            for (int i = 0; i < matriz.size() - 1; i++) {
                matriz.get(i).add(false);
            }
        }
    }

    @Override
    public boolean existeVertice(String vertice) {
        return vertices.contains(vertice);
    }

 
    @Override
    public void adicionarAresta(String origem, String destino) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        int indiceOrigem = vertices.indexOf(origem);
        int indiceDestino = vertices.indexOf(destino);

        matriz.get(indiceOrigem).set(indiceDestino, true);
        matriz.get(indiceDestino).set(indiceOrigem, true);
    }

    @Override
    public void removerAresta(String origem, String destino) {
        if(!existeAresta(origem, destino)){
            return;
        }

        int indiceOrigem = vertices.indexOf(origem);
        int indiceDestino = vertices.indexOf(destino);
        
        matriz.get(indiceOrigem).set(indiceDestino, false);
        matriz.get(indiceDestino).set(indiceOrigem, false);
    }

    @Override
    public boolean existeAresta(String origem, String destino) {

        if(!existeVertice(origem) || !existeVertice(destino)){
            return false;
        }

        int IndiceOrigem = vertices.indexOf(origem);
        int IndiceDestino = vertices.indexOf(destino);

        return matriz.get(IndiceOrigem).get(IndiceDestino);
    }

    @Override
    public void removerVertice(String vertice) {
        if(!existeVertice(vertice)){
            return;
        }

        int IndiceVertice = vertices.indexOf(vertice);
        
        matriz.remove(IndiceVertice);

        for (int i = 0; i < matriz.size(); i++) {
            matriz.get(i).remove(IndiceVertice);
        }
        
        vertices.remove(IndiceVertice);
    }

    @Override
    public int grau(String vertice) {
        if(!existeVertice(vertice)){
            return 0;
        }
        
        int IndiceVertice = vertices.indexOf(vertice);
        
        int contador = 0;

        for(int i = 0; i < matriz.size(); i++){
            if(matriz.get(IndiceVertice).get(i) == true){
                contador++;
            }
        }

        return contador;
    }

    @Override
    public int ordem() {
        return vertices.size();
    }

    @Override
    public int tamanho() {
        int contador = 0;

        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < matriz.get(i).size(); j++){
                if(matriz.get(i).get(j) == true){
                    contador++;
                }
            }
        }

        return contador/2;
    }

    @Override
    public String toString() {
        List<String> linhasArestas = new ArrayList<>();

        for (int i = 0; i < matriz.size(); i++) {
            for (int j = i; j < matriz.get(i).size(); j++) {
                
                if (matriz.get(i).get(j)) {
                    String valor1 = vertices.get(i);
                    String valor2 = vertices.get(j);

                    if (valor1.compareTo(valor2) > 0) {
                        String temp = valor1;
                        valor1 = valor2;
                        valor2 = temp;
                    }

                    linhasArestas.add("  \"" + valor1 + "\" -- \"" + valor2 + "\";");
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
    