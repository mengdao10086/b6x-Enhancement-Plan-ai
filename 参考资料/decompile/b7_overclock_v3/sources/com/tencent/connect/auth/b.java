package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f22442a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f22443d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f22444e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f22445b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22446c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IUiListener f22447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f22448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22449c;
    }

    public static b a() {
        if (f22442a == null) {
            f22442a = new b();
        }
        return f22442a;
    }

    public static int b() {
        int i10 = f22444e + 1;
        f22444e = i10;
        return i10;
    }

    public String c() {
        int iCeil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < iCeil; i10++) {
            stringBuffer.append(charArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int iB = b();
        try {
            this.f22445b.put("" + iB, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return "" + iB;
    }
}
