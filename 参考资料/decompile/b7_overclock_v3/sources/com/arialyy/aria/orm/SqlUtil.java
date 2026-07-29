package com.arialyy.aria.orm;

import ag.c;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.orm.annotation.Default;
import com.arialyy.aria.orm.annotation.Foreign;
import com.arialyy.aria.orm.annotation.Ignore;
import com.arialyy.aria.orm.annotation.Many;
import com.arialyy.aria.orm.annotation.NoNull;
import com.arialyy.aria.orm.annotation.One;
import com.arialyy.aria.orm.annotation.Primary;
import com.arialyy.aria.orm.annotation.Unique;
import com.arialyy.aria.orm.annotation.Wrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.blankj.utilcode.util.i0;
import ee.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
final class SqlUtil {
    private static final String TAG = CommonUtil.getClassName("SqlUtil");

    private static Object checkData(String str, String str2) {
        if (str.equalsIgnoreCase("java.lang.String")) {
            return str2;
        }
        if (str.equalsIgnoreCase("int") || str.equals("java.lang.Integer")) {
            return Integer.valueOf(Integer.parseInt(str2));
        }
        if (str.equalsIgnoreCase("double") || str.equals("java.lang.Double")) {
            return Double.valueOf(Double.parseDouble(str2));
        }
        if (str.equalsIgnoreCase(w.b.f53667c) || str.equals("java.lang.Float")) {
            return Float.valueOf(Float.parseFloat(str2));
        }
        return null;
    }

    public static boolean checkDataExist(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls, String... strArr) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        if (!CommonUtil.checkSqlExpression(strArr)) {
            return false;
        }
        String strReplace = String.format("SELECT rowid, * FROM %s WHERE %s ", CommonUtil.getClassName((Class) cls), strArr[0]).replace("?", "%s");
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            strArr2[i10] = String.format("'%s'", encodeStr(strArr[i11]));
            i10 = i11;
        }
        Cursor cursorRawQuery = sQLiteDatabaseCheckDb.rawQuery(String.format(strReplace, strArr2), null);
        boolean z10 = cursorRawQuery.getCount() > 0;
        closeCursor(cursorRawQuery);
        return z10;
    }

    public static SQLiteDatabase checkDb(SQLiteDatabase sQLiteDatabase) {
        return (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) ? SqlHelper.getInstance().getDb() : sQLiteDatabase;
    }

    public static boolean checkList(Field field) {
        if (CommonUtil.getListParamType(field) == String.class) {
            return true;
        }
        ALog.d(TAG, "map参数错误，支持List<String>的参数字段");
        return false;
    }

    public static boolean checkMap(Field field) {
        Class[] mapParamType = CommonUtil.getMapParamType(field);
        if (mapParamType != null && mapParamType[0] != null && mapParamType[1] != null && mapParamType[0] == String.class && mapParamType[1] == String.class) {
            return true;
        }
        ALog.d(TAG, "map参数错误，支持Map<String,String>的参数字段");
        return false;
    }

    public static void checkOrCreateTable(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        if (tableExists(sQLiteDatabase, cls)) {
            return;
        }
        createTable(sQLiteDatabase, cls);
    }

    public static void clean(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        String className = CommonUtil.getClassName((Class) cls);
        if (tableExists(sQLiteDatabaseCheckDb, cls)) {
            sQLiteDatabaseCheckDb.execSQL("DELETE FROM " + className);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013 A[Catch: all -> 0x0015, DONT_GENERATE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:10:0x0010, B:11:0x0013), top: B:16:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void closeCursor(android.database.Cursor r2) {
        /*
            java.lang.Class<com.arialyy.aria.orm.AbsDelegate> r0 = com.arialyy.aria.orm.AbsDelegate.class
            monitor-enter(r0)
            if (r2 == 0) goto L13
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L13
            r2.close()     // Catch: android.database.SQLException -> Lf java.lang.Throwable -> L15
            goto L13
        Lf:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L15
        L13:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return
        L15:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.orm.SqlUtil.closeCursor(android.database.Cursor):void");
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        Class<?> type;
        String columnType;
        SQLiteDatabase sQLiteDatabaseCheckDb = checkDb(sQLiteDatabase);
        List<Field> allFields = CommonUtil.getAllFields(cls);
        if (allFields == null || allFields.size() <= 0) {
            return;
        }
        ArrayList<Field> arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE IF NOT EXISTS ");
        sb2.append(CommonUtil.getClassName((Class) cls));
        sb2.append(" (");
        for (Field field : allFields) {
            field.setAccessible(true);
            if (!isIgnore(field) && (columnType = getColumnType((type = field.getType()))) != null) {
                sb2.append(field.getName());
                sb2.append(i0.f11861z);
                sb2.append(columnType);
                if (isPrimary(field)) {
                    Primary primary = (Primary) field.getAnnotation(Primary.class);
                    sb2.append(" PRIMARY KEY");
                    if (primary.autoincrement() && (type == Integer.TYPE || type == Integer.class)) {
                        sb2.append(" AUTOINCREMENT");
                    }
                }
                if (isForeign(field)) {
                    arrayList.add(field);
                }
                if (isNoNull(field)) {
                    sb2.append(" NOT NULL");
                }
                if (isDefault(field)) {
                    Default r42 = (Default) field.getAnnotation(Default.class);
                    if (!TextUtils.isEmpty(r42.value())) {
                        sb2.append(" ERROR ");
                        sb2.append("'");
                        sb2.append(r42.value());
                        sb2.append("'");
                    }
                }
                if (isUnique(field)) {
                    sb2.append(" UNIQUE");
                }
                sb2.append(c.f654g);
            }
        }
        for (Field field2 : arrayList) {
            Foreign foreign = (Foreign) field2.getAnnotation(Foreign.class);
            sb2.append("FOREIGN KEY (");
            sb2.append(field2.getName());
            sb2.append(") REFERENCES ");
            sb2.append(CommonUtil.getClassName((Class) foreign.parent()));
            sb2.append(a.f26978c);
            sb2.append(foreign.column());
            sb2.append(a.f26979d);
            ActionPolicy actionPolicyOnUpdate = foreign.onUpdate();
            ActionPolicy actionPolicyOnDelete = foreign.onDelete();
            ActionPolicy actionPolicy = ActionPolicy.NO_ACTION;
            if (actionPolicyOnUpdate != actionPolicy) {
                sb2.append(" ON UPDATE ");
                sb2.append(actionPolicyOnUpdate.function);
            }
            if (actionPolicyOnDelete != actionPolicy) {
                sb2.append(" ON DELETE ");
                sb2.append(actionPolicyOnUpdate.function);
            }
            sb2.append(c.f654g);
        }
        String string = sb2.toString();
        String str = string.substring(0, string.length() - 1) + ");";
        ALog.d(TAG, "创建表的sql：" + str);
        sQLiteDatabaseCheckDb.execSQL(str);
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
        checkDb(sQLiteDatabase).execSQL(String.format("DROP TABLE IF EXISTS %s", str));
    }

    public static String encodeStr(String str) {
        return URLEncoder.encode(str.replaceAll("\\+", "%2B"));
    }

    public static List<Field> getAllNotIgnoreField(Class cls) {
        List<Field> allFields = CommonUtil.getAllFields(cls);
        ArrayList arrayList = new ArrayList();
        if (allFields == null || allFields.size() <= 0) {
            return null;
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            if (!isIgnore(field)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static String getColumnType(Class cls) {
        if (cls == String.class || cls.isEnum()) {
            return "VARCHAR";
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return "INTEGER";
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return "FLOAT";
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return "DOUBLE";
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return "BIGINT";
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return "BOOLEAN";
        }
        if (cls == Date.class || cls == java.sql.Date.class) {
            return "DATA";
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return "BLOB";
        }
        if (cls == Map.class || cls == List.class) {
            return "TEXT";
        }
        return null;
    }

    public static String getColumnTypeByFieldName(Class cls, String str) {
        for (Field field : CommonUtil.getAllFields(cls)) {
            if (field.getName().equals(str)) {
                return getColumnType(field.getType());
            }
        }
        return null;
    }

    public static List<String> getColumns(Class<? extends DbEntity> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : CommonUtil.getAllFields(cls)) {
            field.setAccessible(true);
            if (!isIgnore(field)) {
                arrayList.add(field.getName());
            }
        }
        return arrayList;
    }

    public static String getPrimaryName(Class<? extends DbEntity> cls) {
        List<Field> allFields = CommonUtil.getAllFields(cls);
        if (allFields == null || allFields.isEmpty()) {
            return null;
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            if (isPrimary(field)) {
                return field.getName();
            }
        }
        return null;
    }

    public static boolean isDefault(Field field) {
        return ((Default) field.getAnnotation(Default.class)) != null;
    }

    public static boolean isForeign(Field field) {
        return ((Foreign) field.getAnnotation(Foreign.class)) != null;
    }

    public static boolean isIgnore(Field field) {
        Ignore ignore = (Ignore) field.getAnnotation(Ignore.class);
        int modifiers = field.getModifiers();
        String name = field.getName();
        return (ignore != null && ignore.value()) || name.equals("rowID") || name.equals(AriaConfig.IGNORE_CLASS_KLASS) || name.equals(AriaConfig.IGNORE_CLASS_MONITOR) || field.isSynthetic() || Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers);
    }

    public static boolean isMany(Field field) {
        return ((Many) field.getAnnotation(Many.class)) != null;
    }

    public static boolean isNoNull(Field field) {
        return ((NoNull) field.getAnnotation(NoNull.class)) != null;
    }

    public static boolean isOne(Field field) {
        return ((One) field.getAnnotation(One.class)) != null;
    }

    public static boolean isPrimary(Field field) {
        return ((Primary) field.getAnnotation(Primary.class)) != null;
    }

    public static boolean isUnique(Field field) {
        return ((Unique) field.getAnnotation(Unique.class)) != null;
    }

    public static boolean isWrapper(Class<? extends AbsDbWrapper> cls) {
        return ((Wrapper) cls.getAnnotation(Wrapper.class)) != null;
    }

    public static String list2Str(DbEntity dbEntity, Field field) throws IllegalAccessException {
        List list = (List) field.get(dbEntity);
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            sb2.append("$$");
        }
        return sb2.toString();
    }

    public static String map2Str(Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        for (String str : map.keySet()) {
            sb2.append(CommonUtil.encryptBASE64(str));
            sb2.append("$");
            sb2.append(CommonUtil.encryptBASE64(map.get(str)));
            sb2.append(c.f654g);
        }
        String string = sb2.toString();
        if (!TextUtils.isEmpty(string)) {
            string = string.substring(0, string.length() - 1);
        }
        if (map.size() == 0) {
            return string;
        }
        return string + "_&_decode_&_";
    }

    public static List str2List(String str, Field field) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\$\\$");
        ArrayList arrayList = new ArrayList();
        Class listParamType = CommonUtil.getListParamType(field);
        if (listParamType != null) {
            String name = listParamType.getName();
            for (String str2 : strArrSplit) {
                arrayList.add(checkData(name, str2));
            }
        }
        return arrayList;
    }

    public static Map<String, String> str2Map(String str) {
        boolean z10;
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (str.endsWith("_&_decode_&_")) {
            str = str.substring(0, str.length() - 12);
            z10 = true;
        } else {
            z10 = false;
        }
        for (String str2 : str.split(c.f654g)) {
            String[] strArrSplit = str2.split("\\$");
            if (z10) {
                map.put(CommonUtil.decryptBASE64(strArrSplit[0]), CommonUtil.decryptBASE64(strArrSplit[1]));
            } else {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        return tableExists(sQLiteDatabase, CommonUtil.getClassName((Class) cls));
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = checkDb(sQLiteDatabase).rawQuery(String.format("SELECT COUNT(*) FROM sqlite_master WHERE type='table' AND name='%s'", str), null);
                if (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    if (cursorRawQuery.getInt(0) > 0) {
                        return true;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return false;
        } finally {
            closeCursor(cursorRawQuery);
        }
    }
}
