package m0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.n0;
import g.p0;
import g.v0;
import j0.f;
import java.io.IOException;
import java.io.InputStream;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(29)
public class b0 extends c0 {
    public static int p(@n0 FontStyle fontStyle, @n0 FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // m0.c0
    @p0
    public Typeface b(Context context, f.d dVar, Resources resources, int i10) {
        try {
            FontFamily.Builder builder = null;
            for (f.e eVar : dVar.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, eVar.b()).setWeight(eVar.e()).setSlant(eVar.f() ? 1 : 0).setTtcIndex(eVar.c()).setFontVariationSettings(eVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(o(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // m0.c0
    @p0
    public Typeface d(Context context, @p0 CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (h.c cVar : cVarArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(cVar.d(), SsManifestParser.e.J, cancellationSignal);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(cVar.e()).setSlant(cVar.f() ? 1 : 0).setTtcIndex(cVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th2) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(o(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // m0.c0
    public Typeface e(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // m0.c0
    @p0
    public Typeface f(Context context, Resources resources, int i10, String str, int i11) {
        try {
            Font fontBuild = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // m0.c0
    @n0
    public Typeface g(@n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        return Typeface.create(typeface, i10, z10);
    }

    @Override // m0.c0
    public h.c l(h.c[] cVarArr, int i10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Font o(@n0 FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? 700 : 400, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iP = p(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int iP2 = p(fontStyle, font2.getStyle());
            if (iP2 < iP) {
                font = font2;
                iP = iP2;
            }
        }
        return font;
    }
}
