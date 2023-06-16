package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.example.domain.finder.ProductStatusFinder;

import io.ebean.Model;
import io.ebean.annotation.Cache;
import io.ebean.annotation.DbDefault;
import io.ebean.annotation.EnumValue;
import io.ebean.annotation.DbEnumValue;
import io.ebean.annotation.DbEnumType;

/**
 * Product status entity bean.
 */
@Entity
@Table(name = "productstatus")
@Cache
public class ProductStatus extends Model {

  public static final ProductStatusFinder find = new ProductStatusFinder();

  @Id
  Status id;

  @Size(max = 50)
  String name;

  /** This enum also fails with same error */
  public enum Status {
    @EnumValue("1")
    Created,
    @EnumValue("2")
    Approved,
    @EnumValue("3")
    Deleted;
  }

  /** This enum also fails with same error */
  // public enum Status {
  //   Created(1L),
  //   Approved(2L),
  //   Deleted(3L);
  
  //   Long dbValue;
  //   private Status(Long dbValue) {
  //     this.dbValue = dbValue;
  //   }
  
  //   // annotate a method that returns the value
  //   // in the DB that the enum element maps to
  //   @DbEnumValue(storage = DbEnumType.INTEGER)
  //   public Long getValue() {
  //     return dbValue;
  //   }
  // }

  public Status getId() {
    return id;
  }

  public void setStatus(Status id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

