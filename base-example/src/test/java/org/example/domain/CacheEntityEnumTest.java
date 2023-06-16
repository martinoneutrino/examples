package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheEntityEnumTest {

  /** Add ProductStatus data */
  @Test
  public void cachedEntityRetrieveTest() {

    ProductStatus status = new ProductStatus();
    status.setStatus(ProductStatus.Status.Approved);
    status.setName("approved");
    status.save();

    ProductStatus productStatus = ProductStatus.find.byId(ProductStatus.Status.Approved);
    assertThat(productStatus).isNotNull();

    /* Second call (ProductStatus.find.byId) causes exception:
           java.lang.NumberFormatException: For input string: "Approved"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.base/java.lang.Integer.parseInt(Integer.java:652)
        at java.base/java.lang.Integer.parseInt(Integer.java:770)
        at io.ebeaninternal.server.type.EnumToDbIntegerMap.getBeanValue(EnumToDbIntegerMap.java:40)
        at io.ebeaninternal.server.type.ScalarTypeEnumWithMapping.toBeanType(ScalarTypeEnumWithMapping.java:86)
        at io.ebeaninternal.server.deploy.id.IdBinderSimple.convertId(IdBinderSimple.java:236)
        at io.ebeaninternal.server.deploy.BeanDescriptor.convertId(BeanDescriptor.java:2150)
        at io.ebeaninternal.server.deploy.BeanDescriptorCacheHelp.loadBeanDirect(BeanDescriptorCacheHelp.java:630)
        at io.ebeaninternal.server.deploy.BeanDescriptorCacheHelp.loadBean(BeanDescriptorCacheHelp.java:613)
        at io.ebeaninternal.server.deploy.BeanDescriptorCacheHelp.convertToBean(BeanDescriptorCacheHelp.java:604)
        at io.ebeaninternal.server.deploy.BeanDescriptorCacheHelp.beanCacheGetInternal(BeanDescriptorCacheHelp.java:587)
        at io.ebeaninternal.server.deploy.BeanDescriptorCacheHelp.beanCacheGet(BeanDescriptorCacheHelp.java:566)
        at io.ebeaninternal.server.deploy.BeanDescriptor.cacheBeanGet(BeanDescriptor.java:1295)
        at io.ebeaninternal.server.core.DefaultServer.findIdCheckPersistenceContextAndCache(DefaultServer.java:1014)
        at io.ebeaninternal.server.core.DefaultServer.findId(DefaultServer.java:1041)
        at io.ebeaninternal.server.core.DefaultServer.find(DefaultServer.java:945)
        at io.ebeaninternal.server.core.DefaultServer.find(DefaultServer.java:935)
        at io.ebean.Finder.byId(Finder.java:159)
        at org.example.domain.CacheEntityEnumTest.cachedEntityRetrieveTest(CacheEntityEnumTest.java:42) */
    productStatus = ProductStatus.find.byId(ProductStatus.Status.Approved);
    assertThat(productStatus).isNotNull();
  }

}
