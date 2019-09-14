package asm.bitcoin.Controller;

import asm.bitcoin.Entity.Coin;
import asm.bitcoin.Entity.Market;
import asm.bitcoin.Entity.RESTResponse;
import asm.bitcoin.Service.CoinService;
import asm.bitcoin.Service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/coin")
public class CoinController {
    @Autowired
    private CoinService coinService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listMarket() {
        List<Coin> coinList = coinService.getList();
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(coinList)
                .setMessage("Action success!")
                .buildDatas(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable long id) {
        Coin coin = coinService.getDetail(id);
        if (coin == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not Found Market")
                    .build(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(coin)
                .setMessage("ok")
                .setStatus(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> doRegister(@RequestBody Coin coin) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(coinService.store(coin))
                .setMessage("Save success!")
                .setStatus(HttpStatus.CREATED.value())
                .build(), HttpStatus.CREATED);
    }
}
