package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import g.n0;
import g.p0;
import java.io.File;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.efs.sdk.base.core.b.b f12799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0124a f12800d;

    /* JADX INFO: renamed from: com.efs.sdk.base.core.b.a$a, reason: collision with other inner class name */
    public static class C0124a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12801a = new a(0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static void b(@n0 File file) {
        if (!file.getName().startsWith("wa_")) {
            f.a.f12921a.f12919c.e();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    public static void c(File file) {
        StringBuilder sb2 = new StringBuilder("file is expire: ");
        sb2.append(file.getName());
        sb2.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb2.append(com.efs.sdk.base.core.a.a.b());
        Log.i("efs.cache", sb2.toString());
        if (!file.getName().startsWith("wa_")) {
            f.a.f12921a.f12919c.d();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    public final void a() {
        String[] list;
        File fileD = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!fileD.exists() || !fileD.isDirectory() || (list = fileD.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(fileD, str);
                List<File> listD = com.efs.sdk.base.core.util.b.d(file);
                if (!listD.isEmpty()) {
                    for (File file2 : listD) {
                        if (a(file2.getName())) {
                            c(file2);
                        } else {
                            com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file2.getName());
                            if (bVarB == null) {
                                b(file2);
                            } else {
                                e eVarA = this.f12799c.a(bVarB.f12890a.f12884b);
                                if (eVarA == null) {
                                    b(file2);
                                } else {
                                    eVarA.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.core.util.b.b(file);
            }
        }
    }

    private a() {
        this.f12797a = false;
        this.f12798b = true;
        this.f12799c = new com.efs.sdk.base.core.b.b();
        this.f12800d = new C0124a();
    }

    public static boolean a(String str) {
        try {
            long j10 = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            com.efs.sdk.base.core.a.a.a();
            return Math.abs(com.efs.sdk.base.core.a.a.b() - j10) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    @p0
    public final com.efs.sdk.base.core.d.b a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                c(file);
                return null;
            }
            com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
            if (bVarB == null) {
                b(file);
                return null;
            }
            e eVarA = this.f12799c.a(bVarB.f12890a.f12884b);
            if (eVarA == null) {
                b(file);
                return null;
            }
            if (eVarA.a(file, bVarB)) {
                return bVarB;
            }
            b(file);
            return null;
        } catch (Throwable th2) {
            Log.w("efs.cache", th2);
            b(file);
            return null;
        }
    }
}
