package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f6396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f1350a;

    public ic(int i, int i2) {
        this.f1350a = new int[]{i, i2};
        this.f6396a = new float[]{0.0f, 1.0f};
    }

    public ic(int i, int i2, int i3) {
        this.f1350a = new int[]{i, i2, i3};
        this.f6396a = new float[]{0.0f, 0.5f, 1.0f};
    }

    public ic(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.f1350a = new int[size];
        this.f6396a = new float[size];
        for (int i = 0; i < size; i++) {
            this.f1350a[i] = list.get(i).intValue();
            this.f6396a[i] = list2.get(i).floatValue();
        }
    }
}
