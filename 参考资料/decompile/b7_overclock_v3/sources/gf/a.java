package gf;

import android.support.v4.media.session.MediaSessionCompat;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.math.DoubleMath;
import com.google.zxing.oned.d;
import com.umeng.socialize.bean.HandlerRequestCode;
import cp.n1;
import m9.m;
import mb.e;
import no.nordicsemi.android.dfu.DfuBaseService;
import ob.h;
import rb.a0;
import rb.h0;
import rb.k0;
import v7.a;
import w.w;
import xf.n0;
import zo.q0;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f29378b = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, rc.c.f48463k0, 150, 157, 156, 163, 162, h.H, os.a.f46207a, HideBottomViewOnScrollBehavior.f19616g, e.f41073w1, 181, 180, e.f41031i2, 186, s0.c.f49294u, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, uf.c.Ya, 146, 153, rc.c.f48464l0, 159, 158, 165, ISchedulers.SUB_CANCEL, 171, DoubleMath.MAX_FACTORIAL, 177, 176, 183, 182, a0.f47918w, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, WaspWingInfo.COLD_LEVEL_STANDARD_B7, d.f21430g, 155, 154, 161, 160, 167, 166, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, h0.K, 179, 178, NormalCmdFactory.TASK_CANCEL_ALL, 184, 191, 190, 197, 196, a.c.f52773i, a.c.f52772h, 818, 817}, new int[]{DfuBaseService.NOTIFICATION_ID, 282, 277, 276, 271, 270, gg.b.f29505x, gg.b.f29497v, gg.b.f29457l, gg.b.f29449j, 253, 252, 247, 246, 241, 240, 235, 234, 229, 228, 223, 222, 217, 216, hr.a.f31427a, ISchedulers.IS_M3U8_PEER, 205, a.c.f52774j, BaseQuickAdapter.FOOTER_VIEW, -3}, new int[]{q0.f59440m, 284, 279, gg.b.P, 273, gg.b.J, gg.b.B, gg.b.f29513z, gg.b.f29473p, gg.b.f29465n, 255, 254, a4.d.f205j, 248, 243, m.f40854e0, 237, 236, e.f41040l1, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 225, 224, 219, 218, 213, 212, a.c.f52776l, a.c.f52775k, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, gg.b.D, 263, gg.b.f29481r, 257, 256, e.f41067u1, 250, 245, 244, 239, e.f41061s1, 233, 232, 227, 226, 221, 220, e.f41076x1, 214, 209, 208, 822, -3}, new int[]{gg.b.S, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, w.a.f53657s, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, n1.E, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, 315, 314, 321, MediaSessionCompat.M, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, w.a.f53656r, w.a.f53655q, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, gg.b.E, gg.b.f29493u, gg.b.f29485s, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, gg.b.f29445i, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, a.c.D, a.c.C, gg.b.I, gg.b.G, gg.b.f29509y, gg.b.f29501w, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, gg.b.f29461m, gg.b.f29453k, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, a.c.F, 406, 401, 400, gg.b.C, gg.b.A, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, gg.b.f29477q, gg.b.f29469o, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, w.c.f53698r, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{gg.b.T, 416, w.c.f53701u, w.c.f53700t, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, k0.f48142c, a0.f47914s, 440, 447, 446, 834, -3}, new int[]{419, 418, w.c.f53703w, w.c.f53702v, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, a0.f47912q, a0.f47911p, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, n0.f55274k, 837, -3}, new int[]{483, 482, 477, 476, 471, FloatingActionButton.f20202y, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, w.g.f53774m, w.g.f53773l, 511, w.g.f53779r, gg.b.f29422c0, gg.b.f29414a0, 842, 841}, new int[]{489, 488, 495, 494, w.g.f53770i, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, w.g.f53776o, w.g.f53775n, 513, 512, gg.b.f29438g0, gg.b.f29430e0, 843, -3}, new int[]{491, 490, 497, 496, w.g.f53772k, w.g.f53771j, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, w.g.f53777p, gg.b.Y, gg.b.W, gg.b.f29450j0, gg.b.f29446i0, 845, 844}, new int[]{559, gg.b.f29443h1, 553, 552, gg.b.T0, 546, gg.b.K0, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, gg.b.C0, gg.b.A0, gg.b.f29486s0, gg.b.f29482r0, gg.b.f29462m0, gg.b.f29454k0, 846, -3}, new int[]{561, 560, gg.b.f29423c1, 554, gg.b.W0, gg.b.U0, gg.b.N0, gg.b.L0, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, gg.b.E0, gg.b.D0, gg.b.f29498v0, gg.b.f29490t0, gg.b.f29474p0, 524, 848, 847}, new int[]{563, 562, gg.b.f29439g1, gg.b.f29435f1, gg.b.Z0, gg.b.Y0, gg.b.Q0, gg.b.O0, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, gg.b.H0, gg.b.F0, gg.b.f29510y0, gg.b.f29502w0, 527, gg.b.f29478q0, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, w.e.f53735w, w.e.f53734v, 613, w.e.B, 619, 618, 625, 624, 631, 630, 637, 636, gg.b.Z, gg.b.X, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, w.e.f53737y, w.e.f53736x, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, gg.b.f29426d0, gg.b.f29418b0, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, w.e.f53733u, w.e.f53732t, w.e.A, w.e.f53738z, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, gg.b.f29442h0, gg.b.f29434f0, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, w.h.f53792l, 697, 696, 691, 690, 685, 684, gg.b.f29415a1, 678, 673, gg.b.P0, 667, gg.b.G0, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, w.h.f53795o, 704, 699, 698, 693, 692, 687, gg.b.f29447i1, 681, 680, 675, gg.b.S0, 669, 668, 663, gg.b.B0, 657, 656, 651, gg.b.f29458l0, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, w.h.f53797q, w.h.f53796p, w.h.f53791k, 700, 695, 694, 689, 688, 683, 682, gg.b.X0, gg.b.V0, 671, gg.b.M0, 665, 664, 659, gg.b.f29494u0, 653, gg.b.f29470o0, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, gg.b.f29459l1, 768, gg.b.f29479q1, gg.b.f29475p1, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, HandlerRequestCode.SINA_SHARE_REQUEST_CODE, 764, gg.b.f29467n1, gg.b.f29463m1, 777, 776, 783, 782, 789, 788, 795, com.android.motionelf.tools.a.f11373q, 801, gg.b.f29491t1, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, com.android.motionelf.tools.a.f11372p, 761, 760, 767, 766, 773, gg.b.f29471o1, 779, gg.b.f29483r1, 785, gg.b.f29487s1, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f29379a;

    public a(af.b bVar) {
        this.f29379a = bVar;
    }

    public byte[] a() {
        byte[] bArr = new byte[144];
        int i10 = this.f29379a.i();
        int iM = this.f29379a.m();
        for (int i11 = 0; i11 < i10; i11++) {
            int[] iArr = f29378b[i11];
            for (int i12 = 0; i12 < iM; i12++) {
                int i13 = iArr[i12];
                if (i13 >= 0 && this.f29379a.f(i12, i11)) {
                    int i14 = i13 / 6;
                    bArr[i14] = (byte) (((byte) (1 << (5 - (i13 % 6)))) | bArr[i14]);
                }
            }
        }
        return bArr;
    }
}
