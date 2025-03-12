public class Paciente {
    boolean prioridade;
    String senha;

    public Paciente(boolean prioridade,int numPac){
        this.prioridade = prioridade;
        if(prioridade){
            this.senha = "P-" + (numPac+1);
        }else{
            this.senha = "C-" + (numPac+1);
        }
    }

    public Paciente(int numPac){
        this.prioridade = false;
        this.senha = "C-" + (numPac+1);
    }

    public String getSenha(){
        return this.senha;
    }

}
