package c2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import g.n0;
import g.p0;
import g.v0;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends Closeable {
    void A(int i10);

    void A0();

    @v0(api = 16)
    void B();

    int B0(String str, int i10, ContentValues contentValues, String str2, Object[] objArr);

    void C(String str) throws SQLException;

    long C0(long j10);

    boolean G();

    @v0(api = 16)
    boolean G1();

    void I1(int i10);

    i K(String str);

    boolean K0();

    void K1(long j10);

    Cursor L0(String str);

    @v0(api = 16)
    Cursor O(g gVar, CancellationSignal cancellationSignal);

    long P0(String str, int i10, ContentValues contentValues) throws SQLException;

    void Q0(SQLiteTransactionListener sQLiteTransactionListener);

    boolean R0();

    void R1(@n0 String str, @p0 @SuppressLint({"ArrayReturn"}) Object[] objArr);

    boolean S0();

    void T0();

    boolean e0();

    boolean f1(int i10);

    String getPath();

    int getVersion();

    boolean isOpen();

    int j(String str, String str2, Object[] objArr);

    Cursor j1(g gVar);

    void o();

    @v0(api = 16)
    void o0(boolean z10);

    void o1(Locale locale);

    long q0();

    boolean t(long j10);

    boolean t0();

    Cursor v(String str, Object[] objArr);

    void v0();

    void v1(SQLiteTransactionListener sQLiteTransactionListener);

    List<Pair<String, String>> w();

    boolean x1();

    void y0(String str, Object[] objArr) throws SQLException;

    long z0();
}
