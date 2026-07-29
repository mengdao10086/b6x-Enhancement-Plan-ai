package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c4.g<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c4.d<Integer> f12588b = c4.d.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c4.d<Bitmap.CompressFormat> f12589c = c4.d.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12590d = "BitmapEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12591a;

    public e(@n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f12591a = bVar;
    }

    @Override // c4.g
    @n0
    public EncodeStrategy b(@n0 c4.e eVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|39|3|4|40|5|(5:47|6|(2:8|9)(1:10)|11|12)|45|13|24|25|(1:27)|28|29|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:3:0x0021, B:13:0x004d, B:25:0x0061, B:27:0x0067, B:31:0x00ac, B:32:0x00af), top: B:39:0x0021 }] */
    @Override // c4.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(@g.n0 com.bumptech.glide.load.engine.s<android.graphics.Bitmap> r9, @g.n0 java.io.File r10, @g.n0 c4.e r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.d(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            w4.b.e(r4, r2, r3, r1)
            long r2 = v4.i.b()     // Catch: java.lang.Throwable -> Lb0
            c4.d<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.e.f12588b     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r4 = r11.c(r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb0
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb0
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            com.bumptech.glide.load.engine.bitmap_recycle.b r10 = r8.f12591a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            com.bumptech.glide.load.data.c r10 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.bumptech.glide.load.engine.bitmap_recycle.b r6 = r8.f12591a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r6.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L60 java.lang.Throwable -> Lb0
            goto L60
        L51:
            r9 = move-exception
            r6 = r7
            goto Laa
        L54:
            r6 = r7
            goto L58
        L56:
            r9 = move-exception
            goto Laa
        L58:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L60
            goto L4d
        L60:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb0
            if (r10 == 0) goto La6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0
            r10.<init>()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            int r0 = v4.o.h(r9)     // Catch: java.lang.Throwable -> Lb0
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            double r0 = v4.i.a(r2)     // Catch: java.lang.Throwable -> Lb0
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb0
            c4.d<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.resource.bitmap.e.f12589c     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r11 = r11.c(r0)     // Catch: java.lang.Throwable -> Lb0
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb0
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb0
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb0
        La6:
            w4.b.f()
            return r5
        Laa:
            if (r6 == 0) goto Laf
            r6.close()     // Catch: java.io.IOException -> Laf java.lang.Throwable -> Lb0
        Laf:
            throw r9     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r9 = move-exception
            w4.b.f()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.e.a(com.bumptech.glide.load.engine.s, java.io.File, c4.e):boolean");
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, c4.e eVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.c(f12589c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Deprecated
    public e() {
        this.f12591a = null;
    }
}
