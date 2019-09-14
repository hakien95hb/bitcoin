package asm.bitcoin.Controller;

import asm.bitcoin.Entity.Market;
import asm.bitcoin.Entity.RESTPagination;
import asm.bitcoin.Entity.RESTResponse;
import asm.bitcoin.Service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listMarket() {
        List<Market> marketList = marketService.getList();
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(marketList)
                .setMessage("Action success!")
                .buildDatas(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable long id) {
        Market market = marketService.getDetail(id);
        if (market == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not Found Market")
                    .build(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(market)
                .setMessage("ok")
                .setStatus(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> doRegister(@RequestBody Market market) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(marketService.store(market))
                .setMessage("Save success!")
                .setStatus(HttpStatus.CREATED.value())
                .build(), HttpStatus.CREATED);
    }
}

