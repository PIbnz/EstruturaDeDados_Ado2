public class FilaAtendimento<T> {
    public T[] elementos;
    public int tamanho;

    public FilaAtendimento(int cap){
        this.elementos = (T[]) new Object[cap];
        this.tamanho = 0;
    }

    public FilaAtendimento(){
        this(10);
    }

    public void aumentaCap(){
        if(this.tamanho == this.elementos.length){
            T[] elementosNovos = (T[]) new Object[this.elementos.length*2];
            for (int cont = 0; cont < this.elementos.length; cont++) {
                elementosNovos[cont] = this.elementos[cont];
            }
            this.elementos = elementosNovos;
        }
    }

    public boolean adicionarPos(int posicao, T elemento){
        if(!(posicao >=0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        this.aumentaCap();
        for(int i=this.tamanho-1; i>=posicao; i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;

        return true;
    }

    public boolean enfileirar(T elemento){
        this.aumentaCap();
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for(int i=0; i<this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if(this.tamanho> 0){
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }

    public void remove(int posicao ){
        if(!(posicao >=0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        for (int i=posicao; i<tamanho-1; i++){
            elementos[i] = elementos[i+1];
        }
        tamanho --;
    }

    public boolean estaVazia(){
        return this.tamanho == 0;
    }



    public T espiar(){
        if(this.estaVazia()){
            return null;
        }
        return this.elementos[0];
    }

    public T desenfileirar(){

        if(this.estaVazia()){
            return null;
        }
        final int POS = 0;

        T elementoASerRemovido = this.elementos[POS];
        this.remove(POS);
        return elementoASerRemovido;
    }



}
