package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import cc.c;
import cc.d;
import cc.d0;
import cc.e;
import cc.s;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.offline.DownloadRequest;
import g.b0;
import g.i1;
import g.p0;
import hd.u0;
import hd.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements d0 {
    public static final int A = 4;
    public static final int B = 5;
    public static final int C = 6;
    public static final int D = 7;
    public static final int E = 8;
    public static final int F = 9;
    public static final int G = 10;
    public static final int H = 11;
    public static final int I = 12;
    public static final int J = 13;
    public static final int K = 14;
    public static final String L = "id = ?";
    public static final String M = "state = 2";
    public static final String P = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
    public static final String Q = "1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17430f = "ExoPlayerDownloads";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @i1
    public static final int f17431g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17432h = "id";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f17434j = "uri";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f17437m = "data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f17438n = "state";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f17442r = "stop_reason";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f17447w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f17448x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f17449y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f17450z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final db.a f17453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f17454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("initializationLock")
    public boolean f17455e;
    public static final String N = q(3, 4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f17433i = "mime_type";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f17435k = "stream_keys";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17436l = "custom_cache_key";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f17439o = "start_time_ms";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f17440p = "update_time_ms";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f17441q = "content_length";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f17443s = "failure_reason";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f17444t = "percent_downloaded";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f17445u = "bytes_downloaded";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f17446v = "key_set_id";
    public static final String[] O = {"id", f17433i, "uri", f17435k, f17436l, "data", "state", f17439o, f17440p, f17441q, "stop_reason", f17443s, f17444t, f17445u, f17446v};

    /* JADX INFO: renamed from: com.google.android.exoplayer2.offline.b$b, reason: collision with other inner class name */
    public static final class C0180b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f17456a;

        @Override // cc.e
        public c D1() {
            return b.o(this.f17456a);
        }

        @Override // cc.e, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f17456a.close();
        }

        @Override // cc.e
        public int getCount() {
            return this.f17456a.getCount();
        }

        @Override // cc.e
        public int getPosition() {
            return this.f17456a.getPosition();
        }

        @Override // cc.e
        public /* synthetic */ boolean isAfterLast() {
            return d.a(this);
        }

        @Override // cc.e
        public /* synthetic */ boolean isBeforeFirst() {
            return d.b(this);
        }

        @Override // cc.e
        public boolean isClosed() {
            return this.f17456a.isClosed();
        }

        @Override // cc.e
        public /* synthetic */ boolean isFirst() {
            return d.c(this);
        }

        @Override // cc.e
        public /* synthetic */ boolean isLast() {
            return d.d(this);
        }

        @Override // cc.e
        public /* synthetic */ boolean moveToFirst() {
            return d.e(this);
        }

        @Override // cc.e
        public /* synthetic */ boolean moveToLast() {
            return d.f(this);
        }

        @Override // cc.e
        public /* synthetic */ boolean moveToNext() {
            return d.g(this);
        }

        @Override // cc.e
        public boolean moveToPosition(int i10) {
            return this.f17456a.moveToPosition(i10);
        }

        @Override // cc.e
        public /* synthetic */ boolean moveToPrevious() {
            return d.h(this);
        }

        public C0180b(Cursor cursor) {
            this.f17456a = cursor;
        }
    }

    public b(db.a aVar) {
        this(aVar, "");
    }

    public static /* synthetic */ void i(Throwable th2, AutoCloseable autoCloseable) throws Exception {
        if (th2 == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    public static List<StreamKey> k(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.isEmpty()) {
            return arrayList;
        }
        for (String str2 : u0.n1(str, ag.c.f654g)) {
            String[] strArrN1 = u0.n1(str2, "\\.");
            hd.a.i(strArrN1.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(strArrN1[0]), Integer.parseInt(strArrN1[1]), Integer.parseInt(strArrN1[2])));
        }
        return arrayList;
    }

    @i1
    public static String l(List<StreamKey> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            StreamKey streamKey = list.get(i10);
            sb2.append(streamKey.f17421a);
            sb2.append('.');
            sb2.append(streamKey.f17422b);
            sb2.append('.');
            sb2.append(streamKey.f17423c);
            sb2.append(',');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static c o(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.b bVarF = new DownloadRequest.b(cursor.getString(0), Uri.parse(cursor.getString(2))).e(cursor.getString(1)).f(k(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest downloadRequestA = bVarF.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        s sVar = new s();
        sVar.f10810a = cursor.getLong(13);
        sVar.f10811b = cursor.getFloat(12);
        int i10 = cursor.getInt(6);
        return new c(downloadRequestA, i10, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i10 == 4 ? cursor.getInt(11) : 0, sVar);
    }

    public static c p(Cursor cursor) {
        DownloadRequest downloadRequestA = new DownloadRequest.b(cursor.getString(0), Uri.parse(cursor.getString(2))).e(r(cursor.getString(1))).f(k(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        s sVar = new s();
        sVar.f10810a = cursor.getLong(13);
        sVar.f10811b = cursor.getFloat(12);
        int i10 = cursor.getInt(6);
        return new c(downloadRequestA, i10, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i10 == 4 ? cursor.getInt(11) : 0, sVar);
    }

    public static String q(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("state");
        sb2.append(" IN (");
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i10]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static String r(String str) {
        return com.google.android.exoplayer2.offline.a.f17426d.equals(str) ? w.f31187h0 : com.google.android.exoplayer2.offline.a.f17427e.equals(str) ? w.f31189i0 : com.google.android.exoplayer2.offline.a.f17428f.equals(str) ? w.f31191j0 : w.f31220y;
    }

    @Override // cc.m
    public e a(int... iArr) throws DatabaseIOException {
        m();
        return new C0180b(n(q(iArr), null));
    }

    @Override // cc.d0
    public void b() throws DatabaseIOException {
        m();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put(f17443s, (Integer) 0);
            this.f17453c.getWritableDatabase().update(this.f17452b, contentValues, null, null);
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @Override // cc.d0
    public void c(String str, int i10) throws DatabaseIOException {
        m();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i10));
            this.f17453c.getWritableDatabase().update(this.f17452b, contentValues, N + " AND id = ?", new String[]{str});
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @Override // cc.d0
    public void d(c cVar) throws DatabaseIOException {
        m();
        try {
            t(cVar, this.f17453c.getWritableDatabase());
        } catch (SQLiteException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @Override // cc.d0
    public void e() throws DatabaseIOException {
        m();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.f17453c.getWritableDatabase().update(this.f17452b, contentValues, M, null);
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @Override // cc.m
    @p0
    public c f(String str) throws Exception {
        m();
        try {
            Cursor cursorN = n("id = ?", new String[]{str});
            try {
                if (cursorN.getCount() == 0) {
                    i(null, cursorN);
                    return null;
                }
                cursorN.moveToNext();
                c cVarO = o(cursorN);
                i(null, cursorN);
                return cVarO;
            } finally {
            }
        } catch (SQLiteException e10) {
            throw new DatabaseIOException(e10);
        }
        throw new DatabaseIOException(e10);
    }

    @Override // cc.d0
    public void g(String str) throws DatabaseIOException {
        m();
        try {
            this.f17453c.getWritableDatabase().delete(this.f17452b, "id = ?", new String[]{str});
        } catch (SQLiteException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @Override // cc.d0
    public void h(int i10) throws DatabaseIOException {
        m();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i10));
            this.f17453c.getWritableDatabase().update(this.f17452b, contentValues, N, null);
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    public final void m() throws DatabaseIOException {
        synchronized (this.f17454d) {
            if (this.f17455e) {
                return;
            }
            try {
                int iB = db.d.b(this.f17453c.getReadableDatabase(), 0, this.f17451a);
                if (iB != 3) {
                    SQLiteDatabase writableDatabase = this.f17453c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        db.d.d(writableDatabase, 0, this.f17451a, 3);
                        List<c> listS = iB == 2 ? s(writableDatabase) : new ArrayList<>();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f17452b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f17452b + i0.f11861z + P);
                        Iterator<c> it2 = listS.iterator();
                        while (it2.hasNext()) {
                            t(it2.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                this.f17455e = true;
            } catch (SQLException e10) {
                throw new DatabaseIOException(e10);
            }
        }
    }

    public final Cursor n(String str, @p0 String[] strArr) throws DatabaseIOException {
        try {
            return this.f17453c.getReadableDatabase().query(this.f17452b, O, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    public final List<c> s(SQLiteDatabase sQLiteDatabase) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (!u0.s1(sQLiteDatabase, this.f17452b)) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.f17452b, new String[]{"id", "title", "uri", f17435k, f17436l, "data", "state", f17439o, f17440p, f17441q, "stop_reason", f17443s, f17444t, f17445u}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(p(cursorQuery));
            } finally {
            }
        }
        i(null, cursorQuery);
        return arrayList;
    }

    public final void t(c cVar, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = cVar.f10711a.f17411e;
        if (bArr == null) {
            bArr = u0.f31159f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.f10711a.f17407a);
        contentValues.put(f17433i, cVar.f10711a.f17409c);
        contentValues.put("uri", cVar.f10711a.f17408b.toString());
        contentValues.put(f17435k, l(cVar.f10711a.f17410d));
        contentValues.put(f17436l, cVar.f10711a.f17412f);
        contentValues.put("data", cVar.f10711a.f17413g);
        contentValues.put("state", Integer.valueOf(cVar.f10712b));
        contentValues.put(f17439o, Long.valueOf(cVar.f10713c));
        contentValues.put(f17440p, Long.valueOf(cVar.f10714d));
        contentValues.put(f17441q, Long.valueOf(cVar.f10715e));
        contentValues.put("stop_reason", Integer.valueOf(cVar.f10716f));
        contentValues.put(f17443s, Integer.valueOf(cVar.f10717g));
        contentValues.put(f17444t, Float.valueOf(cVar.b()));
        contentValues.put(f17445u, Long.valueOf(cVar.a()));
        contentValues.put(f17446v, bArr);
        sQLiteDatabase.replaceOrThrow(this.f17452b, null, contentValues);
    }

    public b(db.a aVar, String str) {
        this.f17451a = str;
        this.f17453c = aVar;
        this.f17452b = f17430f + str;
        this.f17454d = new Object();
    }
}
