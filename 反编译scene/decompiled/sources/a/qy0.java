package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qy0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2660a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Integer> f2661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2662a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<Integer> f2663b;
    public int c;
    public int d;

    public final ArrayList<Integer> a() {
        ArrayList<Integer> arrayList = this.f2661a;
        if (arrayList != null) {
            return arrayList;
        }
        f92.m("cycles");
        throw null;
    }

    public final int b() {
        return this.b;
    }

    public final ArrayList<Integer> c() {
        ArrayList<Integer> arrayList = this.f2663b;
        if (arrayList != null) {
            return arrayList;
        }
        f92.m("frequencies");
        throw null;
    }

    public final boolean d() {
        return this.f2662a;
    }

    public final String e() {
        return this.f2660a;
    }

    public final int f() {
        return this.f7251a;
    }

    public final int g() {
        return this.d;
    }

    public final int h() {
        return this.c;
    }

    public final void i(ArrayList<Integer> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f2661a = arrayList;
    }

    public final void j(int i) {
        this.b = i;
    }

    public final void k(ArrayList<Integer> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f2663b = arrayList;
    }

    public final void l(boolean z) {
        this.f2662a = z;
    }

    public final void m(String str) {
        f92.d(str, "<set-?>");
        this.f2660a = str;
    }

    public final void n(int i) {
        this.f7251a = i;
    }

    public final void o(int i) {
        this.d = i;
    }

    public final void p(int i) {
        this.c = i;
    }
}
