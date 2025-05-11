package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.Provider;
import br.com.uniamerica.ibellembalagens.service.ProviderService;
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
class ProviderControllerTest {

    @Mock
    private ProviderService providerService;

    @InjectMocks
    private ProviderController providerController;

    private Provider provider;

    @BeforeEach
    void setUp() {
        provider = new Provider();
        provider.setId(1L);
        provider.setName("Fornecedor Teste");
        provider.setCnpjCpf("12.345.678/0001-99");
    }

    @Test
    void testSaveSuccess() {
        when(providerService.save(any(Provider.class))).thenReturn(provider);

        ResponseEntity<?> response = providerController.save(provider);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fornecedor cadastrado!", response.getBody());
        verify(providerService).save(provider);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar fornecedor");
        doThrow(exception).when(providerService).save(any(Provider.class));

        ResponseEntity<?> response = providerController.save(provider);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar fornecedor", response.getBody());
    }

    @Test
    void testListAll() {
        List<Provider> providers = Arrays.asList(provider);
        when(providerService.listAll()).thenReturn(providers);

        ResponseEntity<List<Provider>> response = providerController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(providerService).listAll();
    }

    @Test
    void testFindById() {
        when(providerService.findById(1L)).thenReturn(provider);

        ResponseEntity<Provider> response = providerController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(provider, response.getBody());
        verify(providerService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = providerController.update(1L, provider);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fornecedor atualizado com sucesso!", response.getBody());
        verify(providerService).update(1L, provider);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(providerService).update(anyLong(), any(Provider.class));

        ResponseEntity<?> response = providerController.update(1L, provider);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = providerController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fornecedor desativado com sucesso!", response.getBody());
        verify(providerService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(providerService).disable(anyLong());

        ResponseEntity<?> response = providerController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = providerController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fornecedor ativado com sucesso!", response.getBody());
        verify(providerService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(providerService).enabled(anyLong());

        ResponseEntity<?> response = providerController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByActiveProviders() {
        List<Provider> activeProviders = Arrays.asList(provider);
        when(providerService.findByActiveProviders()).thenReturn(activeProviders);

        ResponseEntity<?> response = providerController.findByActiveProviders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeProviders, response.getBody());
        verify(providerService).findByActiveProviders();
    }

    @Test
    void testFindByInactiveProviders() {
        List<Provider> inactiveProviders = Arrays.asList(provider);
        when(providerService.findByInactiveProviders()).thenReturn(inactiveProviders);

        ResponseEntity<?> response = providerController.findByInactiveProviders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveProviders, response.getBody());
        verify(providerService).findByInactiveProviders();
    }
}
