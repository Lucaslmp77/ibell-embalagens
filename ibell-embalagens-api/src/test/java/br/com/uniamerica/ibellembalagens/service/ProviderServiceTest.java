package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.Provider;
import br.com.uniamerica.ibellembalagens.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProviderServiceTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderService providerService;

    private Provider provider;

    @BeforeEach
    void setUp() {
        provider = new Provider();
        provider.setId(1L);
        provider.setName("Fornecedor Teste");
        provider.setCnpjCpf("12345678901234");
        provider.setPhoneNumber("999999999");
        provider.setAddres("Endereço Teste");
        provider.setEmail("fornecedor@teste.com");
    }

    @Test
    void testSave() {
        when(providerRepository.save(any(Provider.class))).thenReturn(provider);

        Provider savedProvider = providerService.save(provider);

        assertNotNull(savedProvider);
        assertEquals("Fornecedor Teste", savedProvider.getName());
        verify(providerRepository, times(1)).save(provider);
    }

    @Test
    void testListAll() {
        when(providerRepository.findAll()).thenReturn(Arrays.asList(provider));

        List<Provider> providers = providerService.listAll();

        assertEquals(1, providers.size());
        verify(providerRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));

        Provider foundProvider = providerService.findById(1L);

        assertNotNull(foundProvider);
        assertEquals(1L, foundProvider.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(providerRepository.findById(1L)).thenReturn(Optional.empty());

        Provider result = providerService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        when(providerRepository.save(any(Provider.class))).thenReturn(provider);

        providerService.update(1L, provider);

        verify(providerRepository, times(1)).save(provider);
    }

    @Test
    void testUpdateFailure() {
        Provider differentProvider = new Provider();
        differentProvider.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            providerService.update(1L, differentProvider);
        });
    }

    @Test
    void testDisableSuccess() {
        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));

        providerService.disable(1L);

        verify(providerRepository, times(1)).disable(1L);
    }

    @Test
    void testDisableFailure() {
        Provider differentProvider = new Provider();
        differentProvider.setId(2L);
        when(providerRepository.findById(1L)).thenReturn(Optional.of(differentProvider));

        assertThrows(RuntimeException.class, () -> {
            providerService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));

        providerService.enabled(1L);

        verify(providerRepository, times(1)).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        Provider differentProvider = new Provider();
        differentProvider.setId(2L);
        when(providerRepository.findById(1L)).thenReturn(Optional.of(differentProvider));

        assertThrows(RuntimeException.class, () -> {
            providerService.enabled(1L);
        });
    }

    @Test
    void testFindByActiveProviders() {
        when(providerRepository.findByActiveProviders()).thenReturn(Arrays.asList(provider));

        List<Provider> activeProviders = providerService.findByActiveProviders();

        assertEquals(1, activeProviders.size());
        verify(providerRepository, times(1)).findByActiveProviders();
    }

    @Test
    void testFindByInactiveProviders() {
        when(providerRepository.findByInactiveProviders()).thenReturn(Arrays.asList(provider));

        List<Provider> inactiveProviders = providerService.findByInactiveProviders();

        assertEquals(1, inactiveProviders.size());
        verify(providerRepository, times(1)).findByInactiveProviders();
    }
}