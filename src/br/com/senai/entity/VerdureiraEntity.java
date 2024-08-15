package br.com.senai.entity;

public class VerdureiraEntity {

    private String produto;
    private double valorUnit;
    private int qntd;


    public void setProduto(String produto){
        this.produto = produto;
    }

    public String getProduto() {
        return produto;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }





}
