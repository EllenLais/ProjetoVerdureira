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
        for(int i = 0; i < produtos.size(); i++){
            VerdureiraEntity produto = produtos.get(i);
            System.out.println("ID: " + i);
            System.out.println("Produto: " + produto.getProduto());
            System.out.println("Valor Produto: R$" + produto.getValorUnit());
            System.out.println("Quantidade Produto: " + produto.getQntd());
            double valTotalProdutos = (produto.getValorUnit() * produto.getQntd());
            System.out.println("Valor total em estoque por produto R$: " + valTotalProdutos);
            System.out.println("----------------------------------------");

        }
    }

    public VerdureiraEntity buscarProduto(int id, List<VerdureiraEntity> produtos){
        if (id >= 0 && id < produtos.size()){
            return produtos.get(id);
        }else{
            System.out.println("Produto não encontrado!!");
            return null;
        }

    }

    public VerdureiraEntity editarProduto(VerdureiraEntity verdureiraEntity){
        System.out.println("Informe o campo a ser editado: " +
                "\n1- Nome do Produto" +
                "\n2- Valor unitário" +
                "\n3- Quantidade" +
                "\n4- Editar tudo");
        int opcao = tec.nextInt();
        tec.nextLine();

        switch(opcao){
            case 1:
                System.out.println("Informe o novo nome para o produto: ");
                verdureiraEntity.setProduto(tec.nextLine());
                break;

            case 2:
                System.out.println("Informe o valor unitário: R$");
                verdureiraEntity.setValorUnit(tec.nextDouble());
                break;

            case 3:
                System.out.println("Informe a nova quantidade de produto: ");
                verdureiraEntity.setQntd(tec.nextInt());
                break;

            case 4:
                System.out.println("Informe o novo nome para o produto: ");
                verdureiraEntity.setProduto(tec.nextLine());
                System.out.println("Informe o valor unitário: R$");
                verdureiraEntity.setValorUnit(tec.nextDouble());
                System.out.println("Informe a nova quantidade de produto: ");
                verdureiraEntity.setQntd(tec.nextInt());
                break;

            default:
                System.out.println("Informe uma opção válida!!");
        }

        return verdureiraEntity;
    }

    public void removerProduto(List<VerdureiraEntity> listaProdutos, int id){
        listaProdutos.remove(id);
    }
}



