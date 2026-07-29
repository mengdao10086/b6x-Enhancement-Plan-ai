package na;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class h extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f42007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42008b;

    public h() {
        this.f42007a = new String[0];
        this.f42008b = 0;
    }

    @Override // na.l
    public String h(float f10) {
        int iRound = Math.round(f10);
        return (iRound < 0 || iRound >= this.f42008b || iRound != ((int) f10)) ? "" : this.f42007a[iRound];
    }

    public String[] l() {
        return this.f42007a;
    }

    public void m(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f42007a = strArr;
        this.f42008b = strArr.length;
    }

    public h(String[] strArr) {
        this.f42007a = new String[0];
        this.f42008b = 0;
        if (strArr != null) {
            m(strArr);
        }
    }

    public h(Collection<String> collection) {
        this.f42007a = new String[0];
        this.f42008b = 0;
        if (collection != null) {
            m((String[]) collection.toArray(new String[collection.size()]));
        }
    }
}
