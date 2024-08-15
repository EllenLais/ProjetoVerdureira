package br.com.senai.controller;

import br.com.senai.entity.VerdureiraEntity;
import br.com.senai.service.VerdureiraService;

import java.util.List;

public class VerdureiraController {
    VerdureiraService verdureiraService = new VerdureiraService();


    public VerdureiraEntity cadastrarProduto(String produto, double valorUnit, int qntd){
        return verdureiraService.cadastrarProduto(produto, valorUnit, qntd);
    }

    public void listarProdutos(List<VerdureiraEntity> produtos){
        verdureiraService.listarProdutos(produtos);
    }

    public void buscarProduto(){

    }

    public VerdureiraEntity editarProduto(VerdureiraEntity verdureiraEntity){
        return verdureiraService.editarProduto(verdureiraEntity);
    }

    public void removerProduto(){

    }
}
