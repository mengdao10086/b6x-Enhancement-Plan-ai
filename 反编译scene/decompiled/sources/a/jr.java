package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jr implements zr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1579a;

    public jr(mr mrVar, View view, ArrayList arrayList) {
        this.f6537a = view;
        this.f1579a = arrayList;
    }

    @Override // a.zr
    public void a(as asVar) {
    }

    @Override // a.zr
    public void b(as asVar) {
    }

    @Override // a.zr
    public void c(as asVar) {
    }

    @Override // a.zr
    public void d(as asVar) {
    }

    @Override // a.zr
    public void e(as asVar) {
        asVar.P(this);
        this.f6537a.setVisibility(8);
        int size = this.f1579a.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f1579a.get(i)).setVisibility(0);
        }
    }
}
