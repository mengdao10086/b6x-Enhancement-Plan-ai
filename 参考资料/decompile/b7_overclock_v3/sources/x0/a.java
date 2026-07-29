package x0;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import g.n0;
import g.p0;
import g.v0;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: x0.a$a, reason: collision with other inner class name */
    @v0(28)
    public static class C0643a {
        public static CharSequence a(Context context, ServiceInfo serviceInfo) {
            Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            int i10 = 0;
            Iterator<Locale> it2 = serviceInfo.getNamedContentLocales().iterator();
            while (it2.hasNext()) {
                strArr[i10] = it2.next().toLanguageTag();
                i10++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
    }

    @p0
    public static CharSequence a(@n0 Context context, @n0 ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0643a.a(context, serviceInfo);
        }
        return null;
    }
}
