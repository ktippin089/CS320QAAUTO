/**
 *@author Kevin Wesley Tippin
 *CS-320
 *@version 1.5
 *@since 2025-10-13
 * Unit tests for Contact class.
 * Validates constructor, getters, and setters. 
 */
package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Contact class.
 * Validates constructor and field updates.
 */
public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("C100", "Emma", "Lopez", "5551112222", "45 Birchwood Ave");
    }

    @Test
    @DisplayName("Constructor correctly assigns fields")
    void testConstructorValid() {
        assertEquals("C100", contact.getContactId());
        assertEquals("Emma", contact.getFirstName());
        assertEquals("Lopez", contact.getLastName());
        assertEquals("5551112222", contact.getPhone());
        assertEquals("45 Birchwood Ave", contact.getAddress());
    }

    @Test
    @DisplayName("Constructor rejects invalid or null parameters")
    void testConstructorInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Ava", "Smith", "5551112222", "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ABCDEFGHIJK", "Ava", "Smith", "5551112222", "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("C200", null, "Smith", "5551112222", "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("C201", "Ava", null, "5551112222", "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("C202", "Ava", "Smith", null, "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("C203", "Ava", "Smith", "555ABC9999", "Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("C204", "Ava", "Smith", "5551112222", null));
    }

    @Test
    @DisplayName("Setters update fields and reject invalid input")
    void testSetters() {
        contact.setFirstName("Luna");
        assertEquals("Luna", contact.getFirstName());
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("NameTooLongForField"));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));

        contact.setLastName("Stone");
        assertEquals("Stone", contact.getLastName());
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Longlastnameee"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));

        contact.setPhone("5553334444");
        assertEquals("5553334444", contact.getPhone());
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("555"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));

        contact.setAddress("123 Oak Street");
        assertEquals("123 Oak Street", contact.getAddress());
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
