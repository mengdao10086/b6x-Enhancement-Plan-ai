package a;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uc f7583a = new uc(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3164a;
    public final int b;
    public final int c;
    public final int d;

    public uc(int i, int i2, int i3, int i4) {
        this.f3164a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static uc a(uc ucVar, uc ucVar2) {
        return b(Math.max(ucVar.f3164a, ucVar2.f3164a), Math.max(ucVar.b, ucVar2.b), Math.max(ucVar.c, ucVar2.c), Math.max(ucVar.d, ucVar2.d));
    }

    public static uc b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f7583a : new uc(i, i2, i3, i4);
    }

    public static uc c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static uc d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f3164a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || uc.class != obj.getClass()) {
            return false;
        }
        uc ucVar = (uc) obj;
        return this.d == ucVar.d && this.f3164a == ucVar.f3164a && this.c == ucVar.c && this.b == ucVar.b;
    }

    public int hashCode() {
        return (((((this.f3164a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.f3164a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
