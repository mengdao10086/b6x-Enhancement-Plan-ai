package hd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31110d = "LibraryLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f31111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f31113c;

    public p(String... strArr) {
        this.f31111a = strArr;
    }

    public synchronized boolean a() {
        if (this.f31112b) {
            return this.f31113c;
        }
        this.f31112b = true;
        try {
            for (String str : this.f31111a) {
                System.loadLibrary(str);
            }
            this.f31113c = true;
        } catch (UnsatisfiedLinkError unused) {
            t.n(f31110d, "Failed to load " + Arrays.toString(this.f31111a));
        }
        return this.f31113c;
    }

    public synchronized void b(String... strArr) {
        a.j(!this.f31112b, "Cannot set libraries after loading");
        this.f31111a = strArr;
    }
}
