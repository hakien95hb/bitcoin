package asm.bitcoin.Repository;

import asm.bitcoin.Entity.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinRepository extends JpaRepository<Coin, Long> {
//    List<Coin> getAllByNameAndCoinMarket (int id, int market_id);
    List<Coin> findAllByName(String name);
}
