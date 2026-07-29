package kotlinx.coroutines.channels;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.s0;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@hk.f
public final class j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final b f38377b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final c f38378c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Object f38379a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @yt.l
        public final Throwable f38380a;

        public a(@yt.l Throwable th2) {
            this.f38380a = th2;
        }

        public boolean equals(@yt.l Object obj) {
            return (obj instanceof a) && f0.g(this.f38380a, ((a) obj).f38380a);
        }

        public int hashCode() {
            Throwable th2 = this.f38380a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.j.c
        @yt.k
        public String toString() {
            return "Closed(" + this.f38380a + ')';
        }
    }

    @y1
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @y1
        @yt.k
        public final <E> Object a(@yt.l Throwable th2) {
            return j.c(new a(th2));
        }

        @y1
        @yt.k
        public final <E> Object b() {
            return j.c(j.f38378c);
        }

        @y1
        @yt.k
        public final <E> Object c(E e10) {
            return j.c(e10);
        }
    }

    public static class c {
        @yt.k
        public String toString() {
            return "Failed";
        }
    }

    @s0
    public /* synthetic */ j(Object obj) {
        this.f38379a = obj;
    }

    public static final /* synthetic */ j b(Object obj) {
        return new j(obj);
    }

    @s0
    @yt.k
    public static <T> Object c(@yt.l Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof j) && f0.g(obj, ((j) obj2).o());
    }

    public static final boolean e(Object obj, Object obj2) {
        return f0.g(obj, obj2);
    }

    @yt.l
    public static final Throwable f(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f38380a;
        }
        return null;
    }

    @s0
    public static /* synthetic */ void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.l
    public static final T h(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T i(Object obj) throws Throwable {
        Throwable th2;
        if (!(obj instanceof c)) {
            return obj;
        }
        if ((obj instanceof a) && (th2 = ((a) obj).f38380a) != null) {
            throw th2;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean k(Object obj) {
        return obj instanceof a;
    }

    public static final boolean l(Object obj) {
        return obj instanceof c;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof c);
    }

    @yt.k
    public static String n(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f38379a, obj);
    }

    public int hashCode() {
        return j(this.f38379a);
    }

    public final /* synthetic */ Object o() {
        return this.f38379a;
    }

    @yt.k
    public String toString() {
        return n(this.f38379a);
    }
}
