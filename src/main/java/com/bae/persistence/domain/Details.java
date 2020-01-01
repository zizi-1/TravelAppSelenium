package com.bae.persistence.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateFrom;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateTo;

    private int allowance;
    private int remaining;
    private int spent;

    @OneToMany
    private List<Poi> poi;

    public Details() {
    }

    public Details(String origin, String destination, Date dateFrom, Date dateTo, Poi... poi) {
        super();
        this.origin = origin;
        this.destination = destination;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.poi = Arrays.asList(poi);
    }

    public List<Poi> getPoi() {
        return poi;
    }

    public void setPoi(List<Poi> poi) {
        this.poi = poi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return Objects.equals(id, details.id) &&
                Objects.equals(origin, details.origin) &&
                Objects.equals(destination, details.destination) &&
                Objects.equals(dateFrom, details.dateFrom) &&
                Objects.equals(dateTo, details.dateTo) &&
                Objects.equals(poi, details.poi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, dateFrom, dateTo, poi);
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", poi=" + poi +
                '}';
    }
}
