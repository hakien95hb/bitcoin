package asm.bitcoin.Service;
import asm.bitcoin.Entity.Market;
import asm.bitcoin.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;
@Service
public class MarketServiceImplement implements MarketService {
    @Autowired
    MarketRepository marketRepository;

    @Override
    public List<Market> getList() {
        return marketRepository.findAllByStatus(1);
    }

    @Override
    public Market getDetail(long id) {
        return marketRepository.findById(id).orElse(null);
    }

    @Override
    public Market store(Market market) {
        market.setId(Calendar.getInstance().getTimeInMillis());
        market.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        market.setStatus(1);
        return marketRepository.save(market);
    }


}
