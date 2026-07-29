package db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteOpenHelper f26127a;

    public b(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f26127a = sQLiteOpenHelper;
    }

    @Override // db.a
    public SQLiteDatabase getReadableDatabase() {
        return this.f26127a.getReadableDatabase();
    }

    @Override // db.a
    public SQLiteDatabase getWritableDatabase() {
        return this.f26127a.getWritableDatabase();
    }
}
