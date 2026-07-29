package org.bouncycastle.util.test;

import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
public class c implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f46060d = Strings.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f46061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f46062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f46063c;

    public c(boolean z10, String str) {
        this.f46061a = z10;
        this.f46062b = str;
    }

    public c(boolean z10, String str, Throwable th2) {
        this.f46061a = z10;
        this.f46062b = str;
        this.f46063c = th2;
    }

    public static f c(d dVar, String str) {
        return new c(false, dVar.getName() + ": " + str);
    }

    public static f d(d dVar, String str, Object obj, Object obj2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = f46060d;
        sb2.append(str2);
        sb2.append("Expected: ");
        sb2.append(obj);
        sb2.append(str2);
        sb2.append("Found   : ");
        sb2.append(obj2);
        return c(dVar, sb2.toString());
    }

    public static f e(d dVar, String str, Throwable th2) {
        return new c(false, dVar.getName() + ": " + str, th2);
    }

    public static String f(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(" failing ");
        stringBuffer.append(str2);
        String str5 = f46060d;
        stringBuffer.append(str5);
        stringBuffer.append("    expected: ");
        stringBuffer.append(str3);
        stringBuffer.append(str5);
        stringBuffer.append("    got     : ");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }

    public static f g(d dVar, String str) {
        return new c(true, dVar.getName() + ": " + str);
    }

    @Override // org.bouncycastle.util.test.f
    public Throwable a() {
        return this.f46063c;
    }

    @Override // org.bouncycastle.util.test.f
    public boolean b() {
        return this.f46061a;
    }

    @Override // org.bouncycastle.util.test.f
    public String toString() {
        return this.f46062b;
    }
}
