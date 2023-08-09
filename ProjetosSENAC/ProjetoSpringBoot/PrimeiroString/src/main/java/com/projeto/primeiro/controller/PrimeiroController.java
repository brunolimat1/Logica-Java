package com.projeto.primeiro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping("/dados")
	public String dados() {
		return "Olá, tudo bem!";
	}

	@GetMapping("/listaprodutos")
	public List<List<String>> produtos() {
		List<List<String>> lst = new ArrayList<List<String>>();

		List<String> categoria = new ArrayList<String>();
		categoria.add("Informática");
		categoria.add("Material escritório");
		categoria.add("Escolar");

		List<String> produto = new ArrayList<String>();
		produto.add("Mouse");
		produto.add("Teclado");
		produto.add("Telefone");

		lst.add(produto);
		lst.add(categoria);

		return lst;
	}

	@GetMapping("/products")
	public List<String> products() {
		List<String> lst = new ArrayList<String>();

		lst.add("id: 1");
		lst.add("title: iPhone 9");
		lst.add("description: An apple mobile wich is nothing like apple ");
		lst.add("discountPercentage: 12.96");
		lst.add("rating: 4.69");
		lst.add("stock: 94");
		lst.add("brand: Apple");
		lst.add("category: smartphones");
		lst.add("thumbnail: https://i.dummyjson.com/data/products/1/thumbnail.jpg ");

		lst.add("id: 2");
		lst.add("title: iPhone X ");
		lst.add("description : SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ... ");
		lst.add("price: 899");
		lst.add("discountPercentage: 17.94");
		lst.add("rating: 4.44");
		lst.add("stock: 34");
		lst.add("brand: Apple");
		lst.add("category: smartphones");
		lst.add("thumbnail: https://i.dummyjson.com/data/products/2/thumbnail.jpg");

		lst.add("id: 3");
		lst.add("title: Samsung Universe 9");
		lst.add("description: Samsung's new variant which goes beyond Galaxy to the Universe");
		lst.add("price: 1249 ");
		lst.add("discountPercentage: 15.46");
		lst.add("rating: 4.09");
		lst.add("stock: 36");
		lst.add("brand: Samsung");
		lst.add("category: smarthphones");
		lst.add("thumbnail: https://i.dummyjson.com/data/products/3/thumbnail.jpg");

		lst.add("id: 4");
		lst.add("title: OPPOF19");
		lst.add("description: OPPO F19 is officially announced on April 2021");
		lst.add("price: 280");
		lst.add("discountPercentage: 17.91");
		lst.add("rating: 4.3");
		lst.add("stock: 123");
		lst.add("brand: OPPO");
		lst.add("category: smartphones");
		lst.add("thumbnail: https://i.dummyjson.com/data/products/4/thumbnail.jpg");

		return lst;
	}

	@GetMapping("/images")
	public List<String> images(){
		List<String> lst = new ArrayList<String>();
		
		lst.add("https://i.dummyjson.com/data/products/1/1.jpg");
		lst.add("https://i.dummyjson.com/data/products/1/2.jpg");
		lst.add("https://i.dummyjson.com/data/products/1/3.jpg");
		lst.add("https://i.dummyjson.com/data/products/1/4.jpg");
		lst.add("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
		
		lst.add("https://i.dummyjson.com/data/products/2/1.jpg");
		lst.add("https://i.dummyjson.com/data/products/2/2.jpg");
		lst.add("https://i.dummyjson.com/data/products/2/3.jpg");
		lst.add("https://i.dummyjson.com/data/products/2/thumbnail.jpg");
		
		lst.add("https://i.dummyjson.com/data/products/3/1.jpg");
		lst.add("https://i.dummyjson.com/data/products/3/2.jpg");
		lst.add("https://i.dummyjson.com/data/products/3/3.jpg");
		lst.add("https://i.dummyjson.com/data/products/3/4.jpg");
		lst.add("https://i.dummyjson.com/data/products/3/thumbnail.jpg");
		
		lst.add("https://i.dummyjson.com/data/products/4/1.jpg");
		lst.add("https://i.dummyjson.com/data/products/4/2.jpg");
		lst.add("https://i.dummyjson.com/data/products/4/3.jpg");
		lst.add("https://i.dummyjson.com/data/products/4/thumbnail.jpg");
		
		return lst;
	}
	
}
