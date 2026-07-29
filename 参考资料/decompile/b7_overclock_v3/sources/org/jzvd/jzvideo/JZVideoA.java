package org.jzvd.jzvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import hk.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes6.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0003\u0003\u0012\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lorg/jzvd/jzvideo/JZVideoA;", "Landroid/widget/RelativeLayout;", "Lorg/jzvd/jzvideo/JZVideoA$State;", "a", "Lorg/jzvd/jzvideo/JZVideoA$State;", "getState", "()Lorg/jzvd/jzvideo/JZVideoA$State;", "setState", "(Lorg/jzvd/jzvideo/JZVideoA$State;)V", "state", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "Screen", "State", "jiaozivideoplayer_release"}, k = 1, mv = {1, 4, 1})
public class JZVideoA extends RelativeLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f46187b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f46188a;

    @d0(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lorg/jzvd/jzvideo/JZVideoA$Screen;", "", "(Ljava/lang/String;I)V", "NORMAL", "FULLSCREEN", "TINY", "jiaozivideoplayer_release"}, k = 1, mv = {1, 4, 1})
    public enum Screen {
        NORMAL,
        FULLSCREEN,
        TINY
    }

    @d0(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lorg/jzvd/jzvideo/JZVideoA$State;", "", "(Ljava/lang/String;I)V", "IDLE", "NORMAL", "PREPARING", "PREPARING_CHANGE_URL", "PREPARING_PLAYING", "PREPARED", "PLAYING", "PAUSE", "COMPLETE", "ERROR", "jiaozivideoplayer_release"}, k = 1, mv = {1, 4, 1})
    public enum State {
        IDLE,
        NORMAL,
        PREPARING,
        PREPARING_CHANGE_URL,
        PREPARING_PLAYING,
        PREPARED,
        PLAYING,
        PAUSE,
        COMPLETE,
        ERROR
    }

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lorg/jzvd/jzvideo/JZVideoA$a;", "", "Lkotlin/z1;", "a", "<init>", "()V", "jiaozivideoplayer_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        public a() {
        }

        @m
        public final void a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JZVideoA(@k Context ctx) {
        super(ctx);
        f0.p(ctx, "ctx");
    }

    @m
    public static final void a() {
        f46187b.a();
    }

    @k
    public final State getState() {
        State state = this.f46188a;
        if (state == null) {
            f0.S("state");
        }
        return state;
    }

    public final void setState(@k State state) {
        f0.p(state, "<set-?>");
        this.f46188a = state;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JZVideoA(@k Context ctx, @k AttributeSet attrs) {
        super(ctx, attrs);
        f0.p(ctx, "ctx");
        f0.p(attrs, "attrs");
    }
}
