package io.objectbox.sync.server;

import ii.i;
import io.objectbox.sync.SyncCredentials;
import io.objectbox.sync.a;
import io.objectbox.sync.listener.SyncChangeListener;
import java.util.Iterator;
import javax.annotation.Nullable;
import li.c;
import vi.b;

/* JADX INFO: loaded from: classes5.dex */
@c
public class SyncServerImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f32958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public volatile SyncChangeListener f32959c;

    public SyncServerImpl(vi.c cVar) {
        String str = cVar.f53186b;
        this.f32957a = str;
        long jNativeCreate = nativeCreate(i.f(cVar.f53185a), str, cVar.f53189e);
        if (jNativeCreate == 0) {
            throw new RuntimeException("Failed to create sync server: handle is zero.");
        }
        this.f32958b = jNativeCreate;
        Iterator<SyncCredentials> it2 = cVar.f53187c.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            nativeSetAuthenticator(jNativeCreate, aVar.h(), aVar.g());
            aVar.f();
        }
        for (vi.a aVar2 : cVar.f53188d) {
            a aVar3 = (a) aVar2.f53184b;
            nativeAddPeer(jNativeCreate, aVar2.f53183a, aVar3.h(), aVar3.g());
        }
        SyncChangeListener syncChangeListener = cVar.f53190f;
        if (syncChangeListener != null) {
            b(syncChangeListener);
        }
    }

    private native void nativeAddPeer(long j10, String str, long j11, @Nullable byte[] bArr);

    private static native long nativeCreate(long j10, String str, @Nullable String str2);

    private native void nativeDelete(long j10);

    private native int nativeGetPort(long j10);

    private native String nativeGetStatsString(long j10);

    private native boolean nativeIsRunning(long j10);

    private native void nativeSetAuthenticator(long j10, long j11, @Nullable byte[] bArr);

    private native void nativeSetSyncChangesListener(long j10, @Nullable SyncChangeListener syncChangeListener);

    private native void nativeStart(long j10);

    private native void nativeStop(long j10);

    public final long a() {
        long j10 = this.f32958b;
        if (j10 != 0) {
            return j10;
        }
        throw new IllegalStateException("SyncServer already closed");
    }

    @Override // vi.b
    public void b(@Nullable SyncChangeListener syncChangeListener) {
        this.f32959c = syncChangeListener;
        nativeSetSyncChangesListener(a(), syncChangeListener);
    }

    @Override // vi.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10 = this.f32958b;
        this.f32958b = 0L;
        if (j10 != 0) {
            nativeDelete(j10);
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override // vi.b
    public int getPort() {
        return nativeGetPort(a());
    }

    @Override // vi.b
    public boolean isRunning() {
        return nativeIsRunning(a());
    }

    @Override // vi.b
    public String m0() {
        return this.f32957a;
    }

    @Override // vi.b
    public void start() {
        nativeStart(a());
    }

    @Override // vi.b
    public void stop() {
        nativeStop(a());
    }

    @Override // vi.b
    public String x0() {
        return nativeGetStatsString(a());
    }
}
