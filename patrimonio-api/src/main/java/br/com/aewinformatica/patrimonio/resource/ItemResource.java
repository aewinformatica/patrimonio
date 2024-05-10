package br.com.aewinformatica.patrimonio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.aewinformatica.patrimonio.model.Item;

import br.com.aewinformatica.patrimonio.repository.ItemRepository;
import jakarta.validation.Valid;



@RestController
@CrossOrigin("${api.origin-permitida}")
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/itens")
	public List<Item> listar() {
		return itemRepository.findAll();
	}
	
	@PostMapping("/itens")
	public Item adicionar(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}
}
