package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entities.Aluno;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		int opcao = 0;
        Scanner console = new Scanner(System.in);

        do {
        	System.out.println("####### Menu #######"
        						+ "\n1 - Cadastrar"
        						+ "\n2 - Listar"
        						+ "\n3 - Alterar"
        						+ "\n4 - Excluir"
        						+ "\n5 - Sair");
        	System.out.println("\n\topcao:");
        	opcao = Integer.parseInt(console.nextLine());
        	AlunoJDBC acao = new AlunoJDBC();

        	if (opcao == 1) {
        	
        		Aluno a = new Aluno();        		
        		System.out.println("\n ### Cadastrar Aluno ### \n\r");
        		
        		System.out.print("Nome: ");
        		a.setNome(console.nextLine());
        		
        		System.out.print("Sexo: ");
        		a.setSexo(console.nextLine());
        	
        		System.out.print("Data de Nascimento (dd-mm-aaaa): ");
        		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        		a.setDt_nasc( new Date(console.nextLine()));
        		
        		acao.salvar(a);
        		console.nextLine();
        		System.out.println("\n\n\n\n");
        	}

        	else if (opcao == 2) {
        		List<Aluno> retorno = acao.listar();
        		
        		for(int i = 0; i < retorno.size(); i++) {
        			System.out.println(retorno.get(i).toString());
        		}
        	}

        	else if (opcao == 3) {
        		Aluno a = new Aluno();        		
        		System.out.println("\n ### Atualizar Aluno ### \n\r");

        		System.out.print("Digite o id do aluno que deseja editar:");
        		a.setId(console.nextInt());
        		console.nextLine();
        		
        		System.out.print("Nome: ");
        		a.setNome(console.nextLine());
        		
        		System.out.print("Sexo: ");
        		a.setSexo(console.nextLine());
        	
        		System.out.print("Data de Nascimento (dd-mm-aaaa): ");
        		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        		a.setDt_nasc( new Date(console.nextLine()));
        		
        		acao.alterar(a);
        		System.out.println("\n\n\n\n");
        	}
        	
        	else{
        		acao.fecharConexao();
        		break;
        	}
        } while(opcao != 5);

        System.out.println("Fim da aplicação");
	}

}
