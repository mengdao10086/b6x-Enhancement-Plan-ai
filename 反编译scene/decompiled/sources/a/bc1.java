package a;

import com.omarea.ui.BlurViewRecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bc1 implements yz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dc1 f5693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BlurViewRecyclerView f258a;

    public bc1(BlurViewRecyclerView blurViewRecyclerView, dc1 dc1Var, zz0 zz0Var) {
        this.f258a = blurViewRecyclerView;
        this.f5693a = dc1Var;
        this.f257a = zz0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r3.booleanValue() != false) goto L8;
     */
    @Override // a.yz0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.view.View r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            a.f92.d(r2, r0)
            a.zz0 r2 = r1.f257a
            com.omarea.model.AppInfo r2 = r2.C(r3)
            a.e50 r3 = a.e50.f677a
            java.lang.String r3 = r3.y0()
            java.lang.String r0 = "basic"
            boolean r3 = a.f92.a(r3, r0)
            if (r3 == 0) goto L40
            java.lang.Boolean r3 = r2.enabled
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L2e
            java.lang.Boolean r3 = r2.suspended
            java.lang.String r0 = "appInfo.suspended"
            a.f92.c(r3, r0)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L40
        L2e:
            com.omarea.ui.BlurViewRecyclerView r2 = r1.f258a
            android.content.Context r2 = r2.getContext()
            r3 = 2131887270(0x7f1204a6, float:1.9409142E38)
            r0 = 0
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
            goto L5f
        L40:
            java.lang.String r3 = r2.getPackageName()
            java.lang.String r0 = "plus"
            boolean r3 = a.f92.a(r3, r0)
            if (r3 == 0) goto L56
            a.dc1 r2 = r1.f5693a
            com.omarea.vtools.activities.ActivityFreezeApps$s r2 = r2.f548a
            com.omarea.vtools.activities.ActivityFreezeApps r2 = com.omarea.vtools.activities.ActivityFreezeApps.this
            com.omarea.vtools.activities.ActivityFreezeApps.access$addFreezeAppDialog(r2)
            goto L5f
        L56:
            a.dc1 r3 = r1.f5693a     // Catch: java.lang.Exception -> L5f
            com.omarea.vtools.activities.ActivityFreezeApps$s r3 = r3.f548a     // Catch: java.lang.Exception -> L5f
            com.omarea.vtools.activities.ActivityFreezeApps r3 = com.omarea.vtools.activities.ActivityFreezeApps.this     // Catch: java.lang.Exception -> L5f
            com.omarea.vtools.activities.ActivityFreezeApps.access$startApp(r3, r2)     // Catch: java.lang.Exception -> L5f
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bc1.a(android.view.View, int):void");
    }
}
