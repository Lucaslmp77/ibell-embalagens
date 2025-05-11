package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.Administrator;
import br.com.uniamerica.ibellembalagens.repository.AdministratorRepository;
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
class AdministratorServiceTest {

    @Mock
    private AdministratorRepository administratorRepository;

    @InjectMocks
    private AdministratorService administratorService;

    private Administrator administrator;

    @BeforeEach
    void setUp() {
        administrator = new Administrator();
        administrator.setId(1L);
        administrator.setUsername("admin");
        administrator.setPassword("password");
    }

    @Test
    void testSave() {
        when(administratorRepository.save(any(Administrator.class))).thenReturn(administrator);

        Administrator saved = administratorService.save(administrator);

        assertNotNull(saved);
        assertEquals("admin", saved.getUsername());
        verify(administratorRepository, times(1)).save(administrator);
    }

    @Test
    void testListAll() {
        when(administratorRepository.findAll()).thenReturn(Arrays.asList(administrator));

        List<Administrator> result = administratorService.listAll();

        assertEquals(1, result.size());
        verify(administratorRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(administratorRepository.findById(1L)).thenReturn(Optional.of(administrator));

        Administrator found = administratorService.findById(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(administratorRepository.findById(1L)).thenReturn(Optional.empty());

        Administrator result = administratorService.findById(1L);

        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testUpdateSuccess() {
        when(administratorRepository.save(any(Administrator.class))).thenReturn(administrator);

        administratorService.update(1L, administrator);

        verify(administratorRepository, times(1)).save(administrator);
    }

    @Test
    void testUpdateFailure() {
        Administrator differentAdmin = new Administrator();
        differentAdmin.setId(2L);

        assertThrows(RuntimeException.class, () -> {
            administratorService.update(1L, differentAdmin);
        });
    }

    @Test
    void testDisableSuccess() {
        when(administratorRepository.findById(1L)).thenReturn(Optional.of(administrator));

        administratorService.disable(1L);

        verify(administratorRepository, times(1)).disable(1L);
    }

    @Test
    void testDisableFailure() {
        Administrator differentAdmin = new Administrator();
        differentAdmin.setId(2L);
        when(administratorRepository.findById(1L)).thenReturn(Optional.of(differentAdmin));

        assertThrows(RuntimeException.class, () -> {
            administratorService.disable(1L);
        });
    }

    @Test
    void testEnabledSuccess() {
        when(administratorRepository.findById(1L)).thenReturn(Optional.of(administrator));

        administratorService.enabled(1L);

        verify(administratorRepository, times(1)).enabled(1L);
    }

    @Test
    void testEnabledFailure() {
        Administrator differentAdmin = new Administrator();
        differentAdmin.setId(2L);
        when(administratorRepository.findById(1L)).thenReturn(Optional.of(differentAdmin));

        assertThrows(RuntimeException.class, () -> {
            administratorService.enabled(1L);
        });
    }

    @Test
    void testFindByActiveAdm() {
        when(administratorRepository.findByActiveAdm()).thenReturn(Arrays.asList(administrator));

        List<Administrator> result = administratorService.findByActiveAdm();

        assertEquals(1, result.size());
        verify(administratorRepository, times(1)).findByActiveAdm();
    }

    @Test
    void testFindByInactiveAdm() {
        when(administratorRepository.findByInactiveAdm()).thenReturn(Arrays.asList(administrator));

        List<Administrator> result = administratorService.findByInactiveAdm();

        assertEquals(1, result.size());
        verify(administratorRepository, times(1)).findByInactiveAdm();
    }
}