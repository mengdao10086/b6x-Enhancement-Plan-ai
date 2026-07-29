package bg;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import bg.c;
import com.permissionx.guolindev.request.t;
import com.permissionx.guolindev.request.u;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J!\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lbg/b;", "", "", "", "permissions", "Lcom/permissionx/guolindev/request/t;", "a", "", "b", "([Ljava/lang/String;)Lcom/permissionx/guolindev/request/t;", "Landroidx/fragment/app/g;", androidx.appcompat.widget.c.f2369r, "<init>", "(Landroidx/fragment/app/g;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public g f9428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public Fragment f9429b;

    public b(@k g activity) {
        f0.p(activity, "activity");
        this.f9428a = activity;
    }

    @k
    public final t a(@k List<String> permissions) {
        int i10;
        f0.p(permissions, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i11 = Build.VERSION.SDK_INT;
        g gVar = this.f9428a;
        if (gVar != null) {
            f0.m(gVar);
            i10 = gVar.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.f9429b;
            f0.m(fragment);
            i10 = fragment.R4().getApplicationInfo().targetSdkVersion;
        }
        for (String str : permissions) {
            if (eg.b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains(u.f22155f) && (i11 == 29 || (i11 == 30 && i10 < 30))) {
            linkedHashSet2.remove(u.f22155f);
            linkedHashSet.add(u.f22155f);
        }
        if (linkedHashSet2.contains(c.a.f9430a) && i11 >= 33 && i10 >= 33) {
            linkedHashSet2.remove(c.a.f9430a);
            linkedHashSet.add(c.a.f9430a);
        }
        return new t(this.f9428a, this.f9429b, linkedHashSet, linkedHashSet2);
    }

    @k
    public final t b(@k String... permissions) {
        f0.p(permissions, "permissions");
        return a(CollectionsKt__CollectionsKt.L(Arrays.copyOf(permissions, permissions.length)));
    }

    public b(@k Fragment fragment) {
        f0.p(fragment, "fragment");
        this.f9429b = fragment;
    }
}
