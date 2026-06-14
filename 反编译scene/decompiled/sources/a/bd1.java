package a;

import com.omarea.vtools.activities.ActivityModules;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bd1 implements rh0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityModules f5696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f262a = {"*", "official", "share", "magisk-repo"};

    public bd1(ActivityModules activityModules) {
        this.f5696a = activityModules;
    }

    @Override // a.rh0
    public /* bridge */ /* synthetic */ void a(Integer num) {
        c(num.intValue());
    }

    @Override // a.rh0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        return -1;
    }

    public void c(int i) {
        if (i > -1) {
            this.f5696a.f5369a = this.f262a[i];
        } else if (!(!f92.a(this.f5696a.f5369a, "*"))) {
            return;
        } else {
            this.f5696a.f5369a = "*";
        }
        this.f5696a.s();
    }
}
