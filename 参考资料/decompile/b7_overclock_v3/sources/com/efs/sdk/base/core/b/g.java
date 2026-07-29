package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import g.n0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Handler implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f12805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.d f12806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.c f12807c;

    public static class a extends FileOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f12809b;

        public a(@n0 File file) {
            super(file);
            this.f12809b = file;
            this.f12808a = System.currentTimeMillis();
        }
    }

    public g() {
        super(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper());
        this.f12805a = new ConcurrentHashMap<>();
        this.f12806b = new com.efs.sdk.base.core.e.a.d();
        this.f12807c = new com.efs.sdk.base.core.e.a.c();
    }

    private static long b(String str) {
        Map<String, String> mapC = com.efs.sdk.base.core.config.a.c.a().c();
        String strConcat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!mapC.containsKey(strConcat)) {
            return 60000L;
        }
        String str2 = mapC.get(strConcat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th2) {
            Log.e("efs.cache", "get cache interval error", th2);
            return 60000L;
        }
    }

    private void c(String str) {
        a aVar;
        if (this.f12805a.containsKey(str) && (aVar = this.f12805a.get(str)) != null) {
            try {
                aVar.flush();
                com.efs.sdk.base.core.util.b.a(aVar);
                a(aVar.f12809b);
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    this.f12805a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    f.a.f12921a.f12919c.c();
                } finally {
                    this.f12805a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        f.a.f12921a.f12919c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = bVar;
        messageObtain.what = 0;
        sendMessage(messageObtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(@n0 Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
                return;
            }
            return;
        }
        com.efs.sdk.base.core.d.b bVar = (com.efs.sdk.base.core.d.b) message.obj;
        for (int i11 = 0; i11 < 3; i11++) {
            try {
                a aVarB = b(bVar);
                if (aVarB == null) {
                    Log.w("efs.cache", "writer is null for type " + bVar.f12890a.f12883a);
                    return;
                }
                if (aVarB.getChannel().position() + ((long) bVar.f12892c.length) > 819200) {
                    c(bVar.f12890a.f12883a);
                    aVarB = b(bVar);
                    if (aVarB == null) {
                        Log.w("efs.cache", "writer is null for type " + bVar.f12890a.f12883a);
                        return;
                    }
                }
                aVarB.write(Base64.encode(bVar.f12892c, 11));
                aVarB.write("\n".getBytes());
                return;
            } catch (Throwable th2) {
                Log.e("efs.cache", "cache file error", th2);
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final boolean a(File file, com.efs.sdk.base.core.d.b bVar) {
        if (!bVar.b()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        bVar.f12893d = file;
        bVar.c();
        bVar.b(1);
        return true;
    }

    private a b(com.efs.sdk.base.core.d.b bVar) {
        a aVar;
        Throwable th2;
        a aVarPutIfAbsent;
        if (this.f12805a.containsKey(bVar.f12890a.f12883a)) {
            return this.f12805a.get(bVar.f12890a.f12883a);
        }
        File file = new File(com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVar));
        try {
            aVar = new a(file);
            try {
                aVarPutIfAbsent = this.f12805a.putIfAbsent(bVar.f12890a.f12883a, aVar);
            } catch (Throwable th3) {
                th2 = th3;
                th2.printStackTrace();
            }
        } catch (Throwable th4) {
            aVar = null;
            th2 = th4;
        }
        if (aVarPutIfAbsent != null) {
            com.efs.sdk.base.core.util.b.a(aVar);
            com.efs.sdk.base.core.util.b.b(file);
            return aVarPutIfAbsent;
        }
        Message messageObtain = Message.obtain();
        String str = bVar.f12890a.f12883a;
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessageDelayed(messageObtain, b(str));
        if (!"wa".equalsIgnoreCase(bVar.f12890a.f12883a)) {
            f.a.f12921a.f12919c.b();
        }
        return aVar;
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(@n0 String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessage(messageObtain);
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(File file) {
        byte[] bArr;
        com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
        if (bVarB == null) {
            com.efs.sdk.base.core.b.a unused = a.b.f12801a;
            com.efs.sdk.base.core.b.a.b(file);
        } else if (a(bVarB, file) && (bArr = bVarB.f12892c) != null && bArr.length > 0) {
            com.efs.sdk.base.core.util.b.a(new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVarB)), bVarB.f12892c);
            com.efs.sdk.base.core.util.b.b(file);
        } else {
            com.efs.sdk.base.core.b.a unused2 = a.b.f12801a;
            com.efs.sdk.base.core.b.a.b(file);
        }
    }

    private boolean a(com.efs.sdk.base.core.d.b bVar, File file) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        StringBuilder sb2 = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String strB = com.efs.sdk.base.core.util.b.b.b(line.getBytes());
                if (!TextUtils.isEmpty(strB)) {
                    sb2.append(strB);
                    sb2.append("\n");
                }
            }
            bVar.a(sb2.toString().getBytes());
            bVar.c();
            this.f12807c.a(bVar);
            bVar.f12893d = file;
            com.efs.sdk.base.core.util.b.a(bufferedReader);
            com.efs.sdk.base.core.util.b.a(fileReader);
            return true;
        } catch (Throwable th4) {
            th = th4;
            fileReader2 = fileReader;
            try {
                Log.e("efs.cache", "local decode error", th);
                com.efs.sdk.base.core.util.b.a(bufferedReader);
                com.efs.sdk.base.core.util.b.a(fileReader2);
                return false;
            } catch (Throwable th5) {
                com.efs.sdk.base.core.util.b.a(bufferedReader);
                com.efs.sdk.base.core.util.b.a(fileReader2);
                throw th5;
            }
        }
    }
}
