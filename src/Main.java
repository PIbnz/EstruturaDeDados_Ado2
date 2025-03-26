import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        FilaAtendimento filaAtendimento = new FilaAtendimento();
        String[] menu = {"Solicitar nova senha","Excluir senha","Listar todas as senhas","Proxima senha","Chamar proxima senha","Sair"};
        String[] prioridade = {"Comun","Prioridade"};
        int numComum = 1, numPrioritario = 1;

        while (true){

            int opcao = JOptionPane.showOptionDialog(null,"Menu de Atendimento","Menu de Atendimento",0,1,null,menu,menu[0]);
            if(opcao == 0) {
                int tipo = JOptionPane.showOptionDialog(null, "Tipo de senha:", "Selecionar prioridade",
                        0, JOptionPane.QUESTION_MESSAGE, null, prioridade, prioridade[0]);

                if(tipo == 0) {
                    Paciente p = new Paciente(numComum++);
                    filaAtendimento.enfileirar(p);
                    JOptionPane.showMessageDialog(null, "Senha gerada: " + p.getSenha());
                } else {
                    Paciente p = new Paciente(true, numPrioritario++);
                    filaAtendimento.enfileirar(p);
                    JOptionPane.showMessageDialog(null, "Senha gerada: " + p.getSenha());
                }
            }
            else if(opcao == 1) {
                int senhaExc = JOptionPane.showOptionDialog(null,"Selecione o nivel de prioridade","Prioridade",0,1,null,prioridade,prioridade[0]);
                String senha = JOptionPane.showInputDialog(null,"Informe a senha completa (ex: C-1 ou P-1)");

                boolean removido = false;
                for(int i = 0; i < filaAtendimento.tamanho; i++) {
                    if(filaAtendimento.elementos[i].getSenha().equals(senha)) {
                        filaAtendimento.remove(i);
                        removido = true;
                        break;
                    }
                }

                if(removido) {
                    JOptionPane.showMessageDialog(null,"Senha " + senha + " removida com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null,"Senha não encontrada!");
                }
            }
        else if (opcao == 2) {
                if (filaAtendimento.estaVazia()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma senha na fila");
                } else {
                    StringBuilder lista = new StringBuilder("Senhas na fila:\n");
                    for (int i = 0; i < filaAtendimento.getTamanho(); i++) {
                        lista.append(filaAtendimento.elementos[i].getSenha())
                                .append(filaAtendimento.elementos[i].isPrioridade() ? " (Prioridade)" : "")
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                }
            }else if (opcao == 3) {
            Paciente proximo = filaAtendimento.espiar();
            if(proximo != null) {
                JOptionPane.showMessageDialog(null,"Próxima senha a ser chamada: " + proximo.getSenha());
            } else {
                JOptionPane.showMessageDialog(null,"Não há pacientes na fila!");
            }
        }
        else if (opcao == 4) {
                Paciente chamado = filaAtendimento.desenfileirar();
                if (chamado != null) {
                    String tipo = chamado.isPrioridade() ? "PRIORITÁRIO" : "COMUM";
                    String mensagem = "Senha chamada: " + chamado.getSenha() +
                            "\nTipo: " + tipo;
                    JOptionPane.showMessageDialog(null, mensagem);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há pacientes na fila!");
                }
            }else if (opcao == 5) {
            JOptionPane.showMessageDialog(null,"Saindo do sistema...");
            break;
        }
        }
    }
}