package ru.serverflot.mapi.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_papers")
public class Paper extends AuditModel {
    public Paper() { }

    public Paper(String secid, String name, String emitent_title, String tradedate, Integer numtrades, Double open, Double close) {
        this.secid = secid;
        this.name = name;
        this.emitent_title = emitent_title;
        this.tradedate = tradedate;
        this.numtrades = numtrades;
        this.open = open;
        this.close = close;
    }

    @Id
    @GeneratedValue(generator = "tab_papers_generator")
    @SequenceGenerator(
            name = "tab_papers_generator",
            sequenceName = "tab_papers_sequence",
            initialValue = 1
    )
    private Long id;

    @Column
    private String secid;

    @Column
    private String name;

    @Column
    private String emitent_title;

    @Column
    private String tradedate;

    @Column
    private Integer numtrades;

    @Column
    private Double open;

    @Column
    private Double close;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent_title() {
        return emitent_title;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public Integer getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(Integer numtrades) {
        this.numtrades = numtrades;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }
}
