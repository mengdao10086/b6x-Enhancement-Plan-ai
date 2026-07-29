package g6;

import com.flydigi.data.bean.FirmwareInfoBean;
import java.util.List;
import m5.c0;
import m5.f0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5.d f29060a = (h5.d) f0.i().k().g(h5.d.class);

    @Override // g6.a
    public z<List<FirmwareInfoBean>> a(@k String str) {
        return this.f29060a.a(str).s0(c0.p()).s0(c0.t());
    }

    @Override // g6.a
    public z<FirmwareInfoBean> b(@k String str) {
        return this.f29060a.B(str).s0(c0.p()).s0(c0.t());
    }
}
