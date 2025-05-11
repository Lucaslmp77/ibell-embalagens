package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class ProviderTest {

    private final Validator validator;

    public ProviderTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testProviderInheritance() {
        Provider provider = new Provider();
        assertNull(provider.getId());
        assertNull(provider.getActive());
        assertNull(provider.getRegister());
        assertNull(provider.getUpdate());
    }

    @Test
    void testName() {
        Provider provider = new Provider();
        provider.setName("Fornecedor XYZ");
        assertEquals("Fornecedor XYZ", provider.getName());
    }

    @Test
    void testCnpjCpf() {
        Provider provider = new Provider();
        provider.setCnpjCpf("12.345.678/0001-99");
        assertEquals("12.345.678/0001-99", provider.getCnpjCpf());
    }

    @Test
    void testPhoneNumber() {
        Provider provider = new Provider();
        provider.setPhoneNumber("(41) 99999-9999");
        assertEquals("(41) 99999-9999", provider.getPhoneNumber());
    }

    @Test
    void testAddres() {
        Provider provider = new Provider();
        provider.setAddres("Rua Principal, 123");
        assertEquals("Rua Principal, 123", provider.getAddres());
    }

    @Test
    void testEmail() {
        Provider provider = new Provider();
        provider.setEmail("contato@fornecedor.com");
        assertEquals("contato@fornecedor.com", provider.getEmail());
    }

    @Test
    void testObservation() {
        Provider provider = new Provider();
        provider.setObservation("Entrega apenas dias úteis");
        assertEquals("Entrega apenas dias úteis", provider.getObservation());
    }

    @Test
    void testEmailValidation() {
        Provider provider = new Provider();
        provider.setName("Fornecedor");
        provider.setCnpjCpf("12345678901234");
        provider.setPhoneNumber("41999999999");
        provider.setAddres("Endereço");
        provider.setEmail("email-invalido");

        assertFalse(validator.validate(provider).isEmpty());
    }

    @Test
    void testPrePersistInheritance() {
        Provider provider = new Provider();
        provider.dateRegister();
        assertTrue(provider.getActive());
        assertNotNull(provider.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        Provider provider = new Provider();
        provider.dateUpdate();
        assertNotNull(provider.getUpdate());
    }
}