package x2;

import android.os.Parcel;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b {
    public static boolean a(@n0 Parcel parcel) {
        return parcel.readInt() == 1;
    }

    public static void b(@n0 Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }
}
