package xl;

import com.flydigi.sdk.bluetooth.l;
import kotlin.collections.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lxl/k;", "", "Lkotlin/z1;", "a", "", "id", "value", "k", "", "i", "b", l.f16298a, "defaultValue", "c", "f", "g", "h", "other", xf.j.f55230b, "d", "()I", "headerTableSize", "e", "initialWindowSize", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f55597c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55598d = 65535;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55599e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55600f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55601g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f55602h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f55603i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55604j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f55605k = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f55606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final int[] f55607b = new int[10];

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lxl/k$a;", "", "", "COUNT", "I", "DEFAULT_INITIAL_WINDOW_SIZE", "ENABLE_PUSH", "HEADER_TABLE_SIZE", "INITIAL_WINDOW_SIZE", "MAX_CONCURRENT_STREAMS", "MAX_FRAME_SIZE", "MAX_HEADER_LIST_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public final void a() {
        this.f55606a = 0;
        m.u2(this.f55607b, 0, 0, 0, 6, null);
    }

    public final int b(int i10) {
        return this.f55607b[i10];
    }

    public final boolean c(boolean z10) {
        return (this.f55606a & 4) != 0 ? this.f55607b[2] == 1 : z10;
    }

    public final int d() {
        if ((this.f55606a & 2) != 0) {
            return this.f55607b[1];
        }
        return -1;
    }

    public final int e() {
        if ((this.f55606a & 128) != 0) {
            return this.f55607b[7];
        }
        return 65535;
    }

    public final int f() {
        if ((this.f55606a & 16) != 0) {
            return this.f55607b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int g(int i10) {
        return (this.f55606a & 32) != 0 ? this.f55607b[5] : i10;
    }

    public final int h(int i10) {
        return (this.f55606a & 64) != 0 ? this.f55607b[6] : i10;
    }

    public final boolean i(int i10) {
        return ((1 << i10) & this.f55606a) != 0;
    }

    public final void j(@yt.k k other) {
        f0.p(other, "other");
        int i10 = 0;
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (other.i(i10)) {
                k(i10, other.b(i10));
            }
            i10 = i11;
        }
    }

    @yt.k
    public final k k(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f55607b;
            if (i10 < iArr.length) {
                this.f55606a = (1 << i10) | this.f55606a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public final int l() {
        return Integer.bitCount(this.f55606a);
    }
}
