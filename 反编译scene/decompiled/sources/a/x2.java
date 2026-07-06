package a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x2 implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f3514a;
    public int b;

    public x2(AnimationDrawable animationDrawable, boolean z) {
        b(animationDrawable, z);
    }

    public int a() {
        return this.b;
    }

    public int b(AnimationDrawable animationDrawable, boolean z) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        this.f7846a = numberOfFrames;
        int[] iArr = this.f3514a;
        if (iArr == null || iArr.length < numberOfFrames) {
            this.f3514a = new int[numberOfFrames];
        }
        int[] iArr2 = this.f3514a;
        int i = 0;
        for (int i2 = 0; i2 < numberOfFrames; i2++) {
            int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
            iArr2[i2] = duration;
            i += duration;
        }
        this.b = i;
        return i;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i = (int) ((f * this.b) + 0.5f);
        int i2 = this.f7846a;
        int[] iArr = this.f3514a;
        int i3 = 0;
        while (i3 < i2 && i >= iArr[i3]) {
            i -= iArr[i3];
            i3++;
        }
        return (i3 / i2) + (i3 < i2 ? i / this.b : 0.0f);
    }
}
