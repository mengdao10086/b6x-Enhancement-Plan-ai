package n4;

import a4.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import g.i1;
import g.n0;
import g.p0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c4.f<ByteBuffer, c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f41819f = "BufferGifDecoder";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0463a f41820g = new C0463a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f41821h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ImageHeaderParser> f41823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f41824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0463a f41825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n4.b f41826e;

    /* JADX INFO: renamed from: n4.a$a, reason: collision with other inner class name */
    @i1
    public static class C0463a {
        public a4.a a(a.InterfaceC0009a interfaceC0009a, a4.c cVar, ByteBuffer byteBuffer, int i10) {
            return new a4.e(interfaceC0009a, cVar, byteBuffer, i10);
        }
    }

    @i1
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<a4.d> f41827a = o.f(0);

        public synchronized a4.d a(ByteBuffer byteBuffer) {
            a4.d dVarPoll;
            dVarPoll = this.f41827a.poll();
            if (dVarPoll == null) {
                dVarPoll = new a4.d();
            }
            return dVarPoll.q(byteBuffer);
        }

        public synchronized void b(a4.d dVar) {
            dVar.a();
            this.f41827a.offer(dVar);
        }
    }

    public a(Context context) {
        this(context, com.bumptech.glide.b.e(context).n().g(), com.bumptech.glide.b.e(context).h(), com.bumptech.glide.b.e(context).g());
    }

    public static int e(a4.c cVar, int i10, int i11) {
        int iMin = Math.min(cVar.a() / i11, cVar.d() / i10);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable(f41819f, 2) && iMax > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Downsampling GIF, sampleSize: ");
            sb2.append(iMax);
            sb2.append(", target dimens: [");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            sb2.append("], actual dimens: [");
            sb2.append(cVar.d());
            sb2.append("x");
            sb2.append(cVar.a());
            sb2.append("]");
        }
        return iMax;
    }

    @p0
    public final e c(ByteBuffer byteBuffer, int i10, int i11, a4.d dVar, c4.e eVar) {
        long jB = v4.i.b();
        try {
            a4.c cVarD = dVar.d();
            if (cVarD.b() > 0 && cVarD.c() == 0) {
                Bitmap.Config config = eVar.c(i.f41874a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                a4.a aVarA = this.f41825d.a(this.f41826e, cVarD, byteBuffer, e(cVarD, i10, i11));
                aVarA.f(config);
                aVarA.b();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    return null;
                }
                e eVar2 = new e(new c(this.f41822a, aVarA, j4.c.c(), i10, i11, bitmapA));
                if (Log.isLoggable(f41819f, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Decoded GIF from stream in ");
                    sb2.append(v4.i.a(jB));
                }
                return eVar2;
            }
            if (Log.isLoggable(f41819f, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Decoded GIF from stream in ");
                sb3.append(v4.i.a(jB));
            }
            return null;
        } finally {
            if (Log.isLoggable(f41819f, 2)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Decoded GIF from stream in ");
                sb4.append(v4.i.a(jB));
            }
        }
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(@n0 ByteBuffer byteBuffer, int i10, int i11, @n0 c4.e eVar) {
        a4.d dVarA = this.f41824c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, dVarA, eVar);
        } finally {
            this.f41824c.b(dVarA);
        }
    }

    @Override // c4.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 ByteBuffer byteBuffer, @n0 c4.e eVar) throws IOException {
        return !((Boolean) eVar.c(i.f41875b)).booleanValue() && com.bumptech.glide.load.a.g(this.f41823b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f41821h, f41820g);
    }

    @i1
    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0463a c0463a) {
        this.f41822a = context.getApplicationContext();
        this.f41823b = list;
        this.f41825d = c0463a;
        this.f41826e = new n4.b(eVar, bVar);
        this.f41824c = bVar2;
    }
}
