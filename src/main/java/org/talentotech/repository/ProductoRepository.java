package org.talentotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talentotech.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
