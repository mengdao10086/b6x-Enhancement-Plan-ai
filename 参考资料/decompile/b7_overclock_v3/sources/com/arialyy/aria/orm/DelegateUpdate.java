package com.arialyy.aria.orm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.arialyy.aria.orm.annotation.Primary;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.blankj.utilcode.util.i0;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class DelegateUpdate extends AbsDelegate {
    private DelegateUpdate() {
    }

    private ContentValues createValues(DbEntity dbEntity) {
        List<Field> allFields = CommonUtil.getAllFields(dbEntity.getClass());
        if (allFields.size() > 0) {
            ContentValues contentValues = new ContentValues();
            try {
                for (Field field : allFields) {
                    field.setAccessible(true);
                    if (!isIgnore(dbEntity, field)) {
                        Class<?> type = field.getType();
                        contentValues.put(field.getName(), SqlUtil.encodeStr((type == Map.class && SqlUtil.checkMap(field)) ? SqlUtil.map2Str((Map) field.get(dbEntity)) : (type == List.class && SqlUtil.checkList(field)) ? SqlUtil.list2Str(dbEntity, field) : field.get(dbEntity) != null ? field.get(dbEntity).toString() : null));
                    }
                }
                return contentValues;
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    private boolean isIgnore(Object obj, Field field) throws IllegalAccessException {
        Object obj2;
        if (SqlUtil.isIgnore(field) || (obj2 = field.get(obj)) == null) {
            return true;
        }
        if ((obj2 instanceof String) && TextUtils.isEmpty(String.valueOf(obj2))) {
            return true;
        }
        if ((obj2 instanceof List) && ((List) obj2).size() == 0) {
            return true;
        }
        if ((obj2 instanceof Map) && ((Map) obj2).size() == 0) {
            return true;
        }
        if (SqlUtil.isPrimary(field)) {
            return ((Primary) field.getAnnotation(Primary.class)).autoincrement();
        }
        return false;
    }

    public synchronized <T extends DbEntity> void delData(SQLiteDatabase sQLiteDatabase, Class<T> cls, String... strArr) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, cls);
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (CommonUtil.checkSqlExpression(strArr)) {
            String strReplace = ("DELETE FROM " + CommonUtil.getClassName((Class) cls) + " WHERE " + strArr[0] + i0.f11861z).replace("?", "%s");
            int length = strArr.length - 1;
            String[] strArr2 = new String[length];
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                strArr2[i10] = String.format("'%s'", SqlUtil.encodeStr(strArr[i11]));
                i10 = i11;
            }
            sQLiteDatabaseCheckDb.execSQL(String.format(strReplace, strArr2));
        }
    }

    public synchronized void insertData(SQLiteDatabase sQLiteDatabase, DbEntity dbEntity) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, dbEntity.getClass());
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        ContentValues contentValuesCreateValues = createValues(dbEntity);
        if (contentValuesCreateValues != null) {
            dbEntity.rowID = sQLiteDatabaseCheckDb.insert(CommonUtil.getClassName(dbEntity), null, contentValuesCreateValues);
        } else {
            ALog.e(AbsDelegate.TAG, "保存记录失败，记录没有属性字段");
        }
    }

    public synchronized <T extends DbEntity> void insertManyData(SQLiteDatabase sQLiteDatabase, List<T> list) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        sQLiteDatabaseCheckDb.beginTransaction();
        try {
            try {
                Class<?> cls = null;
                String className = null;
                for (T t10 : list) {
                    if (cls == null || cls != t10.getClass() || className == null) {
                        cls = t10.getClass();
                        className = CommonUtil.getClassName((Class) cls);
                        SqlUtil.checkOrCreateTable(sQLiteDatabaseCheckDb, cls);
                    }
                    ContentValues contentValuesCreateValues = createValues(t10);
                    if (contentValuesCreateValues == null) {
                        ALog.e(AbsDelegate.TAG, "保存记录失败，记录没有属性字段");
                    } else {
                        t10.rowID = sQLiteDatabaseCheckDb.insert(className, null, contentValuesCreateValues);
                    }
                }
                sQLiteDatabaseCheckDb.setTransactionSuccessful();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } finally {
            sQLiteDatabaseCheckDb.endTransaction();
        }
    }

    public synchronized void updateData(SQLiteDatabase sQLiteDatabase, DbEntity dbEntity) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, dbEntity.getClass());
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        ContentValues contentValuesCreateValues = createValues(dbEntity);
        if (contentValuesCreateValues != null) {
            sQLiteDatabaseCheckDb.update(CommonUtil.getClassName(dbEntity), contentValuesCreateValues, "rowid=?", new String[]{String.valueOf(dbEntity.rowID)});
        } else {
            ALog.e(AbsDelegate.TAG, "更新记录失败，记录没有属性字段");
        }
    }

    public synchronized <T extends DbEntity> void updateManyData(SQLiteDatabase sQLiteDatabase, List<T> list) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        sQLiteDatabaseCheckDb.beginTransaction();
        try {
            try {
                Class<?> cls = null;
                String className = null;
                for (T t10 : list) {
                    if (cls == null || cls != t10.getClass() || className == null) {
                        cls = t10.getClass();
                        className = CommonUtil.getClassName((Class) cls);
                    }
                    ContentValues contentValuesCreateValues = createValues(t10);
                    if (contentValuesCreateValues == null) {
                        ALog.e(AbsDelegate.TAG, "更新记录失败，记录没有属性字段");
                    } else {
                        sQLiteDatabaseCheckDb.update(className, contentValuesCreateValues, "rowid=?", new String[]{String.valueOf(t10.rowID)});
                    }
                }
                sQLiteDatabaseCheckDb.setTransactionSuccessful();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } finally {
            sQLiteDatabaseCheckDb.endTransaction();
        }
    }
}
