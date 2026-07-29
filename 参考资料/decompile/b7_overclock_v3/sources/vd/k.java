package vd;

import com.google.android.material.R;
import g.d1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    @g.n
    public final int[] f53084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final i f53085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.f
    public final int f53086c;

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public i f53088b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        @g.n
        public int[] f53087a = new int[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.f
        public int f53089c = R.attr.colorPrimary;

        @n0
        public k d() {
            return new k(this);
        }

        @n0
        public b e(@g.f int i10) {
            this.f53089c = i10;
            return this;
        }

        @n0
        public b f(@p0 i iVar) {
            this.f53088b = iVar;
            return this;
        }

        @n0
        public b g(@n0 @g.n int[] iArr) {
            this.f53087a = iArr;
            return this;
        }
    }

    @n0
    public static k a() {
        return new b().f(i.c()).d();
    }

    @g.f
    public int b() {
        return this.f53086c;
    }

    @p0
    public i c() {
        return this.f53085b;
    }

    @n0
    @g.n
    public int[] d() {
        return this.f53084a;
    }

    @d1
    public int e(@d1 int i10) {
        i iVar = this.f53085b;
        return (iVar == null || iVar.e() == 0) ? i10 : this.f53085b.e();
    }

    public k(b bVar) {
        this.f53084a = bVar.f53087a;
        this.f53085b = bVar.f53088b;
        this.f53086c = bVar.f53089c;
    }
}
