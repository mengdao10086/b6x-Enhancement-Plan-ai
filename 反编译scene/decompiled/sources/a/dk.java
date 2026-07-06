package a;

import android.os.Bundle;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dk extends ri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ek f5910a;

    public dk(ek ekVar) {
        this.f5910a = ekVar;
    }

    @Override // a.ri
    public ni b(int i) {
        return ni.P(this.f5910a.H(i));
    }

    @Override // a.ri
    public ni d(int i) {
        int i2 = i == 2 ? this.f5910a.f758a : this.f5910a.b;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return b(i2);
    }

    @Override // a.ri
    public boolean f(int i, int i2, Bundle bundle) {
        return this.f5910a.P(i, i2, bundle);
    }
}
