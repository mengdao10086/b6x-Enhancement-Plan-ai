package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;

/* JADX INFO: loaded from: classes2.dex */
public class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7507a = "ROOM";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7508b = "room_master_table";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7509c = "_CursorConverter";

    @Deprecated
    public r2() {
    }

    @g.n0
    public static <T extends RoomDatabase> RoomDatabase.a<T> a(@g.n0 Context context, @g.n0 Class<T> cls, @g.n0 String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.a<>(context, cls, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @g.n0
    public static <T, C> T b(@g.n0 Class<C> cls, @g.n0 String str) {
        String str2;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + j3.b.f36044h + str3;
            }
            return (T) Class.forName(str2, true, cls.getClassLoader()).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    @g.n0
    public static <T extends RoomDatabase> RoomDatabase.a<T> c(@g.n0 Context context, @g.n0 Class<T> cls) {
        return new RoomDatabase.a<>(context, cls, null);
    }
}
