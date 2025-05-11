package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.StockOutput;
import br.com.uniamerica.ibellembalagens.service.StockOutputService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockOutputControllerTest {

    @Mock
    private StockOutputService stockOutputService;

    @InjectMocks
    private StockOutputController stockOutputController;

    private StockOutput stockOutput;

    @BeforeEach
    void setUp() {
        stockOutput = new StockOutput();
        stockOutput.setId(1L);
        stockOutput.setQuantityOutput(30F);
        stockOutput.setSaleValue(BigDecimal.valueOf(49.99));
    }

    @Test
    void testSaveSuccess() {
        when(stockOutputService.save(any(StockOutput.class))).thenReturn(stockOutput);

        ResponseEntity<?> response = stockOutputController.save(stockOutput);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Saida de estoque cadastrada!", response.getBody());
        verify(stockOutputService).save(stockOutput);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar saída de estoque");
        doThrow(exception).when(stockOutputService).save(any(StockOutput.class));

        ResponseEntity<?> response = stockOutputController.save(stockOutput);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar saída de estoque", response.getBody());
    }

    @Test
    void testListAll() {
        List<StockOutput> stockOutputs = Arrays.asList(stockOutput);
        when(stockOutputService.listAll()).thenReturn(stockOutputs);

        ResponseEntity<List<StockOutput>> response = stockOutputController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(stockOutputService).listAll();
    }

    @Test
    void testFindById() {
        when(stockOutputService.findById(1L)).thenReturn(stockOutput);

        ResponseEntity<StockOutput> response = stockOutputController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockOutput, response.getBody());
        verify(stockOutputService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = stockOutputController.update(1L, stockOutput);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Saida de estoque atualizada com sucesso!", response.getBody());
        verify(stockOutputService).update(1L, stockOutput);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(stockOutputService).update(anyLong(), any(StockOutput.class));

        ResponseEntity<?> response = stockOutputController.update(1L, stockOutput);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = stockOutputController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Saida de estoque desativada com sucesso!", response.getBody());
        verify(stockOutputService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(stockOutputService).disable(anyLong());

        ResponseEntity<?> response = stockOutputController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = stockOutputController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Saida de estoque ativada com sucesso!", response.getBody());
        verify(stockOutputService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(stockOutputService).enabled(anyLong());

        ResponseEntity<?> response = stockOutputController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByProductInStockOutput() {
        List<StockOutput> stockOutputs = Arrays.asList(stockOutput);
        when(stockOutputService.findByProductInStockOutput(1L)).thenReturn(stockOutputs);

        ResponseEntity<?> response = stockOutputController.findByProductInStockOutput(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockOutputs, response.getBody());
        verify(stockOutputService).findByProductInStockOutput(1L);
    }

    @Test
    void testFindByClientInStockOutput() {
        List<StockOutput> stockOutputs = Arrays.asList(stockOutput);
        when(stockOutputService.findByClientInStockOutput(1L)).thenReturn(stockOutputs);

        ResponseEntity<?> response = stockOutputController.findByClientInStockOutput(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockOutputs, response.getBody());
        verify(stockOutputService).findByClientInStockOutput(1L);
    }

    @Test
    void testFindByActiveStockOutputs() {
        List<StockOutput> activeStockOutputs = Arrays.asList(stockOutput);
        when(stockOutputService.findByActiveStockOutputs()).thenReturn(activeStockOutputs);

        ResponseEntity<?> response = stockOutputController.findByActiveStockOutputs();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeStockOutputs, response.getBody());
        verify(stockOutputService).findByActiveStockOutputs();
    }

    @Test
    void testFindByInactiveStockOutputs() {
        List<StockOutput> inactiveStockOutputs = Arrays.asList(stockOutput);
        when(stockOutputService.findByInactiveStockOutputs()).thenReturn(inactiveStockOutputs);

        ResponseEntity<?> response = stockOutputController.findByInactiveStockOutputs();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveStockOutputs, response.getBody());
        verify(stockOutputService).findByInactiveStockOutputs();
    }
}
