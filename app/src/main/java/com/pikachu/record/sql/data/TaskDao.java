package com.pikachu.record.sql.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pikachu.record.sql.table.Task;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TASK".
*/
public class TaskDao extends AbstractDao<Task, Long> {

    public static final String TABLENAME = "TASK";

    /**
     * Properties of entity Task.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StartTime = new Property(1, String.class, "startTime", false, "START_TIME");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Text = new Property(3, String.class, "text", false, "TEXT");
        public final static Property StopTime = new Property(4, String.class, "stopTime", false, "STOP_TIME");
        public final static Property IsAs = new Property(5, boolean.class, "isAs", false, "IS_AS");
        public final static Property Time = new Property(6, String.class, "time", false, "TIME");
    }


    public TaskDao(DaoConfig config) {
        super(config);
    }
    
    public TaskDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TASK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"START_TIME\" TEXT," + // 1: startTime
                "\"TITLE\" TEXT," + // 2: title
                "\"TEXT\" TEXT," + // 3: text
                "\"STOP_TIME\" TEXT," + // 4: stopTime
                "\"IS_AS\" INTEGER NOT NULL ," + // 5: isAs
                "\"TIME\" TEXT);"); // 6: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TASK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Task entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindString(2, startTime);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(4, text);
        }
 
        String stopTime = entity.getStopTime();
        if (stopTime != null) {
            stmt.bindString(5, stopTime);
        }
        stmt.bindLong(6, entity.getIsAs() ? 1L: 0L);
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(7, time);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Task entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindString(2, startTime);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(4, text);
        }
 
        String stopTime = entity.getStopTime();
        if (stopTime != null) {
            stmt.bindString(5, stopTime);
        }
        stmt.bindLong(6, entity.getIsAs() ? 1L: 0L);
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(7, time);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Task readEntity(Cursor cursor, int offset) {
        Task entity = new Task( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // startTime
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // text
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // stopTime
            cursor.getShort(offset + 5) != 0, // isAs
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Task entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStartTime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setText(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStopTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsAs(cursor.getShort(offset + 5) != 0);
        entity.setTime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Task entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Task entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Task entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
