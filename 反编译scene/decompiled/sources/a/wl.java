package a;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wl implements vl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yl f3453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3454a;
    public final int b;

    public wl(yl ylVar, String str, int i, int i2) {
        this.f3453a = ylVar;
        this.f3454a = str;
        this.f7800a = i;
        this.b = i2;
    }

    @Override // a.vl
    public boolean a(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2) {
        Fragment fragment = this.f3453a.f3735b;
        if (fragment == null || this.f7800a >= 0 || this.f3454a != null || !fragment.o().i()) {
            return this.f3453a.W0(arrayList, arrayList2, this.f3454a, this.f7800a, this.b);
        }
        return false;
    }
}
