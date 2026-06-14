package a;

import java.util.Calendar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7795a;

    public wj0(int i) {
        this.f7795a = i;
    }

    public final int a() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public final int b() {
        int iA = a();
        int i = this.f7795a;
        return iA > i ? (1440 - iA) + i : i - iA;
    }
}
