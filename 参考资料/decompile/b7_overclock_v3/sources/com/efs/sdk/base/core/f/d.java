package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicInteger f12913c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f12914d = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f12912b = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f12915e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f12916f = new AtomicInteger(0);

    @Override // com.efs.sdk.base.core.f.a
    public final void a() {
        if ((this.f12913c.get() == 0 && this.f12914d.get() == 0 && this.f12912b.get() == 0 && this.f12916f.get() == 0 && this.f12915e.get() == 0) || this.f12904a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        ControllerCenter controllerCenter = this.f12904a;
        int i10 = this.f12913c.get();
        int i11 = this.f12914d.get();
        int i12 = this.f12912b.get();
        int i13 = this.f12916f.get();
        int i14 = this.f12915e.get();
        b bVar = new b("efs_core", "lf_st", f.a.f12921a.f12917a.f12911c);
        bVar.put("create_cnt", Integer.valueOf(i10));
        bVar.put("cache_cnt", Integer.valueOf(i11));
        bVar.put("req_cnt", Integer.valueOf(i12));
        bVar.put("err_cnt", Integer.valueOf(i13));
        bVar.put("expire_cnt", Integer.valueOf(i14));
        this.f12913c.addAndGet(i10 * (-1));
        this.f12914d.addAndGet(i11 * (-1));
        this.f12912b.addAndGet(i12 * (-1));
        this.f12916f.addAndGet(i13 * (-1));
        this.f12915e.addAndGet(i14 * (-1));
        controllerCenter.send(bVar);
    }

    public final void b() {
        this.f12913c.incrementAndGet();
    }

    public final void c() {
        this.f12914d.incrementAndGet();
    }

    public final void d() {
        this.f12915e.incrementAndGet();
    }

    public final void e() {
        this.f12916f.incrementAndGet();
    }
}
