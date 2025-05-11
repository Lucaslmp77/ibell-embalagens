package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;

class StockOutputTest {

    private final Validator validator;

    public StockOutputTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testStockOutputInheritance() {
        StockOutput stockOutput = new StockOutput();
        assertNull(stockOutput.getId());
        assertNull(stockOutput.getActive());
        assertNull(stockOutput.getRegister());
        assertNull(stockOutput.getUpdate());
    }

    @Test
    void testClient() {
        StockOutput stockOutput = new StockOutput();
        Client client = new Client();
        stockOutput.setClient(client);
        assertEquals(client, stockOutput.getClient());
    }

    @Test
    void testProduct() {
        StockOutput stockOutput = new StockOutput();
        Product product = new Product();
        stockOutput.setProduct(product);
        assertEquals(product, stockOutput.getProduct());
    }

    @Test
    void testQuantityOutput() {
        StockOutput stockOutput = new StockOutput();
        stockOutput.setQuantityOutput(50.5f);
        assertEquals(50.5f, stockOutput.getQuantityOutput());
    }

    @Test
    void testSaleValue() {
        StockOutput stockOutput = new StockOutput();
        BigDecimal value = new BigDecimal("199.99");
        stockOutput.setSaleValue(value);
        assertEquals(value, stockOutput.getSaleValue());
    }

    @Test
    void testDepartureDate() {
        StockOutput stockOutput = new StockOutput();
        LocalDateTime now = LocalDateTime.now();
        stockOutput.setDepartureDate(now);
        assertEquals(now, stockOutput.getDepartureDate());
    }

    @Test
    void testObservation() {
        StockOutput stockOutput = new StockOutput();
        stockOutput.setObservation("Entrega urgente");
        assertEquals("Entrega urgente", stockOutput.getObservation());
    }

    @Test
    void testPrePersistInheritance() {
        StockOutput stockOutput = new StockOutput();
        stockOutput.dateRegister();
        assertTrue(stockOutput.getActive());
        assertNotNull(stockOutput.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        StockOutput stockOutput = new StockOutput();
        stockOutput.dateUpdate();
        assertNotNull(stockOutput.getUpdate());
    }
}