package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DownsampleStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f12531a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f12532b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f12533c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f12534d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f12535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DownsampleStrategy f12536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DownsampleStrategy f12537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c4.d<DownsampleStrategy> f12538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f12539i;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public static class a extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            if (Math.min(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    public static class b extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            int iCeil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    public static class c extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return b(i10, i11, i12, i13) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.f12533c.a(i10, i11, i12, i13);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, DownsampleStrategy.f12533c.b(i10, i11, i12, i13));
        }
    }

    public static class d extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    public static class e extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return DownsampleStrategy.f12539i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.f12539i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    public static class f extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f12535e = dVar;
        f12536f = new f();
        f12537g = dVar;
        f12538h = c4.d.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f12539i = true;
    }

    public abstract SampleSizeRounding a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
