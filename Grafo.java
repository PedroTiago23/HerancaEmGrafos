package HerancaEmGrafos;
abstract class Grafo{
    public static void main (String[] args){}
    
    public void adicionarVertice(String vertices){}

    public void removerVertice(String vertices){}

    public void adicionarAresta(String origem, String destino){}
        
    public void removerAresta(String origem, String destino){}

    public boolean existeVertice(String vertice){
        return true;
    }

    public boolean existeAresta(String aresta){
        return true;
    }

    public int grau(String vertice){
        return 0;
    }

    public int ordem(){
        return 0;
    }

    public int tamanho(){
        return 0;
    }
    
    public String toString(){
        return "";
    }

}   
