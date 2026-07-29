package cc;

import android.util.SparseArray;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.upstream.cache.a;
import hd.u0;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public class b implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseArray<Constructor<? extends w>> f10689c = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.d f10690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f10691b;

    @Deprecated
    public b(a.d dVar) {
        this(dVar, androidx.profileinstaller.f.f6454a);
    }

    public static SparseArray<Constructor<? extends w>> c() {
        SparseArray<Constructor<? extends w>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, d(jc.a.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(kc.a.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(pc.a.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    public static Constructor<? extends w> d(Class<?> cls) {
        try {
            return cls.asSubclass(w.class).getConstructor(v0.class, a.d.class, Executor.class);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException("Downloader constructor missing", e10);
        }
    }

    @Override // cc.x
    public w a(DownloadRequest downloadRequest) {
        int iB0 = u0.B0(downloadRequest.f17408b, downloadRequest.f17409c);
        if (iB0 == 0 || iB0 == 1 || iB0 == 2) {
            return b(downloadRequest, iB0);
        }
        if (iB0 == 3) {
            return new b0(new v0.c().F(downloadRequest.f17408b).j(downloadRequest.f17412f).a(), this.f10690a, this.f10691b);
        }
        throw new IllegalArgumentException("Unsupported type: " + iB0);
    }

    public final w b(DownloadRequest downloadRequest, int i10) {
        Constructor<? extends w> constructor = f10689c.get(i10);
        if (constructor == null) {
            throw new IllegalStateException("Module missing for content type " + i10);
        }
        try {
            return constructor.newInstance(new v0.c().F(downloadRequest.f17408b).C(downloadRequest.f17410d).j(downloadRequest.f17412f).l(downloadRequest.f17411e).a(), this.f10690a, this.f10691b);
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to instantiate downloader for content type " + i10);
        }
    }

    public b(a.d dVar, Executor executor) {
        this.f10690a = (a.d) hd.a.g(dVar);
        this.f10691b = (Executor) hd.a.g(executor);
    }
}
