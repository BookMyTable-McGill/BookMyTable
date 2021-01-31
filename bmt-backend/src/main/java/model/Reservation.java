package model;

import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Date;
import javax.persistence.ManyToOne;

@Entity
public class Reservation{
   private Time startTime;

public void setStartTime(Time value) {
    this.startTime = value;
}
public Time getStartTime() {
    return this.startTime;
}
private Time endTime;

public void setEndTime(Time value) {
    this.endTime = value;
}
public Time getEndTime() {
    return this.endTime;
}
private Date date;

public void setDate(Date value) {
    this.date = value;
}
public Date getDate() {
    return this.date;
}
private int groupSize;

public void setGroupSize(int value) {
    this.groupSize = value;
}
public int getGroupSize() {
    return this.groupSize;
}
private long id;

public void setId(long value) {
    this.id = value;
}
public long getId() {
    return this.id;
}
   private Customer customer;
   
   @ManyToOne(optional=false)
   public Customer getCustomer() {
      return this.customer;
   }
   
   public void setCustomer(Customer customer) {
      this.customer = customer;
   }
   
   private Table table;
   
   @ManyToOne(optional=false)
   public Table getTable() {
      return this.table;
   }
   
   public void setTable(Table table) {
      this.table = table;
   }
   
   }
