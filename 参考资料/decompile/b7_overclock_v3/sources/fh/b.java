package fh;

import com.tencent.connect.common.Constants;
import com.upyun.library.exception.RespException;
import com.upyun.library.exception.UpYunException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f28429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f28430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f28431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f28432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f28433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gh.c f28434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gh.b f28435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f28436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, Object> f28437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f28438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f28439k;

    public b(k kVar, File file, Map<String, Object> map, String str, String str2, gh.b bVar, gh.c cVar) {
        this.f28429a = kVar;
        this.f28430b = file;
        this.f28431c = (String) map.get(e.f28444a);
        this.f28437i = map;
        this.f28435g = bVar;
        this.f28434f = cVar;
        this.f28438j = str;
        this.f28439k = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f28432d == null || this.f28438j == null || this.f28433e == null || this.f28431c == null) {
            Map<String, Object> map = this.f28437i;
            if (map != null) {
                if ((this.f28438j != null) & (this.f28439k != null)) {
                    this.f28432d = hh.c.d(map);
                    String str = (String) this.f28437i.get(e.f28447d);
                    String str2 = (String) this.f28437i.get(e.f28448e);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Constants.HTTP_POST);
                    sb2.append("&");
                    sb2.append(a.f28350w + this.f28431c);
                    if (str != null) {
                        sb2.append("&");
                        sb2.append(str);
                    }
                    sb2.append("&");
                    sb2.append(this.f28432d);
                    if (str2 != null) {
                        sb2.append("&");
                        sb2.append(str2);
                    }
                    try {
                        byte[] bArrB = hh.c.b(this.f28439k, sb2.toString().trim());
                        if (bArrB != null) {
                            this.f28433e = hh.b.i(bArrB);
                        }
                    } catch (InvalidKeyException e10) {
                        this.f28435g.a(false, null, e10);
                        return;
                    } catch (NoSuchAlgorithmException e11) {
                        this.f28435g.a(false, null, e11);
                        return;
                    } catch (SignatureException e12) {
                        this.f28435g.a(false, null, e12);
                        return;
                    }
                }
            }
            this.f28435g.a(false, null, new UpYunException("参数错误"));
            return;
        }
        try {
            this.f28435g.a(true, this.f28429a.a(this.f28430b, "https://v0.api.upyun.com/" + this.f28431c, this.f28432d, this.f28438j, this.f28433e, this.f28434f), null);
        } catch (RespException | IOException e13) {
            int i10 = this.f28436h + 1;
            this.f28436h = i10;
            if (i10 > j.f28483e || ((e13 instanceof RespException) && ((RespException) e13).a() / 100 != 5)) {
                this.f28435g.a(false, null, e13);
            } else {
                run();
            }
        }
    }

    public b(k kVar, File file, String str, String str2, String str3, gh.b bVar, gh.c cVar) {
        this.f28429a = kVar;
        this.f28430b = file;
        try {
            this.f28431c = (String) new JSONObject(hh.b.e(str)).get(e.f28444a);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        this.f28432d = str;
        this.f28433e = str3;
        this.f28435g = bVar;
        this.f28434f = cVar;
        this.f28438j = str2;
    }
}
