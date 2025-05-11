package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;

class ProductTest {

    private final Validator validator;

    public ProductTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testProductInheritance() {
        Product product = new Product();
        assertNull(product.getId());
        assertNull(product.getActive());
        assertNull(product.getRegister());
        assertNull(product.getUpdate());
    }

    @Test
    void testCode() {
        Product product = new Product();
        product.setCode("PROD001");
        assertEquals("PROD001", product.getCode());
    }

    @Test
    void testProductName() {
        Product product = new Product();
        product.setProductName("Notebook");
        assertEquals("Notebook", product.getProductName());
    }

    @Test
    void testQuantity() {
        Product product = new Product();
        product.setQuantity(10.5f);
        assertEquals(10.5f, product.getQuantity());
    }

    @Test
    void testUnitValue() {
        Product product = new Product();
        product.setUnitValue(new BigDecimal("99.99"));
        assertEquals(new BigDecimal("99.99"), product.getUnitValue());
    }

    @Test
    void testUnitMeasure() {
        Product product = new Product();
        product.setUnitMeasure(UnitMeasure.UNIDADE);
        assertEquals(UnitMeasure.UNIDADE, product.getUnitMeasure());
    }

    @Test
    void testProvider() {
        Product product = new Product();
        Provider provider = new Provider();
        product.setProvider(provider);
        assertEquals(provider, product.getProvider());
    }

    @Test
    void testObservation() {
        Product product = new Product();
        product.setObservation("Fragile product");
        assertEquals("Fragile product", product.getObservation());
    }

    @Test
    void testUniqueConstraints() {
        Product product1 = new Product();
        product1.setCode("PROD001");
        product1.setProductName("Product 1");
        product1.setQuantity(1f);
        product1.setUnitMeasure(UnitMeasure.UNIDADE);
        product1.setProvider(new Provider());

        Product product2 = new Product();
        product2.setCode("PROD001");
        product2.setProductName("Product 1");
        product2.setQuantity(1f);
        product2.setUnitMeasure(UnitMeasure.UNIDADE);
        product2.setProvider(new Provider());

        assertTrue(validator.validate(product1).isEmpty());
        assertTrue(validator.validate(product2).isEmpty());
    }

    @Test
    void testPrePersistInheritance() {
        Product product = new Product();
        product.dateRegister();
        assertTrue(product.getActive());
        assertNotNull(product.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        Product product = new Product();
        product.dateUpdate();
        assertNotNull(product.getUpdate());
    }
}