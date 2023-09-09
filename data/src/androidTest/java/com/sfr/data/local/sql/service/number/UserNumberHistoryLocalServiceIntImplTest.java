package com.sfr.data.local.sql.service.number;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.sfr.data.local.sql.dao.db.UserNumberHistoryDB;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class UserNumberHistoryLocalServiceIntImplTest {

    private UserNumberHistoryDB userNumberHistoryDB;
    private UserNumberHistoryDao userNumberHistoryDao;

    @Before
    public void beforeInit() {
        Context context = ApplicationProvider.getApplicationContext();
        userNumberHistoryDB = Room.inMemoryDatabaseBuilder(context, UserNumberHistoryDB.class).build();
        userNumberHistoryDao = userNumberHistoryDB.getUserNumberHistoryDao();
    }

    @After
    public void after() throws IOException {
        userNumberHistoryDB.close();
    }

    @Test
    public void saveUserNumberHistoryAndReadItInList_shouldWriteAndReadDataWithoutException() throws IOException {
        
    }

}
