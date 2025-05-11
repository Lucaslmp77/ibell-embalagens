package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.StockInput;
import br.com.uniamerica.ibellembalagens.service.StockInputService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockInputControllerTest {

    @Mock
    private StockInputService stockInputService;

    @InjectMocks
    private StockInputController stockInputController;

    private StockInput stockInput;

    @BeforeEach
    void setUp() {
        stockInput = new StockInput();
        stockInput.setId(1L);
        stockInput.setInputQuantity(50F);
        stockInput.setCostValue(25.99F);
    }

    @Test
    void testSaveSuccess() {
        when(stockInputService.save(any(StockInput.class))).thenReturn(stockInput);

        ResponseEntity<?> response = stockInputController.save(stockInput);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Entrada de estoque cadastrada!", response.getBody());
        verify(stockInputService).save(stockInput);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar entrada de estoque");
        doThrow(exception).when(stockInputService).save(any(StockInput.class));

        ResponseEntity<?> response = stockInputController.save(stockInput);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar entrada de estoque", response.getBody());
    }

    @Test
    void testListAll() {
        List<StockInput> stockInputs = Arrays.asList(stockInput);
        when(stockInputService.listAll()).thenReturn(stockInputs);

        ResponseEntity<List<StockInput>> response = stockInputController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(stockInputService).listAll();
    }

    @Test
    void testFindById() {
        when(stockInputService.findById(1L)).thenReturn(stockInput);

        ResponseEntity<StockInput> response = stockInputController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockInput, response.getBody());
        verify(stockInputService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = stockInputController.update(1L, stockInput);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Entrada de estoque atualizada com sucesso!", response.getBody());
        verify(stockInputService).update(1L, stockInput);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(stockInputService).update(anyLong(), any(StockInput.class));

        ResponseEntity<?> response = stockInputController.update(1L, stockInput);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = stockInputController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Entrada de estoque desativada com sucesso!", response.getBody());
        verify(stockInputService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(stockInputService).disable(anyLong());

        ResponseEntity<?> response = stockInputController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = stockInputController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Entrada de estoque ativada com sucesso!", response.getBody());
        verify(stockInputService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(stockInputService).enabled(anyLong());

        ResponseEntity<?> response = stockInputController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByProductInStockInput() {
        List<StockInput> stockInputs = Arrays.asList(stockInput);
        when(stockInputService.findByProductInStockInput(1L)).thenReturn(stockInputs);

        ResponseEntity<?> response = stockInputController.findByProductInStockInput(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockInputs, response.getBody());
        verify(stockInputService).findByProductInStockInput(1L);
    }

    @Test
    void testFindByProviderInStockInput() {
        List<StockInput> stockInputs = Arrays.asList(stockInput);
        when(stockInputService.findByProviderInStockInput(1L)).thenReturn(stockInputs);

        ResponseEntity<?> response = stockInputController.findByProviderInStockInput(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockInputs, response.getBody());
        verify(stockInputService).findByProviderInStockInput(1L);
    }

    @Test
    void testFindByActiveStockInputs() {
        List<StockInput> activeStockInputs = Arrays.asList(stockInput);
        when(stockInputService.findByActiveStockInputs()).thenReturn(activeStockInputs);

        ResponseEntity<?> response = stockInputController.findByActiveStockInputs();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeStockInputs, response.getBody());
        verify(stockInputService).findByActiveStockInputs();
    }

    @Test
    void testFindByInactiveStockInputs() {
        List<StockInput> inactiveStockInputs = Arrays.asList(stockInput);
        when(stockInputService.findByInactiveStockInputs()).thenReturn(inactiveStockInputs);

        ResponseEntity<?> response = stockInputController.findByInactiveStockInputs();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveStockInputs, response.getBody());
        verify(stockInputService).findByInactiveStockInputs();
    }
}
