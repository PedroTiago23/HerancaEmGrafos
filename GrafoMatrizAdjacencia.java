package HerancaEmGrafos;

import java.util.ArrayList;
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
}