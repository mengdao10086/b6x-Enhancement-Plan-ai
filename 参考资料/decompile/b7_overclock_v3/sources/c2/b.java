package c2;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(16)
    public static final class a {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void a(@n0 CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static CancellationSignal b() {
            return new CancellationSignal();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean c(@n0 File file) {
            return SQLiteDatabase.deleteDatabase(file);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void d(@n0 SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean e(@n0 SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static Cursor f(@n0 SQLiteDatabase sQLiteDatabase, @n0 String str, @n0 String[] strArr, @n0 String str2, @n0 CancellationSignal cancellationSignal, @n0 SQLiteDatabase.CursorFactory cursorFactory) {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void g(@n0 SQLiteDatabase sQLiteDatabase, boolean z10) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void h(@n0 SQLiteOpenHelper sQLiteOpenHelper, boolean z10) {
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z10);
        }
    }

    /* JADX INFO: renamed from: c2.b$b, reason: collision with other inner class name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(19)
    public static final class C0107b {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static Uri a(@n0 Cursor cursor) {
            return cursor.getNotificationUri();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean b(@n0 ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(21)
    public static final class c {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static File a(@n0 Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public static final class d {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void a(@n0 Cursor cursor, @n0 Bundle bundle) {
            cursor.setExtras(bundle);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(29)
    public static final class e {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public static List<Uri> a(@n0 Cursor cursor) {
            return cursor.getNotificationUris();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void b(@n0 Cursor cursor, @n0 ContentResolver contentResolver, @n0 List<Uri> list) {
            cursor.setNotificationUris(contentResolver, list);
        }
    }
}
