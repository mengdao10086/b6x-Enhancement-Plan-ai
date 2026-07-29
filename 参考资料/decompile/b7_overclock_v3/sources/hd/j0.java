package hd;

import hd.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class j0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Comparator<b> f31007h = new Comparator() { // from class: hd.h0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return j0.g((j0.b) obj, (j0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator<b> f31008i = new Comparator() { // from class: hd.i0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return j0.h((j0.b) obj, (j0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31009j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31010k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31011l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f31012m = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31013a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f31019g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b[] f31015c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f31014b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31016d = -1;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f31022c;

        public b() {
        }
    }

    public j0(int i10) {
        this.f31013a = i10;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f31020a - bVar2.f31020a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f31022c, bVar2.f31022c);
    }

    public void c(int i10, float f10) {
        b bVar;
        d();
        int i11 = this.f31019g;
        if (i11 > 0) {
            b[] bVarArr = this.f31015c;
            int i12 = i11 - 1;
            this.f31019g = i12;
            bVar = bVarArr[i12];
        } else {
            bVar = new b();
        }
        int i13 = this.f31017e;
        this.f31017e = i13 + 1;
        bVar.f31020a = i13;
        bVar.f31021b = i10;
        bVar.f31022c = f10;
        this.f31014b.add(bVar);
        this.f31018f += i10;
        while (true) {
            int i14 = this.f31018f;
            int i15 = this.f31013a;
            if (i14 <= i15) {
                return;
            }
            int i16 = i14 - i15;
            b bVar2 = this.f31014b.get(0);
            int i17 = bVar2.f31021b;
            if (i17 <= i16) {
                this.f31018f -= i17;
                this.f31014b.remove(0);
                int i18 = this.f31019g;
                if (i18 < 5) {
                    b[] bVarArr2 = this.f31015c;
                    this.f31019g = i18 + 1;
                    bVarArr2[i18] = bVar2;
                }
            } else {
                bVar2.f31021b = i17 - i16;
                this.f31018f -= i16;
            }
        }
    }

    public final void d() {
        if (this.f31016d != 1) {
            Collections.sort(this.f31014b, f31007h);
            this.f31016d = 1;
        }
    }

    public final void e() {
        if (this.f31016d != 0) {
            Collections.sort(this.f31014b, f31008i);
            this.f31016d = 0;
        }
    }

    public float f(float f10) {
        e();
        float f11 = f10 * this.f31018f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f31014b.size(); i11++) {
            b bVar = this.f31014b.get(i11);
            i10 += bVar.f31021b;
            if (i10 >= f11) {
                return bVar.f31022c;
            }
        }
        if (this.f31014b.isEmpty()) {
            return Float.NaN;
        }
        return this.f31014b.get(r5.size() - 1).f31022c;
    }

    public void i() {
        this.f31014b.clear();
        this.f31016d = -1;
        this.f31017e = 0;
        this.f31018f = 0;
    }
}
