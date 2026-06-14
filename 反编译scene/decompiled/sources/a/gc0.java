package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hc0 f6193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Process f993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Thread f996a;
    public final /* synthetic */ Thread b;

    public gc0(hc0 hc0Var, Process process, String str, Thread thread, Thread thread2, Runnable runnable) {
        this.f6193a = hc0Var;
        this.f993a = process;
        this.f995a = str;
        this.f996a = thread;
        this.b = thread2;
        this.f994a = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.webkit.WebView] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.webkit.WebView] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [a.fc0, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [a.fc0, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [a.g30] */
    @Override // java.lang.Runnable
    public void run() {
        ?? r2;
        ?? r1;
        Runnable runnable;
        Runnable runnable2;
        ?? r0 = "";
        ?? fc0Var = "message";
        ?? sb = "type";
        int iWaitFor = -1;
        try {
            try {
                iWaitFor = this.f993a.waitFor();
                try {
                    g30 g30Var = new g30();
                    g30Var.v("type", -2);
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(iWaitFor);
                    g30Var.x("message", sb.toString());
                    ?? r02 = this.f6193a.f6300a.f1352a;
                    fc0Var = new fc0(this, g30Var);
                    r02.post(fc0Var);
                } catch (Exception unused) {
                }
                if (this.f996a.isAlive()) {
                    this.f996a.interrupt();
                }
                if (this.b.isAlive()) {
                    this.b.interrupt();
                }
                runnable2 = this.f994a;
                runnable = runnable2;
                r1 = fc0Var;
                r2 = sb;
                r0 = runnable2;
                fc0Var = fc0Var;
                sb = sb;
            } finally {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            try {
                g30 g30Var2 = new g30();
                g30Var2.v("type", -2);
                sb = new StringBuilder();
                sb.append("");
                sb.append(-1);
                g30Var2.x("message", sb.toString());
                ?? r03 = this.f6193a.f6300a.f1352a;
                fc0Var = new fc0(this, g30Var2);
                r03.post(fc0Var);
            } catch (Exception unused2) {
            }
            if (this.f996a.isAlive()) {
                this.f996a.interrupt();
            }
            if (this.b.isAlive()) {
                this.b.interrupt();
            }
            Runnable runnable3 = this.f994a;
            runnable = runnable3;
            r1 = fc0Var;
            r2 = sb;
            r0 = runnable3;
            fc0Var = fc0Var;
            sb = sb;
            if (runnable3 != null) {
            }
        }
        if (runnable2 != null) {
            runnable.run();
            r0 = runnable;
            fc0Var = r1;
            sb = r2;
        }
    }
}
