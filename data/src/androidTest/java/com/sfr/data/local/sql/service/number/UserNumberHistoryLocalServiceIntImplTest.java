package com.sfr.data.local.sql.service.number;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.sfr.data.local.sql.dao.db.UserNumberHistoryDB;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Optional;

@RunWith(AndroidJUnit4.class)
public class UserNumberHistoryLocalServiceIntImplTest {

    private UserNumberHistoryDB userNumberHistoryDB;
    private UserNumberHistoryDao userNumberHistoryDao;
    private UserNumberHistoryLocalServiceInt userNumberHistoryLocalServiceInt;

    @Before
    public void beforeInit() {
        Context context = ApplicationProvider.getApplicationContext();
        userNumberHistoryDB = Room.inMemoryDatabaseBuilder(context, UserNumberHistoryDB.class).build();
        userNumberHistoryDao = userNumberHistoryDB.getUserNumberHistoryDao();
        userNumberHistoryLocalServiceInt = new UserNumberHistoryLocalServiceIntImpl(userNumberHistoryDao);
    }

    @After
    public void after() throws RuntimeException {
        userNumberHistoryDB.close();
    }

    @Test
    public void saveUserNumberHistoryAndReadItInList_shouldWriteAndReadDataWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity = new UserNumberHistoryEntity("13", " - is very good number", null);
        Optional<UserNumberHistoryEntity> userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        assert userNumberHistoryEntity1.isPresent();
        System.out.println("\n\nResult: " + userNumberHistoryEntity1.get().getPrimaryKey() + "\n\n");
        Assert.assertEquals(userNumberHistoryEntity.getNumber(), userNumberHistoryEntity1.get().getNumber());
        Assert.assertEquals(userNumberHistoryEntity.getNumberInfo(), userNumberHistoryEntity1.get().getNumberInfo());
        Assert.assertNotEquals(userNumberHistoryEntity.getPrimaryKey(), userNumberHistoryEntity1.get().getPrimaryKey());
    }

    @Test
    public void saveLotsOfUserNumbersAndReadItFromDb_shouldWriteAndReadWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity1 = new UserNumberHistoryEntity("13", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntity2 = new UserNumberHistoryEntity("14", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntity3 = new UserNumberHistoryEntity("15", " - is very good number", null);
        Optional<UserNumberHistoryEntity> userNumberHistoryEntityR1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity1
        );
        Optional<UserNumberHistoryEntity> userNumberHistoryEntityR2 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity2
        );
        Optional<UserNumberHistoryEntity> userNumberHistoryEntityR3 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity3
        );
        assert userNumberHistoryEntityR1.isPresent();
        assert userNumberHistoryEntityR2.isPresent();
        assert userNumberHistoryEntityR3.isPresent();
        Assert.assertEquals(userNumberHistoryEntity1.getNumber(), userNumberHistoryEntityR1.get().getNumber());
        Assert.assertEquals(userNumberHistoryEntity2.getNumber(), userNumberHistoryEntityR2.get().getNumber());
        Assert.assertEquals(userNumberHistoryEntity3.getNumber(), userNumberHistoryEntityR3.get().getNumber());
    }

    @Test
    public void getUserNumberHistoryByDetails_shouldReturnItemWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity = new UserNumberHistoryEntity("13", " - is very good number", null);
        Optional<UserNumberHistoryEntity> userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        assert userNumberHistoryEntity1.isPresent();
        Optional<UserNumberHistoryEntity> userNumberHistoryEntity2 = userNumberHistoryLocalServiceInt.getUserNumberHistoryByDetails(
                userNumberHistoryEntity1.get().getNumber()
        );
        assert userNumberHistoryEntity2.isPresent();
        System.out.println("\n\n\n data is: " + userNumberHistoryEntity2.get().getNumber() + ", " + userNumberHistoryEntity1.get().getNumber() + "\n\n\n");
        assert userNumberHistoryEntity1.get().getNumber() != null;
        assert userNumberHistoryEntity1.get().getNumberInfo() != null;
        Assert.assertTrue(userNumberHistoryEntity1.get().getNumber().equals(userNumberHistoryEntity2.get().getNumber()));
        Assert.assertTrue(userNumberHistoryEntity1.get().getNumberInfo().equals(userNumberHistoryEntity2.get().getNumberInfo()));
    }

    @Test
    public void deleteUserNumberHistoryEntityByDetails_shouldDeleteItemWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity = new UserNumberHistoryEntity("13", " - is very good number", null);
        Optional<UserNumberHistoryEntity> userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        List<UserNumberHistoryEntity> list = userNumberHistoryLocalServiceInt.getUserNumbersHistoryAsList();
        assert userNumberHistoryEntity1.isPresent();
        assert !list.isEmpty();
        userNumberHistoryLocalServiceInt.deleteUserNumberHistoryEntityByDetails(userNumberHistoryEntity1.get().getNumber());
        List<UserNumberHistoryEntity> listNew = userNumberHistoryLocalServiceInt.getUserNumbersHistoryAsList();
        assert listNew.isEmpty();
    }

    @Test
    public void getUserNumbersHistoryAsList_shouldReturnListWithoutException() {
        UserNumberHistoryEntity userNumberHistoryEntity = new UserNumberHistoryEntity("13", " - is very good number", null);
        List<UserNumberHistoryEntity> list = userNumberHistoryLocalServiceInt.getUserNumbersHistoryAsList();
        assert list.isEmpty();
        Optional<UserNumberHistoryEntity> userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        List<UserNumberHistoryEntity> list1 = userNumberHistoryLocalServiceInt.getUserNumbersHistoryAsList();
        assert !list1.isEmpty();
    }

}
