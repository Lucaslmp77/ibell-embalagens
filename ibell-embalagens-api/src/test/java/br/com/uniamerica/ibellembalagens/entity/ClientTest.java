package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class ClientTest {

    private final Validator validator;

    public ClientTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testClientInheritance() {
        Client client = new Client();
        assertNull(client.getId());
        assertNull(client.getActive());
        assertNull(client.getRegister());
        assertNull(client.getUpdate());
    }

    @Test
    void testName() {
        Client client = new Client();
        client.setName("John Doe");
        assertEquals("John Doe", client.getName());
    }

    @Test
    void testCnpjCpf() {
        Client client = new Client();
        client.setCnpjCpf("123.456.789-09");
        assertEquals("123.456.789-09", client.getCnpjCpf());
    }

    @Test
    void testPhoneNumber() {
        Client client = new Client();
        client.setPhoneNumber("(99) 99999-9999");
        assertEquals("(99) 99999-9999", client.getPhoneNumber());
    }

    @Test
    void testAddress() {
        Client client = new Client();
        client.setAddress("123 Main St");
        assertEquals("123 Main St", client.getAddress());
    }

    @Test
    void testEmail() {
        Client client = new Client();
        client.setEmail("test@example.com");
        assertEquals("test@example.com", client.getEmail());
    }

    @Test
    void testObservation() {
        Client client = new Client();
        client.setObservation("Special instructions");
        assertEquals("Special instructions", client.getObservation());
    }

    @Test
    void testEmailValidation() {
        Client client = new Client();
        client.setName("Test");
        client.setCnpjCpf("12345678909");
        client.setPhoneNumber("999999999");
        client.setAddress("Address");
        client.setEmail("invalid-email");

        assertFalse(validator.validate(client).isEmpty());
    }

    @Test
    void testPrePersistInheritance() {
        Client client = new Client();
        client.dateRegister();
        assertTrue(client.getActive());
        assertNotNull(client.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        Client client = new Client();
        client.dateUpdate();
        assertNotNull(client.getUpdate());
    }
}