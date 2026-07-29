package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import g.i1;
import g.p0;
import g.v0;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public final class o implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12343d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12344a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<a, Bitmap> f12345b = new h<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NavigableMap<Integer, Integer> f12346c = new PrettyPrintTreeMap();

    @i1
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f12347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12348b;

        public a(b bVar) {
            this.f12347a = bVar;
        }

        public void a(int i10) {
            this.f12348b = i10;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void b() {
            this.f12347a.c(this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f12348b == ((a) obj).f12348b;
        }

        public int hashCode() {
            return this.f12348b;
        }

        public String toString() {
            return o.g(this.f12348b);
        }
    }

    @i1
    public static class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i10) {
            a aVar = (a) super.b();
            aVar.a(i10);
            return aVar;
        }
    }

    public static String g(int i10) {
        return "[" + i10 + "]";
    }

    public static String h(Bitmap bitmap) {
        return g(v4.o.h(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return g(v4.o.g(i10, i11, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int b(Bitmap bitmap) {
        return v4.o.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String c(Bitmap bitmap) {
        return h(bitmap);
    }

    public final void d(Integer num) {
        Integer num2 = (Integer) this.f12346c.get(num);
        if (num2.intValue() == 1) {
            this.f12346c.remove(num);
        } else {
            this.f12346c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void e(Bitmap bitmap) {
        a aVarE = this.f12344a.e(v4.o.h(bitmap));
        this.f12345b.d(aVarE, bitmap);
        Integer num = (Integer) this.f12346c.get(Integer.valueOf(aVarE.f12348b));
        this.f12346c.put(Integer.valueOf(aVarE.f12348b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @p0
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        int iG = v4.o.g(i10, i11, config);
        a aVarE = this.f12344a.e(iG);
        Integer numCeilingKey = this.f12346c.ceilingKey(Integer.valueOf(iG));
        if (numCeilingKey != null && numCeilingKey.intValue() != iG && numCeilingKey.intValue() <= iG * 8) {
            this.f12344a.c(aVarE);
            aVarE = this.f12344a.e(numCeilingKey.intValue());
        }
        Bitmap bitmapA = this.f12345b.a(aVarE);
        if (bitmapA != null) {
            bitmapA.reconfigure(i10, i11, config);
            d(numCeilingKey);
        }
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @p0
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f12345b.f();
        if (bitmapF != null) {
            d(Integer.valueOf(v4.o.h(bitmapF)));
        }
        return bitmapF;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f12345b + "\n  SortedSizes" + this.f12346c;
    }
}
