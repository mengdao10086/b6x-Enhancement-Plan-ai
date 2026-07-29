package z4;

import com.flydigi.data.event.FZAccountLoginChangeEvent;
import com.flydigi.router.LoginInterceptor;
import java.util.HashMap;
import java.util.Map;
import vt.e;

/* JADX INFO: loaded from: classes2.dex */
public class b implements vt.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, vt.c> f57730a = new HashMap();

    static {
        b(new vt.b(LoginInterceptor.class, true, new e[]{new e("onEvent", FZAccountLoginChangeEvent.class)}));
    }

    public static void b(vt.c info) {
        f57730a.put(info.d(), info);
    }

    @Override // vt.d
    public vt.c a(Class<?> subscriberClass) {
        vt.c cVar = f57730a.get(subscriberClass);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }
}
