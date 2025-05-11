package br.com.uniamerica.ibellembalagens.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractEntityTest {

    @Test
    void testId() {
        AbstractEntity entity = new AbstractEntity() {};
        assertNull(entity.getId());

        Long expectedId = 1L;
        entity.setId(expectedId);
        assertEquals(expectedId, entity.getId());
    }

    @Test
    void testActive() {
        AbstractEntity entity = new AbstractEntity() {};
        assertNull(entity.getActive());

        entity.setActive(true);
        assertTrue(entity.getActive());
    }

    @Test
    void testPrePersistSetsActiveAndRegister() {
        AbstractEntity entity = new AbstractEntity() {};
        entity.dateRegister();

        assertTrue(entity.getActive());
        assertNotNull(entity.getRegister());
        assertNull(entity.getUpdate());
    }

    @Test
    void testPreUpdateSetsUpdate() {
        AbstractEntity entity = new AbstractEntity() {};
        entity.dateUpdate();

        assertNotNull(entity.getUpdate());
        assertNull(entity.getRegister());
    }
}