package a;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dx implements TypeEvaluator<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FloatEvaluator f5944a = new FloatEvaluator();

    public dx(ix ixVar) {
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f, Float f2, Float f3) {
        float fFloatValue = this.f5944a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
