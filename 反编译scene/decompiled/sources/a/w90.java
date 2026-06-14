package a;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w90 {
    public final CharSequence a(String str, String str2) {
        f92.d(str, "str");
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        String lowerCase = str.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase();
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, str2.length() + iN, 33);
        return spannableString;
    }

    public final SpannableString b(String str, v72<m42> v72Var) {
        f92.d(str, "text");
        f92.d(v72Var, "onClick");
        int length = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, length, 33);
        spannableString.setSpan(new v90(v72Var), 0, length, 33);
        return spannableString;
    }

    public final CharSequence c(String str) {
        TypefaceSpan typefaceSpan;
        f92.d(str, "text");
        SpannableString spannableString = new SpannableString(str);
        if (Build.VERSION.SDK_INT >= 28) {
            File file = new File("/system/fonts/DroidSansMono.ttf");
            typefaceSpan = new TypefaceSpan(file.exists() ? Typeface.createFromFile(file) : Typeface.MONOSPACE);
        } else {
            typefaceSpan = new TypefaceSpan("monospace");
        }
        spannableString.setSpan(typefaceSpan, 0, str.length(), 18);
        return spannableString;
    }
}
