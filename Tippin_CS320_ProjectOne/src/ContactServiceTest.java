/**
 *@author Kevin Wesley Tippin
 *CS-320
 *@version 1.5
 *@since 2025-10-13
 * Unit tests for the ContactService class.
 * Covers add, delete, update, and retrieval logic. 
 */
package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("C300", "Noah", "Green", "5559998888", "22 Riverbank Rd");
        service.addContact(contact);
    }

    @Test
    @DisplayName("Add and retrieve contact successfully")
    void testAddAndRetrieveContact() {
        Contact retrieved = service.getContact("C300");
        assertNotNull(retrieved);
        assertEquals("Noah", retrieved.getFirstName());
    }

    @Test
    @DisplayName("Add null or duplicate contact should throw exception")
    void testAddContactInvalidCases() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
        Contact duplicate = new Contact("C300", "Alex", "Brown", "5553332222", "14 Willow St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    @DisplayName("Delete existing contact should remove it")
    void testDeleteContact() {
        service.deleteContact("C300");
        assertNull(service.getContact("C300"));
    }

    @Test
    @DisplayName("Delete unknown ID should throw exception")
    void testDeleteUnknown() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("XYZ999"));
    }

    @Test
    @DisplayName("Update contact fields successfully")
    void testUpdateFields() {
        service.updateFirstName("C300", "Liam");
        assertEquals("Liam", service.getContact("C300").getFirstName());

        service.updateLastName("C300", "Gray");
        assertEquals("Gray", service.getContact("C300").getLastName());

        service.updatePhone("C300", "5554443333");
        assertEquals("5554443333", service.getContact("C300").getPhone());

        service.updateAddress("C300", "789 Pine Blvd");
        assertEquals("789 Pine Blvd", service.getContact("C300").getAddress());
    }

    @Test
    @DisplayName("Update should throw exception when contact ID not found")
    void testUpdateThrowsForMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("MISSING", "Test"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("MISSING", "User"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("MISSING", "5555555555"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("MISSING", "123 Lane"));
    }

    @Test
    @DisplayName("getAllContacts returns snapshot copy")
    void testGetAllContactsSnapshot() {
        Map<String, Contact> snapshot = service.getAllContacts();
        assertEquals(1, snapshot.size());
        assertThrows(UnsupportedOperationException.class, () -> snapshot.clear());
    }
}