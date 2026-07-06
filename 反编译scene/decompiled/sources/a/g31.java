package a;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g31 implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f961a;

    public g31(int i) {
        this.f6165a = i;
        this.f961a = "int";
    }

    public /* synthetic */ g31(int i, int i2, b92 b92Var) {
        this((i2 & 1) != 0 ? 3 : i);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        f92.d(spanned, "dest");
        if (charSequence != null && ec2.C(charSequence.toString(), "\"", false, 2, null)) {
            return "";
        }
        int i5 = this.f6165a;
        if (i5 >= 0 && i5 - (spanned.length() - (i4 - i3)) <= 0) {
            return "";
        }
        if ((!f92.a(this.f961a, "")) && charSequence != null) {
            if (f92.a(this.f961a, "int")) {
                if (!Pattern.compile("^[0-9]{0,}$").matcher(charSequence.toString()).matches()) {
                    return "";
                }
            } else if (f92.a(this.f961a, "number") && !Pattern.compile("^[\\-.,0-9]{0,}$").matcher(charSequence.toString()).matches()) {
                return "";
            }
        }
        return null;
    }
}
