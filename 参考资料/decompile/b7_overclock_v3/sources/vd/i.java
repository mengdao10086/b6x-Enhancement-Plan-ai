package vd;

import com.google.android.material.R;
import g.d1;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f53080c = {R.attr.colorError, R.attr.colorOnError, R.attr.colorErrorContainer, R.attr.colorOnErrorContainer};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f53081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d1
    public final int f53082b;

    public i(@g.f @n0 int[] iArr, @d1 int i10) {
        if (i10 != 0 && iArr.length == 0) {
            throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
        }
        this.f53081a = iArr;
        this.f53082b = i10;
    }

    @n0
    public static i a(@g.f @n0 int[] iArr) {
        return new i(iArr, 0);
    }

    @n0
    public static i b(@g.f @n0 int[] iArr, @d1 int i10) {
        return new i(iArr, i10);
    }

    @n0
    public static i c() {
        return b(f53080c, R.style.ThemeOverlay_Material3_HarmonizedColors);
    }

    @n0
    public int[] d() {
        return this.f53081a;
    }

    @d1
    public int e() {
        return this.f53082b;
    }
}
