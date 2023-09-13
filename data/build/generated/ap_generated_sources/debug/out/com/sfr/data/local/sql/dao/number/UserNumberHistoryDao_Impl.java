package com.sfr.data.local.sql.dao.number;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.rxjava3.RxRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import io.reactivex.rxjava3.core.Observable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserNumberHistoryDao_Impl implements UserNumberHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserNumberHistoryEntity> __insertionAdapterOfUserNumberHistoryEntity;

  public UserNumberHistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserNumberHistoryEntity = new EntityInsertionAdapter<UserNumberHistoryEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `USER_NUMBER_HISTORY_TABLE` (`number`,`numberInfo`,`primaryKey`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserNumberHistoryEntity value) {
        if (value.getNumber() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNumber());
        }
        if (value.getNumberInfo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumberInfo());
        }
        if (value.getPrimaryKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getPrimaryKey());
        }
      }
    };
  }

  @Override
  public Long saveUserNumberHistory(final UserNumberHistoryEntity userNumberHistoryEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserNumberHistoryEntity.insertAndReturnId(userNumberHistoryEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory() {
    final String _sql = "SELECT * FROM USER_NUMBER_HISTORY_TABLE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createObservable(__db, false, new String[]{"USER_NUMBER_HISTORY_TABLE"}, new Callable<List<UserNumberHistoryEntity>>() {
      @Override
      public List<UserNumberHistoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
          final int _cursorIndexOfNumberInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "numberInfo");
          final int _cursorIndexOfPrimaryKey = CursorUtil.getColumnIndexOrThrow(_cursor, "primaryKey");
          final List<UserNumberHistoryEntity> _result = new ArrayList<UserNumberHistoryEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UserNumberHistoryEntity _item;
            final String _tmpNumber;
            if (_cursor.isNull(_cursorIndexOfNumber)) {
              _tmpNumber = null;
            } else {
              _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
            }
            final String _tmpNumberInfo;
            if (_cursor.isNull(_cursorIndexOfNumberInfo)) {
              _tmpNumberInfo = null;
            } else {
              _tmpNumberInfo = _cursor.getString(_cursorIndexOfNumberInfo);
            }
            final Long _tmpPrimaryKey;
            if (_cursor.isNull(_cursorIndexOfPrimaryKey)) {
              _tmpPrimaryKey = null;
            } else {
              _tmpPrimaryKey = _cursor.getLong(_cursorIndexOfPrimaryKey);
            }
            _item = new UserNumberHistoryEntity(_tmpNumber,_tmpNumberInfo,_tmpPrimaryKey);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(final Long primaryKey) {
    final String _sql = "SELECT * FROM USER_NUMBER_HISTORY_TABLE WHERE primaryKey=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (primaryKey == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, primaryKey);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfNumberInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "numberInfo");
      final int _cursorIndexOfPrimaryKey = CursorUtil.getColumnIndexOrThrow(_cursor, "primaryKey");
      final UserNumberHistoryEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpNumber;
        if (_cursor.isNull(_cursorIndexOfNumber)) {
          _tmpNumber = null;
        } else {
          _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        }
        final String _tmpNumberInfo;
        if (_cursor.isNull(_cursorIndexOfNumberInfo)) {
          _tmpNumberInfo = null;
        } else {
          _tmpNumberInfo = _cursor.getString(_cursorIndexOfNumberInfo);
        }
        final Long _tmpPrimaryKey;
        if (_cursor.isNull(_cursorIndexOfPrimaryKey)) {
          _tmpPrimaryKey = null;
        } else {
          _tmpPrimaryKey = _cursor.getLong(_cursorIndexOfPrimaryKey);
        }
        _result = new UserNumberHistoryEntity(_tmpNumber,_tmpNumberInfo,_tmpPrimaryKey);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
