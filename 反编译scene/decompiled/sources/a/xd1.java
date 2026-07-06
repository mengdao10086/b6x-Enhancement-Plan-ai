package a;

import android.widget.Toast;
import com.omarea.vtools.activities.ActivityPerfBench;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xd1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPerfBench.f f7879a;

    public xd1(ActivityPerfBench.f fVar) {
        this.f7879a = fVar;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        ea2 ea2VarO = u42.o(zArr);
        ArrayList arrayList = new ArrayList();
        for (Integer num : ea2VarO) {
            if (zArr[num.intValue()]) {
                arrayList.add(num);
            }
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(ActivityPerfBench.this.getContext(), "请至少选择一个核心", 0).show();
        } else {
            this.f7879a.f8795a.f6891a = zArr;
        }
    }
}
