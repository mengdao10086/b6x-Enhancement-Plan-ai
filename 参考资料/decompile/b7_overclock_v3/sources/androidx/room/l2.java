package androidx.room;

import androidx.room.RoomDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 implements c2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2.i f7473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase.e f7474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f7476d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f7477e;

    public l2(@g.n0 c2.i iVar, @g.n0 RoomDatabase.e eVar, String str, @g.n0 Executor executor) {
        this.f7473a = iVar;
        this.f7474b = eVar;
        this.f7475c = str;
        this.f7477e = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.f7474b.a(this.f7475c, this.f7476d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f7474b.a(this.f7475c, this.f7476d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f7474b.a(this.f7475c, this.f7476d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f7474b.a(this.f7475c, this.f7476d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f7474b.a(this.f7475c, this.f7476d);
    }

    @Override // c2.f
    public void D(int i10, String str) {
        u(i10, str);
        this.f7473a.D(i10, str);
    }

    @Override // c2.f
    public void E0(int i10, byte[] bArr) {
        u(i10, bArr);
        this.f7473a.E0(i10, bArr);
    }

    @Override // c2.i
    public String I0() {
        this.f7477e.execute(new Runnable() { // from class: androidx.room.g2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7383a.n();
            }
        });
        return this.f7473a.I0();
    }

    @Override // c2.f
    public void M1() {
        this.f7476d.clear();
        this.f7473a.M1();
    }

    @Override // c2.f
    public void R(int i10, double d10) {
        u(i10, Double.valueOf(d10));
        this.f7473a.R(i10, d10);
    }

    @Override // c2.i
    public void X() {
        this.f7477e.execute(new Runnable() { // from class: androidx.room.h2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7428a.i();
            }
        });
        this.f7473a.X();
    }

    @Override // c2.i
    public long Y() {
        this.f7477e.execute(new Runnable() { // from class: androidx.room.k2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7466a.m();
            }
        });
        return this.f7473a.Y();
    }

    @Override // c2.i
    public long Z1() {
        this.f7477e.execute(new Runnable() { // from class: androidx.room.i2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7430a.k();
            }
        });
        return this.f7473a.Z1();
    }

    @Override // c2.i
    public int a0() {
        this.f7477e.execute(new Runnable() { // from class: androidx.room.j2
            @Override // java.lang.Runnable
            public final void run() {
                this.f7445a.l();
            }
        });
        return this.f7473a.a0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7473a.close();
    }

    @Override // c2.f
    public void l1(int i10) {
        u(i10, this.f7476d.toArray());
        this.f7473a.l1(i10);
    }

    @Override // c2.f
    public void s0(int i10, long j10) {
        u(i10, Long.valueOf(j10));
        this.f7473a.s0(i10, j10);
    }

    public final void u(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.f7476d.size()) {
            for (int size = this.f7476d.size(); size <= i11; size++) {
                this.f7476d.add(null);
            }
        }
        this.f7476d.set(i11, obj);
    }
}
