package a;

import com.omarea.model.DeviceBindInfo;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qv1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rv1 f7244a;

    public qv1(rv1 rv1Var) {
        this.f7244a = rv1Var;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.omarea.model.DeviceBindInfo] */
    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        if (!list.isEmpty()) {
            n92 n92Var = new n92();
            n92Var.f6891a = null;
            int length = zArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                if (zArr[i]) {
                    n92Var.f6891a = (DeviceBindInfo) this.f7244a.b.get(i2);
                }
                i++;
                i2 = i3;
            }
            new sn1(this.f7244a.f7335a, new pv1(this, n92Var)).d();
        }
    }
}
