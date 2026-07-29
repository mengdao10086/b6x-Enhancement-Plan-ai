package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import g.n0;
import g.p0;
import java.util.List;
import java.util.Queue;
import s4.o;
import s4.p;

/* JADX INFO: loaded from: classes2.dex */
public class f<T> implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f12126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f12127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<T> f12128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b<T> f12129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12131g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12133i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12132h = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12134j = true;

    public interface a<U> {
        @n0
        List<U> a(int i10);

        @p0
        h<?> b(@n0 U u6);
    }

    public interface b<T> {
        @p0
        int[] a(@n0 T t10, int i10, int i11);
    }

    public static final class c implements p<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public com.bumptech.glide.request.e f12137c;

        @Override // p4.m
        public void a() {
        }

        @Override // p4.m
        public void b() {
        }

        @Override // p4.m
        public void c() {
        }

        @Override // s4.p
        public void f(@n0 o oVar) {
        }

        @Override // s4.p
        public void g(@n0 Object obj, @p0 t4.f<? super Object> fVar) {
        }

        @Override // s4.p
        public void l(@p0 com.bumptech.glide.request.e eVar) {
            this.f12137c = eVar;
        }

        @Override // s4.p
        public void m(@n0 o oVar) {
            oVar.e(this.f12136b, this.f12135a);
        }

        @Override // s4.p
        public void n(@p0 Drawable drawable) {
        }

        @Override // s4.p
        public void q(@p0 Drawable drawable) {
        }

        @Override // s4.p
        @p0
        public com.bumptech.glide.request.e r() {
            return this.f12137c;
        }

        @Override // s4.p
        public void s(@p0 Drawable drawable) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<c> f12138a;

        public d(int i10) {
            this.f12138a = v4.o.f(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f12138a.offer(new c());
            }
        }

        public c a(int i10, int i11) {
            c cVarPoll = this.f12138a.poll();
            this.f12138a.offer(cVarPoll);
            cVarPoll.f12136b = i10;
            cVarPoll.f12135a = i11;
            return cVarPoll;
        }
    }

    public f(@n0 i iVar, @n0 a<T> aVar, @n0 b<T> bVar, int i10) {
        this.f12127c = iVar;
        this.f12128d = aVar;
        this.f12129e = bVar;
        this.f12125a = i10;
        this.f12126b = new d(i10 + 1);
    }

    public final void a() {
        for (int i10 = 0; i10 < this.f12126b.f12138a.size(); i10++) {
            this.f12127c.C(this.f12126b.a(0, 0));
        }
    }

    public final void b(int i10, int i11) {
        int iMin;
        int iMax;
        if (i10 < i11) {
            iMax = Math.max(this.f12130f, i10);
            iMin = i11;
        } else {
            iMin = Math.min(this.f12131g, i10);
            iMax = i11;
        }
        int iMin2 = Math.min(this.f12133i, iMin);
        int iMin3 = Math.min(this.f12133i, Math.max(0, iMax));
        if (i10 < i11) {
            for (int i12 = iMin3; i12 < iMin2; i12++) {
                d(this.f12128d.a(i12), i12, true);
            }
        } else {
            for (int i13 = iMin2 - 1; i13 >= iMin3; i13--) {
                d(this.f12128d.a(i13), i13, false);
            }
        }
        this.f12131g = iMin3;
        this.f12130f = iMin2;
    }

    public final void c(int i10, boolean z10) {
        if (this.f12134j != z10) {
            this.f12134j = z10;
            a();
        }
        b(i10, (z10 ? this.f12125a : -this.f12125a) + i10);
    }

    public final void d(List<T> list, int i10, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                e(list.get(i11), i10, i11);
            }
            return;
        }
        for (int i12 = size - 1; i12 >= 0; i12--) {
            e(list.get(i12), i10, i12);
        }
    }

    public final void e(@p0 T t10, int i10, int i11) {
        int[] iArrA;
        h<?> hVarB;
        if (t10 == null || (iArrA = this.f12129e.a(t10, i10, i11)) == null || (hVarB = this.f12128d.b(t10)) == null) {
            return;
        }
        hVarB.p1(this.f12126b.a(iArrA[0], iArrA[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        this.f12133i = i12;
        int i13 = this.f12132h;
        if (i10 > i13) {
            c(i11 + i10, true);
        } else if (i10 < i13) {
            c(i10, false);
        }
        this.f12132h = i10;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
