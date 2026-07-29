package com.permissionx.guolindev.request;

import android.os.Build;
import android.provider.Settings;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/permissionx/guolindev/request/c0;", "Lcom/permissionx/guolindev/request/a;", "Lkotlin/z1;", i1.a.f31577d5, "", "", "permissions", i1.a.X4, "Lcom/permissionx/guolindev/request/t;", "permissionBuilder", "<init>", "(Lcom/permissionx/guolindev/request/t;)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class c0 extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@yt.k t permissionBuilder) {
        super(permissionBuilder);
        f0.p(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.b
    public void T() {
        if (!this.f22099a.J()) {
            U();
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || this.f22099a.l() < 23) {
            this.f22099a.f22145l.add("android.permission.WRITE_SETTINGS");
            this.f22099a.f22141h.remove("android.permission.WRITE_SETTINGS");
            U();
            return;
        }
        if (Settings.System.canWrite(this.f22099a.i())) {
            U();
            return;
        }
        t tVar = this.f22099a;
        if (tVar.f22151r == null && tVar.f22152s == null) {
            U();
            return;
        }
        List<String> listP = CollectionsKt__CollectionsKt.P("android.permission.WRITE_SETTINGS");
        t tVar2 = this.f22099a;
        cg.b bVar = tVar2.f22152s;
        if (bVar != null) {
            f0.m(bVar);
            bVar.a(W(), listP, true);
        } else {
            cg.a aVar = tVar2.f22151r;
            f0.m(aVar);
            aVar.a(W(), listP);
        }
    }

    @Override // com.permissionx.guolindev.request.b
    public void V(@yt.k List<String> permissions) {
        f0.p(permissions, "permissions");
        this.f22099a.z(this);
    }
}
