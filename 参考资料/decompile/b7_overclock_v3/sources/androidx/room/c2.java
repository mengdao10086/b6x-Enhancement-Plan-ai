package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 implements c2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2.d f7355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase.e f7356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f7357c;

    public c2(@g.n0 c2.d dVar, @g.n0 RoomDatabase.e eVar, @g.n0 Executor executor) {
        this.f7355a = dVar;
        this.f7356b = eVar;
        this.f7357c = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(String str, List list) {
        this.f7356b.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(c2.g gVar, f2 f2Var) {
        this.f7356b.a(gVar.d(), f2Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f7356b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f7356b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f7356b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(c2.g gVar, f2 f2Var) {
        this.f7356b.a(gVar.d(), f2Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        this.f7356b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.f7356b.a("END TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(String str) {
        this.f7356b.a(str, new ArrayList(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str, List list) {
        this.f7356b.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(String str) {
        this.f7356b.a(str, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1() {
        this.f7356b.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    @Override // c2.d
    public void A(int i10) {
        this.f7355a.A(i10);
    }

    @Override // c2.d
    public void A0() {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.t1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7516a.L();
            }
        });
        this.f7355a.A0();
    }

    @Override // c2.d
    @g.v0(api = 16)
    public void B() {
        this.f7355a.B();
    }

    @Override // c2.d
    public int B0(@g.n0 String str, int i10, @g.n0 ContentValues contentValues, @g.n0 String str2, @g.n0 Object[] objArr) {
        return this.f7355a.B0(str, i10, contentValues, str2, objArr);
    }

    @Override // c2.d
    public void C(@g.n0 final String str) throws SQLException {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.a2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7323a.W(str);
            }
        });
        this.f7355a.C(str);
    }

    @Override // c2.d
    public long C0(long j10) {
        return this.f7355a.C0(j10);
    }

    @Override // c2.d
    public boolean G() {
        return this.f7355a.G();
    }

    @Override // c2.d
    @g.v0(api = 16)
    public boolean G1() {
        return this.f7355a.G1();
    }

    @Override // c2.d
    public void I1(int i10) {
        this.f7355a.I1(i10);
    }

    @Override // c2.d
    @g.n0
    public c2.i K(@g.n0 String str) {
        return new l2(this.f7355a.K(str), this.f7356b, str, this.f7357c);
    }

    @Override // c2.d
    public boolean K0() {
        return this.f7355a.K0();
    }

    @Override // c2.d
    public void K1(long j10) {
        this.f7355a.K1(j10);
    }

    @Override // c2.d
    @g.n0
    public Cursor L0(@g.n0 final String str) {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.b2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7341a.b0(str);
            }
        });
        return this.f7355a.L0(str);
    }

    @Override // c2.d
    @g.n0
    public Cursor O(@g.n0 final c2.g gVar, @g.n0 CancellationSignal cancellationSignal) {
        final f2 f2Var = new f2();
        gVar.a(f2Var);
        this.f7357c.execute(new Runnable() { // from class: androidx.room.z1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7606a.M0(gVar, f2Var);
            }
        });
        return this.f7355a.j1(gVar);
    }

    @Override // c2.d
    public long P0(@g.n0 String str, int i10, @g.n0 ContentValues contentValues) throws SQLException {
        return this.f7355a.P0(str, i10, contentValues);
    }

    @Override // c2.d
    public void Q0(@g.n0 SQLiteTransactionListener sQLiteTransactionListener) {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.x1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7562a.M();
            }
        });
        this.f7355a.Q0(sQLiteTransactionListener);
    }

    @Override // c2.d
    public /* synthetic */ boolean R0() {
        return c2.c.b(this);
    }

    @Override // c2.d
    public /* synthetic */ void R1(String str, Object[] objArr) {
        c2.c.a(this, str, objArr);
    }

    @Override // c2.d
    public boolean S0() {
        return this.f7355a.S0();
    }

    @Override // c2.d
    public void T0() {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.q1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7503a.T();
            }
        });
        this.f7355a.T0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7355a.close();
    }

    @Override // c2.d
    public boolean e0() {
        return this.f7355a.e0();
    }

    @Override // c2.d
    public boolean f1(int i10) {
        return this.f7355a.f1(i10);
    }

    @Override // c2.d
    @g.n0
    public String getPath() {
        return this.f7355a.getPath();
    }

    @Override // c2.d
    public int getVersion() {
        return this.f7355a.getVersion();
    }

    @Override // c2.d
    public boolean isOpen() {
        return this.f7355a.isOpen();
    }

    @Override // c2.d
    public int j(@g.n0 String str, @g.n0 String str2, @g.n0 Object[] objArr) {
        return this.f7355a.j(str, str2, objArr);
    }

    @Override // c2.d
    @g.n0
    public Cursor j1(@g.n0 final c2.g gVar) {
        final f2 f2Var = new f2();
        gVar.a(f2Var);
        this.f7357c.execute(new Runnable() { // from class: androidx.room.y1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7584a.G0(gVar, f2Var);
            }
        });
        return this.f7355a.j1(gVar);
    }

    @Override // c2.d
    public void o() {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.w1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7539a.I();
            }
        });
        this.f7355a.o();
    }

    @Override // c2.d
    @g.v0(api = 16)
    public void o0(boolean z10) {
        this.f7355a.o0(z10);
    }

    @Override // c2.d
    public void o1(@g.n0 Locale locale) {
        this.f7355a.o1(locale);
    }

    @Override // c2.d
    public long q0() {
        return this.f7355a.q0();
    }

    @Override // c2.d
    public boolean t(long j10) {
        return this.f7355a.t(j10);
    }

    @Override // c2.d
    public boolean t0() {
        return this.f7355a.t0();
    }

    @Override // c2.d
    @g.n0
    public Cursor v(@g.n0 final String str, @g.n0 Object[] objArr) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.f7357c.execute(new Runnable() { // from class: androidx.room.s1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7511a.F0(str, arrayList);
            }
        });
        return this.f7355a.v(str, objArr);
    }

    @Override // c2.d
    public void v0() {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.u1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7519a.d1();
            }
        });
        this.f7355a.v0();
    }

    @Override // c2.d
    public void v1(@g.n0 SQLiteTransactionListener sQLiteTransactionListener) {
        this.f7357c.execute(new Runnable() { // from class: androidx.room.v1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7528a.P();
            }
        });
        this.f7355a.v1(sQLiteTransactionListener);
    }

    @Override // c2.d
    @g.n0
    public List<Pair<String, String>> w() {
        return this.f7355a.w();
    }

    @Override // c2.d
    public boolean x1() {
        return this.f7355a.x1();
    }

    @Override // c2.d
    public void y0(@g.n0 final String str, @g.n0 Object[] objArr) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.f7357c.execute(new Runnable() { // from class: androidx.room.r1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7504a.Z(str, arrayList);
            }
        });
        this.f7355a.y0(str, arrayList.toArray());
    }

    @Override // c2.d
    public long z0() {
        return this.f7355a.z0();
    }
}
