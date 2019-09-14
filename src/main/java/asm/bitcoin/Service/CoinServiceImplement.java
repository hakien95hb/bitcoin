package asm.bitcoin.Service;

import asm.bitcoin.Entity.Coin;
import asm.bitcoin.Entity.Market;
import asm.bitcoin.Repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class CoinServiceImplement implements CoinService {
    @Autowired
    CoinRepository coinRepository;

    public List<Coin> getList() {
        return coinRepository.findAll();
    }
    @Override
    public Coin getDetail(long id) {
        return coinRepository.findById(id).orElse(null);
    }

    @Override
    public Coin store(Coin coin) {
        coin.setId(Calendar.getInstance().getTimeInMillis());
        coin.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        coin.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        return coinRepository.save(coin);
    }


}
