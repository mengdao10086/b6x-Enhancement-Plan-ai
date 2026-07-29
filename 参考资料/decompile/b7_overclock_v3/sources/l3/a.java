package l3;

import android.content.Context;
import android.view.Display;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import java.util.Arrays;
import java.util.List;
import o5.m;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f39430a = Arrays.asList("LenovoTB-J716F", "LenovoTB-J706F", "LenovoYT-K606F", "ZA8E0018CN", "WGR-W09", "WGR-W19", "WGR-AN19");

    public static int a(int i10, Context context) {
        int iN = m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, -1);
        if (n8.a.f(context)) {
            if (iN == 1) {
                return 2;
            }
            Display displayB = n8.a.b(context, false);
            n.a("当前投屏方向：" + displayB.getRotation());
            if (displayB.getRotation() == 0) {
                return 1;
            }
        } else {
            if (iN == 1) {
                return i10;
            }
            if (i10 != 1 && i10 == 3) {
                return 2;
            }
        }
        return 0;
    }
}
