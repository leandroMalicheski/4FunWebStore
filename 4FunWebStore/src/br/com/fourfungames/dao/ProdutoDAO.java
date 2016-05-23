package br.com.fourfungames.dao;

import java.util.ArrayList;

import br.com.fourfungames.model.Produto;

public class ProdutoDAO {
	
	ArrayList<Produto> listaProdutos;
	
	public ArrayList<Produto> list() {
		
		if(listaProdutos == null){
			Produto produto = new Produto();
			produto.setId(0);
			produto.setName("Battlefield Hardline");
			produto.setDescricao("Jogo de Tiro");
			produto.setValor(230.0D);
			produto.setCaminhoImagem("content/images/capas/BFHardline.png");
	
			Produto produto1 = new Produto();
			produto1.setId(1);
			produto1.setName("Assasin's Creed Black Flag");
			produto1.setDescricao("Jogo de Aventura");
			produto1.setValor(180.0D);
			produto1.setCaminhoImagem("content/images/capas/BlackFlag.png");
	
			Produto produto2 = new Produto();
			produto2.setId(2);
			produto2.setName("Battlefield Hardline");
			produto2.setDescricao("Jogo de Tiro");
			produto2.setValor(230.0D);
			produto2.setCaminhoImagem("content/images/capas/BFHardline.png");
	
			Produto produto3 = new Produto();
			produto3.setId(3);
			produto3.setName("Assasin's Creed Black Flag");
			produto3.setDescricao("Jogo de Aventura");
			produto3.setValor(180.0D);
			produto3.setCaminhoImagem("content/images/capas/BlackFlag.png");
	
			this.listaProdutos = new ArrayList<Produto>();
			listaProdutos.add(produto);
			listaProdutos.add(produto1);
			listaProdutos.add(produto2);
			listaProdutos.add(produto3);
		}

		return listaProdutos;
	}
	
	public Produto listById(int id){
		if(listaProdutos != null){
			Produto result = null;
			for (Produto produto : listaProdutos) {
				if (produto.getId() == id) {
					result = produto;
				}
			}
			return result;
		}else{
			list();
			return listById(id);
		}
	}
}