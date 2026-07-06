package a;

import android.widget.Toast;
import com.omarea.ui.SeekBar;
import com.omarea.vtools.activities.ActivityPowerBench;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oe1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench.t f7013a;

    public oe1(ActivityPowerBench.t tVar) {
        this.f7013a = tVar;
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
            Toast.makeText(ActivityPowerBench.this.getContext(), ActivityPowerBench.this.getString(u61.pb_need_one), 0).show();
            return;
        }
        ActivityPowerBench.this.f5409a = zArr;
        ((SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_threads)).setProgress(list.size());
        ActivityPowerBench.this.U();
    }
}
