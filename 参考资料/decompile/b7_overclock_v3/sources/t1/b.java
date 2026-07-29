package t1;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b {
    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt(MediaBrowserCompat.f816d, -1) == -1 && bundle2.getInt(MediaBrowserCompat.f817e, -1) == -1 : bundle2 == null ? bundle.getInt(MediaBrowserCompat.f816d, -1) == -1 && bundle.getInt(MediaBrowserCompat.f817e, -1) == -1 : bundle.getInt(MediaBrowserCompat.f816d, -1) == bundle2.getInt(MediaBrowserCompat.f816d, -1) && bundle.getInt(MediaBrowserCompat.f817e, -1) == bundle2.getInt(MediaBrowserCompat.f817e, -1);
    }

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int i10;
        int i11;
        int i12;
        int i13 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f816d, -1);
        int i14 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f816d, -1);
        int i15 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f817e, -1);
        int i16 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f817e, -1);
        int i17 = Integer.MAX_VALUE;
        if (i13 == -1 || i15 == -1) {
            i10 = Integer.MAX_VALUE;
            i11 = 0;
        } else {
            i11 = i13 * i15;
            i10 = (i15 + i11) - 1;
        }
        if (i14 == -1 || i16 == -1) {
            i12 = 0;
        } else {
            i12 = i14 * i16;
            i17 = (i16 + i12) - 1;
        }
        return i10 >= i12 && i17 >= i11;
    }
}
