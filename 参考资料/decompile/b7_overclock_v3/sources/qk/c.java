package qk;

import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends qk.a implements h<Character>, s<Character> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f47395e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final c f47396f = new c(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final c a() {
            return c.f47396f;
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    @kotlin.k(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @v0(version = "1.7")
    @kotlin.q
    public static /* synthetic */ void r() {
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return p(((Character) comparable).charValue());
    }

    @Override // qk.a
    public boolean equals(@yt.l Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (g() != cVar.g() || j() != cVar.j()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // qk.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + j();
    }

    @Override // qk.a, qk.h
    public boolean isEmpty() {
        return f0.t(g(), j()) > 0;
    }

    public boolean p(char c10) {
        return f0.t(g(), c10) <= 0 && f0.t(c10, j()) <= 0;
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Character d() {
        if (j() != 65535) {
            return Character.valueOf((char) (j() + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Character e() {
        return Character.valueOf(j());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Character a() {
        return Character.valueOf(g());
    }

    @Override // qk.a
    @yt.k
    public String toString() {
        return g() + ".." + j();
    }
}
