package db;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    public static final String A1 = "ExoPlayer";

    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
