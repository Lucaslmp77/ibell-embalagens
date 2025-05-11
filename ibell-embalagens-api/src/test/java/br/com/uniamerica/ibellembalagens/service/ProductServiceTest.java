package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.Product;
import br.com.uniamerica.ibellembalagens.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

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
    void testSaveWithNullQuantity() {
        Product newProduct = new Product();
        newProduct.setCode("PROD002");
        newProduct.setProductName("Mouse");
        newProduct.setQuantity(null);

        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product savedProduct = productService.save(newProduct);

        assertEquals(0.0F, savedProduct.getQuantity());
        assertEquals(BigDecimal.ZERO, savedProduct.getUnitValue());
        verify(productRepository, times(1)).save(newProduct);
    }

    @Test
    void testSaveWithValidQuantity() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product savedProduct = productService.save(product);

        assertEquals(10.0F, savedProduct.getQuantity());
        assertEquals(BigDecimal.valueOf(1999.99), savedProduct.getUnitValue());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testListAll() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));

        List<Product> products = productService.listAll();

        assertEquals(1, products.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product foundProduct = productService.findById(1L);

        assertNotNull(foundProduct);
        assertEquals(1L, foundProduct.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        Product result = productService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        productService.update(1L, product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testUpdateFailure() {
        Product differentProduct = new Product();
        differentProduct.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            productService.update(1L, differentProduct);
        });
    }

    @Test
    void testDisableSuccess() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        productService.disable(1L);

        verify(productRepository, times(1)).disable(1L);
    }

    @Test
    void testDisableFailure() {
        Product differentProduct = new Product();
        differentProduct.setId(2L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(differentProduct));

        assertThrows(RuntimeException.class, () -> {
            productService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        productService.enabled(1L);

        verify(productRepository, times(1)).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        Product differentProduct = new Product();
        differentProduct.setId(2L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(differentProduct));

        assertThrows(RuntimeException.class, () -> {
            productService.enabled(1L);
        });
    }

    @Test
    void testFindByActiveProducts() {
        when(productRepository.findByActiveProducts()).thenReturn(Arrays.asList(product));

        List<Product> activeProducts = productService.findByActiveProducts();

        assertEquals(1, activeProducts.size());
        verify(productRepository, times(1)).findByActiveProducts();
    }

    @Test
    void testFindByInactiveProducts() {
        when(productRepository.findByInactiveProducts()).thenReturn(Arrays.asList(product));

        List<Product> inactiveProducts = productService.findByInactiveProducts();

        assertEquals(1, inactiveProducts.size());
        verify(productRepository, times(1)).findByInactiveProducts();
    }
}