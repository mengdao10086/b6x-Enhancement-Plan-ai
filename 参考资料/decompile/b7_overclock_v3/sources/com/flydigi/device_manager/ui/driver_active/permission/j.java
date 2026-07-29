package com.flydigi.device_manager.ui.driver_active.permission;

import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f14918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f14919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14920c;

    public j(@yt.k String title, @yt.k String content, int i10) {
        f0.p(title, "title");
        f0.p(content, "content");
        this.f14918a = title;
        this.f14919b = content;
        this.f14920c = i10;
    }

    public static /* synthetic */ j e(j jVar, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jVar.f14918a;
        }
        if ((i11 & 2) != 0) {
            str2 = jVar.f14919b;
        }
        if ((i11 & 4) != 0) {
            i10 = jVar.f14920c;
        }
        return jVar.d(str, str2, i10);
    }

    @yt.k
    public final String a() {
        return this.f14918a;
    }

    @yt.k
    public final String b() {
        return this.f14919b;
    }

    public final int c() {
        return this.f14920c;
    }

    @yt.k
    public final j d(@yt.k String title, @yt.k String content, int i10) {
        f0.p(title, "title");
        f0.p(content, "content");
        return new j(title, content, i10);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return f0.g(this.f14918a, jVar.f14918a) && f0.g(this.f14919b, jVar.f14919b) && this.f14920c == jVar.f14920c;
    }

    @yt.k
    public final String f() {
        return this.f14919b;
    }

    public final int g() {
        return this.f14920c;
    }

    @yt.k
    public final String h() {
        return this.f14918a;
    }

    public int hashCode() {
        return (((this.f14918a.hashCode() * 31) + this.f14919b.hashCode()) * 31) + this.f14920c;
    }

    @yt.k
    public String toString() {
        return "PermissionInstructionItem(title=" + this.f14918a + ", content=" + this.f14919b + ", imageResId=" + this.f14920c + ')';
    }
}
