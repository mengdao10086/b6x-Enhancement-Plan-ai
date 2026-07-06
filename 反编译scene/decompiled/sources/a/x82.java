package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class x82 implements ha2, Serializable {
    public static final Object b = w82.f7767a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ha2 f7863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Class f3547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3549a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f3550b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3551b;

    public x82(Object obj, Class cls, String str, String str2, boolean z) {
        this.f3548a = obj;
        this.f3547a = cls;
        this.f3549a = str;
        this.f3550b = str2;
        this.f3551b = z;
    }

    public ha2 a() {
        ha2 ha2Var = this.f7863a;
        if (ha2Var != null) {
            return ha2Var;
        }
        b();
        this.f7863a = this;
        return this;
    }

    public abstract ha2 b();

    public Object c() {
        return this.f3548a;
    }

    public String e() {
        return this.f3549a;
    }

    public ja2 g() {
        Class cls = this.f3547a;
        if (cls == null) {
            return null;
        }
        return this.f3551b ? o92.c(cls) : o92.b(cls);
    }

    public String j() {
        return this.f3550b;
    }
}
