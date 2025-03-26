public class Paciente {
    private String senha;
    private boolean prioridade;

    public Paciente(boolean prioridade, int numPac) {
        this.prioridade = prioridade;
        this.senha = (prioridade ? "P-" : "C-") + numPac;
    }

    public Paciente(int numPac) {
        this(false, numPac);
    }

    public String getSenha() {
        return senha;
    }

    public boolean isPrioridade() {
        return prioridade;
}
}