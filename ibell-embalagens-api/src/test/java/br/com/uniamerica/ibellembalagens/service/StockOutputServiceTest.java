package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.*;
import br.com.uniamerica.ibellembalagens.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockOutputServiceTest {

    @Mock
    private StockOutputRepository stockOutputRepository;

    @Mock
    private StockInputRepository stockInputRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private StockOutputService stockOutputService;

    private StockOutput stockOutput;
    private Product product;
    private Client client;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setQuantity(100f);
        product.setUnitValue(BigDecimal.valueOf(50.0));

        client = new Client();
        client.setId(1L);

        stockOutput = new StockOutput();
        stockOutput.setId(1L);
        stockOutput.setProduct(product);
        stockOutput.setClient(client);
        stockOutput.setQuantityOutput(10f);
        stockOutput.setSaleValue(BigDecimal.valueOf(500.0));
        stockOutput.setDepartureDate(LocalDateTime.now());
    }

    @Test
    void testSaveSuccess() {
        when(stockOutputRepository.save(any(StockOutput.class))).thenReturn(stockOutput);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.getQuantityByIdProduct(1L)).thenReturn(100f);
        when(stockOutputRepository.getSumOutputQuantity(1L)).thenReturn(10f);
        when(stockInputRepository.getSumInputQuantity(1L)).thenReturn(100f);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        StockOutput result = stockOutputService.save(stockOutput);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(stockOutputRepository, times(2)).save(stockOutput);
        verify(productRepository).save(product);
    }

    @Test
    void testSaveInsufficientQuantity() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.getQuantityByIdProduct(1L)).thenReturn(5f);
        stockOutput.setQuantityOutput(10f);

        assertThrows(RuntimeException.class, () -> {
            stockOutputService.save(stockOutput);
        });
    }

    @Test
    void testListAll() {
        when(stockOutputRepository.findAll()).thenReturn(Arrays.asList(stockOutput));

        List<StockOutput> result = stockOutputService.listAll();

        assertEquals(1, result.size());
        verify(stockOutputRepository).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.of(stockOutput));

        StockOutput result = stockOutputService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.empty());

        StockOutput result = stockOutputService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        stockOutput.setId(1L);
        when(stockOutputRepository.save(stockOutput)).thenReturn(stockOutput);

        stockOutputService.update(1L, stockOutput);

        verify(stockOutputRepository).save(stockOutput);
    }

    @Test
    void testUpdateFailure() {
        StockOutput differentOutput = new StockOutput();
        differentOutput.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            stockOutputService.update(1L, differentOutput);
        });
    }

    @Test
    void testDisableSuccess() {
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.of(stockOutput));

        stockOutputService.disable(1L);

        verify(stockOutputRepository).disable(1L);
    }

    @Test
    void testDisableFailure() {
        StockOutput differentOutput = new StockOutput();
        differentOutput.setId(2L);
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.of(differentOutput));

        assertThrows(RuntimeException.class, () -> {
            stockOutputService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.of(stockOutput));

        stockOutputService.enabled(1L);

        verify(stockOutputRepository).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        StockOutput differentOutput = new StockOutput();
        differentOutput.setId(2L);
        when(stockOutputRepository.findById(1L)).thenReturn(Optional.of(differentOutput));

        assertThrows(RuntimeException.class, () -> {
            stockOutputService.enabled(1L);
        });
    }

    @Test
    void testFindByProductInStockOutput() {
        when(stockOutputRepository.findByProductInStockOutput(1L)).thenReturn(Arrays.asList(stockOutput));

        List<StockOutput> result = stockOutputService.findByProductInStockOutput(1L);

        assertEquals(1, result.size());
        verify(stockOutputRepository).findByProductInStockOutput(1L);
    }

    @Test
    void testFindByClientInStockOutput() {
        when(stockOutputRepository.findByClientInStockOutput(1L)).thenReturn(Arrays.asList(stockOutput));

        List<StockOutput> result = stockOutputService.findByClientInStockOutput(1L);

        assertEquals(1, result.size());
        verify(stockOutputRepository).findByClientInStockOutput(1L);
    }

    @Test
    void testFindByActiveStockOutputs() {
        List<StockOutput> expectedList = Arrays.asList(stockOutput);
        when(stockOutputRepository.findByActiveStockOutputs()).thenReturn(expectedList);

        List<StockOutput> result = stockOutputService.findByActiveStockOutputs();

        assertEquals(1, result.size());
        verify(stockOutputRepository).findByActiveStockOutputs();
    }

    @Test
    void testFindByInactiveStockOutputs() {
        List<StockOutput> expectedList = Arrays.asList(stockOutput);
        when(stockOutputRepository.findByInactiveStockOutputs()).thenReturn(expectedList);

        List<StockOutput> result = stockOutputService.findByInactiveStockOutputs();

        assertEquals(1, result.size());
        verify(stockOutputRepository).findByInactiveStockOutputs();
    }
}