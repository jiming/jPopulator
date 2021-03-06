package io.github.benas.jpopulator.test;

import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.beans.JSR349AnnotatedBean;
import io.github.benas.jpopulator.impl.PopulatorBuilder;
import org.junit.Assert;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class to test validity of values generated for bean validation annotated fields.
 *
 * @author Mahmoud Ben Hassine (md.benhassine@gmail.com)
 */
public class BeanValidationTest {

    /**
     * The populator to test.
     */
    private Populator populator;

    @Before
    public void setUp() throws Exception {
        populator = new PopulatorBuilder().build();
    }

    @org.junit.Test
    public void testGeneratedValuesValidity() throws Exception {
        JSR349AnnotatedBean bean = populator.populateBean(JSR349AnnotatedBean.class);
        Assert.assertNotNull(bean);
        Assert.assertFalse(bean.isUnsupported());// @AssertFalse boolean unsupported;
        Assert.assertTrue(bean.isActive());// @AssertFalse boolean active;
        Assert.assertNull(bean.getUnusedString());// @Null String unusedString;
        Assert.assertNotNull(bean.getUsername());// @NotNull String username;
        Assert.assertTrue(bean.getBirthday().before(new Date()));// @Future Date eventDate;
        Assert.assertTrue(bean.getEventDate().after(new Date()));// @Past Date birthday;
        Assert.assertTrue(bean.getMaxQuantity() <= 10);// @Max(10) int maxQuantity;
        Assert.assertTrue(bean.getMinQuantity() >= 5);// @Min(5) int minQuantity;
        Assert.assertTrue(bean.getMaxDiscount().compareTo(new BigDecimal("30.00")) <= 0);// @DecimalMax("30.00") BigDecimal maxDiscount;;
        Assert.assertTrue(bean.getMinDiscount().compareTo(new BigDecimal("5.00")) >= 0);// @DecimalMin("5.00") BigDecimal minDiscount;;
        Assert.assertTrue(bean.getMinQuantity() >= 5);// @Min(5) int minQuantity;
        Assert.assertTrue(bean.getBriefMessage().length() >= 2 && bean.getBriefMessage().length() <= 10);// @Size(min=2, max=10) String briefMessage;
    }

}
