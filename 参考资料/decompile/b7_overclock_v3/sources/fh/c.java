package fh;

import android.text.TextUtils;
import com.blankj.utilcode.util.i0;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.t;
import okhttp3.u;
import okhttp3.v;
import okhttp3.w;

/* JADX INFO: loaded from: classes5.dex */
public class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28440a = "HTTP_TRACE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f28441c = Charset.forName("UTF-8");

    public static String b(u uVar) {
        String strX = uVar.x();
        String strZ = uVar.z();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(uVar.X());
        sb2.append("://");
        sb2.append(uVar.F());
        if (strZ != null) {
            strX = strX + '?' + strZ;
        }
        sb2.append(strX);
        return sb2.toString();
    }

    public final String a(u uVar) {
        try {
            String strDecode = URLDecoder.decode(uVar.x(), "UTF-8");
            String strDecode2 = URLDecoder.decode(uVar.z(), "UTF-8");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(uVar.X());
            sb2.append("://");
            sb2.append(uVar.F());
            if (strDecode2 != null) {
                strDecode = strDecode + '?' + strDecode2;
            }
            sb2.append(strDecode);
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // okhttp3.v
    public d0 intercept(v.a aVar) throws Exception {
        b0 b0VarT = aVar.T();
        c0 c0VarF = b0VarT.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<---------------------------BEGIN REQUEST---------------------------------->");
        sb2.append("\n");
        sb2.append("Request encoded url: ");
        sb2.append(b0VarT.m());
        sb2.append(i0.f11861z);
        sb2.append(b(b0VarT.q()));
        sb2.append("\n");
        String strA = a(b0VarT.q());
        if (!TextUtils.isEmpty(strA)) {
            sb2.append("Request decoded url: ");
            sb2.append(b0VarT.m());
            sb2.append(i0.f11861z);
            sb2.append(strA);
        }
        t tVarK = b0VarT.k();
        sb2.append("\n=============== Headers ===============\n");
        int size = tVarK.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            sb2.append(tVarK.j(size));
            sb2.append(" : ");
            sb2.append(tVarK.d(tVarK.j(size)));
            sb2.append("\n");
        }
        sb2.append("\n=============== END Headers ===============\n");
        if (c0VarF != null) {
            okio.j jVar = new okio.j();
            c0VarF.r(jVar);
            w wVarB = c0VarF.b();
            if (wVarB != null) {
                wVarB.f(f28441c);
            }
            if (c0VarF.a() < 1000) {
                sb2.append(jVar.O0(f28441c));
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            d0 d0VarE = aVar.e(b0VarT);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            e0 e0VarL = d0VarE.L();
            sb2.append("\n");
            sb2.append("Response timeout: ");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append("\n");
            sb2.append("Response message: ");
            sb2.append(d0VarE.m1());
            sb2.append("\n");
            sb2.append("Response code: ");
            sb2.append(d0VarE.W());
            if (e0VarL != null) {
                okio.l lVarSource = e0VarL.source();
                lVarSource.request(Long.MAX_VALUE);
                okio.j jVarE = lVarSource.e();
                w wVarContentType = e0VarL.contentType();
                Charset charsetF = wVarContentType != null ? wVarContentType.f(f28441c) : null;
                if (charsetF == null) {
                    charsetF = f28441c;
                }
                if (e0VarL.contentLength() != 0) {
                    sb2.append("\n");
                    sb2.append("Response body: \n");
                    sb2.append(jVarE.clone().O0(charsetF));
                }
            }
            t tVarH1 = d0VarE.h1();
            sb2.append("\n=============== Headers ===============\n");
            for (int size2 = tVarH1.size() - 1; size2 > -1; size2--) {
                sb2.append(tVarH1.j(size2));
                sb2.append(" : ");
                sb2.append(tVarH1.d(tVarH1.j(size2)));
                sb2.append("\n");
            }
            sb2.append("\n=============== END Headers ===============\n");
            sb2.append("\n");
            sb2.append("<-----------------------------END REQUEST--------------------------------->");
            sb2.append("\n\n\n");
            return d0VarE;
        } catch (Exception e10) {
            throw e10;
        }
    }
}
