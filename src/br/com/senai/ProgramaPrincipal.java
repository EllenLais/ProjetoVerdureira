package br.com.senai;

import br.com.senai.controller.VerdureiraController;
import br.com.senai.entity.VerdureiraEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaPrincipal {
        public static void main(String[] args) {
            Scanner tec = new Scanner(System.in);
            List<VerdureiraEntity> produtos = new ArrayList<>();

            boolean repetir = true;
            int opcao;

            String produto;
            double valorUnit;
            int qntd;
            int qntdEstoque = 0;
            double valTotalProdutos = 0;
            double valorEstoque = 0;


            VerdureiraController verdureiraController = new VerdureiraController();

            do {
                System.out.println("---------MENU---------");
                System.out.println("1- Cadastrar Verduras");
                System.out.println("2- Listar Produtos");
                System.out.println("3- Buscar Produtos");
                System.out.println("4- Editar Produto");
                System.out.println("5- Excluir Produto");
                System.out.println("6- Encerrar Sistema!!");
                System.out.println("----------------------");
                System.out.println("Informe a opção desejada: ");
                opcao = tec.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("---Cadastrar Produtos---");

                        System.out.print("Informe o produto: ");
                        tec.nextLine();
                        produto = tec.nextLine();
                        System.out.println("Informe o valor do produto: R$ ");
                        valorUnit = tec.nextDouble();
                        System.out.println("Informe a quantidade: ");
                        qntd = tec.nextInt();

                        valTotalProdutos = (valorUnit * qntd);
                        System.out.println("Valor total em estoque por produto R$: " + valTotalProdutos);
                        qntdEstoque += qntd;
                        valorEstoque += valTotalProdutos;


                        VerdureiraEntity verdureira = verdureiraController.cadastrarProduto(produto, valorUnit, qntd);
                        produtos.add(verdureira);
                        break;

                    case 2:
                        System.out.println("---Listar Produtos---");
                        verdureiraController.listarProdutos(produtos);
                        System.out.println("------------------------");

                        System.out.println("Quantidade de produtos no estoque: " + qntdEstoque);
                        System.out.println("Valor total em estoque R$: " + valorEstoque);
                        break;

                    case 3:
                        System.out.println("---Buscar Produtos---");
                        System.out.println("Informe o ID do produto desejado: ");
                        int id = tec.nextInt();
                        VerdureiraEntity produtoBuscado = verdureiraController.buscarProduto(id, produtos);
                        if (produtoBuscado != null){
                            System.out.println("Produto encontrado: " + produtoBuscado.getProduto());
                            System.out.println("Quantidade: " + produtoBuscado.getQntd());
                            System.out.println("Valor unitário: R$" + produtoBuscado.getValorUnit());
                        }else{
                            System.out.println("Produto não encontrado!!");
                        }

                        break;

                    case 4:
                        System.out.println("---Editar Produto---");
                        System.out.print("Informe o id do produto:  ");
                        int idE = tec.nextInt();
                        if (idE >= produtos.size() || idE < 0) {
                            System.out.println("Produto não cadastrado!!!!!");
                            break;
                        }
                        VerdureiraEntity verdureiraEntityEdit = produtos.get(idE);
                        VerdureiraEntity produtoEditado = verdureiraController.editarProduto(verdureiraEntityEdit);
                        produtos.set(idE, produtoEditado);
                        break;

                    case 5:
                        System.out.println("---Excluir Produto---");
                        System.out.println("Digite o ID a ser removido: ");
                        int idEP = tec.nextInt();

                        if (idEP >= 0 && idEP < produtos.size()){
                            VerdureiraEntity produtoRemovido = produtos.remove(idEP);
                            qntdEstoque -= produtoRemovido.getQntd();
                            valorEstoque -= produtoRemovido.getValorUnit() * produtoRemovido.getQntd();
                            System.out.println("Produto removido com sucesso!");
                        }else{
                            System.out.println("Nenhum item com o ID informado!!");
                        }
                        break;

                    case 6:
                        repetir = false;
                        System.out.println("SISTEMA ENCERRADO!!");
                        tec.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida, favor tentar novamente!!");
                        break;
                }
            }
            while (repetir);
        }
    }

