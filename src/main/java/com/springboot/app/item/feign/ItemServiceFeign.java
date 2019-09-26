package com.springboot.app.item.feign;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.app.item.model.Item;
import com.springboot.app.item.service.ItemService;

@Service
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRestFeign productoClienteRestFeign;

	@Override
	public List<Item> findAll() {
		return productoClienteRestFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(productoClienteRestFeign.detalle(id), cantidad);
	}

}
