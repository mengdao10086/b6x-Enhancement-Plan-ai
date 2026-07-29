package d4;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25970a = 512;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25971b = 384;

    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384;
    }

    public static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
