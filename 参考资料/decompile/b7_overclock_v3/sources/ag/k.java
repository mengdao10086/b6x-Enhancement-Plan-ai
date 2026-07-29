package ag;

import g.n0;
import g.p0;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class k implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f676c = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<String> f677a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f678b = new ArrayList();

    @Override // ag.m
    public void a(@n0 g gVar) {
        this.f678b.add((g) n.a(gVar));
    }

    @Override // ag.m
    public void b(@n0 String str, @p0 Object... objArr) {
        q(3, null, str, objArr);
    }

    @Override // ag.m
    public m c(String str) {
        if (str != null) {
            this.f677a.set(str);
        }
        return this;
    }

    @Override // ag.m
    public void d(@n0 String str, @p0 Object... objArr) {
        q(2, null, str, objArr);
    }

    @Override // ag.m
    public void e(@n0 String str, @p0 Object... objArr) {
        m(null, str, objArr);
    }

    @Override // ag.m
    public void f(@p0 String str) {
        if (n.d(str)) {
            n("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            n(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            e("Invalid xml", new Object[0]);
        }
    }

    @Override // ag.m
    public void g(@n0 String str, @p0 Object... objArr) {
        q(5, null, str, objArr);
    }

    @Override // ag.m
    public void h(@n0 String str, @p0 Object... objArr) {
        q(7, null, str, objArr);
    }

    @Override // ag.m
    public void i(@p0 String str) {
        if (n.d(str)) {
            n("Empty/Null json content");
            return;
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith(zc.a.f58316d)) {
                n(new JSONObject(strTrim).toString(2));
            } else if (strTrim.startsWith("[")) {
                n(new JSONArray(strTrim).toString(2));
            } else {
                e("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            e("Invalid Json", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x0021, B:9:0x0025, B:12:0x002d, B:13:0x0033, B:15:0x0039, B:17:0x0045), top: B:24:0x0005 }] */
    @Override // ag.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void j(int r3, @g.p0 java.lang.String r4, @g.p0 java.lang.String r5, @g.p0 java.lang.Throwable r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r6 == 0) goto L1d
            if (r5 == 0) goto L1d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r0.<init>()     // Catch: java.lang.Throwable -> L4b
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = " : "
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = ag.n.c(r6)     // Catch: java.lang.Throwable -> L4b
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L4b
        L1d:
            if (r6 == 0) goto L25
            if (r5 != 0) goto L25
            java.lang.String r5 = ag.n.c(r6)     // Catch: java.lang.Throwable -> L4b
        L25:
            boolean r6 = ag.n.d(r5)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L2d
            java.lang.String r5 = "Empty/NULL log message"
        L2d:
            java.util.List<ag.g> r6 = r2.f678b     // Catch: java.lang.Throwable -> L4b
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L4b
        L33:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L49
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Throwable -> L4b
            ag.g r0 = (ag.g) r0     // Catch: java.lang.Throwable -> L4b
            boolean r1 = r0.b(r3, r4)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L33
            r0.a(r3, r4, r5)     // Catch: java.lang.Throwable -> L4b
            goto L33
        L49:
            monitor-exit(r2)
            return
        L4b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.k.j(int, java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    @Override // ag.m
    public void k() {
        this.f678b.clear();
    }

    @Override // ag.m
    public void l(@n0 String str, @p0 Object... objArr) {
        q(4, null, str, objArr);
    }

    @Override // ag.m
    public void m(@p0 Throwable th2, @n0 String str, @p0 Object... objArr) {
        q(6, th2, str, objArr);
    }

    @Override // ag.m
    public void n(@p0 Object obj) {
        q(3, null, n.f(obj), new Object[0]);
    }

    @n0
    public final String o(@n0 String str, @p0 Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @p0
    public final String p() {
        String str = this.f677a.get();
        if (str == null) {
            return null;
        }
        this.f677a.remove();
        return str;
    }

    public final synchronized void q(int i10, @p0 Throwable th2, @n0 String str, @p0 Object... objArr) {
        n.a(str);
        j(i10, p(), o(str, objArr), th2);
    }
}
