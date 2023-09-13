package com.sfr.data.local.sql.service.number;

import android.content.Context;
import android.util.Log;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subscribers.TestSubscriber;

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
        UserNumberHistoryEntity userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        System.out.println("\n\nResult: " + userNumberHistoryEntity1.getPrimaryKey() + "\n\n");
        Assert.assertEquals(userNumberHistoryEntity.getNumber(), userNumberHistoryEntity1.getNumber());
        Assert.assertEquals(userNumberHistoryEntity.getNumberInfo(), userNumberHistoryEntity1.getNumberInfo());
        Assert.assertNotEquals(userNumberHistoryEntity.getPrimaryKey(), userNumberHistoryEntity1.getPrimaryKey());
    }

    @Test
    public void saveLotsOfUserNumbersAndReadItFromDb_shouldWriteAndReadWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity1 = new UserNumberHistoryEntity("13", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntity2 = new UserNumberHistoryEntity("14", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntity3 = new UserNumberHistoryEntity("15", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntityR1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity1
        );
        UserNumberHistoryEntity userNumberHistoryEntityR2 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity2
        );
        UserNumberHistoryEntity userNumberHistoryEntityR3 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity3
        );

        Assert.assertEquals(userNumberHistoryEntity1.getNumber(), userNumberHistoryEntityR1.getNumber());
        Assert.assertEquals(userNumberHistoryEntity2.getNumber(), userNumberHistoryEntityR2.getNumber());
        Assert.assertEquals(userNumberHistoryEntity3.getNumber(), userNumberHistoryEntityR3.getNumber());
    }

    @Test
    public void getUserNumberHistoryByDetails_shouldReturnItemWithoutException() throws RuntimeException {
        UserNumberHistoryEntity userNumberHistoryEntity = new UserNumberHistoryEntity("13", " - is very good number", null);
        UserNumberHistoryEntity userNumberHistoryEntity1 = userNumberHistoryLocalServiceInt.saveUserNumberHistory(
                userNumberHistoryEntity
        );
        UserNumberHistoryEntity userNumberHistoryEntity2 = userNumberHistoryLocalServiceInt.getUserNumberHistoryByDetails(
                userNumberHistoryEntity1.getNumber(), userNumberHistoryEntity1.getNumberInfo()
        );
        System.out.println("\n\n\n data is: " + userNumberHistoryEntity2.getNumber() + ", " + userNumberHistoryEntity1.getNumber() + "\n\n\n");
        assert userNumberHistoryEntity1.getNumber() != null;
        assert userNumberHistoryEntity1.getNumberInfo() != null;
        Assert.assertTrue(userNumberHistoryEntity1.getNumber().equals(userNumberHistoryEntity2.getNumber()));
        Assert.assertTrue(userNumberHistoryEntity1.getNumberInfo().equals(userNumberHistoryEntity2.getNumberInfo()));
    }

}
