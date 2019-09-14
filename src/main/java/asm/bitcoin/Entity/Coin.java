package asm.bitcoin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Coin {
    @Id
    private long id;
    private String name;
    private String baseAsset;
    private String quoteAsset;
    private int lastPrice;
    private int volumn24h;
    private long createdAtMLS;
    private long updatedAtMLS;
    private int status;

    @ManyToMany
    @JoinTable(
            name = "coinMarket",
            joinColumns = @JoinColumn(name = "coin_id"),
            inverseJoinColumns = @JoinColumn(name = "market_id"))

    Set<Market> coinMarket;

    public Set<Market> getCoinMarket() {
        return coinMarket;
    }

    public void setCoinMarket(Set<Market> coinMarket) {
        this.coinMarket = coinMarket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    public int getVolumn24h() {
        return volumn24h;
    }

    public void setVolumn24h(int volumn24h) {
        this.volumn24h = volumn24h;
    }

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
