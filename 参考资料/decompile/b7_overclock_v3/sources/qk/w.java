package qk;

import java.util.Iterator;
import kotlin.c2;
import kotlin.l1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@c2(markerClass = {kotlin.s.class})
@v0(version = "1.5")
public class w implements Iterable<l1>, jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f47429d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47432c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final w a(int i10, int i11, int i12) {
            return new w(i10, i11, i12, null);
        }
    }

    public w(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f47430a = i10;
        this.f47431b = bk.u.d(i10, i11, i12);
        this.f47432c = i12;
    }

    public /* synthetic */ w(int i10, int i11, int i12, kotlin.jvm.internal.u uVar) {
        this(i10, i11, i12);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (this.f47430a != wVar.f47430a || this.f47431b != wVar.f47431b || this.f47432c != wVar.f47432c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f47430a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f47430a * 31) + this.f47431b) * 31) + this.f47432c;
    }

    public boolean isEmpty() {
        if (this.f47432c > 0) {
            if (Integer.compare(this.f47430a ^ Integer.MIN_VALUE, this.f47431b ^ Integer.MIN_VALUE) > 0) {
                return true;
            }
        } else if (Integer.compare(this.f47430a ^ Integer.MIN_VALUE, this.f47431b ^ Integer.MIN_VALUE) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @yt.k
    public final Iterator<l1> iterator() {
        return new x(this.f47430a, this.f47431b, this.f47432c, null);
    }

    public final int j() {
        return this.f47431b;
    }

    public final int l() {
        return this.f47432c;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f47432c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) l1.g0(this.f47430a));
            sb2.append("..");
            sb2.append((Object) l1.g0(this.f47431b));
            sb2.append(" step ");
            i10 = this.f47432c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) l1.g0(this.f47430a));
            sb2.append(" downTo ");
            sb2.append((Object) l1.g0(this.f47431b));
            sb2.append(" step ");
            i10 = -this.f47432c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
