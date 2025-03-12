import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        FilaAtendimento<Object> filaAtendimento = new FilaAtendimento<Object>();
        String[] menu = {"Solicitar nova senha","Excluir senha","Listar todas as senhas","Proxima senha","Chamar proxima senha","Sair"};
        String[] prioridade = {"Comun","Prioridade"};
        int numPac = 0;
        int totPri = 0;

        while (true){

            int opcao = JOptionPane.showOptionDialog(null,"Menu de Atendimento","Menu de Atendimento",0,1,null,menu,menu[0]);

        if(opcao == 0){
            int opcao1 = JOptionPane.showOptionDialog(null,"Selecione a sua prioridade","Selecione o nivel de prioridade",0,1,null,prioridade,prioridade[0]);

            if(opcao1 == 0){
                Paciente paciente = new Paciente(numPac);
                numPac++;
                filaAtendimento.enfileirar(paciente);
                JOptionPane.showMessageDialog(null,"Sua senha é : " + paciente.getSenha());
            }else{
                Paciente paciente = new Paciente(true,totPri);
                filaAtendimento.adicionarPos(totPri,paciente);
                totPri++;
                JOptionPane.showMessageDialog(null,"Sua senha é : " + paciente.getSenha());
            }
        } else if (opcao == 1) {
            for (int cont = 0; cont < filaAtendimento.getTamanho(); cont++) {

            }
        }


        }
    }
}