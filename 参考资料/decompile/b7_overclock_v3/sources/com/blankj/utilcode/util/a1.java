package com.blankj.utilcode.util;

import com.blankj.utilcode.util.j1;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11692a = System.getProperty("line.separator");

    public static class a extends j1.f<b> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String[] f11693p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ boolean f11694q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ boolean f11695r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j1.b bVar, String[] strArr, boolean z10, boolean z11) {
            super(bVar);
            this.f11693p = strArr;
            this.f11694q = z10;
            this.f11695r = z11;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b e() {
            return a1.f(this.f11693p, this.f11694q, this.f11695r);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11698c;

        public b(int i10, String str, String str2) {
            this.f11696a = i10;
            this.f11697b = str;
            this.f11698c = str2;
        }

        public String toString() {
            return "result: " + this.f11696a + "\nsuccessMsg: " + this.f11697b + "\nerrorMsg: " + this.f11698c;
        }
    }

    public a1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static b a(String str, boolean z10) {
        return f(new String[]{str}, z10, true);
    }

    public static b b(String str, boolean z10, boolean z11) {
        return f(new String[]{str}, z10, z11);
    }

    public static b c(List<String> list, boolean z10) {
        return f(list == null ? null : (String[]) list.toArray(new String[0]), z10, true);
    }

    public static b d(List<String> list, boolean z10, boolean z11) {
        return f(list == null ? null : (String[]) list.toArray(new String[0]), z10, z11);
    }

    public static b e(String[] strArr, boolean z10) {
        return f(strArr, z10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.blankj.utilcode.util.a1.b f(java.lang.String[] r10, boolean r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.a1.f(java.lang.String[], boolean, boolean):com.blankj.utilcode.util.a1$b");
    }

    public static j1.f<b> g(String str, boolean z10, j1.b<b> bVar) {
        return l(new String[]{str}, z10, true, bVar);
    }

    public static j1.f<b> h(String str, boolean z10, boolean z11, j1.b<b> bVar) {
        return l(new String[]{str}, z10, z11, bVar);
    }

    public static j1.f<b> i(List<String> list, boolean z10, j1.b<b> bVar) {
        return l(list == null ? null : (String[]) list.toArray(new String[0]), z10, true, bVar);
    }

    public static j1.f<b> j(List<String> list, boolean z10, boolean z11, j1.b<b> bVar) {
        return l(list == null ? null : (String[]) list.toArray(new String[0]), z10, z11, bVar);
    }

    public static j1.f<b> k(String[] strArr, boolean z10, j1.b<b> bVar) {
        return l(strArr, z10, true, bVar);
    }

    public static j1.f<b> l(String[] strArr, boolean z10, boolean z11, @g.n0 j1.b<b> bVar) {
        Objects.requireNonNull(bVar, "Argument 'consumer' of type Utils.Consumer<CommandResult> (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l1.v(new a(bVar, strArr, z10, z11));
    }
}
