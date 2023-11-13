import Clientes.Cliente;
import Clientes.ClienteBuilder;

public class Main {
    public static void main (String []args){

        Cliente clienteM = new Cliente("Felipe","Almeida","Andrade","123.456.789-90",
                "felipeALA@hotmail.com",'M', "23/08/1997","Av. Carlos de carvalho",
                "(99) 7835-8125" );
        System.out.println(clienteM.toString());

        Cliente clienteF = new Cliente("Fernanda","Ribeiro","Lima","195.453.739-50",
                "fernandalima@hotmail.com",'F', "15/04/2005","Av. Maranhao",
                "(99) 8756-1238" );
        System.out.println(clienteF.toString());

        ClienteBuilder clienteFCompleto = new ClienteBuilder().comIdentificacao("Julia","Arruda",
                "Felz","567.231.457-98",'F',"12/03/1999").comContatos
                ("Av. Rondonia","(76) 1234-1234","julianafelz@gmail.com");
        System.out.println(clienteFCompleto.toString());

        ClienteBuilder clienteMIdentificacao = new ClienteBuilder().comIdentificacao("Felipe", "almeida","Andrade", "23.456.789-90", 'M',"23/08/1997");
        System.out.println(clienteMIdentificacao.toString());

        ClienteBuilder clienteMContatos = new ClienteBuilder().comContatos("Av. Carlos de carvalho",
                "(99) 7835-8125","felipeALA@hotmail.com");
        System.out.println(clienteMContatos.toStringContatos());

    }
}