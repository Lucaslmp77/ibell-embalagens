package br.com.uniamerica.ibellembalagens.controller;

import br.com.uniamerica.ibellembalagens.entity.Administrator;
import br.com.uniamerica.ibellembalagens.service.AdministratorService;
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
class AdministratorControllerTest {

    @Mock
    private AdministratorService administratorService;

    @InjectMocks
    private AdministratorController administratorController;

    private Administrator administrator;

    @BeforeEach
    void setUp() {
        administrator = new Administrator();
        administrator.setId(1L);
        administrator.setUsername("admin");
        administrator.setPassword("password");
    }

    @Test
    void testSaveSuccess() {
        when(administratorService.save(any(Administrator.class))).thenReturn(administrator);

        ResponseEntity<?> response = administratorController.save(administrator);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Administrador cadastrado!", response.getBody());
        verify(administratorService).save(administrator);
    }

    @Test
    void testSaveFailure() {
        RuntimeException exception = new RuntimeException("Erro ao salvar");
        doThrow(exception).when(administratorService).save(any(Administrator.class));

        ResponseEntity<?> response = administratorController.save(administrator);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar", response.getBody());
    }

    @Test
    void testListAll() {
        List<Administrator> admins = Arrays.asList(administrator);
        when(administratorService.listAll()).thenReturn(admins);

        ResponseEntity<List<Administrator>> response = administratorController.listAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(administratorService).listAll();
    }

    @Test
    void testFindById() {
        when(administratorService.findById(1L)).thenReturn(administrator);

        ResponseEntity<Administrator> response = administratorController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(administrator, response.getBody());
        verify(administratorService).findById(1L);
    }

    @Test
    void testUpdateSuccess() {
        ResponseEntity<?> response = administratorController.update(1L, administrator);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Administrador atualizado com sucesso!", response.getBody());
        verify(administratorService).update(1L, administrator);
    }

    @Test
    void testUpdateFailure() {
        RuntimeException exception = new RuntimeException("Erro na atualização");
        doThrow(exception).when(administratorService).update(anyLong(), any(Administrator.class));

        ResponseEntity<?> response = administratorController.update(1L, administrator);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro na atualização", response.getBody());
    }

    @Test
    void testDisableSuccess() {
        ResponseEntity<?> response = administratorController.disable(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Administrador desativado com sucesso!", response.getBody());
        verify(administratorService).disable(1L);
    }

    @Test
    void testDisableFailure() {
        RuntimeException exception = new RuntimeException("Erro ao desativar");
        doThrow(exception).when(administratorService).disable(anyLong());

        ResponseEntity<?> response = administratorController.disable(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao desativar", response.getBody());
    }

    @Test
    void testEnabledSuccess() {
        ResponseEntity<?> response = administratorController.enabled(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Administrador ativado com sucesso!", response.getBody());
        verify(administratorService).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        RuntimeException exception = new RuntimeException("Erro ao ativar");
        doThrow(exception).when(administratorService).enabled(anyLong());

        ResponseEntity<?> response = administratorController.enabled(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao ativar", response.getBody());
    }

    @Test
    void testFindByActiveAdm() {
        List<Administrator> activeAdmins = Arrays.asList(administrator);
        when(administratorService.findByActiveAdm()).thenReturn(activeAdmins);

        ResponseEntity<?> response = administratorController.findByActiveAdm();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(activeAdmins, response.getBody());
        verify(administratorService).findByActiveAdm();
    }

    @Test
    void testFindByInactiveAdm() {
        List<Administrator> inactiveAdmins = Arrays.asList(administrator);
        when(administratorService.findByInactiveAdm()).thenReturn(inactiveAdmins);

        ResponseEntity<?> response = administratorController.findByInactiveAdm();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inactiveAdmins, response.getBody());
        verify(administratorService).findByInactiveAdm();
    }

    //Falhas controladas
    @Test
    void testFalha3_SaveSemValidarDadosEntrada() {
        Administrator invalidAdmin = new Administrator();
        invalidAdmin.setUsername("a"); // Username muito curto
        invalidAdmin.setPassword("1"); // Password muito curto

        when(administratorService.save(any())).thenReturn(invalidAdmin);

        ResponseEntity<?> response = administratorController.save(invalidAdmin);

        // Deveria ser BAD_REQUEST mas é OK (falha no controller)
        assertEquals(HttpStatus.OK, response.getStatusCode(),
                "Deveria validar dados antes de processar");
    }

    @Test
    void testFalha4_FindByIdRetorna200ParaNaoEncontrado() {
        Administrator emptyAdmin = new Administrator(); // Objeto vazio
        when(administratorService.findById(1L)).thenReturn(emptyAdmin);

        ResponseEntity<Administrator> response = administratorController.findById(1L);

        // Deveria ser NOT_FOUND mas é OK (falha no controller)
        assertEquals(HttpStatus.OK, response.getStatusCode(),
                "Deveria retornar 404 quando admin não existe");
    }
}