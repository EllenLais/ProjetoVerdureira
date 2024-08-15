package br.com.senai.service;

import br.com.senai.entity.VerdureiraEntity;

import java.util.List;
import java.util.Scanner;

public class VerdureiraService {
    Scanner tec = new Scanner(System.in);

    public VerdureiraEntity cadastrarProduto(String produto, double valorUnit, int qntd){
        VerdureiraEntity verdureiraEntity = new VerdureiraEntity();

        verdureiraEntity.setProduto(produto);
        verdureiraEntity.setValorUnit(valorUnit);
        verdureiraEntity.setQntd(qntd);

        return verdureiraEntity;
    }

    public void listarProdutos(List<VerdureiraEntity> produtos){
        System.out.println("PRODUTOS CADASTRADOS");
        produtos.forEach(produto ->{
            System.out.println("Produto: " + produto.getProduto());
            System.out.println("Valor Produto: " + produto.getValorUnit());
            System.out.println("Quantidade Produto: " + produto.getQntd());
            double valTotalProdutos = (produto.getValorUnit() * produto.getQntd());
            System.out.println("Valor total em estoque por produto R$: " + valTotalProdutos);
            System.out.println("----------------------------------------");

        });
    }

    public void buscarProduto(List<VerdureiraEntity> produtos){

    }

    public VerdureiraEntity editarProduto(VerdureiraEntity verdureiraEntity){
        System.out.print("Informe o novo nome para o produto: ");
        String produto = tec.nextLine();
        verdureiraEntity.setProduto(produto);
        return verdureiraEntity;
    }

    public void removerProduto(){

    }
}


