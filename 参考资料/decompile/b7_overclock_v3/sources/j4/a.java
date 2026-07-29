package j4;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import c4.d;
import c4.e;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.u;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(api = 28)
public final class a implements ImageDecoder.OnHeaderDecodedListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f36056h = "ImageDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f36057a = u.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DecodeFormat f36060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DownsampleStrategy f36061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f36062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PreferredColorSpace f36063g;

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public class C0407a implements ImageDecoder.OnPartialImageListener {
        public C0407a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@n0 ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public a(int i10, int i11, @n0 e eVar) {
        this.f36058b = i10;
        this.f36059c = i11;
        this.f36060d = (DecodeFormat) eVar.c(o.f12607g);
        this.f36061e = (DownsampleStrategy) eVar.c(DownsampleStrategy.f12538h);
        d<Boolean> dVar = o.f12611k;
        this.f36062f = eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue();
        this.f36063g = (PreferredColorSpace) eVar.c(o.f12608h);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@n0 ImageDecoder imageDecoder, @n0 ImageDecoder.ImageInfo imageInfo, @n0 ImageDecoder.Source source) {
        boolean z10 = false;
        if (this.f36057a.g(this.f36058b, this.f36059c, this.f36062f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f36060d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0407a());
        Size size = imageInfo.getSize();
        int width = this.f36058b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f36059c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f36061e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable(f36056h, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Resizing from [");
            sb2.append(size.getWidth());
            sb2.append("x");
            sb2.append(size.getHeight());
            sb2.append("] to [");
            sb2.append(iRound);
            sb2.append("x");
            sb2.append(iRound2);
            sb2.append("] scaleFactor: ");
            sb2.append(fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        PreferredColorSpace preferredColorSpace = this.f36063g;
        if (preferredColorSpace != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 28) {
                if (i10 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            } else {
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z10 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        }
    }
}
