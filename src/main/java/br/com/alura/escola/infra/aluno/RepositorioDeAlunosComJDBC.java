package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, aluno.getCpf());
            pstmt.setString(2, aluno.getNome());
            pstmt.setString(3, aluno.getEmail());
            pstmt.execute();

            sql = "INSERT INTO TELEFONE VALUES (?,?)";
            pstmt = this.connection.prepareStatement(sql);
            for(Telefone telefone : aluno.getTelefones()) {
                pstmt.setString(1, telefone.getDdd());
                pstmt.setString(1, telefone.getNumero());
                pstmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pstmt.close();
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM ALUNO WHERE ALUNO.CPF = ?";
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, cpf.getNumero());
            rs = pstmt.executeQuery();
            var encontrou = rs.next();

            if(!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }
            CPF cpfAluno = new CPF(rs.getString("CPF"));
            String nome = rs.getString("NOME");
            Email email = new Email(rs.getString("EMAIL"));
            Aluno aluno = new Aluno(cpfAluno, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT * FROM TELEFONE WHERE ALUNO_ID = ?";
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                aluno.adicionarTelefone(rs.getString("DDD"), rs.getString("NUMERO"));
            }
            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PreparedStatement psTelefone = null;
        ResultSet rsTelefone = null;
        try {
            String sql = "SELECT * FROM ALUNO";
            pstmt = this.connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                CPF cpfAluno = new CPF(rs.getString("CPF"));
                String nome = rs.getString("NOME");
                Email email = new Email(rs.getString("EMAIL"));
                Aluno aluno = new Aluno(cpfAluno, nome, email);

                Long id = rs.getLong("id");
                sql = "SELECT * FROM TELEFONE WHERE ALUNO_ID = ?";
                psTelefone = this.connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    aluno.adicionarTelefone(rsTelefone.getString("DDD"), rsTelefone.getString("NUMERO"));
                }
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rsTelefone.close();
                psTelefone.close();
                rs.close();
                pstmt.close();
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
