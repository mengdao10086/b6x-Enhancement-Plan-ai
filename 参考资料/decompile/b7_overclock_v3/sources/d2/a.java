package d2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import c2.b;
import c2.g;
import c2.i;
import g.n0;
import g.p0;
import g.v0;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c2.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f25949b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f25950c = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f25951a;

    /* JADX INFO: renamed from: d2.a$a, reason: collision with other inner class name */
    public class C0290a implements SQLiteDatabase.CursorFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f25952a;

        public C0290a(g gVar) {
            this.f25952a = gVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f25952a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public class b implements SQLiteDatabase.CursorFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f25954a;

        public b(g gVar) {
            this.f25954a = gVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f25954a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f25951a = sQLiteDatabase;
    }

    @Override // c2.d
    public void A(int i10) {
        this.f25951a.setVersion(i10);
    }

    @Override // c2.d
    public void A0() {
        this.f25951a.beginTransactionNonExclusive();
    }

    @Override // c2.d
    @v0(api = 16)
    public void B() {
        b.a.d(this.f25951a);
    }

    @Override // c2.d
    public int B0(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("UPDATE ");
        sb2.append(f25949b[i10]);
        sb2.append(str);
        sb2.append(" SET ");
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        int i11 = 0;
        for (String str3 : contentValues.keySet()) {
            sb2.append(i11 > 0 ? ag.c.f654g : "");
            sb2.append(str3);
            objArr2[i11] = contentValues.get(str3);
            sb2.append("=?");
            i11++;
        }
        if (objArr != null) {
            for (int i12 = size; i12 < length; i12++) {
                objArr2[i12] = objArr[i12 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        i iVarK = K(sb2.toString());
        c2.a.e(iVarK, objArr2);
        return iVarK.a0();
    }

    @Override // c2.d
    public void C(String str) throws SQLException {
        this.f25951a.execSQL(str);
    }

    @Override // c2.d
    public long C0(long j10) {
        return this.f25951a.setMaximumSize(j10);
    }

    @Override // c2.d
    public boolean G() {
        return this.f25951a.isDatabaseIntegrityOk();
    }

    @Override // c2.d
    @v0(api = 16)
    public boolean G1() {
        return b.a.e(this.f25951a);
    }

    @Override // c2.d
    public void I1(int i10) {
        this.f25951a.setMaxSqlCacheSize(i10);
    }

    @Override // c2.d
    public i K(String str) {
        return new e(this.f25951a.compileStatement(str));
    }

    @Override // c2.d
    public boolean K0() {
        return this.f25951a.yieldIfContendedSafely();
    }

    @Override // c2.d
    public void K1(long j10) {
        this.f25951a.setPageSize(j10);
    }

    @Override // c2.d
    public Cursor L0(String str) {
        return j1(new c2.a(str));
    }

    @Override // c2.d
    @v0(api = 16)
    public Cursor O(g gVar, CancellationSignal cancellationSignal) {
        return b.a.f(this.f25951a, gVar.d(), f25950c, null, cancellationSignal, new b(gVar));
    }

    @Override // c2.d
    public long P0(String str, int i10, ContentValues contentValues) throws SQLException {
        return this.f25951a.insertWithOnConflict(str, null, contentValues, i10);
    }

    @Override // c2.d
    public void Q0(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f25951a.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // c2.d
    public boolean R0() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Override // c2.d
    public void R1(@n0 String str, @p0 Object[] objArr) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f25951a.execPerConnectionSQL(str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i10);
    }

    @Override // c2.d
    public boolean S0() {
        return this.f25951a.isDbLockedByCurrentThread();
    }

    @Override // c2.d
    public void T0() {
        this.f25951a.endTransaction();
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f25951a == sQLiteDatabase;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25951a.close();
    }

    @Override // c2.d
    public boolean e0() {
        return this.f25951a.isReadOnly();
    }

    @Override // c2.d
    public boolean f1(int i10) {
        return this.f25951a.needUpgrade(i10);
    }

    @Override // c2.d
    public String getPath() {
        return this.f25951a.getPath();
    }

    @Override // c2.d
    public int getVersion() {
        return this.f25951a.getVersion();
    }

    @Override // c2.d
    public boolean isOpen() {
        return this.f25951a.isOpen();
    }

    @Override // c2.d
    public int j(String str, String str2, Object[] objArr) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM ");
        sb2.append(str);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb2.append(str3);
        i iVarK = K(sb2.toString());
        c2.a.e(iVarK, objArr);
        return iVarK.a0();
    }

    @Override // c2.d
    public Cursor j1(g gVar) {
        return this.f25951a.rawQueryWithFactory(new C0290a(gVar), gVar.d(), f25950c, null);
    }

    @Override // c2.d
    public void o() {
        this.f25951a.beginTransaction();
    }

    @Override // c2.d
    @v0(api = 16)
    public void o0(boolean z10) {
        b.a.g(this.f25951a, z10);
    }

    @Override // c2.d
    public void o1(Locale locale) {
        this.f25951a.setLocale(locale);
    }

    @Override // c2.d
    public long q0() {
        return this.f25951a.getPageSize();
    }

    @Override // c2.d
    public boolean t(long j10) {
        return this.f25951a.yieldIfContendedSafely(j10);
    }

    @Override // c2.d
    public boolean t0() {
        return this.f25951a.enableWriteAheadLogging();
    }

    @Override // c2.d
    public Cursor v(String str, Object[] objArr) {
        return j1(new c2.a(str, objArr));
    }

    @Override // c2.d
    public void v0() {
        this.f25951a.setTransactionSuccessful();
    }

    @Override // c2.d
    public void v1(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f25951a.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // c2.d
    public List<Pair<String, String>> w() {
        return this.f25951a.getAttachedDbs();
    }

    @Override // c2.d
    public boolean x1() {
        return this.f25951a.inTransaction();
    }

    @Override // c2.d
    public void y0(String str, Object[] objArr) throws SQLException {
        this.f25951a.execSQL(str, objArr);
    }

    @Override // c2.d
    public long z0() {
        return this.f25951a.getMaximumSize();
    }
}
