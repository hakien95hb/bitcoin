package asm.bitcoin.Service;

import asm.bitcoin.Entity.Coin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CoinService {

    List<Coin> getList();

    Coin getDetail(long id);

    Coin store(Coin coin);
}
