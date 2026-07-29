package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0011\b\u0000\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/permissionx/guolindev/request/y;", "Lcom/permissionx/guolindev/request/a;", "Lkotlin/z1;", i1.a.f31577d5, "", "", "permissions", i1.a.X4, "Lcom/permissionx/guolindev/request/t;", "permissionBuilder", "<init>", "(Lcom/permissionx/guolindev/request/t;)V", "e", "a", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class y extends com.permissionx.guolindev.request.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f22162e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final String f22163f = "android.permission.MANAGE_EXTERNAL_STORAGE";

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/permissionx/guolindev/request/y$a;", "", "", "MANAGE_EXTERNAL_STORAGE", "Ljava/lang/String;", "<init>", "()V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@yt.k t permissionBuilder) {
        super(permissionBuilder);
        f0.p(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.b
    public void T() {
        if (!this.f22099a.G() || Build.VERSION.SDK_INT < 30) {
            U();
            return;
        }
        if (Environment.isExternalStorageManager()) {
            U();
            return;
        }
        t tVar = this.f22099a;
        if (tVar.f22151r == null && tVar.f22152s == null) {
            U();
            return;
        }
        List<String> listP = CollectionsKt__CollectionsKt.P(f22163f);
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
        this.f22099a.v(this);
    }
}
