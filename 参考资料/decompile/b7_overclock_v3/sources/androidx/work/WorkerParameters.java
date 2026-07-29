package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.p0;
import g.v0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public UUID f8299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public d f8300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public Set<String> f8301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public a f8302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public Executor f8304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public w2.a f8305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public y f8306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public s f8307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public h f8308j;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public List<String> f8309a = Collections.emptyList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public List<Uri> f8310b = Collections.emptyList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v0(28)
        public Network f8311c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerParameters(@n0 UUID id2, @n0 d inputData, @n0 Collection<String> tags, @n0 a runtimeExtras, @f0(from = 0) int runAttemptCount, @n0 Executor backgroundExecutor, @n0 w2.a workTaskExecutor, @n0 y workerFactory, @n0 s progressUpdater, @n0 h foregroundUpdater) {
        this.f8299a = id2;
        this.f8300b = inputData;
        this.f8301c = new HashSet(tags);
        this.f8302d = runtimeExtras;
        this.f8303e = runAttemptCount;
        this.f8304f = backgroundExecutor;
        this.f8305g = workTaskExecutor;
        this.f8306h = workerFactory;
        this.f8307i = progressUpdater;
        this.f8308j = foregroundUpdater;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public Executor a() {
        return this.f8304f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public h b() {
        return this.f8308j;
    }

    @n0
    public UUID c() {
        return this.f8299a;
    }

    @n0
    public d d() {
        return this.f8300b;
    }

    @p0
    @v0(28)
    public Network e() {
        return this.f8302d.f8311c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public s f() {
        return this.f8307i;
    }

    @f0(from = 0)
    public int g() {
        return this.f8303e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public a h() {
        return this.f8302d;
    }

    @n0
    public Set<String> i() {
        return this.f8301c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public w2.a j() {
        return this.f8305g;
    }

    @n0
    @v0(24)
    public List<String> k() {
        return this.f8302d.f8309a;
    }

    @n0
    @v0(24)
    public List<Uri> l() {
        return this.f8302d.f8310b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public y m() {
        return this.f8306h;
    }
}
