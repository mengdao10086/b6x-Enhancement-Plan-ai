package bg;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import f0.a0;
import g.n0;
import h0.d;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f9430a = "android.permission.POST_NOTIFICATIONS";
    }

    public static boolean a(@n0 Context context) {
        return a0.p(context).a();
    }

    public static b b(@n0 Fragment fragment) {
        return new b(fragment);
    }

    public static b c(@n0 g gVar) {
        return new b(gVar);
    }

    public static boolean d(@n0 Context context, @n0 String str) {
        return d.a(context, str) == 0;
    }
}
