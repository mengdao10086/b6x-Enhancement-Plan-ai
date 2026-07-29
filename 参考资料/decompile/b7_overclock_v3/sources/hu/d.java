package hu;

import android.database.ContentObserver;

/* JADX INFO: loaded from: classes6.dex */
public class d extends ContentObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31492d = "VMS_IDLG_SDK_Observer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f31495c;

    public d(c cVar, int i10, String str) {
        super(null);
        this.f31495c = cVar;
        this.f31494b = i10;
        this.f31493a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        c cVar = this.f31495c;
        if (cVar != null) {
            cVar.d(this.f31494b, this.f31493a);
        }
    }
}
