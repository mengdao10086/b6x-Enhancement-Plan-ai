package zn;

/* JADX INFO: loaded from: classes5.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f59106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuffer f59107d;

    public y1(String str) {
        this(str, ',');
    }

    public y1(String str, char c10) {
        this.f59107d = new StringBuffer();
        this.f59104a = str;
        this.f59105b = -1;
        this.f59106c = c10;
    }

    public boolean a() {
        return this.f59105b != this.f59104a.length();
    }

    public String b() {
        if (this.f59105b == this.f59104a.length()) {
            return null;
        }
        int i10 = this.f59105b + 1;
        this.f59107d.setLength(0);
        boolean z10 = false;
        boolean z11 = false;
        while (i10 != this.f59104a.length()) {
            char cCharAt = this.f59104a.charAt(i10);
            if (cCharAt != '\"') {
                if (!z10 && !z11) {
                    if (cCharAt == '\\') {
                        this.f59107d.append(cCharAt);
                        z10 = true;
                    } else {
                        if (cCharAt == this.f59106c) {
                            break;
                        }
                        this.f59107d.append(cCharAt);
                    }
                }
                i10++;
            } else if (!z10) {
                z11 = !z11;
            }
            this.f59107d.append(cCharAt);
            z10 = false;
            i10++;
        }
        this.f59105b = i10;
        return this.f59107d.toString();
    }
}
