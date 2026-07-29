package io.objectbox.sync;

import ii.i;
import io.objectbox.BoxStore;
import io.objectbox.sync.SyncBuilder;
import io.objectbox.sync.listener.SyncChangeListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import li.c;
import si.e;
import ui.d;
import ui.f;

/* JADX INFO: loaded from: classes5.dex */
@c
public class SyncClientImpl implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public BoxStore f32936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InternalSyncClientListener f32938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final si.a f32939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f32940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public volatile ui.e f32941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public volatile ui.b f32942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public volatile ui.c f32943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public volatile f f32944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f32945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f32946k;

    public class InternalSyncClientListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f32947a;

        public InternalSyncClientListener() {
            this.f32947a = new CountDownLatch(1);
        }

        public boolean a(long j10) {
            try {
                return this.f32947a.await(j10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return false;
            }
        }

        public void b() {
            ui.c cVar = SyncClientImpl.this.f32943h;
            if (cVar != null) {
                cVar.a();
            }
        }

        public void c() {
            SyncClientImpl.this.f32945j = 20L;
            this.f32947a.countDown();
            ui.e eVar = SyncClientImpl.this.f32941f;
            if (eVar != null) {
                eVar.c();
            }
        }

        public void d(long j10) {
            SyncClientImpl.this.f32945j = j10;
            this.f32947a.countDown();
            ui.e eVar = SyncClientImpl.this.f32941f;
            if (eVar != null) {
                eVar.b(j10);
            }
        }

        public void e(long j10) {
            f fVar = SyncClientImpl.this.f32944i;
            if (fVar != null) {
                fVar.e(j10);
            }
        }

        public void f() {
            ui.b bVar = SyncClientImpl.this.f32942g;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    public static class b implements si.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f32949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f32950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SyncClientImpl f32951c;

        @Override // si.b
        public boolean b() {
            if (!this.f32951c.O1()) {
                return false;
            }
            f();
            this.f32949a = true;
            SyncClientImpl syncClientImpl = this.f32951c;
            return syncClientImpl.nativeObjectsMessageSend(syncClientImpl.u(), this.f32950b);
        }

        @Override // si.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b c(long j10, byte[] bArr, boolean z10) {
            f();
            this.f32951c.nativeObjectsMessageAddBytes(this.f32950b, j10, bArr, z10);
            return this;
        }

        @Override // si.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b a(long j10, String str) {
            f();
            this.f32951c.nativeObjectsMessageAddString(this.f32950b, j10, str);
            return this;
        }

        public final void f() {
            if (this.f32949a) {
                throw new IllegalStateException("Already sent this message, start a new one instead.");
            }
        }

        public b(SyncClientImpl syncClientImpl, long j10, @Nullable String str) {
            this.f32951c = syncClientImpl;
            this.f32950b = syncClientImpl.nativeObjectsMessageStart(j10, str);
        }
    }

    public SyncClientImpl(SyncBuilder syncBuilder) {
        this.f32936a = syncBuilder.f32924b;
        String str = syncBuilder.f32925c;
        this.f32937b = str;
        this.f32939d = syncBuilder.f32923a.b();
        long jNativeCreate = nativeCreate(i.f(syncBuilder.f32924b), str, syncBuilder.f32933k);
        if (jNativeCreate == 0) {
            throw new RuntimeException("Failed to create sync client: handle is zero.");
        }
        this.f32940e = jNativeCreate;
        SyncBuilder.RequestUpdatesMode requestUpdatesMode = syncBuilder.f32935m;
        if (requestUpdatesMode != SyncBuilder.RequestUpdatesMode.AUTO) {
            nativeSetRequestUpdatesMode(jNativeCreate, requestUpdatesMode != SyncBuilder.RequestUpdatesMode.MANUAL, false);
        }
        if (syncBuilder.f32934l) {
            nativeSetUncommittedAcks(jNativeCreate, true);
        }
        d dVar = syncBuilder.f32932j;
        if (dVar != null) {
            J0(dVar);
        } else {
            this.f32941f = syncBuilder.f32927e;
            this.f32942g = syncBuilder.f32928f;
            SyncChangeListener syncChangeListener = syncBuilder.f32929g;
            if (syncChangeListener != null) {
                b(syncChangeListener);
            }
            this.f32943h = syncBuilder.f32930h;
            this.f32944i = syncBuilder.f32931i;
        }
        InternalSyncClientListener internalSyncClientListener = new InternalSyncClientListener();
        this.f32938c = internalSyncClientListener;
        nativeSetListener(jNativeCreate, internalSyncClientListener);
        i0(syncBuilder.f32926d);
        i.m(syncBuilder.f32924b, this);
    }

    private native boolean nativeCancelUpdates(long j10);

    private static native long nativeCreate(long j10, String str, @Nullable String[] strArr);

    private native void nativeDelete(long j10);

    private native int nativeGetState(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeObjectsMessageAddBytes(long j10, long j11, byte[] bArr, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeObjectsMessageAddString(long j10, long j11, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeObjectsMessageSend(long j10, long j11);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeObjectsMessageStart(long j10, @Nullable String str);

    private native boolean nativeRequestFullSync(long j10, boolean z10);

    private native boolean nativeRequestUpdates(long j10, boolean z10);

    private native long nativeRoundtripTime(long j10);

    private native long nativeServerTime(long j10);

    private native long nativeServerTimeDiff(long j10);

    private native void nativeSetListener(long j10, @Nullable InternalSyncClientListener internalSyncClientListener);

    private native void nativeSetLoginInfo(long j10, long j11, @Nullable byte[] bArr);

    private native void nativeSetRequestUpdatesMode(long j10, boolean z10, boolean z11);

    private native void nativeSetSyncChangesListener(long j10, @Nullable SyncChangeListener syncChangeListener);

    private native void nativeSetUncommittedAcks(long j10, boolean z10);

    private native void nativeStart(long j10);

    private native void nativeStop(long j10);

    private native boolean nativeTriggerReconnect(long j10);

    @Override // si.e
    public boolean F() {
        return nativeRequestUpdates(u(), false);
    }

    @li.b
    public boolean I() {
        return nativeRequestFullSync(u(), true);
    }

    @Override // si.e
    public void J0(@Nullable d dVar) {
        this.f32941f = dVar;
        this.f32942g = dVar;
        this.f32944i = dVar;
        this.f32943h = dVar;
        b(dVar);
    }

    @Override // si.e
    public boolean N1(long j10) {
        if (!this.f32946k) {
            start();
        }
        return this.f32938c.a(j10);
    }

    @Override // si.e
    public boolean O1() {
        return this.f32946k;
    }

    @Override // si.e
    public void P1() {
        nativeTriggerReconnect(u());
    }

    @Override // si.e
    public boolean Q() {
        return nativeCancelUpdates(u());
    }

    @Override // si.e
    public long Q1() {
        return nativeServerTime(u());
    }

    @Override // si.e
    public long X1() {
        return nativeRoundtripTime(u());
    }

    @Override // si.e
    public void b(@Nullable SyncChangeListener syncChangeListener) {
        nativeSetSyncChangesListener(u(), syncChangeListener);
    }

    @Override // si.e
    public boolean b1() {
        return nativeRequestUpdates(u(), true);
    }

    @Override // si.e
    public void c1(@Nullable ui.c cVar) {
        this.f32943h = cVar;
    }

    @Override // si.e
    @li.b
    public boolean c2() {
        return nativeRequestFullSync(u(), false);
    }

    @Override // si.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10;
        synchronized (this) {
            si.a aVar = this.f32939d;
            if (aVar != null) {
                aVar.d();
            }
            BoxStore boxStore = this.f32936a;
            if (boxStore != null) {
                if (boxStore.V1() == this) {
                    i.m(boxStore, null);
                }
                this.f32936a = null;
            }
            j10 = this.f32940e;
            this.f32940e = 0L;
        }
        if (j10 != 0) {
            nativeDelete(j10);
        }
    }

    @Override // si.e
    public boolean e1() {
        return this.f32945j == 20;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override // si.e
    public void i0(SyncCredentials syncCredentials) {
        io.objectbox.sync.a aVar = (io.objectbox.sync.a) syncCredentials;
        nativeSetLoginInfo(u(), aVar.h(), aVar.g());
        aVar.f();
    }

    @Override // si.e
    public void p(@Nullable ui.e eVar) {
        this.f32941f = eVar;
    }

    @Override // si.e
    public void p0(@Nullable ui.b bVar) {
        this.f32942g = bVar;
    }

    @Override // si.e
    public si.b r(long j10, @Nullable String str) {
        return new b(j10, str);
    }

    @Override // si.e
    public synchronized void start() {
        nativeStart(u());
        this.f32946k = true;
        si.a aVar = this.f32939d;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    @Override // si.e
    public synchronized void stop() {
        si.a aVar = this.f32939d;
        if (aVar != null) {
            aVar.d();
        }
        nativeStop(u());
        this.f32946k = false;
    }

    @Override // si.e
    public String t1() {
        return this.f32937b;
    }

    public final long u() {
        long j10 = this.f32940e;
        if (j10 != 0) {
            return j10;
        }
        throw new IllegalStateException("SyncClient already closed");
    }

    @Override // si.e
    public long u0() {
        return nativeServerTimeDiff(u());
    }

    @Override // si.e
    public long w0() {
        return this.f32945j;
    }

    @Override // si.e
    public void x(@Nullable f fVar) {
        this.f32944i = fVar;
    }

    public SyncState z() {
        return SyncState.fromId(nativeGetState(u()));
    }
}
