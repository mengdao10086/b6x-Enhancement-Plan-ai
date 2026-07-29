package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0004\b(\u0010)J)\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006Jw\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b\u001f\u0010\"R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b$\u0010\"R'\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u00118\u0006¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b#\u0010'¨\u0006*"}, d2 = {"Lokio/r;", "", i1.a.f31577d5, "Lkotlin/reflect/d;", "type", "c", "(Lkotlin/reflect/d;)Ljava/lang/Object;", "", "isRegularFile", "isDirectory", "Lokio/k0;", "symlinkTarget", "", "size", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "", "extras", "a", "(ZZLokio/k0;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/r;", "", "toString", "Z", "k", "()Z", "b", xf.j.f55230b, "Lokio/k0;", "i", "()Lokio/k0;", "d", "Ljava/lang/Long;", "h", "()Ljava/lang/Long;", "e", "f", "g", "Ljava/util/Map;", "()Ljava/util/Map;", "<init>", "(ZZLokio/k0;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f44195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f44196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final k0 f44197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final Long f44198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final Long f44199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public final Long f44200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final Long f44201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final Map<kotlin.reflect.d<?>, Object> f44202h;

    public r() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public r(boolean z10, boolean z11, @yt.l k0 k0Var, @yt.l Long l10, @yt.l Long l11, @yt.l Long l12, @yt.l Long l13, @yt.k Map<kotlin.reflect.d<?>, ? extends Object> extras) {
        kotlin.jvm.internal.f0.p(extras, "extras");
        this.f44195a = z10;
        this.f44196b = z11;
        this.f44197c = k0Var;
        this.f44198d = l10;
        this.f44199e = l11;
        this.f44200f = l12;
        this.f44201g = l13;
        this.f44202h = kotlin.collections.s0.D0(extras);
    }

    @yt.k
    public final r a(boolean z10, boolean z11, @yt.l k0 k0Var, @yt.l Long l10, @yt.l Long l11, @yt.l Long l12, @yt.l Long l13, @yt.k Map<kotlin.reflect.d<?>, ? extends Object> extras) {
        kotlin.jvm.internal.f0.p(extras, "extras");
        return new r(z10, z11, k0Var, l10, l11, l12, l13, extras);
    }

    @yt.l
    public final <T> T c(@yt.k kotlin.reflect.d<? extends T> type) {
        kotlin.jvm.internal.f0.p(type, "type");
        Object obj = this.f44202h.get(type);
        if (obj == null) {
            return null;
        }
        return (T) kotlin.reflect.e.a(type, obj);
    }

    @yt.l
    public final Long d() {
        return this.f44199e;
    }

    @yt.k
    public final Map<kotlin.reflect.d<?>, Object> e() {
        return this.f44202h;
    }

    @yt.l
    public final Long f() {
        return this.f44201g;
    }

    @yt.l
    public final Long g() {
        return this.f44200f;
    }

    @yt.l
    public final Long h() {
        return this.f44198d;
    }

    @yt.l
    public final k0 i() {
        return this.f44197c;
    }

    public final boolean j() {
        return this.f44196b;
    }

    public final boolean k() {
        return this.f44195a;
    }

    @yt.k
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f44195a) {
            arrayList.add("isRegularFile");
        }
        if (this.f44196b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f44198d;
        if (l10 != null) {
            arrayList.add(kotlin.jvm.internal.f0.C("byteCount=", l10));
        }
        Long l11 = this.f44199e;
        if (l11 != null) {
            arrayList.add(kotlin.jvm.internal.f0.C("createdAt=", l11));
        }
        Long l12 = this.f44200f;
        if (l12 != null) {
            arrayList.add(kotlin.jvm.internal.f0.C("lastModifiedAt=", l12));
        }
        Long l13 = this.f44201g;
        if (l13 != null) {
            arrayList.add(kotlin.jvm.internal.f0.C("lastAccessedAt=", l13));
        }
        if (!this.f44202h.isEmpty()) {
            arrayList.add(kotlin.jvm.internal.f0.C("extras=", this.f44202h));
        }
        return CollectionsKt___CollectionsKt.h3(arrayList, ", ", "FileMetadata(", ee.a.f26979d, 0, null, null, 56, null);
    }

    public /* synthetic */ r(boolean z10, boolean z11, k0 k0Var, Long l10, Long l11, Long l12, Long l13, Map map, int i10, kotlin.jvm.internal.u uVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) == 0 ? z11 : false, (i10 & 4) != 0 ? null : k0Var, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : l11, (i10 & 32) != 0 ? null : l12, (i10 & 64) == 0 ? l13 : null, (i10 & 128) != 0 ? kotlin.collections.s0.z() : map);
    }
}
