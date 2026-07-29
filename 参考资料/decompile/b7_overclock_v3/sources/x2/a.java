package x2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {
    @n0
    public static byte[] a(@n0 Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    @n0
    public static <T> T b(@n0 byte[] bArr, @n0 Parcelable.Creator<T> creator) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }
}
