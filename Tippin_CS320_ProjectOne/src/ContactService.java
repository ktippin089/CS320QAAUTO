/**
 * @author Kevin Wesley Tippin
 * CS-320
 * @version 1.5
 * @since 2025-10-13
 * ContactService manages a collection of contacts in memory.
 * Supports adding, deleting, retrieving, and updating contacts.
 */
package contactservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ContactService {

    // Internal contact storage (no database)
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a contact. Throws exception if null or ID already exists.
     */
    public void addContact(Contact contact) {
        if (contact == null)
            throw new IllegalArgumentException("Contact cannot be null");
        if (contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Retrieves a contact by ID or returns null if not found.
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /**
     * Returns a safe, unmodifiable copy of all contacts.
     */
    public Map<String, Contact> getAllContacts1() {
        return Collections.unmodifiableMap(new HashMap<>(contacts));
    }

    /**
     * Deletes a contact by ID. Throws exception if not found.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact ID not found");
        contacts.remove(contactId);
    }

    // ===== Update Methods =====
    public void updateFirstName(String contactId, String newFirstName) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact ID not found");
        c.setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact ID not found");
        c.setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact ID not found");
        c.setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact ID not found");
        c.setAddress(newAddress);
    }


	public Map<String, Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}
}