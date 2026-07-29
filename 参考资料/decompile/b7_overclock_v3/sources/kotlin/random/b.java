package kotlin.random;

import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends kotlin.random.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final a f38012c = new a();

    public static final class a extends ThreadLocal<java.util.Random> {
        @Override // java.lang.ThreadLocal
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.a
    @k
    public java.util.Random v() {
        java.util.Random random = this.f38012c.get();
        f0.o(random, "implStorage.get()");
        return random;
    }
}
