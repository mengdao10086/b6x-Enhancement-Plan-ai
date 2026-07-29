package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
public final class TextViewKt {

    @t0({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<Editable, z1> f5185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.r<CharSequence, Integer, Integer, Integer, z1> f5186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.r<CharSequence, Integer, Integer, Integer, z1> f5187c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.l<? super Editable, z1> lVar, ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> rVar, ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> rVar2) {
            this.f5185a = lVar;
            this.f5186b = rVar;
            this.f5187c = rVar2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@yt.l Editable editable) {
            this.f5185a.i(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
            this.f5186b.N(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
            this.f5187c.N(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    @t0({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f5191a;

        public b(ik.l lVar) {
            this.f5191a = lVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@yt.l Editable editable) {
            this.f5191a.i(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @t0({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n78#2:98\n77#3:99\n*E\n"})
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.r f5192a;

        public c(ik.r rVar) {
            this.f5192a = rVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@yt.l Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
            this.f5192a.N(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @t0({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n*L\n1#1,97:1\n78#2:98\n71#3:99\n*E\n"})
    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.r f5193a;

        public d(ik.r rVar) {
            this.f5193a = rVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@yt.l Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@yt.l CharSequence charSequence, int i10, int i11, int i12) {
            this.f5193a.N(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    @yt.k
    public static final TextWatcher a(@yt.k TextView textView, @yt.k ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> beforeTextChanged, @yt.k ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> onTextChanged, @yt.k ik.l<? super Editable, z1> afterTextChanged) {
        f0.p(textView, "<this>");
        f0.p(beforeTextChanged, "beforeTextChanged");
        f0.p(onTextChanged, "onTextChanged");
        f0.p(afterTextChanged, "afterTextChanged");
        a aVar = new a(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(aVar);
        return aVar;
    }

    public static /* synthetic */ TextWatcher b(TextView textView, ik.r beforeTextChanged, ik.r onTextChanged, ik.l afterTextChanged, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            beforeTextChanged = new ik.r<CharSequence, Integer, Integer, Integer, z1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                @Override // ik.r
                public /* bridge */ /* synthetic */ z1 N(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    b(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return z1.f38230a;
                }

                public final void b(@yt.l CharSequence charSequence, int i11, int i12, int i13) {
                }
            };
        }
        if ((i10 & 2) != 0) {
            onTextChanged = new ik.r<CharSequence, Integer, Integer, Integer, z1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                @Override // ik.r
                public /* bridge */ /* synthetic */ z1 N(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    b(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return z1.f38230a;
                }

                public final void b(@yt.l CharSequence charSequence, int i11, int i12, int i13) {
                }
            };
        }
        if ((i10 & 4) != 0) {
            afterTextChanged = new ik.l<Editable, z1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                public final void b(@yt.l Editable editable) {
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Editable editable) {
                    b(editable);
                    return z1.f38230a;
                }
            };
        }
        f0.p(textView, "<this>");
        f0.p(beforeTextChanged, "beforeTextChanged");
        f0.p(onTextChanged, "onTextChanged");
        f0.p(afterTextChanged, "afterTextChanged");
        a aVar = new a(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(aVar);
        return aVar;
    }

    @yt.k
    public static final TextWatcher c(@yt.k TextView textView, @yt.k ik.l<? super Editable, z1> action) {
        f0.p(textView, "<this>");
        f0.p(action, "action");
        b bVar = new b(action);
        textView.addTextChangedListener(bVar);
        return bVar;
    }

    @yt.k
    public static final TextWatcher d(@yt.k TextView textView, @yt.k ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> action) {
        f0.p(textView, "<this>");
        f0.p(action, "action");
        c cVar = new c(action);
        textView.addTextChangedListener(cVar);
        return cVar;
    }

    @yt.k
    public static final TextWatcher e(@yt.k TextView textView, @yt.k ik.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, z1> action) {
        f0.p(textView, "<this>");
        f0.p(action, "action");
        d dVar = new d(action);
        textView.addTextChangedListener(dVar);
        return dVar;
    }
}
