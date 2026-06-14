package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public iq f6630a = new iq();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jq f1676a;

    public kq(jq jqVar) {
        this.f1676a = jqVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int iC = this.f1676a.c();
        int iD = this.f1676a.d();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA = this.f1676a.a(i);
            this.f6630a.e(iC, iD, this.f1676a.e(viewA), this.f1676a.b(viewA));
            if (i3 != 0) {
                this.f6630a.d();
                this.f6630a.a(i3);
                if (this.f6630a.b()) {
                    return viewA;
                }
            }
            if (i4 != 0) {
                this.f6630a.d();
                this.f6630a.a(i4);
                if (this.f6630a.b()) {
                    view = viewA;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        this.f6630a.e(this.f1676a.c(), this.f1676a.d(), this.f1676a.e(view), this.f1676a.b(view));
        if (i == 0) {
            return false;
        }
        this.f6630a.d();
        this.f6630a.a(i);
        return this.f6630a.b();
    }
}
