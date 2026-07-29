package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.efs.sdk.base.core.f.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f12922b = new ConcurrentHashMap<>(10);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicInteger f12926d = new AtomicInteger(0);

        public a(String str, String str2, String str3) {
            this.f12923a = str;
            this.f12924b = str2;
            this.f12925c = str3;
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.f12922b.containsKey(str4) || this.f12922b.get(str4) == null) {
            this.f12922b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.f12922b.get(str4).f12926d.incrementAndGet();
    }

    @Override // com.efs.sdk.base.core.f.a
    public final void a() {
        try {
            if (this.f12904a != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                Iterator<Map.Entry<String, a>> it2 = this.f12922b.entrySet().iterator();
                while (it2.hasNext()) {
                    a value = it2.next().getValue();
                    int i10 = value.f12926d.get();
                    if (i10 > 0) {
                        ControllerCenter controllerCenter = this.f12904a;
                        String str = value.f12923a;
                        String str2 = value.f12924b;
                        String str3 = value.f12925c;
                        b bVar = new b("efs_core", "req_succ_rate", f.a.f12921a.f12917a.f12911c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", Integer.valueOf(i10));
                        controllerCenter.send(bVar);
                        value.f12926d.addAndGet(i10 * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
