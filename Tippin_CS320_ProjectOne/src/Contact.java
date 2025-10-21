/**
 * @author Kevin Wesley Tippin
 * CS-320
 * @version 1.5
 * @since 2025-10-13
 */
package contactservice;
/**
 * Contact class for Project 3-2: Contact Service
 *
 * Represents a single contact record with validated contact record. 
 */
public class Contact {

    // ===== Fields =====
    private final String contactId;   // Unique, immutable
    private String firstName;         // Required, <= 10 chars
    private String lastName;          // Required, <= 10 chars
    private String phone;             // Exactly 10 digits
    private String address;           // Required, <= 30 chars

    // ===== Constructor =====
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Contact ID must be non-null and <= 10 characters");

        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // ===== Getters =====
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // ===== Setters with Validation =====
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // ===== Validation Helpers =====
    private void validateFirstName(String name) {
        if (name == null || name.length() > 10)
            throw new IllegalArgumentException("First name must be non-null and <= 10 characters");
    }

    private void validateLastName(String name) {
        if (name == null || name.length() > 10)
            throw new IllegalArgumentException("Last name must be non-null and <= 10 characters");
    }

    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Address must be non-null and <= 30 characters");
    }
}