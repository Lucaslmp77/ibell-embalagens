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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockInputServiceTest {

    @Mock
    private StockInputRepository stockInputRepository;

    @Mock
    private StockOutputRepository stockOutputRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private StockInputService stockInputService;

    private StockInput stockInput;
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setQuantity(100f);
        product.setUnitValue(BigDecimal.valueOf(50.0));

        Provider provider = new Provider();
        provider.setId(1L);

        stockInput = new StockInput();
        stockInput.setId(1L);
        stockInput.setProduct(product);
        stockInput.setProvider(provider);
        stockInput.setInputQuantity(50f);
        stockInput.setCostValue(2500f);
    }

    @Test
    void testSave() {
        when(stockInputRepository.save(any(StockInput.class))).thenReturn(stockInput);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(stockOutputRepository.getSumOutputQuantity(1L)).thenReturn(30f);
        when(stockInputRepository.getSumInputQuantity(1L)).thenReturn(150f);
        when(stockInputRepository.updateNewCostValue(1L)).thenReturn(5000.0F);
        when(productRepository.getQuantityByIdProduct(1L)).thenReturn(120f);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        StockInput result = stockInputService.save(stockInput);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(stockInputRepository, times(2)).save(stockInput);
        verify(productRepository).save(product);
    }

    @Test
    void testSaveWithNullOutputSum() {
        when(stockInputRepository.save(any(StockInput.class))).thenReturn(stockInput);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(stockOutputRepository.getSumOutputQuantity(1L)).thenReturn(null);
        when(stockInputRepository.getSumInputQuantity(1L)).thenReturn(150f);
        when(stockInputRepository.updateNewCostValue(1L)).thenReturn(5000.0F);
        when(productRepository.getQuantityByIdProduct(1L)).thenReturn(150f);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        StockInput result = stockInputService.save(stockInput);

        assertNotNull(result);
        verify(stockInputRepository, times(2)).save(stockInput);
    }

    @Test
    void testListAll() {
        when(stockInputRepository.findAll()).thenReturn(Arrays.asList(stockInput));

        List<StockInput> result = stockInputService.listAll();

        assertEquals(1, result.size());
        verify(stockInputRepository).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(stockInputRepository.findById(1L)).thenReturn(Optional.of(stockInput));

        StockInput result = stockInputService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(stockInputRepository.findById(1L)).thenReturn(Optional.empty());

        StockInput result = stockInputService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        stockInput.setId(1L);

        when(stockInputRepository.save(stockInput)).thenReturn(stockInput);

        stockInputService.update(1L, stockInput);

        verify(stockInputRepository).save(stockInput);
    }

    @Test
    void testUpdateFailure() {
        StockInput differentInput = new StockInput();
        differentInput.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            stockInputService.update(1L, differentInput);
        });
    }

    @Test
    void testDisableSuccess() {
        when(stockInputRepository.findById(1L)).thenReturn(Optional.of(stockInput));

        stockInputService.disable(1L);

        verify(stockInputRepository).disable(1L);
    }

    @Test
    void testDisableFailure() {
        StockInput differentInput = new StockInput();
        differentInput.setId(2L);
        when(stockInputRepository.findById(1L)).thenReturn(Optional.of(differentInput));

        assertThrows(RuntimeException.class, () -> {
            stockInputService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(stockInputRepository.findById(1L)).thenReturn(Optional.of(stockInput));

        stockInputService.enabled(1L);

        verify(stockInputRepository).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        StockInput differentInput = new StockInput();
        differentInput.setId(2L);
        when(stockInputRepository.findById(1L)).thenReturn(Optional.of(differentInput));

        assertThrows(RuntimeException.class, () -> {
            stockInputService.enabled(1L);
        });
    }

    @Test
    void testFindByProductInStockInput() {
        when(stockInputRepository.findByProductInStockInput(1L)).thenReturn(Arrays.asList(stockInput));

        List<StockInput> result = stockInputService.findByProductInStockInput(1L);

        assertEquals(1, result.size());
        verify(stockInputRepository).findByProductInStockInput(1L);
    }

    @Test
    void testFindByProviderInStockInput() {
        when(stockInputRepository.findByProviderInStockInput(1L)).thenReturn(Arrays.asList(stockInput));

        List<StockInput> result = stockInputService.findByProviderInStockInput(1L);

        assertEquals(1, result.size());
        verify(stockInputRepository).findByProviderInStockInput(1L);
    }

    @Test
    void testFindByActiveStockInputs() {
        ArrayList<StockInput> expectedList = new ArrayList<>(Arrays.asList(stockInput));
        when(stockInputRepository.findByActiveStockInputs()).thenReturn(expectedList);

        List<StockInput> result = stockInputService.findByActiveStockInputs();

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(expectedList, result)
        );
        verify(stockInputRepository).findByActiveStockInputs();
    }

    @Test
    void testFindByInactiveStockInputs() {
        when(stockInputRepository.findByInactiveStockInputs()).thenReturn(Arrays.asList(stockInput));

        List<StockInput> result = stockInputService.findByInactiveStockInputs();

        assertEquals(1, result.size());
        verify(stockInputRepository).findByInactiveStockInputs();
    }
}