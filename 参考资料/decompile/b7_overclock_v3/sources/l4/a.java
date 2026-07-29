package l4;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.v0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
@v0(28)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f39439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f39440b;

    /* JADX INFO: renamed from: l4.a$a, reason: collision with other inner class name */
    public static final class C0441a implements s<Drawable> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f39441b = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimatedImageDrawable f39442a;

        public C0441a(AnimatedImageDrawable animatedImageDrawable) {
            this.f39442a = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.s
        public void a() {
            this.f39442a.stop();
            this.f39442a.clearAnimationCallbacks();
        }

        @Override // com.bumptech.glide.load.engine.s
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f39442a;
        }

        @Override // com.bumptech.glide.load.engine.s
        public int c() {
            return this.f39442a.getIntrinsicWidth() * this.f39442a.getIntrinsicHeight() * o.i(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // com.bumptech.glide.load.engine.s
        @n0
        public Class<Drawable> d() {
            return Drawable.class;
        }
    }

    public static final class b implements c4.f<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39443a;

        public b(a aVar) {
            this.f39443a = aVar;
        }

        @Override // c4.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s<Drawable> b(@n0 ByteBuffer byteBuffer, int i10, int i11, @n0 c4.e eVar) throws IOException {
            return this.f39443a.b(ImageDecoder.createSource(byteBuffer), i10, i11, eVar);
        }

        @Override // c4.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(@n0 ByteBuffer byteBuffer, @n0 c4.e eVar) throws IOException {
            return this.f39443a.d(byteBuffer);
        }
    }

    public static final class c implements c4.f<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39444a;

        public c(a aVar) {
            this.f39444a = aVar;
        }

        @Override // c4.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s<Drawable> b(@n0 InputStream inputStream, int i10, int i11, @n0 c4.e eVar) throws IOException {
            return this.f39444a.b(ImageDecoder.createSource(v4.a.b(inputStream)), i10, i11, eVar);
        }

        @Override // c4.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(@n0 InputStream inputStream, @n0 c4.e eVar) throws IOException {
            return this.f39444a.c(inputStream);
        }
    }

    public a(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f39439a = list;
        this.f39440b = bVar;
    }

    public static c4.f<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        return new b(new a(list, bVar));
    }

    public static c4.f<InputStream, Drawable> f(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        return new c(new a(list, bVar));
    }

    public s<Drawable> b(@n0 ImageDecoder.Source source, int i10, int i11, @n0 c4.e eVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new j4.a(i10, i11, eVar));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new C0441a((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + drawableDecodeDrawable);
    }

    public boolean c(InputStream inputStream) throws IOException {
        return e(com.bumptech.glide.load.a.f(this.f39439a, inputStream, this.f39440b));
    }

    public boolean d(ByteBuffer byteBuffer) throws IOException {
        return e(com.bumptech.glide.load.a.g(this.f39439a, byteBuffer));
    }

    public final boolean e(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }
}
