package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	int id = 0;

	@Override
	public void procurarPorId(int id) {
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\n⚠️ O Produto ID %d não foi encontrado.\n", id);
	}

	@Override
	public void listarTodos() {
		if (listaProdutos.isEmpty()) {
			System.out.println("\n⚠️ Nenhum produto cadastrado.");
			return;
		}

		for (var produto : listaProdutos) {
			produto.visualizar();
			System.out.println("---------------------------------------");
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println(" Produto cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.printf("\nO Produto ID %d foi atualizado com sucesso!\n", produto.getId());
		} else {
			System.out.printf("\nO Produto ID %d não foi encontrado.\n", produto.getId());
		}
	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			listaProdutos.remove(produto.get());
			System.out.printf("\nO Produto ID %d foi excluído com sucesso!\n", id);
		} else {
			System.out.printf("\nO Produto ID %d não foi encontrado.\n", id);
		}
	}
	public void procurarPorNome(String nome) {
	    var resultados = listaProdutos.stream()
	        .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
	        .toList();

	    if (resultados.isEmpty()) {
	        System.out.println("\n⚠️ Nenhum produto encontrado com esse nome.");
	    } else {
	        resultados.forEach(p -> {
	            p.visualizar();
	            System.out.println("---------------------------------------");
	        });
	    }
	}

	// Métodos Auxiliares

	public int gerarId() {
		return ++id;
	}

	private Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}
		return Optional.empty();
	}
}
