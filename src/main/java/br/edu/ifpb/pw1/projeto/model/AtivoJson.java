package br.edu.ifpb.pw1.projeto.model;

import java.math.BigDecimal;
import java.util.Objects;

public class AtivoJson {
    private String symbol;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal price;
    private Long volume;
    private String latestTradingDay;
    private BigDecimal previousClose;
    private BigDecimal change;
    private String changePercen;
    private String nameAtivo;

    public AtivoJson() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getLatestTradingDay() {
        return latestTradingDay;
    }

    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(BigDecimal previousClose) {
        this.previousClose = previousClose;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public String getChangePercen() {
        return changePercen;
    }

    public void setChangePercen(String changePercen) {
        this.changePercen = changePercen;
    }

    public String getNameAtivo() {
        return nameAtivo;
    }

    public void setNameAtivo(String nameAtivo) {
        this.nameAtivo = nameAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtivoJson ativoJson = (AtivoJson) o;
        return Objects.equals(symbol, ativoJson.symbol) &&
                Objects.equals(open, ativoJson.open) &&
                Objects.equals(high, ativoJson.high) &&
                Objects.equals(low, ativoJson.low) &&
                Objects.equals(price, ativoJson.price) &&
                Objects.equals(volume, ativoJson.volume) &&
                Objects.equals(latestTradingDay, ativoJson.latestTradingDay) &&
                Objects.equals(previousClose, ativoJson.previousClose) &&
                Objects.equals(change, ativoJson.change) &&
                Objects.equals(changePercen, ativoJson.changePercen) &&
                Objects.equals(nameAtivo, ativoJson.nameAtivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, open, high, low, price, volume, latestTradingDay, previousClose, change, changePercen, nameAtivo);
    }

    @Override
    public String toString() {
        return "AtivoJson{" +
                "symbol='" + symbol + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", price=" + price +
                ", volume=" + volume +
                ", latestTradingDay='" + latestTradingDay + '\'' +
                ", previousClose=" + previousClose +
                ", change=" + change +
                ", changePercen='" + changePercen + '\'' +
                ", nameAtivo='" + nameAtivo + '\'' +
                '}';
    }
}
