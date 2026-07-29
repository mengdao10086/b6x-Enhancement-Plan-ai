package com.flydigi.base.common;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    public class a extends ag.a {
        @Override // ag.a, ag.g
        public boolean b(int i10, String str) {
            return false;
        }
    }

    public static void a(Object obj) {
    }

    public static void b(String str, Object... objArr) {
    }

    public static void c(String str, Object... objArr) {
    }

    public static void d(Throwable th2, String str, Object... objArr) {
    }

    public static void e(String str, Object... objArr) {
    }

    public static void f() {
        ag.j.a(new a());
    }

    public static void g(String str) {
        ag.j.h(str);
    }

    public static void h(String str, int i10, String str2) {
        if (str.length() > i10) {
            str.substring(0, i10);
            if (str.length() - i10 > i10) {
                h(str.substring(i10), i10, str2);
            } else {
                str.substring(i10);
            }
        }
    }

    public static void i(String str, Object... objArr) {
    }

    public static void j(String str, Object... objArr) {
    }

    public static void k(String str, Object... objArr) {
        ag.j.n(str, objArr);
    }

    public static void l(String str) {
        ag.j.o(str);
    }
}
