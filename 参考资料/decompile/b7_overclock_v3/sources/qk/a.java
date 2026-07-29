package qk;

import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements Iterable<Character>, jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final C0546a f47381d = new C0546a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f47382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f47383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47384c;

    /* JADX INFO: renamed from: qk.a$a, reason: collision with other inner class name */
    public static final class C0546a {
        public C0546a() {
        }

        public /* synthetic */ C0546a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final a a(char c10, char c11, int i10) {
            return new a(c10, c11, i10);
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f47382a = c10;
        this.f47383b = (char) bk.n.c(c10, c11, i10);
        this.f47384c = i10;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f47382a != aVar.f47382a || this.f47383b != aVar.f47383b || this.f47384c != aVar.f47384c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char g() {
        return this.f47382a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f47382a * 31) + this.f47383b) * 31) + this.f47384c;
    }

    public boolean isEmpty() {
        if (this.f47384c > 0) {
            if (f0.t(this.f47382a, this.f47383b) > 0) {
                return true;
            }
        } else if (f0.t(this.f47382a, this.f47383b) < 0) {
            return true;
        }
        return false;
    }

    public final char j() {
        return this.f47383b;
    }

    public final int l() {
        return this.f47384c;
    }

    @Override // java.lang.Iterable
    @yt.k
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public kotlin.collections.q iterator() {
        return new b(this.f47382a, this.f47383b, this.f47384c);
    }

    @yt.k
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f47384c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f47382a);
            sb2.append("..");
            sb2.append(this.f47383b);
            sb2.append(" step ");
            i10 = this.f47384c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f47382a);
            sb2.append(" downTo ");
            sb2.append(this.f47383b);
            sb2.append(" step ");
            i10 = -this.f47384c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
