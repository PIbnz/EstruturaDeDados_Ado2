public class FilaAtendimento {
    public Paciente[] elementos;
    public int tamanho;
    public int contadorPrioritarios;

    public FilaAtendimento(int capacidade) {
        this.elementos = new Paciente[capacidade];
        this.tamanho = 0;
        this.contadorPrioritarios = 0;
    }


    public FilaAtendimento(){
        this(10);
    }

    public void aumentaCap(){
        if(this.tamanho == this.elementos.length){
            Paciente[] elementosNovos = new Paciente[this.elementos.length*2];
            for (int cont = 0; cont < this.elementos.length; cont++) {
                elementosNovos[cont] = this.elementos[cont];
            }
            this.elementos = elementosNovos;
        }
    }


    public void enfileirar(Paciente paciente) {
        aumentaCap();
        elementos[tamanho++] = paciente;
    }


    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "Fila vazia";
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            s.append(elementos[i].getSenha())
                    .append(elementos[i].isPrioridade() ? " (Prioritário)" : "")
                    .append("\n");
        }
        return s.toString();
    }

    public int getContadorPrioritarios() {
        return this.contadorPrioritarios;
}


    public boolean estaVazia(){
        return this.tamanho == 0;
    }

    public Paciente espiar() {
        if (estaVazia()) {
            return null;
        }

        // Prioriza não prioritários se já atendeu 3+ prioritários
        if (contadorPrioritarios >= 3) {
            for (int i = 0; i < tamanho; i++) {
                if (!elementos[i].isPrioridade()) {
                    return elementos[i];
                }
            }
        }

        // Busca por prioritários
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].isPrioridade()) {
                return elementos[i];
            }
        }

        // Retorna o primeiro da fila se não encontrar prioritários
        return elementos[0];
    }

    public Paciente desenfileirar() {
        Paciente proximo = espiar();
        if (proximo == null) {
            return null;
        }

        int posicao = buscarPosicao(proximo);
        if (posicao != -1) {
            atualizarContador(proximo);
            remove(posicao);
        }

        return proximo;

    }

    private int buscarPosicao(Paciente paciente) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == paciente) {
                return i;
            }
        }
        return -1;
    }


    public void remove(int posicao) {
            for (int i = posicao; i < tamanho - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            elementos[--tamanho] = null;
        }

    private void atualizarContador(Paciente paciente) {
        if (paciente.isPrioridade()) {
            contadorPrioritarios++;
        } else {
            contadorPrioritarios = 0;
        }
    }




}
