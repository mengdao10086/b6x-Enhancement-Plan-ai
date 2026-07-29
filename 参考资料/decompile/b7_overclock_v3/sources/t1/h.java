package t1;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.util.j;
import g.n0;
import t1.e;

/* JADX INFO: loaded from: classes2.dex */
public class h implements e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f50839c = "MediaSessionManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f50840d = e.f50829c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f50841e = "android.permission.STATUS_BAR_SERVICE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f50842f = "android.permission.MEDIA_CONTENT_CONTROL";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f50843g = "enabled_notification_listeners";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f50844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f50845b;

    public static class a implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f50846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f50847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f50848c;

        public a(String str, int i10, int i11) {
            this.f50846a = str;
            this.f50847b = i10;
            this.f50848c = i11;
        }

        @Override // t1.e.c
        public int a() {
            return this.f50848c;
        }

        @Override // t1.e.c
        public int b() {
            return this.f50847b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return (this.f50847b < 0 || aVar.f50847b < 0) ? TextUtils.equals(this.f50846a, aVar.f50846a) && this.f50848c == aVar.f50848c : TextUtils.equals(this.f50846a, aVar.f50846a) && this.f50847b == aVar.f50847b && this.f50848c == aVar.f50848c;
        }

        public int hashCode() {
            return j.b(this.f50846a, Integer.valueOf(this.f50848c));
        }

        @Override // t1.e.c
        public String m() {
            return this.f50846a;
        }
    }

    public h(Context context) {
        this.f50844a = context;
        this.f50845b = context.getContentResolver();
    }

    @Override // t1.e.a
    public boolean a(@n0 e.c cVar) {
        try {
            if (this.f50844a.getPackageManager().getApplicationInfo(cVar.m(), 0) == null) {
                return false;
            }
            return d(cVar, f50841e) || d(cVar, f50842f) || cVar.a() == 1000 || c(cVar);
        } catch (PackageManager.NameNotFoundException unused) {
            if (f50840d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Package ");
                sb2.append(cVar.m());
                sb2.append(" doesn't exist");
            }
            return false;
        }
    }

    @Override // t1.e.a
    public Context b() {
        return this.f50844a;
    }

    public boolean c(@n0 e.c cVar) {
        String string = Settings.Secure.getString(this.f50845b, "enabled_notification_listeners");
        if (string != null) {
            for (String str : string.split(":")) {
                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(cVar.m())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(e.c cVar, String str) {
        return cVar.b() < 0 ? this.f50844a.getPackageManager().checkPermission(str, cVar.m()) == 0 : this.f50844a.checkPermission(str, cVar.b(), cVar.a()) == 0;
    }
}
