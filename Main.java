package com.tokioschool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bem-vindo a listar alunos!");
        Scanner ler = new Scanner(System.in);
        BaseDados bd = new BaseDados();

        while (ler.hasNext()) {
            String input = ler.nextLine();

            if (input.equals("sair")) {
                break;
            } else if (input.equals("listar alunos")) {
                bd.listarAlunos();
            } else if (input.equals("inserir aluno")) {
                String nome = "";
                int idade = 0;
                String disciplina = "";

                System.out.print("Nome: ");
                if (ler.hasNext()) {
                    nome = ler.nextLine();
                }
                System.out.print("Idade: ");
                if (ler.hasNext()) {
                    idade = Integer.parseInt(ler.nextLine());
                }
                System.out.print("Disciplina: ");
                if (ler.hasNext()) {
                    disciplina = ler.nextLine();
                }
                bd.inserirAluno(nome, idade, disciplina);
                System.out.println("Aluno inserido com sucesso!");
            } else if (input.equals("apagar aluno")) {
                System.out.println("Nome do aluno que deseja apagar: ");
                String nome=ler.nextLine();
                bd.apagarAlunos(nome);
            }else if(input.equals("encontrar aluno"))
                    {
                System.out.println("Nome do aluno que deseja encontrar: ");
                String nome=ler.nextLine();
                bd.encontrarAluno(nome);
                 }
            else if(input.equals("apagar alunos")){
                bd.apagarTodosAlunos();
            }
              else{ System.out.println("Comando não reconhecido.");}

        }
        System.out.println("Programa Terminado!");
    }
}