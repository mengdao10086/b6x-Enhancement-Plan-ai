package a;

import android.content.Context;
import com.omarea.Scene;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.AutoSkipCloudData$updateConfig$1", f = "AutoSkipCloudData.kt", l = {}, m = "invokeSuspend")
public final class tn0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3047a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f3048b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tn0(boolean z, Context context, b62 b62Var) {
        super(2, b62Var);
        this.f3048b = z;
        this.f3047a = context;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tn0 tn0Var = new tn0(this.f3048b, this.f3047a, b62Var);
        tn0Var.f7515a = (wd2) obj;
        return tn0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tn0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            URLConnection uRLConnectionOpenConnection = new URL("https://vtools.oss-cn-beijing.aliyuncs.com/addin/auto-skip-config-v1.json").openConnection();
            f92.c(uRLConnectionOpenConnection, "connection");
            uRLConnectionOpenConnection.setConnectTimeout(15000);
            uRLConnectionOpenConnection.setReadTimeout(20000);
            bufferedReader = new BufferedReader(new InputStreamReader(uRLConnectionOpenConnection.getInputStream()));
            sb = new StringBuilder();
        } catch (Exception unused) {
            if (this.f3048b) {
                Scene.c.p(Scene.f4798a, "获取云端配置数据失败~", 0, 2, null);
            }
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append("\n");
            return m42.f6769a;
        }
        String string = sb.toString();
        f92.c(string, "stringBuilder.toString()");
        int length = string.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zBooleanValue = t62.a(f92.e(t62.b(string.charAt(!z ? i : length)).charValue(), 32) <= 0).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        d30 d30Var = new d30(string.subSequence(i, length + 1).toString());
        if (this.f3048b) {
            Scene.c.p(Scene.f4798a, "从云端获得 " + d30Var.g() + " 条(自动跳过)数据", 0, 2, null);
        }
        jx0 jx0Var = new jx0(this.f3047a);
        jx0Var.b();
        int iG = d30Var.g();
        for (int i2 = 0; i2 < iG; i2++) {
            g30 g30VarD = d30Var.d(i2);
            if (g30VarD != null) {
                t62.a(jx0Var.a(g30VarD.i("activity"), g30VarD.i("viewId")));
            }
        }
        return m42.f6769a;
    }
}
