package androidx.activity.result;

import f.b;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public b.j.f f1431a = b.j.C0317b.f27347a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public b.j.f f1432a = b.j.C0317b.f27347a;

        @yt.k
        public final j a() {
            j jVar = new j();
            jVar.b(this.f1432a);
            return jVar;
        }

        @yt.k
        public final a b(@yt.k b.j.f mediaType) {
            f0.p(mediaType, "mediaType");
            this.f1432a = mediaType;
            return this;
        }
    }

    @yt.k
    public final b.j.f a() {
        return this.f1431a;
    }

    public final void b(@yt.k b.j.f fVar) {
        f0.p(fVar, "<set-?>");
        this.f1431a = fVar;
    }
}
