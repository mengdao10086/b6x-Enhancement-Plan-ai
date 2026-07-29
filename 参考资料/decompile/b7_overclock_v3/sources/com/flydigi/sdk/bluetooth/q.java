package com.flydigi.sdk.bluetooth;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public a f16316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public j9.b f16317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16318c;

    public interface a {
        void a(@yt.k q qVar, @yt.l byte[] bArr);
    }

    public q(@yt.l a aVar) {
        this.f16316a = aVar;
        this.f16318c = this.f16317b != null;
    }

    public final void a() {
        this.f16317b = null;
    }

    public final void b() {
        a aVar = this.f16316a;
        if (aVar != null) {
            j9.b bVar = this.f16317b;
            aVar.a(this, bVar != null ? bVar.k() : null);
        }
    }

    @yt.l
    public final a c() {
        return this.f16316a;
    }

    @yt.l
    public final j9.b d() {
        return this.f16317b;
    }

    public final boolean e() {
        return this.f16318c;
    }

    public final void f(@yt.l a aVar) {
        this.f16316a = aVar;
    }

    public final void g(@yt.l j9.b bVar) {
        this.f16317b = bVar;
    }

    public final void h(@yt.k j9.b command) {
        kotlin.jvm.internal.f0.p(command, "command");
        this.f16317b = command;
    }
}
