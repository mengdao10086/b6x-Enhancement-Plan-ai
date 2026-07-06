package androidx.core.graphics.drawable;

import a.hu;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(hu huVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f8192a = huVar.p(iconCompat.f8192a, 1);
        iconCompat.f4187a = huVar.j(iconCompat.f4187a, 2);
        iconCompat.f4184a = huVar.r(iconCompat.f4184a, 3);
        iconCompat.f4188b = huVar.p(iconCompat.f4188b, 4);
        iconCompat.c = huVar.p(iconCompat.c, 5);
        iconCompat.f4182a = (ColorStateList) huVar.r(iconCompat.f4182a, 6);
        iconCompat.f4186a = huVar.t(iconCompat.f4186a, 7);
        iconCompat.f4189b = huVar.t(iconCompat.f4189b, 8);
        iconCompat.i();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, hu huVar) {
        huVar.x(true, true);
        iconCompat.j(huVar.f());
        int i = iconCompat.f8192a;
        if (-1 != i) {
            huVar.F(i, 1);
        }
        byte[] bArr = iconCompat.f4187a;
        if (bArr != null) {
            huVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f4184a;
        if (parcelable != null) {
            huVar.H(parcelable, 3);
        }
        int i2 = iconCompat.f4188b;
        if (i2 != 0) {
            huVar.F(i2, 4);
        }
        int i3 = iconCompat.c;
        if (i3 != 0) {
            huVar.F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f4182a;
        if (colorStateList != null) {
            huVar.H(colorStateList, 6);
        }
        String str = iconCompat.f4186a;
        if (str != null) {
            huVar.J(str, 7);
        }
        String str2 = iconCompat.f4189b;
        if (str2 != null) {
            huVar.J(str2, 8);
        }
    }
}
