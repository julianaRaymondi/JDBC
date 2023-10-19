package com.tokioschool;

public class Aluno {
    private String nome;
    private int idade;
    private  String disciplina;

    public Aluno(String nome, int idade, String disciplina) {
        this.nome = nome;
        this.idade = idade;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
