package Clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente {
    private String nomeCompleto;
    private String primeiroNome;
    private String sobrenome;
    private String nomeDoMeio;
    private String email;
    private String dataDeNascimento;
    private int idadeAtual;
    private String cpf;
    private char genero;
    private String endereco;
    private String telefone;

    public Cliente(String primeiroNome, String nomeDoMeio, String sobrenome, String cpf, String email,
                   char genero, String dataDeNascimento,String endereco, String telefone) {
        this.primeiroNome = primeiroNome;
        this.nomeDoMeio = nomeDoMeio;
        this.sobrenome = sobrenome;
        this.nomeCompleto = primeiroNome + " " + nomeDoMeio + " " + sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.dataDeNascimento = dataDeNascimento;
        this.idadeAtual = definirIdadeAtual();
        this.endereco = endereco;
        this.telefone = telefone;
    }
    private int definirIdadeAtual() {
        int anoAtual = recuperaAnoAtual();
        int anoNascimento = recuperarAnoNascimento();
        return recuperaAnoAtual() - recuperarAnoNascimento();
    }

    private int recuperarAnoNascimento() {
        Calendar calendario = Calendar.getInstance();
        Date dataNascimentoCliente;
        try {
            dataNascimentoCliente = definirFormatoDaData("").parse(dataDeNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        calendario.setTime(dataNascimentoCliente);
        return calendario.get(Calendar.YEAR);
    }

    private int recuperaAnoAtual() {
        Calendar calendario = Calendar.getInstance();
        Date diaAtual = new Date();
        calendario.setTime(diaAtual);
        return calendario.get(Calendar.YEAR);
    }

    private SimpleDateFormat definirFormatoDaData(String formatoDaData) {
        if (formatoDaData.equals("")) {
            return new SimpleDateFormat("dd/MM/yyyy");
        } else {
            return new SimpleDateFormat(formatoDaData);
        }

    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int idadeAtual) {
        this.idadeAtual = idadeAtual;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String tratamentoGenero() {
        if (getGenero() == 'M') {
            return "Sr. ";
        } else if (getGenero() == 'F') {
            return "Sra.";
        } else {
            return "";
        }
    }

    public String toString() {
        return tratamentoGenero() + " " + getNomeCompleto() + " , com CPF: " +
                getCpf() + " data de nascimento " + getDataDeNascimento() +
                " com idade de " + getIdadeAtual() + " e e-mail:" + getEmail() +
                ", endereço " + getEndereco() + " e telefone " + getTelefone();
    }
}
