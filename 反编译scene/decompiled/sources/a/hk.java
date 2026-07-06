package a;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hk<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fk<T> f6319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1175a = new Rect();
    public final Rect b = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f1176b;

    public hk(boolean z, fk<T> fkVar) {
        this.f1176b = z;
        this.f6319a = fkVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.f1175a;
        Rect rect2 = this.b;
        this.f6319a.a(t, rect);
        this.f6319a.a(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.f1176b ? 1 : -1;
        }
        if (i3 > i4) {
            return this.f1176b ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return this.f1176b ? 1 : -1;
        }
        if (i7 > i8) {
            return this.f1176b ? -1 : 1;
        }
        return 0;
    }
}
