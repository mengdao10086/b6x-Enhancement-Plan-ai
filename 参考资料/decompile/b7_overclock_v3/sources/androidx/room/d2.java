package androidx.room;

import androidx.room.RoomDatabase;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class d2 implements c2.e, p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2.e f7363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase.e f7364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f7365c;

    public d2(@g.n0 c2.e eVar, @g.n0 RoomDatabase.e eVar2, @g.n0 Executor executor) {
        this.f7363a = eVar;
        this.f7364b = eVar2;
        this.f7365c = executor;
    }

    @Override // c2.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7363a.close();
    }

    @Override // c2.e
    @g.p0
    public String getDatabaseName() {
        return this.f7363a.getDatabaseName();
    }

    @Override // c2.e
    public c2.d getReadableDatabase() {
        return new c2(this.f7363a.getReadableDatabase(), this.f7364b, this.f7365c);
    }

    @Override // c2.e
    public c2.d getWritableDatabase() {
        return new c2(this.f7363a.getWritableDatabase(), this.f7364b, this.f7365c);
    }

    @Override // androidx.room.p0
    @g.n0
    public c2.e l() {
        return this.f7363a;
    }

    @Override // c2.e
    @g.v0(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f7363a.setWriteAheadLoggingEnabled(z10);
    }
}
