package com.tokioschool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDados {



    List<Aluno> alunos= new ArrayList<>();

    private Connection con=null;

    public BaseDados() {

       //alunos.add(new Aluno("Joquim",50,"Base de dados"));
       //alunos.add(new Aluno("Adilio",30,"Java"));

        try {
            //Acesso a base de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokio_school?charactereEncoding=latin1","root","basedadosju");


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void listarAlunos()
    {
        /*System.out.println("Alunos registados:");
        for (Aluno aluno: alunos)
        {
            System.out.println(aluno);
        }*/

        try {
            //Execução da query
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM alunos");

            if (resultSet.first()) { // Verificar se existem alunos
                System.out.println("Alunos registados");

                do {//imprime o primeiro e depois preciso haver mais para contnuar imprimindo
                    System.out.println("\tNome: " + resultSet.getString("nome") +
                            "\tIdade: " + resultSet.getInt("idade") +
                            "\tDisciplina: " + resultSet.getString("disciplina"));
                } while (resultSet.next()); // Avançar no cursor a próxima linha se houver mais resultados, caso seja falso não continua.

            } else {
                System.out.println("Não existe alunos registados");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserirAluno(String nome, int idade, String disciplina)
    {
      // alunos.add( new Aluno(nome,idade,disciplina));
        try {
            PreparedStatement pstmt=con.prepareStatement("INSERT INTO alunos VALUES(?,?,?)");
            pstmt.setString(1,nome);
            pstmt.setInt(2,idade);
            pstmt.setString(3,disciplina);

            pstmt.executeUpdate();//usa-se uma alteração da base de dados
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void apagarAlunos(String nome)
    {
       /* for (Aluno aluno:alunos)
        {
            if (aluno.getNome().equals(nome))
            {
                alunos.remove(aluno);
                System.out.println("O aluno foi removido!");
                return;
            }
        }
        System.out.println("Aluno "+nome+" não encontrado!");*/


        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM alunos WHERE nome = ?");
            pstmt.setString(1, nome); // numero é a coluna, e depois o nome a receber no método

            int numeroLinhas = pstmt.executeUpdate();
            if (numeroLinhas == 0) {
                System.out.println("Aluno(a) " + nome + " não encontrado!");
            }
            else
            {
                System.out.println("Aluno apagado com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void encontrarAluno(String nome) {
        /*for (Aluno aluno: alunos)
        {
            if (aluno.getNome().equals(aluno))
            {
                System.out.println(aluno.toString());
            }
        }*/


        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM alunos WHERE nome=?");
            pstmt.setString(1, nome); // Substituir o valor do parâmetro '?' pelo valor da variável 'nome'


            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println("\tNome: " + resultSet.getString("nome") +
                        "\tIdade: " + resultSet.getInt("idade") +
                        "\tDisciplina: " + resultSet.getString("disciplina"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void apagarTodosAlunos()
    {
        //alunos.clear();
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM alunos");
            int numerolinhas= pstmt.executeUpdate();

            System.out.println("Numero de registos apagados " + numerolinhas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
