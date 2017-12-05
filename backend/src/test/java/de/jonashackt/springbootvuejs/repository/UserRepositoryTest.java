package de.jonashackt.springbootvuejs.repository;

import java.util.*;
import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.domain.Doctor;
import de.jonashackt.springbootvuejs.domain.Disability;
import de.jonashackt.springbootvuejs.domain.Project;
import de.jonashackt.springbootvuejs.domain.Limitation;
import de.jonashackt.springbootvuejs.domain.Contact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;
    Date birthdate = new Date();
    Doctor doctorexample = new Doctor("Resu","Tset","AndereStraße 2 Stadt 11111","110");
    Contact examplecontact = new Contact("Kontakt","Noch eine Straße 3 Stadt 11111","123456789");
    List<Project> projects = new ArrayList<>();
    List<Limitation> limits = new ArrayList<>();
    Project projectexample = new Project("Testen",15,10,"www.beispiel.de",null);
    User norbertSiegmund = new User("Norbert", "Siegmund");
    User jonasHecht = new User("Jonas", "Hecht");
    User testUser = new User("Test","User",birthdate,"Straße 1 Stadt 11111",
            "0900","110",examplecontact,
            true,true,true,true,true,
            doctorexample,projects,null,limits);

    @Before
    public void fillSomeDataIntoOurDb() {
        // Add new Users to Database
        entityManager.persist(norbertSiegmund);
        entityManager.persist(jonasHecht);
        entityManager.persist(testUser);
    }

    @Test
    public void testFindByLastName() throws Exception {
        // Search for specific User in Database according to lastname
        List<User> usersWithLastNameSiegmund = users.findByLastName("Siegmund");

        assertThat(usersWithLastNameSiegmund, contains(norbertSiegmund));
    }


    @Test
    public void testFindByFirstName() throws Exception {
        // Search for specific User in Database according to firstname
        List<User> usersWithFirstNameJonas = users.findByFirstName("Jonas");

        assertThat(usersWithFirstNameJonas, contains(jonasHecht));
    }

    @Test
    public void testFindByAddress() throws Exception {
        List<User> usersWithAddressStadt = users.findByAddress("Straße 1 Stadt 11111");

        assertThat(usersWithAddressStadt, contains(testUser));
    }

}