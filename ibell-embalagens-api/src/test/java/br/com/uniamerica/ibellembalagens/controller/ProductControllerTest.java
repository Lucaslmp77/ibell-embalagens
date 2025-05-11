package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.Product;
import br.com.uniamerica.ibellembalagens.service.ProductService;
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
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setCode("PROD001");
        product.setProductName("Notebook");
        product.setQuantity(10.0F);
        product.setUnitValue(BigDecimal.valueOf(1999.99));
    }

    @Test
    void testSaveSuccess() {
        when(productService.save(any(Product.class))).thenReturn(product);

        ResponseEntity<?> response = productController.save(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto cadastrado!", response.getBody());
        verify(productService).save(product);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar produto");
        doThrow(exception).when(productService).save(any(Product.class));

        ResponseEntity<?> response = productController.save(product);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar produto", response.getBody());
    }

    @Test
    void testListAll() {
        List<Product> products = Arrays.asList(product);
        when(productService.listAll()).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(productService).listAll();
    }

    @Test
    void testFindById() {
        when(productService.findById(1L)).thenReturn(product);

        ResponseEntity<Product> response = productController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = productController.update(1L, product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto atualizado com sucesso!", response.getBody());
        verify(productService).update(1L, product);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(productService).update(anyLong(), any(Product.class));

        ResponseEntity<?> response = productController.update(1L, product);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = productController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto desativado com sucesso!", response.getBody());
        verify(productService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(productService).disable(anyLong());

        ResponseEntity<?> response = productController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = productController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto ativado com sucesso!", response.getBody());
        verify(productService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(productService).enabled(anyLong());

        ResponseEntity<?> response = productController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByActiveProducts() {
        List<Product> activeProducts = Arrays.asList(product);
        when(productService.findByActiveProducts()).thenReturn(activeProducts);

        ResponseEntity<?> response = productController.findByActiveProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeProducts, response.getBody());
        verify(productService).findByActiveProducts();
    }

    @Test
    void testFindByInactiveProducts() {
        List<Product> inactiveProducts = Arrays.asList(product);
        when(productService.findByInactiveProducts()).thenReturn(inactiveProducts);

        ResponseEntity<?> response = productController.findByInactiveProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveProducts, response.getBody());
        verify(productService).findByInactiveProducts();
    }
}