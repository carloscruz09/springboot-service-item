package com.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.item.config.AppConfig;
import com.springboot.app.item.model.Item;
import com.springboot.app.item.model.Producto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private AppConfig restClient;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(
				restClient.registrarRestTemplate().getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Producto producto = restClient.registrarRestTemplate().getForObject("http://localhost:8001/listar",
				Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
