package com.bae.persistence.domain;

import javax.persistence.*;
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
    private Date dateFrom;
    private Date dateTo;
    private int allowance;
    private int remaining;
    private int spent;

    @OneToMany
    private List<Poi> poi;

    public Details() {
    }

    public Details(Long id, String origin, String destination, Date dateFrom, Date dateTo, int allowance, int remaining, int spent) {
        super();
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.allowance = allowance;
        this.remaining = remaining;
        this.spent = spent;
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

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getSpent() {
        return spent;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return allowance == details.allowance &&
                remaining == details.remaining &&
                spent == details.spent &&
                id.equals(details.id) &&
                Objects.equals(origin, details.origin) &&
                Objects.equals(destination, details.destination) &&
                Objects.equals(dateFrom, details.dateFrom) &&
                Objects.equals(dateTo, details.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, dateFrom, dateTo, allowance, remaining, spent);
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", allowance=" + allowance +
                ", remaining=" + remaining +
                ", spent=" + spent +
                '}';
    }

    //    public Details() {
//
//    }
//
//    public Details(Long id, String origin, String destination, Date dateFrom, Date dateTo) {
//        super();
//        this.id = id;
//        this.origin = origin;
//        this.destination = destination;
//        this.dateFrom = dateFrom;
//        this.dateTo = dateTo;
//    }
//
//    public Long getId() {
//    	return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDestination() {
//    	return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//
//    public Date getDateFrom() {
//        return dateFrom;
//    }
//
//    public void setDateFrom(Date dateFrom) {
//        this.dateFrom = dateFrom;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public Date getDateTo() {
//        return dateTo;
//    }
//
//    public void setDateTo(Date dateTo) {
//        this.dateTo = dateTo;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((dateFrom == null) ? 0 : dateFrom.hashCode());
//        result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
//        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Details other = (Details) obj;
//        if (dateFrom == null) {
//            if (other.dateFrom != null)
//                return false;
//        } else if (!dateFrom.equals(other.dateFrom))
//            return false;
//        if (dateTo == null) {
//            if (other.dateTo != null)
//                return false;
//        } else if (!dateTo.equals(other.dateTo))
//            return false;
//        if (destination == null) {
//            if (other.destination != null)
//                return false;
//        } else if (!destination.equals(other.destination))
//            return false;
//        if (id == null) {
//            if (other.id != null)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        if (origin == null) {
//            return other.origin == null;
//        } else return origin.equals(other.origin);
//    }
//
//    @Override
//    public String toString() {
//        return "Details [id=" + id + ", origin=" + origin + ", destination=" + destination + ", dateFrom=" + dateFrom
//                + ", dateTo=" + dateTo + "]";
//    }

}
