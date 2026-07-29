package v6;

import ag.c;
import androidx.room.h3;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.StringsKt__StringsKt;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nStringListConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringListConverter.kt\ncom/flydigi/database/StringListConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,28:1\n1855#2,2:29\n*S KotlinDebug\n*F\n+ 1 StringListConverter.kt\ncom/flydigi/database/StringListConverter\n*L\n22#1:29,2\n*E\n"})
public final class a {
    @l
    @h3
    public final List<String> a(@k String value) {
        f0.p(value, "value");
        return StringsKt__StringsKt.U4(value, new String[]{c.f654g}, false, 0, 6, null);
    }

    @k
    @h3
    public final String b(@k List<String> list) {
        f0.p(list, "list");
        StringBuilder sb2 = new StringBuilder(list.get(0));
        for (String str : list) {
            sb2.append(c.f654g);
            sb2.append(str);
        }
        String string = sb2.toString();
        f0.o(string, "str.toString()");
        return string;
    }
}
