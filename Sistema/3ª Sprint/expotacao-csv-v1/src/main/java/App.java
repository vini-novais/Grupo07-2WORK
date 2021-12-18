import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void gravaArquivoCsv(UsuarioObj<Usuario> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq, false);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Usuario dog = lista.getElemento(i);
                saida.format("%d;%s;%s;%s\n", dog.getId(), dog.getNome(),
                        dog.getCpf(), dog.getEmail());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);

            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }
        try {
            System.out.printf("%4s %-15s %-9s %15s\n", "ID", "NOME", "CPF", "EMAIL");
            while (entrada.hasNext()) {  // Enquanto não for final do arquivo
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String cpf = entrada.next();
                String email = entrada.next();
                System.out.printf("%4d %-15s %-9s %15s\n", id, nome, cpf, email);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        UsuarioObj<Usuario> lista = new UsuarioObj(10);
        lista.adiciona(new Usuario(1, "vanderlei", "22222", "doidos@"));
        lista.adiciona(new Usuario(2, "maxx", "344444", "dai1n@"));
        lista.adiciona(new Usuario(3, "marx", "6565656", "dai1n@"));
        lista.adiciona(new Usuario(4, "Durno", "232323", "dai1n@"));
        lista.adiciona(new Usuario(5, "webs", "3453242", "dai1n@"));
        lista.adiciona(new Usuario(6, "Feira", "242234", "dai1n@"));

        lista.exibe();
        gravaArquivoCsv(lista, "Usuários ativos");
        leExibeArquivoCsv("usuarios");
    }
}