package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.Client;
import br.com.uniamerica.ibellembalagens.repository.ClientRepository;
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
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
        client.setId(1L);
        client.setName("Cliente Teste");
        client.setCnpjCpf("12345678901");
        client.setPhoneNumber("999999999");
        client.setEmail("teste@teste.com");
    }

    @Test
    void testSaveSuccess() {
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        Client savedClient = clientService.save(client);

        assertNotNull(savedClient);
        assertEquals("Cliente Teste", savedClient.getName());
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testListAll() {
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client));

        List<Client> clients = clientService.listAll();

        assertEquals(1, clients.size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client foundClient = clientService.findById(1L);

        assertNotNull(foundClient);
        assertEquals(1L, foundClient.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        Client result = clientService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        clientService.update(1L, client);

        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testUpdateFailure() {
        Client differentClient = new Client();
        differentClient.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            clientService.update(1L, differentClient);
        });
    }

    @Test
    void testDisableSuccess() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        clientService.disable(1L);

        verify(clientRepository, times(1)).disable(1L);
    }

    @Test
    void testDisableFailure() {
        Client differentClient = new Client();
        differentClient.setId(2L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(differentClient));

        assertThrows(RuntimeException.class, () -> {
            clientService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        clientService.enabled(1L);

        verify(clientRepository, times(1)).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        Client differentClient = new Client();
        differentClient.setId(2L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(differentClient));

        assertThrows(RuntimeException.class, () -> {
            clientService.enabled(1L);
        });
    }

    @Test
    void testFindByActiveClients() {
        when(clientRepository.findByActiveClients()).thenReturn(Arrays.asList(client));

        List<Client> activeClients = clientService.findByActiveClients();

        assertEquals(1, activeClients.size());
        verify(clientRepository, times(1)).findByActiveClients();
    }

    @Test
    void testFindByInactiveClients() {
        when(clientRepository.findByInactiveClients()).thenReturn(Arrays.asList(client));

        List<Client> inactiveClients = clientService.findByInactiveClients();

        assertEquals(1, inactiveClients.size());
        verify(clientRepository, times(1)).findByInactiveClients();
    }

    //Falhas controladas
    @Test
    void testFalha3_ComCnpjCpfDuplicado_DeveLancarExcecao() {
        Client existing = new Client();
        existing.setCnpjCpf("12345678900");

        when(clientRepository.findByCnpjCpf("12345678900")).thenReturn(Optional.of(existing));

        Client novo = new Client();
        novo.setCnpjCpf("12345678900");

        assertThrows(RuntimeException.class, () -> clientService.save(novo),
                "Exceção ao tentar salvar CNPJ/CPF duplicado");

        verify(clientRepository, never()).save(novo);
        verify(clientRepository).findByCnpjCpf("12345678900");
    }
}