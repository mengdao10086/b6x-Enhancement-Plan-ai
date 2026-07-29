package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import g.i1;
import g.p0;
import g.v0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public class n implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12330d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f12331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f12332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f12333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f12334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Bitmap.Config[] f12335i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12336a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<b, Bitmap> f12337b = new h<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f12338c = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12339a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f12339a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12339a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12339a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12339a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @i1
    public static class c extends d<b> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b bVarB = b();
            bVarB.a(i10, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f12331e = configArr;
        f12332f = configArr;
        f12333g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f12334h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f12335i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ee.a.f26979d;
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f12332f;
        }
        int i10 = a.f12339a[config.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Bitmap.Config[]{config} : f12335i : f12334h : f12333g : f12331e;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return h(v4.o.g(i10, i11, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int b(Bitmap bitmap) {
        return v4.o.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String c(Bitmap bitmap) {
        return h(v4.o.h(bitmap), bitmap.getConfig());
    }

    public final void d(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(bitmap) + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void e(Bitmap bitmap) {
        b bVarE = this.f12336a.e(v4.o.h(bitmap), bitmap.getConfig());
        this.f12337b.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(bVarE.f12341b));
        navigableMapJ.put(Integer.valueOf(bVarE.f12341b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @p0
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        b bVarG = g(v4.o.g(i10, i11, config), config);
        Bitmap bitmapA = this.f12337b.a(bVarG);
        if (bitmapA != null) {
            d(Integer.valueOf(bVarG.f12341b), bitmapA);
            bitmapA.reconfigure(i10, i11, config);
        }
        return bitmapA;
    }

    public final b g(int i10, Bitmap.Config config) {
        b bVarE = this.f12336a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer numCeilingKey = j(config2).ceilingKey(Integer.valueOf(i10));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i10 * 8) {
                if (numCeilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarE;
                        }
                    } else if (config2.equals(config)) {
                        return bVarE;
                    }
                }
                this.f12336a.c(bVarE);
                return this.f12336a.e(numCeilingKey.intValue(), config2);
            }
        }
        return bVarE;
    }

    public final NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f12338c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f12338c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @p0
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f12337b.f();
        if (bitmapF != null) {
            d(Integer.valueOf(v4.o.h(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f12337b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f12338c.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f12338c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }

    @i1
    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f12340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f12342c;

        public b(c cVar) {
            this.f12340a = cVar;
        }

        public void a(int i10, Bitmap.Config config) {
            this.f12341b = i10;
            this.f12342c = config;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void b() {
            this.f12340a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12341b == bVar.f12341b && v4.o.d(this.f12342c, bVar.f12342c);
        }

        public int hashCode() {
            int i10 = this.f12341b * 31;
            Bitmap.Config config = this.f12342c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.h(this.f12341b, this.f12342c);
        }

        @i1
        public b(c cVar, int i10, Bitmap.Config config) {
            this(cVar);
            a(i10, config);
        }
    }
}
