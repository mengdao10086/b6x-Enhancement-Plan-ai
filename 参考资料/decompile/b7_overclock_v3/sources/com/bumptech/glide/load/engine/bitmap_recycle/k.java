package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import g.n0;
import g.p0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class k implements e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12317k = "LruBitmapPool";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Bitmap.Config f12318l = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f12319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Bitmap.Config> f12320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f12322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12328j;

    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public static final class b implements a {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
        }
    }

    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Bitmap> f12329a = Collections.synchronizedSet(new HashSet());

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
            if (!this.f12329a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f12329a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
            if (!this.f12329a.contains(bitmap)) {
                this.f12329a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    public k(long j10, l lVar, Set<Bitmap.Config> set) {
        this.f12321c = j10;
        this.f12323e = j10;
        this.f12319a = lVar;
        this.f12320b = set;
        this.f12322d = new b();
    }

    @TargetApi(26)
    public static void h(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @n0
    public static Bitmap i(int i10, int i11, @p0 Bitmap.Config config) {
        if (config == null) {
            config = f12318l;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> o() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static l p() {
        return new n();
    }

    @TargetApi(19)
    public static void s(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    public static void u(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        s(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long a() {
        return this.f12323e;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void b(int i10) {
        if (Log.isLoggable(f12317k, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trimMemory, level=");
            sb2.append(i10);
        }
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            c();
        } else if (i10 >= 20 || i10 == 15) {
            v(a() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void c() {
        v(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void d(float f10) {
        this.f12323e = Math.round(this.f12321c * f10);
        l();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void e(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f12319a.b(bitmap) <= this.f12323e && this.f12320b.contains(bitmap.getConfig())) {
                int iB = this.f12319a.b(bitmap);
                this.f12319a.e(bitmap);
                this.f12322d.b(bitmap);
                this.f12327i++;
                this.f12324f += (long) iB;
                if (Log.isLoggable(f12317k, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Put bitmap in pool=");
                    sb2.append(this.f12319a.c(bitmap));
                }
                j();
                l();
                return;
            }
            if (Log.isLoggable(f12317k, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Reject bitmap from pool, bitmap: ");
                sb3.append(this.f12319a.c(bitmap));
                sb3.append(", is mutable: ");
                sb3.append(bitmap.isMutable());
                sb3.append(", is allowed config: ");
                sb3.append(this.f12320b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @n0
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapQ = q(i10, i11, config);
        if (bitmapQ == null) {
            return i(i10, i11, config);
        }
        bitmapQ.eraseColor(0);
        return bitmapQ;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @n0
    public Bitmap g(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapQ = q(i10, i11, config);
        return bitmapQ == null ? i(i10, i11, config) : bitmapQ;
    }

    public final void j() {
        if (Log.isLoggable(f12317k, 2)) {
            k();
        }
    }

    public final void k() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hits=");
        sb2.append(this.f12325g);
        sb2.append(", misses=");
        sb2.append(this.f12326h);
        sb2.append(", puts=");
        sb2.append(this.f12327i);
        sb2.append(", evictions=");
        sb2.append(this.f12328j);
        sb2.append(", currentSize=");
        sb2.append(this.f12324f);
        sb2.append(", maxSize=");
        sb2.append(this.f12323e);
        sb2.append("\nStrategy=");
        sb2.append(this.f12319a);
    }

    public final void l() {
        v(this.f12323e);
    }

    public long m() {
        return this.f12328j;
    }

    public long n() {
        return this.f12324f;
    }

    @p0
    public final synchronized Bitmap q(int i10, int i11, @p0 Bitmap.Config config) {
        Bitmap bitmapF;
        h(config);
        bitmapF = this.f12319a.f(i10, i11, config != null ? config : f12318l);
        if (bitmapF == null) {
            if (Log.isLoggable(f12317k, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing bitmap=");
                sb2.append(this.f12319a.a(i10, i11, config));
            }
            this.f12326h++;
        } else {
            this.f12325g++;
            this.f12324f -= (long) this.f12319a.b(bitmapF);
            this.f12322d.a(bitmapF);
            u(bitmapF);
        }
        if (Log.isLoggable(f12317k, 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Get bitmap=");
            sb3.append(this.f12319a.a(i10, i11, config));
        }
        j();
        return bitmapF;
    }

    public long r() {
        return this.f12325g;
    }

    public long t() {
        return this.f12326h;
    }

    public final synchronized void v(long j10) {
        while (this.f12324f > j10) {
            Bitmap bitmapRemoveLast = this.f12319a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable(f12317k, 5)) {
                    k();
                }
                this.f12324f = 0L;
                return;
            }
            this.f12322d.a(bitmapRemoveLast);
            this.f12324f -= (long) this.f12319a.b(bitmapRemoveLast);
            this.f12328j++;
            if (Log.isLoggable(f12317k, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Evicting bitmap=");
                sb2.append(this.f12319a.c(bitmapRemoveLast));
            }
            j();
            bitmapRemoveLast.recycle();
        }
    }

    public k(long j10) {
        this(j10, p(), o());
    }

    public k(long j10, Set<Bitmap.Config> set) {
        this(j10, p(), set);
    }
}
