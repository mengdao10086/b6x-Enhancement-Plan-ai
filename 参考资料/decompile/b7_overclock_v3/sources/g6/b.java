package g6;

import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.google.gson.Gson;
import java.io.File;
import java.util.List;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f29058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f29059b;

    public b() {
        File file = new File(j1.a().getCacheDir(), "api");
        this.f29058a = file;
        b0.k(file);
        this.f29059b = new Gson();
    }

    @Override // g6.a
    public z<List<FirmwareInfoBean>> a(@k String str) {
        return null;
    }

    @Override // g6.a
    public z<FirmwareInfoBean> b(@k String str) {
        return null;
    }
}
