package com.sfr.data.local.sql.dao.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserNumberHistoryDB_Impl extends UserNumberHistoryDB {
  private volatile UserNumberHistoryDao _userNumberHistoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `USER_NUMBER_HISTORY_TABLE` (`number` TEXT, `numberInfo` TEXT, `primaryKey` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd549151207ce2c0b95dc0dd3aa1ef321')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `USER_NUMBER_HISTORY_TABLE`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUSERNUMBERHISTORYTABLE = new HashMap<String, TableInfo.Column>(3);
        _columnsUSERNUMBERHISTORYTABLE.put("number", new TableInfo.Column("number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERNUMBERHISTORYTABLE.put("numberInfo", new TableInfo.Column("numberInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERNUMBERHISTORYTABLE.put("primaryKey", new TableInfo.Column("primaryKey", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUSERNUMBERHISTORYTABLE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUSERNUMBERHISTORYTABLE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUSERNUMBERHISTORYTABLE = new TableInfo("USER_NUMBER_HISTORY_TABLE", _columnsUSERNUMBERHISTORYTABLE, _foreignKeysUSERNUMBERHISTORYTABLE, _indicesUSERNUMBERHISTORYTABLE);
        final TableInfo _existingUSERNUMBERHISTORYTABLE = TableInfo.read(_db, "USER_NUMBER_HISTORY_TABLE");
        if (! _infoUSERNUMBERHISTORYTABLE.equals(_existingUSERNUMBERHISTORYTABLE)) {
          return new RoomOpenHelper.ValidationResult(false, "USER_NUMBER_HISTORY_TABLE(com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity).\n"
                  + " Expected:\n" + _infoUSERNUMBERHISTORYTABLE + "\n"
                  + " Found:\n" + _existingUSERNUMBERHISTORYTABLE);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d549151207ce2c0b95dc0dd3aa1ef321", "f5f2708d657ae731ff2f75813931087b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "USER_NUMBER_HISTORY_TABLE");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `USER_NUMBER_HISTORY_TABLE`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserNumberHistoryDao.class, UserNumberHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserNumberHistoryDao getUserNumberHistoryDao() {
    if (_userNumberHistoryDao != null) {
      return _userNumberHistoryDao;
    } else {
      synchronized(this) {
        if(_userNumberHistoryDao == null) {
          _userNumberHistoryDao = new UserNumberHistoryDao_Impl(this);
        }
        return _userNumberHistoryDao;
      }
    }
  }
}
