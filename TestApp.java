package test;

import main.Aluno;
import main.App;
import main.Professor;
import org.junit.Test;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestApp {

    App app = new App();

    @Test
    public void testLoginAlunoSucesso() {
        // Setup
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno("Mauricio Taques", "12345678900", "mtaques@email.com", "123456789", "Rua A, 123", "mautaques", "senha123", "03/05/2003");
        App.getAlunos().add(aluno);  // Adiciona o aluno para teste

        // Teste
        String cpf = "12345678900";
        String senha = "senha123";
        Aluno alunoLogado = App.buscarAlunoPorCpf(cpf);
        assertNotNull(alunoLogado);
        assertTrue(alunoLogado.getSenha().equals(senha));
    }

    @Test
    public void testLoginFalho() {
        // Setup
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno("Mauricio Taques", "12345678900", "mtaques@email.com", "123456789", "Rua A, 123", "mautaques", "senha123", "03/05/2003");
        App.getAlunos().add(aluno);

        // Teste
        String cpf = "987654321";  // CPF não cadastrado
        String senha = "senhaErrada";  // Senha incorreta
        Aluno alunoLogado = App.buscarAlunoPorCpf(cpf);
        assertNull(alunoLogado);
    }




}
