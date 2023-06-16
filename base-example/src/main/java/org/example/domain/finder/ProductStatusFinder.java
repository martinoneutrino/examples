package org.example.domain.finder;

import io.ebean.Finder;
import org.example.domain.ProductStatus;

public class ProductStatusFinder extends Finder<ProductStatus.Status, ProductStatus> {

  /**
   * Construct using the default EbeanServer.
   */
  public ProductStatusFinder() {
    super(ProductStatus.class);
  }

}
