package m9;

import com.blankj.utilcode.util.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f40730a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ArrayList<String> f40731b = CollectionsKt__CollectionsKt.r("FeiZhi Wasp", "FeiZhi Wasp-BT", "FeiZhi Wasp-N", "FeiZhi Wasp-X", "FeiZhi APEX", "FeiZhi Wee", "FeiZhi Wee 2", "FeiZhi Wee 2T", "FeiZhi Q1", "FeiZhi D1", "FeiZhi X8/X8Pro", "FeiZhi X9ET/ETPro", "Flydigi Wasp 2", "Flydigi Wasp 2T", "Flydigi Wasp 2S", "Flydigi APEX 2", "Flydigi APEX 3", "Flydigi APEX 4", "Flydigi Wee 3", "Flydigi VADER 2", "Flydigi VADER 2P", "Flydigi Vader 3", "Flydigi VADER 3P", "Flydigi Vader 3 Pro", "Flydigi Vader 4", "Flydigi F1", "Flydigi G1", "Flydigi Q1");

    public final boolean a(@yt.k String nameWithoutI) {
        Object next;
        f0.p(nameWithoutI, "nameWithoutI");
        Iterator<T> it2 = f40731b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String strL2 = kotlin.text.u.l2((String) next, i0.f11861z, "", false, 4, null);
            Locale locale = Locale.getDefault();
            f0.o(locale, "getDefault()");
            String lowerCase = strL2.toLowerCase(locale);
            f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strL22 = kotlin.text.u.l2(nameWithoutI, i0.f11861z, "", false, 4, null);
            Locale locale2 = Locale.getDefault();
            f0.o(locale2, "getDefault()");
            String lowerCase2 = strL22.toLowerCase(locale2);
            f0.o(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (androidx.core.util.j.a(lowerCase, lowerCase2)) {
                break;
            }
        }
        return ((String) next) != null;
    }
}
