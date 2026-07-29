package d7;

import com.blankj.utilcode.util.u;
import java.util.Arrays;
import java.util.Objects;
import u9.b;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26070f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26071g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26072h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26073i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f26074j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f26076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f26077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26079e;

    public static a g(@k byte[] bArr, boolean z10) {
        u.l(bArr);
        a aVar = new a();
        aVar.l(bArr[4]);
        aVar.k(bArr[5]);
        aVar.j(bArr[6]);
        int i10 = !z10 ? 8 : 7;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        aVar.h(new int[]{b.b(bArr[i10]), b.b(bArr[i11]), b.b(bArr[i12])});
        int i14 = i13 + 1;
        aVar.i(new int[]{b.b(bArr[i13]), b.b(bArr[i14]), b.b(bArr[i14 + 1])});
        return aVar;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        aVar.l(this.f26075a);
        aVar.k(this.f26078d);
        aVar.j(this.f26079e);
        aVar.h(this.f26076b);
        aVar.i(this.f26077c);
        return aVar;
    }

    public int[] b() {
        return this.f26076b;
    }

    public int[] c() {
        return this.f26077c;
    }

    public int d() {
        return this.f26079e;
    }

    public int e() {
        return this.f26078d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f26075a == aVar.f26075a && this.f26078d == aVar.f26078d && this.f26079e == aVar.f26079e && Arrays.equals(this.f26076b, aVar.f26076b) && Arrays.equals(this.f26077c, aVar.f26077c);
    }

    public int f() {
        return this.f26075a;
    }

    public void h(int[] iArr) {
        this.f26076b = iArr;
    }

    public int hashCode() {
        return (((Objects.hash(Integer.valueOf(this.f26075a), Integer.valueOf(this.f26078d), Integer.valueOf(this.f26079e)) * 31) + Arrays.hashCode(this.f26076b)) * 31) + Arrays.hashCode(this.f26077c);
    }

    public void i(int[] iArr) {
        this.f26077c = iArr;
    }

    public void j(int i10) {
        this.f26079e = i10;
    }

    public void k(int i10) {
        this.f26078d = i10;
    }

    public void l(int i10) {
        this.f26075a = i10;
    }

    public String toString() {
        return "LedConfigBean{type=" + this.f26075a + ", color1=" + Arrays.toString(this.f26076b) + ", color2=" + Arrays.toString(this.f26077c) + ", time=" + this.f26078d + ", light=" + this.f26079e + '}';
    }
}
