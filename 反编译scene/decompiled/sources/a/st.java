package a;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class st implements TypeEvaluator<wc[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wc[] f7430a;

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public wc[] evaluate(float f, wc[] wcVarArr, wc[] wcVarArr2) {
        if (!xc.b(wcVarArr, wcVarArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!xc.b(this.f7430a, wcVarArr)) {
            this.f7430a = xc.f(wcVarArr);
        }
        for (int i = 0; i < wcVarArr.length; i++) {
            this.f7430a[i].d(wcVarArr[i], wcVarArr2[i], f);
        }
        return this.f7430a;
    }
}
