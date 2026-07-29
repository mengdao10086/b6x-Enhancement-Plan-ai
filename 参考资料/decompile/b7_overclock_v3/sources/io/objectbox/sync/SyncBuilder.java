package io.objectbox.sync;

import io.objectbox.BoxStore;
import io.objectbox.sync.listener.SyncChangeListener;
import java.util.Arrays;
import javax.annotation.Nullable;
import li.b;
import ui.c;
import ui.d;
import ui.e;
import ui.f;

/* JADX INFO: loaded from: classes5.dex */
@b
public class SyncBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti.a f32923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BoxStore f32924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f32925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SyncCredentials f32926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public e f32927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public ui.b f32928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public SyncChangeListener f32929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public c f32930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public f f32931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public d f32932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public String[] f32933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f32934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RequestUpdatesMode f32935m = RequestUpdatesMode.AUTO;

    public enum RequestUpdatesMode {
        MANUAL,
        AUTO,
        AUTO_NO_PUSHES
    }

    public SyncBuilder(BoxStore boxStore, String str, SyncCredentials syncCredentials) {
        d(boxStore, "BoxStore is required.");
        d(str, "Sync server URL is required.");
        d(syncCredentials, "Sync credentials are required.");
        if (!BoxStore.v2()) {
            throw new IllegalStateException("This library does not include ObjectBox Sync. Please visit https://objectbox.io/sync/ for options.");
        }
        this.f32923a = ti.a.a();
        this.f32924b = boxStore;
        this.f32925c = str;
        this.f32926d = syncCredentials;
    }

    public si.e a() {
        if (this.f32924b.V1() == null) {
            return new SyncClientImpl(this);
        }
        throw new IllegalStateException("The given store is already associated with a Sync client, close it first.");
    }

    public si.e b() {
        si.e eVarA = a();
        eVarA.start();
        return eVarA;
    }

    public SyncBuilder c(SyncChangeListener syncChangeListener) {
        this.f32929g = syncChangeListener;
        return this;
    }

    public final void d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public SyncBuilder e(ui.b bVar) {
        this.f32928f = bVar;
        return this;
    }

    public SyncBuilder f(c cVar) {
        this.f32930h = cVar;
        return this;
    }

    public SyncBuilder g(d dVar) {
        this.f32932j = dVar;
        return this;
    }

    public SyncBuilder h(e eVar) {
        this.f32927e = eVar;
        return this;
    }

    public SyncBuilder i(RequestUpdatesMode requestUpdatesMode) {
        this.f32935m = requestUpdatesMode;
        return this;
    }

    public SyncBuilder j(f fVar) {
        this.f32931i = fVar;
        return this;
    }

    public SyncBuilder k(String[] strArr) {
        this.f32933k = (String[]) Arrays.copyOf(strArr, strArr.length);
        return this;
    }

    public SyncBuilder l() {
        this.f32934l = true;
        return this;
    }
}
