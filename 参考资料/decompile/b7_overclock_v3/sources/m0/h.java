package m0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import g.v0;
import java.io.IOException;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class h {

    @t0({"SMAP\nImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt$decodeBitmap$1\n*L\n1#1,56:1\n*E\n"})
    public static final class a implements ImageDecoder.OnHeaderDecodedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.q<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, z1> f40556a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, z1> qVar) {
            this.f40556a = qVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(@yt.k ImageDecoder decoder, @yt.k ImageDecoder.ImageInfo info, @yt.k ImageDecoder.Source source) {
            kotlin.jvm.internal.f0.p(decoder, "decoder");
            kotlin.jvm.internal.f0.p(info, "info");
            kotlin.jvm.internal.f0.p(source, "source");
            this.f40556a.A(decoder, info, source);
        }
    }

    @t0({"SMAP\nImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt$decodeDrawable$1\n*L\n1#1,56:1\n*E\n"})
    public static final class b implements ImageDecoder.OnHeaderDecodedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.q<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, z1> f40557a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(ik.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, z1> qVar) {
            this.f40557a = qVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(@yt.k ImageDecoder decoder, @yt.k ImageDecoder.ImageInfo info, @yt.k ImageDecoder.Source source) {
            kotlin.jvm.internal.f0.p(decoder, "decoder");
            kotlin.jvm.internal.f0.p(info, "info");
            kotlin.jvm.internal.f0.p(source, "source");
            this.f40557a.A(decoder, info, source);
        }
    }

    @yt.k
    @v0(28)
    public static final Bitmap a(@yt.k ImageDecoder.Source source, @yt.k ik.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, z1> action) throws IOException {
        kotlin.jvm.internal.f0.p(source, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new a(action));
        kotlin.jvm.internal.f0.o(bitmapDecodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @yt.k
    @v0(28)
    public static final Drawable b(@yt.k ImageDecoder.Source source, @yt.k ik.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, z1> action) throws IOException {
        kotlin.jvm.internal.f0.p(source, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new b(action));
        kotlin.jvm.internal.f0.o(drawableDecodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
