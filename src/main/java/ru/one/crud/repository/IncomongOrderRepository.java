package ru.one.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.one.crud.entity.IncomingOrder;

public interface IncomongOrderRepository extends JpaRepository<IncomingOrder, Long> {
}
