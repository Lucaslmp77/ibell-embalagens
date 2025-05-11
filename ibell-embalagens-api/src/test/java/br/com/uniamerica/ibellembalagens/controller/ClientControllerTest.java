package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.Client;
import br.com.uniamerica.ibellembalagens.service.ClientService;
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
class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

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
        when(clientService.save(any(Client.class))).thenReturn(client);

        ResponseEntity<?> response = clientController.save(client);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente cadastrado!", response.getBody());
        verify(clientService).save(client);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar cliente");
        doThrow(exception).when(clientService).save(any(Client.class));

        ResponseEntity<?> response = clientController.save(client);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar cliente", response.getBody());
    }

    @Test
    void testListAll() {
        List<Client> clients = Arrays.asList(client);
        when(clientService.listAll()).thenReturn(clients);

        ResponseEntity<List<Client>> response = clientController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(clientService).listAll();
    }

    @Test
    void testFindById() {
        when(clientService.findById(1L)).thenReturn(client);

        ResponseEntity<Client> response = clientController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
        verify(clientService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = clientController.update(1L, client);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente atualizado com sucesso!", response.getBody());
        verify(clientService).update(1L, client);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(clientService).update(anyLong(), any(Client.class));

        ResponseEntity<?> response = clientController.update(1L, client);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = clientController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente desativado com sucesso!", response.getBody());
        verify(clientService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(clientService).disable(anyLong());

        ResponseEntity<?> response = clientController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = clientController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente ativado com sucesso!", response.getBody());
        verify(clientService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(clientService).enabled(anyLong());

        ResponseEntity<?> response = clientController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByActiveClients() {
        List<Client> activeClients = Arrays.asList(client);
        when(clientService.findByActiveClients()).thenReturn(activeClients);

        ResponseEntity<?> response = clientController.findByActiveClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeClients, response.getBody());
        verify(clientService).findByActiveClients();
    }

    @Test
    void testFindByInactiveClients() {
        List<Client> inactiveClients = Arrays.asList(client);
        when(clientService.findByInactiveClients()).thenReturn(inactiveClients);

        ResponseEntity<?> response = clientController.findByInactiveClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveClients, response.getBody());
        verify(clientService).findByInactiveClients();
    }
}