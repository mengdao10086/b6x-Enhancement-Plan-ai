package kd;

import android.animation.TypeEvaluator;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class c implements TypeEvaluator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f37171a = new c();

    @n0
    public static c b() {
        return f37171a;
    }

    @Override // android.animation.TypeEvaluator
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float f10, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f11 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = num2.intValue();
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f12 = f11 + (((((iIntValue2 >> 24) & 255) / 255.0f) - f11) * f10);
        float fPow5 = fPow2 + ((((float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * f10);
        float fPow6 = fPow3 + (f10 * (((float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d)) - fPow3));
        return Integer.valueOf((Math.round(((float) Math.pow(fPow + ((fPow4 - fPow) * f10), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f));
    }
}
