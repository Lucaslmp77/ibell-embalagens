package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class AdministratorTest {

    private final Validator validator;

    public AdministratorTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testAdministratorInheritance() {
        Administrator admin = new Administrator();
        assertNull(admin.getId());
        assertNull(admin.getActive());
        assertNull(admin.getRegister());
        assertNull(admin.getUpdate());
    }

    @Test
    void testUsername() {
        Administrator admin = new Administrator();
        String validUsername = "admin123";
        admin.setUsername(validUsername);
        assertEquals(validUsername, admin.getUsername());
    }

    @Test
    void testPassword() {
        Administrator admin = new Administrator();
        String validPassword = "senha123";
        admin.setPassword(validPassword);
        assertEquals(validPassword, admin.getPassword());
    }

    @Test
    void testLengthValidations() {
        Administrator admin = new Administrator();

        admin.setUsername("ab");
        admin.setPassword("senhaValida");
        assertFalse(validator.validate(admin).isEmpty());

        admin.setUsername("username_muito_longo_para_ser_valido");
        assertFalse(validator.validate(admin).isEmpty());

        admin.setUsername("userValido");
        admin.setPassword("12");
        assertFalse(validator.validate(admin).isEmpty());

        admin.setPassword("senha_muito_longa_para_ser_valida");
        assertFalse(validator.validate(admin).isEmpty());
    }

    @Test
    void testPrePersistInheritance() {
        Administrator admin = new Administrator();
        admin.dateRegister();
        assertTrue(admin.getActive());
        assertNotNull(admin.getRegister());
    }

    @Test
    void testPreUpdateInheritance() {
        Administrator admin = new Administrator();
        admin.dateUpdate();
        assertNotNull(admin.getUpdate());
    }

}