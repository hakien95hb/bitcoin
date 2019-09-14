package asm.bitcoin.Service;

import asm.bitcoin.Entity.Market;

import java.util.List;

public interface MarketService {
    List<Market> getList();

    Market getDetail(long id);

    Market store(Market market);

}
