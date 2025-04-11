package se.lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StudentTest {
    @Test
    void testCreatingStudent() {
        // expected result 1
        int id = 0;
        String name = "Test";
        String email = "test@testia.com";
        String address = "Testvägen 11";
        // expected result 2
        int id2 = 0;
        String name2 = "Fake";
        String email2 = "fake@email.com";
        String address2 = "Fakevägen 1";
        // test 1
        Student student1 = new Student("Test", "test@testia.com", "Testvägen 11");
        Student student2 = new Student("Fake", "fake@email.com", "Fakevägen 1");
        Assertions.assertEquals(id, student1.getId());
        Assertions.assertEquals(name, student1.getName());
        Assertions.assertEquals(email, student1.getEmail());
        Assertions.assertEquals(address, student1.getAddress());
        // test 2
        Assertions.assertEquals(id2, student2.getId());
        Assertions.assertEquals(name2, student2.getName());
        Assertions.assertEquals(email2, student2.getEmail());
        Assertions.assertEquals(address2, student2.getAddress());
    }
}
