package m0;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public static final i f40558e = new i(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40562d;

    @v0(29)
    public static class a {
        @g.u
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public i(int i10, int i11, int i12, int i13) {
        this.f40559a = i10;
        this.f40560b = i11;
        this.f40561c = i12;
        this.f40562d = i13;
    }

    @n0
    public static i a(@n0 i iVar, @n0 i iVar2) {
        return d(iVar.f40559a + iVar2.f40559a, iVar.f40560b + iVar2.f40560b, iVar.f40561c + iVar2.f40561c, iVar.f40562d + iVar2.f40562d);
    }

    @n0
    public static i b(@n0 i iVar, @n0 i iVar2) {
        return d(Math.max(iVar.f40559a, iVar2.f40559a), Math.max(iVar.f40560b, iVar2.f40560b), Math.max(iVar.f40561c, iVar2.f40561c), Math.max(iVar.f40562d, iVar2.f40562d));
    }

    @n0
    public static i c(@n0 i iVar, @n0 i iVar2) {
        return d(Math.min(iVar.f40559a, iVar2.f40559a), Math.min(iVar.f40560b, iVar2.f40560b), Math.min(iVar.f40561c, iVar2.f40561c), Math.min(iVar.f40562d, iVar2.f40562d));
    }

    @n0
    public static i d(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f40558e : new i(i10, i11, i12, i13);
    }

    @n0
    public static i e(@n0 Rect rect) {
        return d(rect.left, rect.top, rect.right, rect.bottom);
    }

    @n0
    public static i f(@n0 i iVar, @n0 i iVar2) {
        return d(iVar.f40559a - iVar2.f40559a, iVar.f40560b - iVar2.f40560b, iVar.f40561c - iVar2.f40561c, iVar.f40562d - iVar2.f40562d);
    }

    @n0
    @v0(api = 29)
    public static i g(@n0 Insets insets) {
        return d(insets.left, insets.top, insets.right, insets.bottom);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    @v0(api = 29)
    public static i i(@n0 Insets insets) {
        return g(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f40562d == iVar.f40562d && this.f40559a == iVar.f40559a && this.f40561c == iVar.f40561c && this.f40560b == iVar.f40560b;
    }

    @n0
    @v0(29)
    public Insets h() {
        return a.a(this.f40559a, this.f40560b, this.f40561c, this.f40562d);
    }

    public int hashCode() {
        return (((((this.f40559a * 31) + this.f40560b) * 31) + this.f40561c) * 31) + this.f40562d;
    }

    @n0
    public String toString() {
        return "Insets{left=" + this.f40559a + ", top=" + this.f40560b + ", right=" + this.f40561c + ", bottom=" + this.f40562d + '}';
    }
}
