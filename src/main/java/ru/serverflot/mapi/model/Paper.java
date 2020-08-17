package ru.serverflot.mapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tab_papers")
public class Paper extends AuditModel {
    @Id
    @GeneratedValue(generator = "tab_papers_generator")
    @SequenceGenerator(
            name = "tab_papers_generator",
            sequenceName = "tab_papers_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "secid", insertable = false, updatable = false)
    private String secid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "secid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private History paperHistory;

    @Column
    private String boardid;

    @Column
    private Date tradedate;

    @Column
    private String shortname;

    @Column
    private Double numtrades;

    @Column
    private Double value;

    @Column
    private Double open;

    @Column
    private Double low;

    @Column
    private Double high;

    @Column
    private Double legalcloseprice;

    @Column
    private Double waprice;

    @Column
    private Double close;

    @Column
    private Double volume;

    @Column
    private Double marketprice2;

    @Column
    private Double marketprice3;

    @Column
    private Double admittedquote;

    @Column
    private Double mp2valtrd;

    @Column
    private Double marketprice3tradesvalue;

    @Column
    private Double admittedvalue;

    @Column
    private Double waval;

    @Column
    private Long tradingsession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public History getPaperHistory() {
        return paperHistory;
    }

    public void setPaperHistory(History paperHistory) {
        this.paperHistory = paperHistory;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Double getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(Double numtrades) {
        this.numtrades = numtrades;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLegalcloseprice() {
        return legalcloseprice;
    }

    public void setLegalcloseprice(Double legalcloseprice) {
        this.legalcloseprice = legalcloseprice;
    }

    public Double getWaprice() {
        return waprice;
    }

    public void setWaprice(Double waprice) {
        this.waprice = waprice;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMarketprice2() {
        return marketprice2;
    }

    public void setMarketprice2(Double marketprice2) {
        this.marketprice2 = marketprice2;
    }

    public Double getMarketprice3() {
        return marketprice3;
    }

    public void setMarketprice3(Double marketprice3) {
        this.marketprice3 = marketprice3;
    }

    public Double getAdmittedquote() {
        return admittedquote;
    }

    public void setAdmittedquote(Double admittedquote) {
        this.admittedquote = admittedquote;
    }

    public Double getMp2valtrd() {
        return mp2valtrd;
    }

    public void setMp2valtrd(Double mp2valtrd) {
        this.mp2valtrd = mp2valtrd;
    }

    public Double getMarketprice3tradesvalue() {
        return marketprice3tradesvalue;
    }

    public void setMarketprice3tradesvalue(Double marketprice3tradesvalue) {
        this.marketprice3tradesvalue = marketprice3tradesvalue;
    }

    public Double getAdmittedvalue() {
        return admittedvalue;
    }

    public void setAdmittedvalue(Double admittedvalue) {
        this.admittedvalue = admittedvalue;
    }

    public Double getWaval() {
        return waval;
    }

    public void setWaval(Double waval) {
        this.waval = waval;
    }

    public Long getTradingsession() {
        return tradingsession;
    }

    public void setTradingsession(Long tradingsession) {
        this.tradingsession = tradingsession;
    }
}
