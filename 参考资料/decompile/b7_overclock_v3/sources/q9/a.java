package q9;

import androidx.core.util.j;
import com.blankj.utilcode.util.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f47156a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final String f47157b = "FLYDIGI Cyberfox";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final String f47158c = "FLYDIGI Cyberfox T1";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final String f47159d = "FLYDIGI Cyberfox X1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final ArrayList<String> f47160e = CollectionsKt__CollectionsKt.r(f47157b, f47158c, f47159d, "HX1 BLE");

    public final boolean a(@l String str) {
        Object next;
        if (str == null) {
            return false;
        }
        Iterator<T> it2 = f47160e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String strL2 = u.l2((String) next, i0.f11861z, "", false, 4, null);
            Locale locale = Locale.getDefault();
            f0.o(locale, "getDefault()");
            String lowerCase = strL2.toLowerCase(locale);
            f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strL22 = u.l2(str, i0.f11861z, "", false, 4, null);
            Locale locale2 = Locale.getDefault();
            f0.o(locale2, "getDefault()");
            String lowerCase2 = strL22.toLowerCase(locale2);
            f0.o(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (j.a(lowerCase, lowerCase2)) {
                break;
            }
        }
        return ((String) next) != null || u.t2(str, "x1_ota", true);
    }
}
