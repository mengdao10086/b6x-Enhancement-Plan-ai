package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4629a = versionedParcel.M(iconCompat.f4629a, 1);
        iconCompat.f4631c = versionedParcel.t(iconCompat.f4631c, 2);
        iconCompat.f4632d = versionedParcel.W(iconCompat.f4632d, 3);
        iconCompat.f4633e = versionedParcel.M(iconCompat.f4633e, 4);
        iconCompat.f4634f = versionedParcel.M(iconCompat.f4634f, 5);
        iconCompat.f4635g = (ColorStateList) versionedParcel.W(iconCompat.f4635g, 6);
        iconCompat.f4637i = versionedParcel.d0(iconCompat.f4637i, 7);
        iconCompat.f4638j = versionedParcel.d0(iconCompat.f4638j, 8);
        iconCompat.h();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.j0(true, true);
        iconCompat.i(versionedParcel.i());
        int i10 = iconCompat.f4629a;
        if (-1 != i10) {
            versionedParcel.M0(i10, 1);
        }
        byte[] bArr = iconCompat.f4631c;
        if (bArr != null) {
            versionedParcel.u0(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f4632d;
        if (parcelable != null) {
            versionedParcel.X0(parcelable, 3);
        }
        int i11 = iconCompat.f4633e;
        if (i11 != 0) {
            versionedParcel.M0(i11, 4);
        }
        int i12 = iconCompat.f4634f;
        if (i12 != 0) {
            versionedParcel.M0(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f4635g;
        if (colorStateList != null) {
            versionedParcel.X0(colorStateList, 6);
        }
        String str = iconCompat.f4637i;
        if (str != null) {
            versionedParcel.f1(str, 7);
        }
        String str2 = iconCompat.f4638j;
        if (str2 != null) {
            versionedParcel.f1(str2, 8);
        }
    }
}
