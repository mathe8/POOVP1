package com.prova.main;
import java.lang.Math;

public class Conta {

    private String Nome;
    private String CPF;
    private Integer NumeroConta;
    private Double Saldo;

    public Conta() {
        this.NumeroConta = 100000;
        this.Saldo = 0.00;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return this.Nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public Integer getNumeroConta() {
        return this.NumeroConta;
    }

    public Double getSaldo() {
        return this.Saldo;
    }

    public void realizarDeposito(Double Valor) {
        this.Saldo = this.Saldo + Valor;
    }

    public void realizarSaque(Double Valor) {
        this.Saldo = this.Saldo - Valor;
    }

    public void realizarTransferencia(Double Valor) {
        this.Saldo = this.Saldo - Valor;
    }

    public void atribuirNumeroConta() {
        int Min = 100000;
        int Max = 999999;

        this.NumeroConta = (int)(Math.random() * ((Max - Min) + 1)) + Min;
    }

}
