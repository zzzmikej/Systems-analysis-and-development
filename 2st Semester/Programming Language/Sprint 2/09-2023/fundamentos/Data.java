import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Data {
    public static void main(String[] args){
        DateTimeFormatter formatadorDeHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // System.out.println(dataHora.format(formatadorDeHora));

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoParaCaptura = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite sua data de nascimento:");
        LocalDate dataAniversario = LocalDate.parse(scanner.nextLine(), formatoParaCaptura);

        System.out.println(dataAniversario);
    }
}
