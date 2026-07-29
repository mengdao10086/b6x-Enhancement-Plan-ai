package qk;

import kotlin.collections.k0;

/* JADX INFO: loaded from: classes5.dex */
public class k implements Iterable<Integer>, jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f47405d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47408c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final k a(int i10, int i11, int i12) {
            return new k(i10, i11, i12);
        }
    }

    public k(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f47406a = i10;
        this.f47407b = bk.n.c(i10, i11, i12);
        this.f47408c = i12;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (this.f47406a != kVar.f47406a || this.f47407b != kVar.f47407b || this.f47408c != kVar.f47408c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f47406a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f47406a * 31) + this.f47407b) * 31) + this.f47408c;
    }

    public boolean isEmpty() {
        if (this.f47408c > 0) {
            if (this.f47406a > this.f47407b) {
                return true;
            }
        } else if (this.f47406a < this.f47407b) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.f47407b;
    }

    public final int l() {
        return this.f47408c;
    }

    @Override // java.lang.Iterable
    @yt.k
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public k0 iterator() {
        return new l(this.f47406a, this.f47407b, this.f47408c);
    }

    @yt.k
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f47408c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f47406a);
            sb2.append("..");
            sb2.append(this.f47407b);
            sb2.append(" step ");
            i10 = this.f47408c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f47406a);
            sb2.append(" downTo ");
            sb2.append(this.f47407b);
            sb2.append(" step ");
            i10 = -this.f47408c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
