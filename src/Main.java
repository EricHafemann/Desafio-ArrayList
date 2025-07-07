import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Double> notas = new ArrayList<>();
    static ArrayList<String> alunos = new ArrayList<>();
    clearScream cs = new clearScream();

    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {
        Scanner s = new Scanner(System.in);
        int op = 0;

        boolean valido = true;
        do {
            try {
                System.out.println("===========================");
                System.out.println("==    MENU DO SISTEMA    ==");
                System.out.println("===========================\n");

                System.out.println("1- CADASTRAR ALUNO");
                System.out.println("2- VER ALUNOS CADASTRADOS");
                System.out.println("3- VER MÉDIA DA TURMA");
                System.out.println("4- SAIR");
                System.out.println("===========================");
                System.out.print("Escolha uma opção: ");

                op = s.nextInt();
                s.nextLine();

                switch (op) {

                    case 1:
                    {
                        cadastrarAluno();
                        break;
                    }
                    case 2:
                    {
                        exibirAlunos();
                        break;
                    }
                    case 3:
                    {
                        mediaTurma();
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Programa Finalizado!");
                        System.exit(0);
                        break;
                    }

                    default:
                        System.out.println("\n\n================================");
                        System.out.println("Valor inválido. Tente novamente!");
                        System.out.println("================================");

                        try {
                            Thread.sleep(2000);
                        }catch (Exception e)
                        {
                            System.out.println("Erro:"+e.getMessage());
                        }

                        valido = false;
                        clearScream.limparTela();
                        menuInicial();

                        valido = false;
                        clearScream.limparTela();

                }

            } catch (InputMismatchException e) {
                System.out.println("\n\n===========================");
                System.out.println("   Digite apenas números.  ");
                System.out.println("===========================");

                try {
                    Thread.sleep(2000);
                }catch (Exception e1)
                {
                    System.out.println("Erro:"+e.getMessage());
                }

                clearScream.limparTela();
                s.nextLine();
            }

        } while (valido);
    }

    public static void cadastrarAluno() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        String nome = s.nextLine();
        alunos.add(nome);

        int contNota = 1;
        double nota = 0;

        do {
            System.out.println("Digite a " + contNota + "ª nota: ");
            try {
                nota = s.nextDouble();

                if (nota >= 0 && nota <= 10) {
                    notas.add(nota);
                    contNota++;
                } else {
                    System.out.println("Nota Inválida. Somente de 0 a 10.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.\n");
                s.nextLine();
            }

        } while (contNota <= 3);




        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    public static void exibirAlunos() {

        Scanner s = new Scanner(System.in);

        if (alunos.isEmpty()) {
            System.out.println("\n==========================");
            System.out.println("  Nenhum aluno cadastrado.  ");
            System.out.println("==========================\n");

            System.out.println("Aperte Enter para voltar ao Menu...");
            String  a1 = s.nextLine();

            clearScream.limparTela();
            menuInicial();

        } else {
            System.out.println("---------------------------");
            System.out.println("-   Alunos cadastrados:   -");
            System.out.println("---------------------------\n");

            int ind = 0;
            String sit = null;
            int contAlunos = 1;

            for (String aluno : alunos) {
                System.out.println("---------------------------");
                System.out.println(contAlunos+"- " + aluno);
                System.out.println("---------------------------");
                System.out.println("NOTAS: ");
                System.out.println("1-"+notas.get(ind));
                System.out.println("2-"+notas.get(ind + 1));
                System.out.println("3-"+notas.get(ind + 2));
                System.out.println("---------------------------");
                double md = (notas.get(ind) + notas.get(ind+1) + notas.get(ind+2) ) / 3;
                System.out.printf("Média: %.2f\n", md);
                System.out.println("---------------------------");
                if (md >= 7)
                {
                    sit = "Aprovado";
                }
                else
                {
                    sit = "Reprovado";
                }
                System.out.println("Situação: "+sit+"\n");
                ind = ind + 3;
                contAlunos++;

            }
            System.out.println("\nAperte Enter para voltar ao Menu...");
                String  a2 = s.nextLine();

            clearScream.limparTela();
            menuInicial();
        }
    }

    public static void mediaTurma() {
        Scanner s = new Scanner(System.in);

        System.out.println("========================");
        System.out.println("==  TOTAL DE ALUNOS: " + alunos.size() + " ==");
        System.out.println("========================");

        int ind = 0;
        double soma = 0;

        for (int i = 0; i < alunos.size(); i++) {
            double mediaAluno = (notas.get(ind) + notas.get(ind + 1) + notas.get(ind + 2)) / 3.0;
            soma += mediaAluno;
            ind += 3;
        }

        double mediaTurma = soma / alunos.size();

        System.out.println("Média da Turma: " + mediaTurma);

        System.out.println("\nAperte Enter para voltar ao Menu...");
        String a2 = s.nextLine();

        clearScream.limparTela();
        menuInicial();

    }
}
