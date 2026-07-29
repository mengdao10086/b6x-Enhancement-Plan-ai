package com.arialyy.aria.orm;

import ag.c;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.arialyy.aria.orm.annotation.Many;
import com.arialyy.aria.orm.annotation.One;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.blankj.utilcode.util.i0;
import hb.u;
import j3.b;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class DelegateFind extends AbsDelegate {
    private final String PARENT_COLUMN_ALIAS = "p";
    private final String CHILD_COLUMN_ALIAS = "c";

    private DelegateFind() {
    }

    private <T extends DbEntity> T createChild(Class<T> cls, List<Field> list, Cursor cursor) throws IllegalAccessException, InstantiationException {
        T tNewInstance = cls.newInstance();
        tNewInstance.rowID = cursor.getInt(cursor.getColumnIndex("c".concat("rowid")));
        for (Field field : list) {
            field.setAccessible(true);
            setFieldValue(field.getType(), field, cursor.getColumnIndex("c".concat(field.getName())), cursor, tNewInstance);
        }
        return tNewInstance;
    }

    private <T extends DbEntity> List<T> createChildren(SQLiteDatabase sQLiteDatabase, Class<T> cls, List<Field> list, String str, String str2, DbEntity dbEntity) throws IllegalAccessException {
        for (Field field : list) {
            field.setAccessible(true);
            if (field.getName().equals(str2)) {
                Object objEncode = field.get(dbEntity);
                if (objEncode instanceof String) {
                    objEncode = URLEncoder.encode((String) objEncode);
                }
                return findData(sQLiteDatabase, cls, str + "='" + objEncode + "'");
            }
        }
        return new ArrayList();
    }

    private <T extends DbEntity> T createParent(int i10, Class<T> cls, List<Field> list, Cursor cursor) throws IllegalAccessException, InstantiationException {
        T tNewInstance = cls.newInstance();
        tNewInstance.rowID = i10;
        for (Field field : list) {
            field.setAccessible(true);
            setFieldValue(field.getType(), field, cursor.getColumnIndex("p".concat(field.getName())), cursor, tNewInstance);
        }
        return tNewInstance;
    }

    private <T extends DbEntity> List<T> exeNormalDataSql(SQLiteDatabase sQLiteDatabase, Class<T> cls, String str, String[] strArr) {
        Cursor cursorRawQuery;
        SqlUtil.checkOrCreateTable(sQLiteDatabase, cls);
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            int i10 = 0;
            for (String str2 : strArr) {
                strArr2[i10] = SqlUtil.encodeStr(str2);
                i10++;
            }
            cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr2);
        } else {
            cursorRawQuery = sQLiteDatabase.rawQuery(str, null);
        }
        List<T> listNewInstanceEntity = cursorRawQuery.getCount() > 0 ? newInstanceEntity(cls, cursorRawQuery) : null;
        closeCursor(cursorRawQuery);
        return listNewInstanceEntity;
    }

    private <T extends AbsDbWrapper> List<T> exeRelationSql(SQLiteDatabase sQLiteDatabase, Class<T> cls, int i10, int i11, String... strArr) {
        String string;
        SQLiteDatabase sQLiteDatabase2;
        String[] strArr2;
        boolean z10;
        Cursor cursorRawQuery;
        List<T> listNewInstanceEntity;
        String str = "p";
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (!SqlUtil.isWrapper(cls)) {
            ALog.e(AbsDelegate.TAG, "查询数据失败，实体类没有使用@Wrapper 注解");
            return null;
        }
        Field[] oneAndManyField = getOneAndManyField(cls);
        if (oneAndManyField == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Field field = oneAndManyField[0];
        Field field2 = oneAndManyField[1];
        try {
            Many many = (Many) field2.getAnnotation(Many.class);
            Class<?> cls2 = Class.forName(field.getType().getName());
            Class<?> cls3 = Class.forName(CommonUtil.getListParamType(field2).getName());
            SqlUtil.checkOrCreateTable(sQLiteDatabaseCheckDb, cls2);
            SqlUtil.checkOrCreateTable(sQLiteDatabaseCheckDb, cls3);
            String simpleName = cls2.getSimpleName();
            String simpleName2 = cls3.getSimpleName();
            List<Field> allNotIgnoreField = SqlUtil.getAllNotIgnoreField(cls2);
            List<Field> allNotIgnoreField2 = SqlUtil.getAllNotIgnoreField(cls3);
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            if (allNotIgnoreField != null) {
                try {
                    sb3.append(simpleName.concat(".rowid AS ").concat("p").concat("rowid,"));
                    Iterator<Field> it2 = allNotIgnoreField.iterator();
                    while (it2.hasNext()) {
                        Field next = it2.next();
                        Iterator<Field> it3 = it2;
                        String strConcat = str.concat(next.getName());
                        sb3.append(simpleName.concat(b.f36044h).concat(next.getName()));
                        sb3.append(" AS ");
                        sb3.append(strConcat);
                        sb3.append(c.f654g);
                        it2 = it3;
                        str = str;
                    }
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    e.printStackTrace();
                    return null;
                }
            }
            if (allNotIgnoreField2 != null) {
                sb3.append(simpleName2.concat(".rowid AS ").concat("c").concat("rowid,"));
                for (Field field3 : allNotIgnoreField2) {
                    String strConcat2 = "c".concat(field3.getName());
                    sb4.append(simpleName2.concat(b.f36044h).concat(field3.getName()));
                    sb4.append(" AS ");
                    sb4.append(strConcat2);
                    sb4.append(c.f654g);
                }
            }
            String string2 = sb3.toString();
            String string3 = sb4.toString();
            if (!TextUtils.isEmpty(string2)) {
                string2 = string2.substring(0, string2.length() - 1);
            }
            if (!TextUtils.isEmpty(string3)) {
                string3 = string3.substring(0, string3.length() - 1);
            }
            sb2.append("SELECT ");
            if (!TextUtils.isEmpty(string2)) {
                sb2.append(string2);
                sb2.append(c.f654g);
            }
            if (!TextUtils.isEmpty(string3)) {
                sb2.append(string3);
            }
            if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                sb2.append(" * ");
            }
            sb2.append(" FROM ");
            sb2.append(simpleName);
            sb2.append(" INNER JOIN ");
            sb2.append(simpleName2);
            sb2.append(" ON ");
            sb2.append(simpleName.concat(b.f36044h).concat(many.parentColumn()));
            sb2.append(" = ");
            sb2.append(simpleName2.concat(b.f36044h).concat(many.entityColumn()));
            if (strArr == null || strArr.length <= 0) {
                string = sb2.toString();
            } else {
                if (!CommonUtil.checkSqlExpression(strArr)) {
                    return null;
                }
                sb2.append(" WHERE ");
                sb2.append(strArr[0]);
                sb2.append(i0.f11861z);
                String strReplace = sb2.toString().replace("?", "%s");
                int i12 = 1;
                int length = strArr.length - 1;
                String[] strArr3 = new String[length];
                int i13 = 0;
                while (i13 < length) {
                    Object[] objArr = new Object[i12];
                    int i14 = i13 + 1;
                    objArr[0] = SqlUtil.encodeStr(strArr[i14]);
                    strArr3[i13] = String.format("'%s'", objArr);
                    i13 = i14;
                    i12 = 1;
                }
                string = String.format(strReplace, strArr3);
            }
            if (i10 == -1 || i11 == -1) {
                sQLiteDatabase2 = sQLiteDatabaseCheckDb;
                strArr2 = null;
                z10 = false;
            } else {
                string = string.concat(String.format(" Group by %s LIMIT %s,%s", simpleName.concat(b.f36044h).concat(many.parentColumn()), Integer.valueOf((i10 - 1) * i11), Integer.valueOf(i11)));
                sQLiteDatabase2 = sQLiteDatabaseCheckDb;
                strArr2 = null;
                z10 = true;
            }
            cursorRawQuery = sQLiteDatabase2.rawQuery(string, strArr2);
            listNewInstanceEntity = newInstanceEntity(cls, cls2, cls3, cursorRawQuery, allNotIgnoreField, allNotIgnoreField2, z10, sQLiteDatabase2, many.entityColumn(), many.parentColumn());
        } catch (ClassNotFoundException e11) {
            e = e11;
        }
        try {
            closeCursor(cursorRawQuery);
            return listNewInstanceEntity;
        } catch (ClassNotFoundException e12) {
            e = e12;
            e.printStackTrace();
            return null;
        }
    }

    private Field[] getOneAndManyField(Class cls) {
        Field[] fieldArr = new Field[2];
        Field field = null;
        Field field2 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (Field field3 : cls.getDeclaredFields()) {
            if (SqlUtil.isOne(field3)) {
                if (z10) {
                    ALog.w(AbsDelegate.TAG, "查询数据失败，实体中有多个@One 注解");
                    return null;
                }
                field = field3;
                z10 = true;
            }
            if (SqlUtil.isMany(field3)) {
                if (z11) {
                    ALog.w(AbsDelegate.TAG, "查询数据失败，实体中有多个@Many 注解");
                    return null;
                }
                if (!field3.getType().isAssignableFrom(List.class)) {
                    ALog.w(AbsDelegate.TAG, "查询数据失败，@Many 注解的类型不是List");
                    return null;
                }
                field2 = field3;
                z11 = true;
            }
        }
        if (field == null || field2 == null) {
            ALog.w(AbsDelegate.TAG, "查询数据失败，实体中没有@One或@Many注解");
            return null;
        }
        if (field2.getType() != List.class) {
            ALog.w(AbsDelegate.TAG, "查询数据失败，@Many注解的字段必须是List");
            return null;
        }
        fieldArr[0] = field;
        fieldArr[1] = field2;
        return fieldArr;
    }

    private synchronized <T extends AbsDbWrapper, P extends DbEntity, C extends DbEntity> List<T> newInstanceEntity(Class<T> cls, Class<P> cls2, Class<C> cls3, Cursor cursor, List<Field> list, List<Field> list2, boolean z10, SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        while (cursor.moveToNext()) {
            try {
                int i10 = cursor.getInt(cursor.getColumnIndex("p".concat("rowid")));
                if (sparseArray.get(i10) == null) {
                    sparseArray.put(i10, new ArrayList());
                    sparseArray2.put(i10, createParent(i10, cls2, list, cursor));
                }
                if (z10) {
                    List listCreateChildren = createChildren(sQLiteDatabase, cls3, list, str, str2, (DbEntity) sparseArray2.get(i10));
                    if (listCreateChildren != null) {
                        ((List) sparseArray.get(i10)).addAll(listCreateChildren);
                    }
                } else {
                    ((List) sparseArray.get(i10)).add(createChild(cls3, list2, cursor));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        List<Field> allNotIgnoreField = SqlUtil.getAllNotIgnoreField(cls);
        if (allNotIgnoreField != null && !allNotIgnoreField.isEmpty()) {
            for (int i11 = 0; i11 < sparseArray2.size(); i11++) {
                int iKeyAt = sparseArray2.keyAt(i11);
                T tNewInstance = cls.newInstance();
                boolean z11 = false;
                boolean z12 = false;
                for (Field field : allNotIgnoreField) {
                    if (!z11 && field.getAnnotation(One.class) != null) {
                        field.set(tNewInstance, sparseArray2.get(iKeyAt));
                        z11 = true;
                    }
                    if (!z12 && field.getAnnotation(Many.class) != null) {
                        field.set(tNewInstance, sparseArray.get(iKeyAt));
                        z12 = true;
                    }
                }
                tNewInstance.handleConvert();
                arrayList.add(tNewInstance);
            }
            return arrayList;
        }
        return null;
    }

    private void setFieldValue(Class cls, Field field, int i10, Cursor cursor, DbEntity dbEntity) throws IllegalAccessException {
        if (cursor == null || cursor.isClosed()) {
            ALog.e(AbsDelegate.TAG, "cursor没有初始化");
            return;
        }
        if (cls == String.class) {
            String string = cursor.getString(i10);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            field.set(dbEntity, URLDecoder.decode(string));
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            field.setInt(dbEntity, cursor.getInt(i10));
            return;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            field.setFloat(dbEntity, cursor.getFloat(i10));
            return;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            field.setDouble(dbEntity, cursor.getDouble(i10));
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            field.setLong(dbEntity, cursor.getLong(i10));
            return;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            if (TextUtils.isEmpty(cursor.getString(i10))) {
                field.setBoolean(dbEntity, false);
                return;
            } else {
                field.setBoolean(dbEntity, !r2.equalsIgnoreCase("false"));
                return;
            }
        }
        if (cls == Date.class || cls == java.sql.Date.class) {
            field.set(dbEntity, new Date(URLDecoder.decode(cursor.getString(i10))));
            return;
        }
        if (cls == byte[].class) {
            field.set(dbEntity, cursor.getBlob(i10));
            return;
        }
        if (cls == Map.class) {
            String string2 = cursor.getString(i10);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            field.set(dbEntity, SqlUtil.str2Map(URLDecoder.decode(string2)));
            return;
        }
        if (cls == List.class) {
            String string3 = cursor.getString(i10);
            if (TextUtils.isEmpty(string3)) {
                return;
            }
            field.set(dbEntity, SqlUtil.str2List(URLDecoder.decode(string3), field));
        }
    }

    public <T extends DbEntity> List<T> findAllData(SQLiteDatabase sQLiteDatabase, Class<T> cls) {
        return exeNormalDataSql(checkDb(sQLiteDatabase), cls, String.format("SELECT rowid, * FROM %s", CommonUtil.getClassName((Class) cls)), null);
    }

    public <T extends DbEntity> List<T> findData(SQLiteDatabase sQLiteDatabase, Class<T> cls, String... strArr) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (!CommonUtil.checkSqlExpression(strArr)) {
            return null;
        }
        String str = String.format("SELECT rowid, * FROM %s WHERE %s", CommonUtil.getClassName((Class) cls), strArr[0]);
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        try {
            System.arraycopy(strArr, 1, strArr2, 0, length);
            return exeNormalDataSql(sQLiteDatabaseCheckDb, cls, str, strArr2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public <T extends DbEntity> List<T> findDataByFuzzy(SQLiteDatabase sQLiteDatabase, Class<T> cls, String str) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sql语句表达式不能为null或\"\"");
        }
        if (str.toUpperCase().contains("LIKE")) {
            return exeNormalDataSql(sQLiteDatabaseCheckDb, cls, String.format("SELECT rowid, * FROM %s, WHERE %s", CommonUtil.getClassName((Class) cls), str), null);
        }
        throw new IllegalArgumentException("sql语句表达式未包含LIEK");
    }

    public <T extends AbsDbWrapper> List<T> findRelationData(SQLiteDatabase sQLiteDatabase, Class<T> cls, String... strArr) {
        return exeRelationSql(sQLiteDatabase, cls, 1, Integer.MAX_VALUE, strArr);
    }

    public int[] getRowId(SQLiteDatabase sQLiteDatabase, Class cls) {
        Cursor cursorRawQuery = checkDb(sQLiteDatabase).rawQuery("SELECT rowid, * FROM " + CommonUtil.getClassName(cls), null);
        int[] iArr = new int[cursorRawQuery.getCount()];
        int i10 = 0;
        while (cursorRawQuery.moveToNext()) {
            iArr[i10] = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("rowid"));
            i10++;
        }
        cursorRawQuery.close();
        return iArr;
    }

    public <T extends DbEntity> boolean itemExist(SQLiteDatabase sQLiteDatabase, Class<T> cls, long j10) {
        return itemExist(sQLiteDatabase, CommonUtil.getClassName((Class) cls), j10);
    }

    public <T extends AbsDbWrapper> List<T> findRelationData(SQLiteDatabase sQLiteDatabase, Class<T> cls, int i10, int i11, String... strArr) {
        if (i10 >= 1 && i11 >= 1) {
            return exeRelationSql(sQLiteDatabase, cls, i10, i11, strArr);
        }
        ALog.w(AbsDelegate.TAG, "page，num 小于1");
        return null;
    }

    public boolean itemExist(SQLiteDatabase sQLiteDatabase, String str, long j10) {
        Cursor cursorRawQuery = checkDb(sQLiteDatabase).rawQuery("SELECT rowid FROM " + str + " WHERE rowid=" + j10, null);
        boolean z10 = cursorRawQuery.getCount() > 0;
        cursorRawQuery.close();
        return z10;
    }

    public int getRowId(SQLiteDatabase sQLiteDatabase, Class cls, Object[] objArr, Object[] objArr2) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (objArr.length > 0 && objArr2.length > 0) {
            if (objArr.length != objArr2.length) {
                ALog.e(AbsDelegate.TAG, "groupHash 和 vaule 长度不相等");
                return -1;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SELECT rowid FROM ");
            sb2.append(CommonUtil.getClassName(cls));
            sb2.append(" WHERE ");
            int i10 = 0;
            for (Object obj : objArr) {
                sb2.append(obj);
                sb2.append(u.f30904o);
                sb2.append("'");
                sb2.append(objArr2[i10]);
                sb2.append("'");
                sb2.append(i10 >= objArr.length + (-1) ? "" : c.f654g);
                i10++;
            }
            Cursor cursorRawQuery = sQLiteDatabaseCheckDb.rawQuery(sb2.toString(), null);
            int columnIndex = cursorRawQuery.getColumnIndex("rowid");
            cursorRawQuery.close();
            return columnIndex;
        }
        ALog.e(AbsDelegate.TAG, "请输入删除条件");
        return -1;
    }

    public <T extends DbEntity> List<T> findData(SQLiteDatabase sQLiteDatabase, Class<T> cls, int i10, int i11, String... strArr) {
        if (i10 >= 1 && i11 >= 1) {
            SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
            if (!CommonUtil.checkSqlExpression(strArr)) {
                return null;
            }
            String str = String.format("SELECT rowid, * FROM %s WHERE %s LIMIT %s,%s", CommonUtil.getClassName((Class) cls), strArr[0], Integer.valueOf((i10 - 1) * i11), Integer.valueOf(i11));
            int length = strArr.length - 1;
            String[] strArr2 = new String[length];
            try {
                System.arraycopy(strArr, 1, strArr2, 0, length);
                return exeNormalDataSql(sQLiteDatabaseCheckDb, cls, str, strArr2);
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
        ALog.w(AbsDelegate.TAG, "page, bum 小于1");
        return null;
    }

    public <T extends DbEntity> List<T> findDataByFuzzy(SQLiteDatabase sQLiteDatabase, Class<T> cls, int i10, int i11, String str) {
        if (i10 >= 1 && i11 >= 1) {
            SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
            if (!TextUtils.isEmpty(str)) {
                if (str.toUpperCase().contains("LIKE")) {
                    return exeNormalDataSql(sQLiteDatabaseCheckDb, cls, String.format("SELECT rowid, * FROM %s WHERE %s LIMIT %s,%s", CommonUtil.getClassName((Class) cls), str, Integer.valueOf((i10 - 1) * i11), Integer.valueOf(i11)), null);
                }
                throw new IllegalArgumentException("sql语句表达式未包含LIEK");
            }
            throw new IllegalArgumentException("sql语句表达式不能为null或\"\"");
        }
        ALog.w(AbsDelegate.TAG, "page, bum 小于1");
        return null;
    }

    private synchronized <T extends DbEntity> List<T> newInstanceEntity(Class<T> cls, Cursor cursor) {
        ArrayList arrayList;
        List<Field> allFields = CommonUtil.getAllFields(cls);
        arrayList = new ArrayList();
        if (allFields != null && allFields.size() > 0) {
            while (cursor.moveToNext()) {
                try {
                    T tNewInstance = cls.newInstance();
                    String name = "";
                    for (Field field : allFields) {
                        field.setAccessible(true);
                        if (!SqlUtil.isIgnore(field)) {
                            Class<?> type = field.getType();
                            if (SqlUtil.isPrimary(field) && (type == Integer.TYPE || type == Integer.class)) {
                                name = field.getName();
                            }
                            String str = name;
                            int columnIndex = cursor.getColumnIndex(field.getName());
                            if (columnIndex != -1) {
                                setFieldValue(type, field, columnIndex, cursor, tNewInstance);
                            }
                            name = str;
                        }
                    }
                    if (TextUtils.isEmpty(name)) {
                        name = "rowid";
                    }
                    tNewInstance.rowID = cursor.getInt(cursor.getColumnIndex(name));
                    arrayList.add(tNewInstance);
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (InstantiationException e11) {
                    e11.printStackTrace();
                }
            }
            closeCursor(cursor);
        }
        return arrayList;
    }
}
