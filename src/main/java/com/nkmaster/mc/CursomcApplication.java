package com.nkmaster.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nkmaster.mc.domain.Categoria;
import com.nkmaster.mc.domain.Cidade;
import com.nkmaster.mc.domain.Cliente;
import com.nkmaster.mc.domain.Endereco;
import com.nkmaster.mc.domain.Estado;
import com.nkmaster.mc.domain.Produto;
import com.nkmaster.mc.enums.TipoCliente;
import com.nkmaster.mc.repositories.CategoriaRepository;
import com.nkmaster.mc.repositories.CidadeRepository;
import com.nkmaster.mc.repositories.ClienteResitory;
import com.nkmaster.mc.repositories.EnderecoRepository;
import com.nkmaster.mc.repositories.EstadoRepository;
import com.nkmaster.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired			//dependencia
	public CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteResitory clienteResitory;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "1234567890", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("1111111111","2222222222"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303", "Jardim", "333333333", cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Matos", "105", "Sala 800","Centro", "444444444", cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteResitory.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
	}

}
