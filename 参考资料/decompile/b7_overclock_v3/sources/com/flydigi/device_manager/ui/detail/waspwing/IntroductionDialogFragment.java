package com.flydigi.device_manager.ui.detail.waspwing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import c7.n2;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.BaseBottomSheetFragment;
import com.flydigi.device_manager.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class IntroductionDialogFragment extends BaseBottomSheetFragment {

    @yt.k
    public static final a I8 = new a(null);

    @yt.k
    public static final String J8 = "title";

    @yt.k
    public static final String K8 = "introductions";
    public c7.y H8;

    @cl.d
    public static final class Introduction implements Parcelable {

        @yt.k
        public static final Parcelable.Creator<Introduction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public String f14650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public String f14651b;

        public static final class a implements Parcelable.Creator<Introduction> {
            @Override // android.os.Parcelable.Creator
            @yt.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Introduction createFromParcel(@yt.k Parcel parcel) {
                f0.p(parcel, "parcel");
                return new Introduction(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Introduction[] newArray(int i10) {
                return new Introduction[i10];
            }
        }

        public static final class b extends i.d<Introduction> {
            @Override // androidx.recyclerview.widget.i.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public boolean a(@yt.k Introduction oldItem, @yt.k Introduction newItem) {
                f0.p(oldItem, "oldItem");
                f0.p(newItem, "newItem");
                return n0.b(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.i.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public boolean b(@yt.k Introduction oldItem, @yt.k Introduction newItem) {
                f0.p(oldItem, "oldItem");
                f0.p(newItem, "newItem");
                return f0.g(oldItem, newItem);
            }
        }

        public Introduction(@yt.l String str, @yt.k String content) {
            f0.p(content, "content");
            this.f14650a = str;
            this.f14651b = content;
        }

        public static /* synthetic */ Introduction g(Introduction introduction, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = introduction.f14650a;
            }
            if ((i10 & 2) != 0) {
                str2 = introduction.f14651b;
            }
            return introduction.e(str, str2);
        }

        public final void C(@yt.l String str) {
            this.f14650a = str;
        }

        @yt.l
        public final String a() {
            return this.f14650a;
        }

        @yt.k
        public final String b() {
            return this.f14651b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @yt.k
        public final Introduction e(@yt.l String str, @yt.k String content) {
            f0.p(content, "content");
            return new Introduction(str, content);
        }

        public boolean equals(@yt.l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Introduction)) {
                return false;
            }
            Introduction introduction = (Introduction) obj;
            return f0.g(this.f14650a, introduction.f14650a) && f0.g(this.f14651b, introduction.f14651b);
        }

        public int hashCode() {
            String str = this.f14650a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f14651b.hashCode();
        }

        @yt.k
        public final String j() {
            return this.f14651b;
        }

        @yt.l
        public final String s() {
            return this.f14650a;
        }

        @yt.k
        public String toString() {
            return "Introduction(title=" + this.f14650a + ", content=" + this.f14651b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@yt.k Parcel out, int i10) {
            f0.p(out, "out");
            out.writeString(this.f14650a);
            out.writeString(this.f14651b);
        }

        public final void z(@yt.k String str) {
            f0.p(str, "<set-?>");
            this.f14651b = str;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final IntroductionDialogFragment a(@yt.k String title, @yt.k ArrayList<Introduction> introductions) {
            f0.p(title, "title");
            f0.p(introductions, "introductions");
            IntroductionDialogFragment introductionDialogFragment = new IntroductionDialogFragment();
            introductionDialogFragment.c5(androidx.core.os.e.b(new Pair("title", title), new Pair(IntroductionDialogFragment.K8, introductions)));
            return introductionDialogFragment;
        }
    }

    public static final class b extends androidx.recyclerview.widget.s<Introduction, a> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<Introduction> f14652c;

        public static final class a extends RecyclerView.e0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public final n2 f14653a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@yt.k View itemView) {
                super(itemView);
                f0.p(itemView, "itemView");
                n2 n2VarA = n2.a(itemView);
                f0.o(n2VarA, "bind(itemView)");
                this.f14653a = n2VarA;
            }

            @yt.k
            public final n2 h() {
                return this.f14653a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.k List<Introduction> introductions) {
            super(new Introduction.b());
            f0.p(introductions, "introductions");
            this.f14652c = introductions;
        }

        @Override // androidx.recyclerview.widget.s, androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f14652c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@yt.k a holder, int i10) {
            f0.p(holder, "holder");
            TextView textView = holder.h().f10276c;
            f0.o(textView, "holder.viewBinding.tvTitle");
            o5.c.b(textView, Boolean.valueOf(!n0.m(this.f14652c.get(i10).s())), false, 2, null);
            holder.h().f10276c.setText(this.f14652c.get(i10).s());
            holder.h().f10275b.setText(this.f14652c.get(i10).j());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        @yt.k
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@yt.k ViewGroup parent, int i10) {
            f0.p(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item_waspwing_introduction, parent, false);
            f0.o(viewInflate, "from(parent.context).inf…roduction, parent, false)");
            return new a(viewInflate);
        }
    }

    public static final void m6(IntroductionDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.H5();
    }

    @Override // com.flydigi.base.common.BaseBottomSheetFragment
    public int h6() {
        return R.layout.device_dialog_introduction;
    }

    @Override // com.flydigi.base.common.BaseBottomSheetFragment
    public void i6() {
    }

    @Override // com.flydigi.base.common.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        c7.y yVarA = c7.y.a(view);
        f0.o(yVarA, "bind(view)");
        n6(yVarA);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            List parcelableArrayList = bundleT1.getParcelableArrayList(K8);
            if (parcelableArrayList == null) {
                parcelableArrayList = CollectionsKt__CollectionsKt.E();
            } else {
                f0.o(parcelableArrayList, "bundle.getParcelableArra…emptyList<Introduction>()");
            }
            l6().f10591c.setAdapter(new b(parcelableArrayList));
            l6().f10592d.setText(bundleT1.getString("title"));
        }
        l6().f10590b.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntroductionDialogFragment.m6(this.f14753a, view2);
            }
        });
    }

    @yt.k
    public final c7.y l6() {
        c7.y yVar = this.H8;
        if (yVar != null) {
            return yVar;
        }
        f0.S("viewBinding");
        return null;
    }

    public final void n6(@yt.k c7.y yVar) {
        f0.p(yVar, "<set-?>");
        this.H8 = yVar;
    }
}
