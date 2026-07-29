package u9;

import com.flydigi.data.DataConstant;
import fh.l;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.d0;
import org.json.JSONObject;
import xi.b0;
import xi.c0;
import xi.z;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static /* synthetic */ void c(b0 b0Var, boolean z10, d0 d0Var, Exception exc) {
        if (exc != null || !d0Var.k1() || d0Var.L() == null) {
            b0Var.onError(exc);
            return;
        }
        try {
            b0Var.onNext(new JSONObject(d0Var.L().string()).optString("url"));
            b0Var.onComplete();
        } catch (Exception e10) {
            b0Var.onError(e10);
        }
    }

    public static /* synthetic */ void d(File file, String str, final b0 b0Var) throws Exception {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        String str2 = calendar.get(1) + fh.a.f28350w + (calendar.get(2) + 1) + calendar.get(5) + fh.a.f28350w + (a5.f.i().l() + System.nanoTime() + j3.b.f36044h + com.blankj.utilcode.util.b0.F(file));
        HashMap map = new HashMap();
        map.put(fh.e.f28444a, str);
        map.put("expiration", "9990000000");
        map.put(fh.e.f28453j, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put(fh.e.f28445b, str2);
        map.put(fh.e.f28448e, hh.c.j(file));
        l.c().b(file, map, DataConstant.UPYUN_OPERATER, hh.c.h(DataConstant.UPYUN_PASSWORD), new gh.b() { // from class: u9.i
            @Override // gh.b
            public final void a(boolean z10, d0 d0Var, Exception exc) {
                k.c(b0Var, z10, d0Var, exc);
            }
        }, null);
    }

    public static void e(File file, String bucket, gh.b completeListener, gh.c progressListener) {
        if (file == null || !file.exists()) {
            return;
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        String str = calendar.get(1) + fh.a.f28350w + (calendar.get(2) + 1) + calendar.get(5) + fh.a.f28350w + (a5.f.i().l() + calendar.getTimeInMillis() + j3.b.f36044h + com.blankj.utilcode.util.b0.F(file));
        HashMap map = new HashMap();
        map.put(fh.e.f28444a, bucket);
        map.put("expiration", "9990000000");
        map.put(fh.e.f28453j, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put(fh.e.f28445b, str);
        map.put(fh.e.f28448e, hh.c.j(file));
        l.c().b(file, map, DataConstant.UPYUN_OPERATER, hh.c.h(DataConstant.UPYUN_PASSWORD), completeListener, progressListener);
    }

    public static z<String> f(File file, String bucket) {
        return g("", file, bucket);
    }

    public static z<String> g(String name, final File file, final String bucket) {
        return z.r1(new c0() { // from class: u9.j
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                k.d(file, bucket, b0Var);
            }
        }).J5(lj.b.d());
    }
}
