package l0;

import android.database.sqlite.SQLiteDatabase;
import ik.l;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final <T> T a(@k SQLiteDatabase sQLiteDatabase, boolean z10, @k l<? super SQLiteDatabase, ? extends T> body) {
        f0.p(sQLiteDatabase, "<this>");
        f0.p(body, "body");
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tI = body.i(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tI;
        } finally {
            c0.d(1);
            sQLiteDatabase.endTransaction();
            c0.c(1);
        }
    }

    public static /* synthetic */ Object b(SQLiteDatabase sQLiteDatabase, boolean z10, l body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        f0.p(sQLiteDatabase, "<this>");
        f0.p(body, "body");
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objI = body.i(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objI;
        } finally {
            c0.d(1);
            sQLiteDatabase.endTransaction();
            c0.c(1);
        }
    }
}
