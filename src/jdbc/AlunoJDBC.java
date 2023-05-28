package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	Connection con;
	String sql;
	PreparedStatement pst;

	public void salvar(Aluno a) throws SQLException {
		try {
			con = DB.getConexao();
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.executeUpdate();
			System.out.println("Cadastro aluno com sucesso");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Aluno> listar() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();

		try {
			con = DB.getConexao();
			sql = "SELECT * FROM aluno";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("idaluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDt_nasc(rs.getDate("dt_nasc"));
				alunos.add(aluno);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return alunos;
	}

	public void apagar(int id) throws SQLException {
		try {
			con = DB.getConexao();
			sql = "DELETE FROM aluno WHERE idaluno = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Aluno deletado com sucesso");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void alterar(Aluno a) {
		if (this.alunoExiste(a.getId())) {
			try {
				con = DB.getConexao();
				sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE idaluno = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, a.getNome());
				pst.setString(2, a.getSexo());
				Date dataSql = new Date(a.getDt_nasc().getTime());
				pst.setDate(3, dataSql);
				pst.setInt(4, a.getId());
				pst.executeUpdate();
				System.out.println("Aluno editado com sucesso");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void fecharConexao() throws SQLException {
		DB.closeConexao();
	}

	private boolean alunoExiste(int id) {
		try {
			con = DB.getConexao();
			sql = "SELECT * FROM aluno WHERE idaluno = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			int contador = 0;
			while(rs.next()) {
				contador++;
			}
		    if (contador > 0) {
		    	return true;
		    }
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}
}
