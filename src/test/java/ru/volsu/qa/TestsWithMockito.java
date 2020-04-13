package ru.volsu.qa;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestsWithMockito {

    @Mock
    private DatabaseDAO databaseDAO = new DatabaseDAO();

    @Spy
    List<String> spyList = new ArrayList<>();

    @BeforeClass
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(this.databaseDAO.findUser("John")).thenReturn(new User("John", "Smith"));
    }

    @Test
    public void testWithMock(){
        int id = this.databaseDAO.saveUser(new User());
        Assert.assertEquals(id, 0);

        String lastName = this.databaseDAO.findUser("John").getLastName();
        Assert.assertEquals(lastName, "Doe");
    }

    @Test
    public void testWithSpy(){
        spyList.add("one");
        spyList.add("two");

        Assert.assertEquals(spyList.size(), 2);

        Mockito.verify(spyList).add("one");

        Mockito.doReturn(100).when(spyList).size();

        Assert.assertEquals(spyList.size(), 100);

    }
}
