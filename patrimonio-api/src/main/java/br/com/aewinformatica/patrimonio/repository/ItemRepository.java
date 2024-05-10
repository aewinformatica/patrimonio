package br.com.aewinformatica.patrimonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aewinformatica.patrimonio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
