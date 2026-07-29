package ed;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.common.base.Predicate;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r {
    static {
        Predicate<String> predicate = HttpDataSource.f19028a;
    }

    public static /* synthetic */ boolean a(String str) {
        String strW1 = u0.w1(str);
        return (TextUtils.isEmpty(strW1) || (strW1.contains("text") && !strW1.contains(hd.w.f31177c0)) || strW1.contains("html") || strW1.contains("xml")) ? false : true;
    }
}
