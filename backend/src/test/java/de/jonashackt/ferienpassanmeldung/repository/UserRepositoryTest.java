package de.jonashackt.ferienpassanmeldung.repository;

import java.util.*;
import de.jonashackt.ferienpassanmeldung.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;


import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date tempDate = new Date();
    String registerDateString = dateFormat.format(tempDate);
    Doctor doctorexample = new Doctor("Resu","Tset","AndereStraße 2 Stadt", "11111","110");
    Contact examplecontact = new Contact("Kontakt","Noch eine Straße 3 Stadt", "11111","123456789");
    List<Project> projects = new ArrayList<>();
    List<Limitation> limits = new ArrayList<>();
    Project projectexample = new Project("Testen",15,10,"www.beispiel.de",null);
    User norbertSiegmund = new User("Norbert", "Siegmund");
    User jonasHecht = new User("Jonas", "Hecht");
    User testUser = new User("Test","User","01.01.1999",registerDateString,"Straße 1","Stadt","11111",
            "0900","110",examplecontact,
            true,true,true,true,true,
            doctorexample,projects,limits);

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


}
