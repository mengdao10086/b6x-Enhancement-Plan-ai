package fa;

import android.content.Context;
import java.util.ArrayList;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J#\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lfa/k;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", "permission", "", "a", "", "permissions", "b", "(Landroid/content/Context;[Ljava/lang/String;)Z", "c", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final k f28015a = new k();

    public final boolean a(@yt.k Context context, @yt.k String permission) {
        f0.p(context, "context");
        f0.p(permission, "permission");
        return h0.d.a(context, permission) == 0;
    }

    public final boolean b(@yt.k Context context, @yt.k String[] permissions) {
        f0.p(context, "context");
        f0.p(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (f28015a.a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList.size() == permissions.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(@yt.k android.content.Context r6, @yt.k java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.f0.p(r6, r0)
            java.lang.String r0 = "permission"
            kotlin.jvm.internal.f0.p(r7, r0)
            android.content.pm.PackageManager r0 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            r1 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r6 = r0.getPackageInfo(r6, r1)
            java.lang.String[] r6 = r6.requestedPermissions
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L29
            int r2 = r6.length
            if (r2 != 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = 0
        L24:
            if (r2 == 0) goto L27
            goto L29
        L27:
            r2 = 0
            goto L2a
        L29:
            r2 = 1
        L2a:
            if (r2 == 0) goto L2d
            return r1
        L2d:
            java.lang.String r2 = "permissions"
            kotlin.jvm.internal.f0.o(r6, r2)
            int r2 = r6.length
            r3 = 0
        L34:
            if (r3 >= r2) goto L41
            r4 = r6[r3]
            int r3 = r3 + 1
            boolean r4 = kotlin.jvm.internal.f0.g(r4, r7)
            if (r4 == 0) goto L34
            return r0
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.k.c(android.content.Context, java.lang.String):boolean");
    }
}
