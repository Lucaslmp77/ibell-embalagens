package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;

class StockInputTest {

    private final Validator validator;

    public StockInputTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testStockInputInheritance() {
        StockInput stockInput = new StockInput();
        assertNull(stockInput.getId());
        assertNull(stockInput.getActive());
        assertNull(stockInput.getRegister());
        assertNull(stockInput.getUpdate());
    }

    @Test
    void testProduct() {
        StockInput stockInput = new StockInput();
        Product product = new Product();
        stockInput.setProduct(product);
        assertEquals(product, stockInput.getProduct());
    }

    @Test
    void testProvider() {
        StockInput stockInput = new StockInput();
        Provider provider = new Provider();
        stockInput.setProvider(provider);
        assertEquals(provider, stockInput.getProvider());
    }

    @Test
    void testCostValue() {
        StockInput stockInput = new StockInput();
        stockInput.setCostValue(150.50f);
        assertEquals(150.50f, stockInput.getCostValue());
    }

    @Test
    void testInputQuantity() {
        StockInput stockInput = new StockInput();
        stockInput.setInputQuantity(100f);
        assertEquals(100f, stockInput.getInputQuantity());
    }

    @Test
    void testDateEntry() {
        StockInput stockInput = new StockInput();
        Date now = new Date();
        stockInput.setDateEntry(now);
        assertEquals(now, stockInput.getDateEntry());
    }

    @Test
    void testObservation() {
        StockInput stockInput = new StockInput();
        stockInput.setObservation("Lote especial");
        assertEquals("Lote especial", stockInput.getObservation());
    }

    @Test
    void testPrePersistInheritance() {
        StockInput stockInput = new StockInput();
        stockInput.dateRegister();
        assertTrue(stockInput.getActive());
        assertNotNull(stockInput.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        StockInput stockInput = new StockInput();
        stockInput.dateUpdate();
        assertNotNull(stockInput.getUpdate());
    }
}