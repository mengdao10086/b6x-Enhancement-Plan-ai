# 路线 A — P3：端到端验收报告

> **执行体**：P3 验收 agent（只读，未改任何仓库文件；本报告是唯一新建文件）
> **快照时刻**：2026-09-20 00:12 ~ 00:21:47（本地时间）
> **重要前提**：验收期间**工作树在被其他 agent 并发修改**——`CHANGELOG.md` 于 00:17:18、`README.md` 于 00:17:09、`待办.md` 于 00:17:20、`app/build.gradle.kts` 于 00:21 前后被写入，并新出现未跟踪文件 `参考资料/c_historical_sources/tempctrl2.7.c`。本报告所有结论以 **00:21:47 快照**为准；晚于此的改动未覆盖。
> **结论三档**：通过 / 有问题 / 无法核实。

---

## 1. 路径一致性的四方闭环

**结论：通过**

### 四方一致性（逐字核对）

| 来源 | 文件:行 | 值 |
|---|---|---|
| `tempctrl.c` 的 `PRIVATE_DIR` | `magisk模块(智能温控)/tempctrl.c:81` | `/data/data/com.example.waspwingtempctrl/files` |
| `ConfigStore.DAEMON_PRIVATE_DIR` | `.../ConfigStore.java:74` | `/data/data/com.example.waspwingtempctrl/files` |
| `applicationId` | `.../app/build.gradle.kts:10` | `com.example.waspwingtempctrl` |
| `params.json` 的 `LOG_FILE` | `app/src/main/assets/params.json` `keys.LOG_FILE.default` 与 `.factory` | 均为 `/data/data/com.example.waspwingtempctrl/files/tempctrl.log` |

四者互相一致。另有两处派生落点同源：`ConfigStore.java:423`（`desc` 声明三方一致要求）、`params.def.json` 的 `audit.crossChecks` 两条（`LOG_FILE default/factory = <PRIVATE_DIR>/<二进制名>.log`、`PRIVATE_DIR = /data/data/<applicationId>/files`），由 `check_params.py` 自动执行，实测通过。

### 落点体系归属（逐条列出所有绝对路径）

**A. app 私有目录 `/data/data/com.example.waspwingtempctrl/files/`**
- `tempctrl.c:849` 日志 `<PRIVATE_DIR>/<二进制名>.log`；`tempctrl.c:866` 配置 `<PRIVATE_DIR>/profile.conf`；`tempctrl.c:319` 曲线数据 `<PRIVATE_DIR>/tempctrl_webui.data`；`tempctrl.c:2702` 锁 `<PRIVATE_DIR>/tempctrl.lock`
- `ConfigStore.java:74/170`；`Deployer.java:286-287` 中转副本 `deploy/{tempctrl, b6x-tempctrl.sh}`；`Deployer.java:537` 预创建 `tempctrl.log`/`tempctrl_webui.data`；`Deployer.java:568` 清理名单
- `ui/AppFiles.java:28/30`（`LOG_NAME="tempctrl.log"`、`DATA_NAME="tempctrl_webui.data"`）

**B. `/data/local/tmp/`**
- `Deployer.java:51` `BIN_DEST=/data/local/tmp/tempctrl`；`Deployer.java:17`（脚本）与 `Deployer.java:664` `tempctrl_service.log`
- status 双文件：`tempctrl.c:315-316` 与 `MainHook.java:48-49`
- 遗留清理：`Deployer.java:647` `tempctrl.lock`、`Deployer.java:654` `tempctrl_last_dev`

**C. `service.d`**
- `Deployer.java:57/59` `/data/adb/service.d`、`/data/adb/ksu/service.d`；`Deployer.java:607-610` 探测 `/data/adb/ksu/bin/ksud`

**D. 飞智 app 私有目录（只有 MainHook 用）**
- `MainHook.java:1084` `"/data/data/" + pkg + "/files/tempctrl_last_dev"`

**落在上述体系之外的（逐个列出）**
1. `magisk模块(智能温控)/tempctrl.c:853` — 私有目录不可用时的兜底 `/cache/<二进制名>.log`。**在体系之外，但是有意设计**（`set_default_log_path()` 写明「回退 /cache 并写 stderr，不静默」），`逻辑说明.md` 亦有记载。
2. `magisk模块(智能温控)/tempctrl.c:1414` — `/system/bin/am`（系统二进制，非数据落点）。
3. `Deployer.java:647` — `rm -f /data/local/tmp/tempctrl.lock`：**本版从未使用该路径**（锁在私有目录），是上一版遗留物的清理，`uninstallScript()` 里**没有注释说明它是遗留项**（同段只对 `tempctrl_last_dev` 加了遗留注释）。

除上述 3 条外，`assets/deploy/b6x-tempctrl.sh` 与 `Deployer.java` 中出现的每一个绝对路径都在三套落点体系内。

`b6x-tempctrl.sh` 全文出现的绝对路径：`/system/bin/sh`（shebang）、`/data/local/tmp/tempctrl`（`:16`）、`/data/local/tmp/tempctrl_service.log`（`:17`）、`/dev/null`（`:68`）——无越界。

---

## 2. status 双文件不动

**结论：通过**

### 路径字面量逐一比对（完全一致）

| | C 端 | Java 端 |
|---|---|---|
| B6X | `tempctrl.c:315` `/data/local/tmp/tempctrl_b6x.status` | `MainHook.java:48` `/data/local/tmp/tempctrl_b6x.status` |
| B7X | `tempctrl.c:316` `/data/local/tmp/tempctrl_b7x.status` | `MainHook.java:49` `/data/local/tmp/tempctrl_b7x.status` |

`git diff HEAD -- magisk模块(智能温控)/tempctrl.c` 中**没有任何 `status_file_path_*` / `strncmp(line, "…="` 行的增删**（grep 该 diff 的 `^[-+]` 结果为空）→ 路径、字段、预创建、`chmod 0666` 确实一字未动。

### 字段名两端比对（人肉比对结论）

C 端无常量表，字段名以 `strncmp` 硬编码散落在两个解析函数中。逐条比对结果：

**写入端（只有 MainHook 写；C 端全库不写 status，只 `fopen(...,"a")` 预创建）** — `MainHook.java:228-265` 依次写 9 个字段：

| # | Java 写入字面量 | C 读取点 | 是否一致 |
|---|---|---|---|
| 1 | `BLE=` （`MainHook.java:230`） | `tempctrl.c:1021`（`read_single_status`）、`tempctrl.c:1116`（`read_cooler_params`） | ✅ |
| 2 | `CONNECTED_AT=`（`:231`） | `tempctrl.c:1030` | ✅ |
| 3 | `BLE_OWNER_LAST=`（`:232`） | `tempctrl.c:1032` | ✅ |
| 4 | `RUN_MODE=`（`:241`） | `tempctrl.c:1122` | ✅ |
| 5 | `HOT_TEMP=`（`:244`） | `tempctrl.c:1118` | ✅ |
| 6 | `COLD_TEMP=`（`:257`） | `tempctrl.c:1120` | ✅ |
| 7 | `RPM_REAL=`（`:260`） | `tempctrl.c:1124` | ✅ |
| 8 | `COLD_REAL=`（`:262`） | `tempctrl.c:1126` | ✅ |
| 9 | `TARGET_TEMP=`（`:263`） | **无任何读取点** | ⚠️ 见下 |

- 关键前提也成立：C 端用 `strncmp(line, "X=", n)` 要求键在**行首**，Java 侧逐行 `sb.append("X=")` 写，满足。
- `tempctrl.c:1017/1111` 用 `char line[64]` 逐行读，最长的 `BLE_OWNER_LAST=<int> <long>` 远低于 64，无截断风险。

**唯一事实性发现（非本次引入）**：`TARGET_TEMP` 被 Java 写、**没有任何消费者**——`grep TARGET_TEMP` 在 `tempctrl.c`（当前与 `HEAD` 版）均 0 命中，`HEAD` 版 `webroot/app.js` 0 命中，原生界面 java 侧 0 命中。属**既存无用字段**，路线 A 未引入、也未清理。

---

## 3. 广播协议两端一致

**结论：通过**

### Action 名

| | C 端 | Java 端 |
|---|---|---|
| B6X | `tempctrl.c:1411` `com.flydigi.SET_TEMPERATURE` | `MainHook.java:57` `ACTION_TEMP_B6` = 同值 |
| B7X | `tempctrl.c:1410` `com.flydigi.SET_TEMPERATURE_B7` | `MainHook.java:58` `ACTION_TEMP_B7` = 同值 |

`MainHook.java:139` 按 `appKind==7` 选 B7、否则 B6，与 C 端按 `active_device == DEVICE_B7X` 选 Action 的语义一一对应。

### Extra 键名逐一对照（顺序问题专门核过）

C 端 `tempctrl.c:1416-1423` 的 `--ei` 发出序列与 Java 端 `MainHook.java:145-151` 的 `getIntExtra` 键名：

| C 端下发序 | C 端键名（`tempctrl.c`） | Java 端 `getIntExtra` 键名（`MainHook.java`） | 一致 |
|---|---|---|---|
| 1 | `mode`（`:1417`） | `"mode"`（`:145`） | ✅ |
| 2 | `temperature`（`:1418`） | `"temperature"`（`:146`） | ✅ |
| 3 | `windOC`（`:1419`） | `"windOC"`（`:147`） | ✅ |
| 4 | `coldOC`（`:1420`） | `"coldOC"`（`:148`） | ✅ |
| 5 | `windLevel`（`:1421`） | `"windLevel"`（`:149`） | ✅ |
| 6 | `modeCustom`（`:1422`，恒 `0`） | `"modeCustom"`（`:150`） | ✅ |
| 7 | `extra`（`:1423`，恒 `0`） | `"extra"`（`:151`） | ✅ |

**顺序错位专项结论**：两端 7 个键**逐位同名**，且 `am broadcast --ei <键> <值>` 是**具名**参数（不是位置参数），Android 侧解析与顺序无关，**不存在顺序错位风险**。C 端 `execl` 的实参本身也是「键、值」成对排列（`tempctrl.c:1416-1423`），无错配。

### 自动拉起额外标志

- C 端 `tempctrl.c:1721/1725` `--es b6x_auto_launch 1`
- Java 端 `MainHook.java:55` `AUTO_LAUNCH_EXTRA = "b6x_auto_launch"`，`:1145` 读 `getStringExtra` — ✅ 一致（键名与类型 es/String 对应）

---

## 4. 参数定义与 C 端

**结论：通过（附「无法自动核对区」清单与人工/空白判定）**

### 命令实测（00:21 复跑）

```
python 参数定义/check_params.py            → A/B/C 全 PASS，EXIT=0
python 参数定义/gen_params.py --audit      → 漂移 0 条 / 提示 4 条，EXIT=0
  C 侧自动核对：默认值 通过 66 / 豁免 1 / 无 C 变量 7
                范围   通过 47 / 无 clamp 20 / 无 C 变量 7
```

### audit 报出的「无法自动核对区」逐条

**(a) 范围无 C 端 clamp —— 20 个取值位**（`gen_params.py --audit` 第四行 INFO 全列）
`DEBUG_ENABLED[1]`、`DEBUG_SENSOR[1]`、`DEBUG_EXEC[1]`、`DEBUG_CONN[1]`、`DEBUG_CONFIG[1]`、`DEBUG_MAIN[1]`、`DEBUG_PID[1]`、`DEBUG_LAUNCH[1]`、`PERF_ENABLED[1]`、`PID_TARGET_DIR[1]`、`PID_SPEED_RECALL[1]`、`SYSFS_ENABLED[1]`、`BATT_TEMP_PATH[1]`、`BATT_CURRENT_PATH[1]`、`CPU_TEMP_PATH_FMT[1]`、`LOG_FILE[1]`、`APP_LAUNCH_ENABLED[1]`、`APP_LAUNCH_SCREEN_GATE[1][2][3]`

按 `params.def.json` 逐键查证后的判定：
- **已人工核对（有裁定文字）**：`BATT_TEMP_PATH`/`BATT_CURRENT_PATH`/`CPU_TEMP_PATH_FMT` 的 `rangeNote` = 「路径字符串，无取值范围」；`LOG_FILE` 的 `rangeNote` = 「路径字符串，无取值范围」且另有 `audit.skipDefault` 一条豁免（理由写明：C 内静态初值为空串、运行期按二进制名派生，真实一致性由 `crossChecks` 第 1 条核对）；`PID_TARGET_DIR[1]`/`PID_SPEED_RECALL[1]`/`APP_LAUNCH_SCREEN_GATE[1..3]` 的 `unitNote` = 「布尔子开关，取值 0/1」，`rangeNote` = 「范围逐字段见 fields」。
- **真空白（有 min/max 但无任何说明）**：`DEBUG_ENABLED`、`DEBUG_SENSOR`、`DEBUG_EXEC`、`DEBUG_CONN`、`DEBUG_CONFIG`、`DEBUG_MAIN`、`DEBUG_PID`、`DEBUG_LAUNCH`、`PERF_ENABLED`、`SYSFS_ENABLED`、`APP_LAUNCH_ENABLED` 共 **11 个 `type=switch` 键**——`min=0/max=1` 结构上自明（C 侧当布尔用，故无 clamp），但 `rangeNote` **为空**（实测 `None`）。功能上不会出错（界面按 switch 控件钳制），属「无文字裁定」而非「语义未定」。

**(b) 无 C 变量 —— 7 个取值位**：`PID_KI_DYN_T`(3 槽)、`PID_KI_DYN_GATE`(2 槽)、`PID_KI_DYN_WIN`(2 槽)，`audit.cVars` 中 `cVar` 为 `null`
- **已人工核对**：三键 `rangeNote` 均已写明护栏语义——`PID_KI_DYN_T` =「三值另有跨字段护栏 T1 > T2 且 M < T1，越界整组拒绝（不是钳位）」；`PID_KI_DYN_GATE` =「越界整组拒绝（不是钳位）」；`PID_KI_DYN_WIN` =「N 的上限 = tempctrl.c 的 KI_DYN_WIN_MAX(=128)，越界整组拒绝（不是钳位）」，且该槽带 `rangeMacro: KI_DYN_WIN_MAX`。

**(c) 无 C 变量 —— 5 个键**：`WEBUI_GAP_SEC`、`WEBUI_LABEL_MERGE_PX`、`WEBUI_RPM_AXIS_MIN`、`WEBUI_CURVE_FILTER`、`WEBUI_AUTOSAVE`，`audit.cVars` 中为 `[]`
- 判定：**设计如此**（界面专用键，C 端不消费），非空白。

**(d) 4 条「提示」（非错误）**：schema.js 键序与定义不同（不影响功能，顺序失配影响的是 schema 渲染顺序与 `profile.conf` 的一致性）；`逻辑说明.md` 参数表行序与定义不同（文档为阅读便利排版，属预期）；另两条即上面 (a)(b)。
- 前两条属**「已知不漂移的格式差异」**，`check_params.py` 判 PASS，可接受。

**(e) 已知盲区（`待办.md` 风险 9 自述，本次核实为真）**：审计核对规则把日志后缀写死，二进制改名会让核对仍通过；`tempctrl.c` 的 `WEBUI_DATA_MAX_LINES 720` 与 `chart.rollingMaxLines` 是宏、无法自动核对。

---

## 5. 界面调用边界（I5）

**结论：通过**

扫描范围：`app/src/main/java/com/example/waspwingtempctrl/ui/**`（24 个文件）+ `SetupActivity.java` + `ui/StatusFragment.java`。

| 检查项 | 结果 |
|---|---|
| 直接拼 shell 命令 | **0 处**。全包 grep `sh -c` / `am broadcast` / `dumpsys` / `pgrep` / `pkill` / `chmod` / `/data/local/tmp`，唯一命中是注释（`ui/StatusFragment.java:20`「su 诊断」为文案、`ui/LogClassifier.java:39` 引用日志关键词字面量） |
| 直接用 `Runtime.exec` / `ProcessBuilder` | **0 处**（`grep -rn 'Runtime\.\|ProcessBuilder\|exec('` 在 `ui/` 与 `SetupActivity.java` 均为空） |
| 调用 `RootShell` | **0 处**（`grep -rn RootShell ui/` 为空）。界面只经 `Deployer`：`ui/StatusFragment.java:16` import、`:92/98/104/110` 调 `Deployer.get(ctx).{deploy,uninstall,startDaemon,buildDiagnostics}`、`:86` 调 `probe()`，与 `ui/StatusFragment.java:23-27` 的边界声明相符 |
| 绕过 `ConfigStore` 直读写 `profile.conf` | **0 处**。`ui/` 内对 `profile.conf` 的引用全是注释/文案（`ui/ChartConfig.java:83` 失败提示、`ui/ChartFragment.java:36` 线程说明、`ui/ConfigFormFragment.java:41` 边界声明）；配置读写一律 `ConfigStore.get()`（`ui/ChartConfig.java:78`、`ui/ConfigFormFragment.java:79`） |
| 主线程调 `RootShell` 阻塞方法 | **0 处**。`Deployer` 的 4 个阻塞调用全走后台线程：`ui/StatusFragment.java:131` `new Thread(...)`、`:146` `activity.runOnUiThread(...)` 回主线程渲染；其余阻塞 IO 也都在后台（`ui/ChartFragment.java:230`、`ui/LogFragment.java:230`、`ui/ConfigFormFragment.java:80` 单线程 executor、`ui/ConfigWriteQueue.java:42`） |
| 直接文件 IO | 仅 `ui/AppFiles.java`（`:140` `RandomAccessFile`）——**读的是 `tempctrl.log` / `tempctrl_webui.data`，不是 `profile.conf`**（`ui/AppFiles.java:28/30/41/45`），属设计内的直读层 |

`SetupActivity.java` 本身零业务（`:20-21` 声明，实测全文只有 TabLayout add/hide/show），`ui/` 内无 `Runtime`、无 shell 字符串。

---

## 6. 卸载残留清单 vs 实际产物

**结论：有问题**

### 实际会被写出来的东西 vs `Deployer.uninstall()` 的覆盖

| # | 落点（产生者） | uninstall 是否清 | 备注 |
|---|---|---|---|
| 1 | `/data/local/tmp/tempctrl`（Deployer） | ✅ `Deployer.java:646` | |
| 2 | `/data/adb/service.d/b6x-tempctrl.sh` 与 `/data/adb/ksu/service.d/…`（Deployer） | ✅ `:644-645` | |
| 3 | 私有目录 `deploy/`（中转副本 `tempctrl` + 脚本，Deployer） | ✅ `:575-583` | 部署成功后**保留在原地**直到卸载 |
| 4 | 私有目录 `profile.conf`（Deployer 仅不存在时写） | ❌ 有意不清 `:349` | 用户配置，已在 javadoc 写明 |
| 5 | 私有目录 `tempctrl.log` / `tempctrl_webui.data`（预创建 + daemon 写） | ✅ `:568` | |
| 6 | 私有目录 `tempctrl.lock`（daemon） | ✅ `:568`，**仅在确认进程已退出时** `:376` | |
| 7 | `/data/local/tmp/tempctrl_service.log`（service.d 脚本） | ✅ `:649` | **但见问题 ①** |
| 8 | `/data/local/tmp/tempctrl_b6x.status` / `_b7x.status`（daemon 预创建） | ✅ `:648-649` | 与仍激活的 MainHook 共有；MainHook 会自行重建，无实害 |
| 9 | `/data/local/tmp/tempctrl_last_dev`（旧版遗留） | ✅ `:654` | 注释明确标注为迁移残留 |
| 10 | `/data/data/<飞智包名>/files/tempctrl_last_dev`（MainHook 新落点） | ❌ 有意不碰 `:352-355` | |
| 11 | 省电白名单（deviceidle/appops/standby） | ❌ 有意不回滚 `:350-351` | |
| 12 | `/cache/<二进制名>.log`（C 端私有目录不可用时的兜底日志） | ❌ **未覆盖** | 见问题 ② |
| 13 | `/data/local/tmp/tempctrl_b6x.status.tmp` / `_b7x.status.tmp`（MainHook 原子写中转，`MainHook.java:272-281`） | ❌ **未覆盖** | 见问题 ③ |
| 14 | `/data/local/tmp/tempctrl.lock`（本版从不产生） | ✅ `:647`，但**无遗留注释** | 见问题 ④ |

**清单遗漏**
① `log()` 会在卸载后**重建** `/data/local/tmp/tempctrl_service.log`：`assets/deploy/b6x-tempctrl.sh:21-23` 的 `log()` 用 `>>` 追加（文件不存在即创建），而 service.d 脚本进程（`:91-97` 的 `while true` 看门狗）**不会被 `uninstallScript()` 的 `pkill -f "$BIN"` 杀掉**——它的 cmdline 是 `/system/bin/sh /data/adb/service.d/b6x-tempctrl.sh`，不含 `$BIN` 字符串，`Deployer.java:571/642` 的 `pgrep -f "$BIN"` 也匹配不到它。卸载后该脚本继续每 300s 走一轮 `start()` → `:62-64` 判定二进制不存在 → `log "二进制缺失或不可执行…"` → **重新创建刚被删掉的日志文件**。最小复现：部署 → 触发过开机拉起（或手工跑一次脚本）→ 卸载部署 → 观察 `/data/local/tmp/tempctrl_service.log` 在 ≤300s 内重新出现且持续增长。
② `/cache/<二进制名>.log` 不在清理范围（`tempctrl.c:853` 的兜底路径）。仅在「私有目录不可用」时才产生，属边缘路径，但确为清单外的产物。
③ `.status.tmp` 不在清理范围（`MainHook.java:272` 建、`:279` 失败时 `delete()`）。正常情况下每次 rename 成功会消失，但进程被杀在中途时会留下。属**低概率残留**。
④ `Deployer.java:647` 的 `rm -f /data/local/tmp/tempctrl.lock` 清的是一个**本版从未创建的路径**，且同段注释块（`:651-653`）只解释了 `tempctrl_last_dev`。属「清对了但没说明为什么」——不影响正确性（若真有上一版残留，清掉是对的）。

**多清**：未发现越界删除。唯一可议的是第 8 项（status 双文件与仍在使用的 MainHook 共有），但 `Deployer.java:377` 的步骤文案与 javadoc 已如实说明「守护进程下次启动会重建；仍激活的 MainHook 读到缺失即视为断联」，属**已声明的有意行为**，不计为多清。

---

## 7. CI 产物形态（静态核对，**CI 未真跑**）

**结论：通过（静态）** — 以下全为读 `.github/workflows/build.yml` 的静态结论，**未在 runner 上验证**；`待办.md` 与本报告均不声称已运行。

| 核对点 | 证据 | 结论 |
|---|---|---|
| R6 覆盖面 | `build.yml:122-125`：`cd "magisk模块(智能温控)" && find . -type f ! -name '*.md' -print0 \| LC_ALL=C sort -z \| xargs -0 -r sha256sum` | ✅ 递归覆盖该目录 `**`，排除 md。本地实测（同命令）参与哈希的 5 个文件：`build_tempctrl.sh`、`magisk模块框架/profile.conf`、`magisk模块框架/webroot/schema.js`、`patch_tls.py`、`tempctrl.c`；该目录内仅 `逻辑说明.md`、`动态KI机制流程图.md` 被排除 |
| 日志打印参与哈希的文件清单 | `build.yml:121-122` | ✅ 有（可审计覆盖面） |
| `check_params.py` 在 Gradle 之前 | `build.yml:73-74`（紧跟 `:69` checkout，是 job 第 1 个 step）→ Gradle 在 `:86-87` / `:199-203` | ✅ 顺序正确 |
| 注入 `assets/tempctrl-arm64` 存在 | `build.yml:185-196`，`DEST="lsp模块(apk修复+温控接口)/app/src/main/assets/tempctrl-arm64"`（= `Deployer.BIN_ASSET`，`Deployer.java:49`） | ✅ 存在，且有 `-s` 空文件兜底断言 |
| 拆 APK 断言存在 | `build.yml:216-222`，`unzip -l "$APK" \| grep -q 'assets/tempctrl-arm64' \|\| exit 1` | ✅ 存在 |
| 三段顺序 | 注入 `:185` → `assembleRelease` `:199` → 重命名 `:210` → 拆包断言 `:216` → 上传 `:224` | ✅ 顺序正确（断言在出包之后、上传之前） |

**事实性观察（不构成问题）**
- 哈希把 `magisk模块框架/profile.conf` 与 `webroot/schema.js` 也算进去，而这两者**不参与编译**（APK 内不存在 `assets/profile.conf`，实测 `app/src/main/assets/` 只有 `deploy/`、`params.json`、`xposed_init`）→ 只改配置模板/对账副本会**无谓地使二进制缓存失效并重编译**。保守方向，无正确性风险。
- `assets/tempctrl-arm64` **不在 `.gitignore`**（实测该文件当前不存在于工作树；`.gitignore` 无匹配项）→ CI 的 `cp` 会在 runner 上产生一个未跟踪文件；同理，将来一次 `git add -A` 会把二进制提交进库（与「仓库不提交二进制」相违）。属**风险提示**，非当前缺陷。
- `patch_tls.py`（`:180-181`）无条件执行，缓存命中时会**对缓存里已修补过的二进制再补一次**。是否为幂等以 `patch_tls.py` 自述为准，本次未复核其幂等性。

---

## 8. 删除 / 修改 / 保留三段清单逐条对账

**结论：有问题**

依据：`git status --short`（00:21:47 快照）+ `git diff HEAD`。

### 删除段（`待办.md:148`）— **完全一致**

计划 8 条（`META-INF/` 展开为 2 文件）→ 实际 **10 个 ` D`，无多删、无漏删**：
`module.prop`、`META-INF/com/google/android/{update-binary,updater-script}`、`customize.sh`、`uninstall.sh`、`service.sh`、`webroot/{app.js,index.html,style.css}`、`strip_webroot.py`。逐条比对一致。

### 保留段（`待办.md:150`）— **1 条被改**

| 计划保留 | 实际 | 判定 |
|---|---|---|
| `build_tempctrl.sh` | 未出现在 `git status` | ✅ 未动 |
| `patch_tls.py` | 未出现在 `git status` | ✅ 未动 |
| `MainHook.java`（status 路径与广播协议原样） | 文件被改（`M`，+24/-4 仅 `last_dev` 4 处，见 `git diff`）；status 路径/字段/广播未动 | ✅ 实质符合（`待办.md` 自身「保留不动」与「修改」两段对同一文件表述矛盾，以「修改」段为准） |
| `profile.conf`（转为分发模板） | **被改 5 行**（`LOG_FILE` 值+注释、`APP_LAUNCH_ENABLED` 1→0、`APP_WATCHDOG` 6→0） | ⚠️ **该保留却被改**。改动内容本身符合冻结决策（P0/I1 交接项），但计划未把 `profile.conf` 列入「修改」清单 |

### 修改段（`待办.md:128-136`）— **漏改 0，计划外改动 3**

计划 6 条全部落地：`AndroidManifest.xml` ✅、`app/build.gradle.kts` ✅、`tempctrl.c` ✅、`MainHook.java` ✅、`.github/workflows/build.yml` ✅、四份文档 ✅（`README.md`/`CHANGELOG.md`/`CLAUDE.md`/`magisk模块(智能温控)/逻辑说明.md` 均为 `M`）。

**计划未列但实际被改**（逐条）：
1. `lsp模块(apk修复+温控接口)/gradle.properties`（+2 行，`android.overridePathCheck=true`）——`待办.md` 的修改清单与「保留不动」清单**都未提及**；为 AGP 8.2.0 拒绝非 ASCII 路径的必要开关。
2. `待办.md` 自身（`M`，+323 行）。
3. `app/build.gradle.kts` 的 `versionCode 4→5` / `versionName "2.6"→"3.0"`——计划未授权版本号变更，且与 `CLAUDE.md:47`「版本号不自动更新」冲突（详见第 10 项）。

**计划提到但未做的**：`待办.md:130` 要求 Manifest「加权限（`POST_NOTIFICATIONS` 等）」，实际 `AndroidManifest.xml` **一个权限都没加**（`git diff` 中新增的是注释，明写「本批次不新增任何权限…后续批次按需再加」）。属**有理由的偏差**，但确与计划原文不符。

**未跟踪新文件对账**：`assets/deploy/`、`assets/params.json`、`ConfigStore.java`、`Deployer.java`、`RootShell.java`、`SetupActivity.java`、`ui/`、`res/*` 全部是计划内产物 ✅。**计划外**：`参考资料/c_historical_sources/tempctrl2.7.c`（验收期间新出现，不在任何清单内）。

---

## 9. 失效引用（指向已删文件）

**结论：有问题**

### 必须改（会误导读者或已进入产物）

| 文件:行 | 指向 | 理由 |
|---|---|---|
| `magisk模块(智能温控)/tempctrl.c:5` | `由 service.sh 启动并守护` | 代码头顶注释；`service.sh` 已删，现由 `service.d` 脚本拉起 → 事实错误 |
| `参数定义/params.def.json:29` | `（app.js）` in `chart.sourceNote` | **进入产物**：实测出现在 `app/src/main/assets/params.json:1502`（另见 `:1575`、`:1614` 的 `rangeNote`「范围来自界面实现（app.js）」）→ 界面/用户可见的文案引用了已删文件 |
| `参数定义/params.def.json:959` | `（app.js）` | 同上，→ `params.json:1502` |
| `参数定义/params.def.json:1014` | `（app.js）` | 同上，→ `params.json:1575` |
| `参数定义/params.def.json:1035` | `（app.js）` | 同上，→ `params.json:1614` |

### 建议改（行号已不可验证；`app.js` 已删，注释里的 `app.js:NNNN` 无处可查）

原生界面里**成规模**存在，共 21 处（`grep -rn 'app.js' ui/`）：
- `ui/ChartAxis.java:7`（`app.js:821-889`）、`:53`（`app.js:1070`）
- `ui/ChartConfig.java:86`（`783-792`）、`:91`（`775`）、`:94`（`816-819`）、`:96`（`796-800`）、`:101`（`751-772`）、`:113`（同口径）
- `ui/ChartDataset.java:6`（`614-632`）、`:14`（`960-963`）
- `ui/ChartSample.java:9`（`620-621`）、`:33`（`963`）、`:35`（`960`）
- `ui/ChartSeries.java:10`（`163-172`）、`:15`（`1020-1027`）、`:17`（`1034-1037`）
- `ui/ChartView.java:258`（`1049-1052`）、`:352`（`1118`）
- `ui/ChartWindow.java:7`（`1012,1121`）
- `ui/LogClassifier.java:31`（`webroot/app.js:1230`）
- `ui/LogTailReader.java:23`（`webroot/app.js:1237`）、`:35`（`app.js:1237`）
- `magisk模块(智能温控)/magisk模块框架/webroot/schema.js:11`（`app.js`）、`:14`（`app.js 实际使用为准`）、`:21`（`app.js 未引用`）、`:22`（`app.js 未引用`）
- `参数定义/对齐报告.md:138/144/196/200`、`参数定义/对齐报告.md:67/70/80`（引 `customize.sh`）

> 这些是**出处锚点**（说明「此口径照旧实现而来」）。文件已删 → 锚点失效、行号不可复核。是否保留为历史注记由用户裁定；**但 `params.json` 里那 5 处会随 APK 出厂，优先级最高**。

### 可保留为历史注记（已显式标注或有语境可辨）

| 文件:行 | 内容 | 判定 |
|---|---|---|
| `magisk模块(智能温控)/逻辑说明.md:661` | 「**已随路线 A 删除**：`module.prop`、`META-INF/`、`customize.sh`、`uninstall.sh`、`service.sh`、`webroot/{index.html,app.js,style.css}`、`strip_webroot.py`」 | ✅ 显式历史注记，正是要求保留的形态 |
| `lsp模块(apk修复+温控接口)/app/src/main/assets/deploy/b6x-tempctrl.sh:40` | 「旧 `service.sh` 就踩过这个坑」 | ✅ 有「旧」字限定，语境可辨 |
| `diagnose_status.sh:21` | `for f in /data/adb/modules/*/module.prop` | ⚠️ 半失效：合并后不再有 Magisk 模块 → 该循环恒落空；脚本本身（诊断 status 文件）仍有价值。`待办.md:190`（L2 行）已登记该问题 |
| `参数定义/对齐报告.md` 全篇 | 引 `app.js` / `customize.sh` | ✅ 审计历史记录，属性上就该保持原样 |
| `magisk模块(智能温控)/magisk模块框架/profile.conf` 段标题 | 「`[4] WebUI 界面（仅 WebUI 读取，守护进程忽略）`」 | ⚠️ 命名陈旧（该组现由原生界面消费，非 WebUI）。同源问题：目录名 `webroot/` 已名不副实（P2 已登记） |
| `CHANGELOG.md` / `TECH_DEBT.md` / `README.md` | 未见对已删文件的失效引用 | ✅ |

**与 P2 自述的对照**：P2 称「三份 md 自查：**无指向已删文件的失效引用**」——在**其声明的三份 md（README/CLAUDE/逻辑说明）范围内成立**（本次复核确认）。但 P2 未覆盖 `tempctrl.c:5`、`params.def.json`（→ 产物 `params.json`）、`ui/*.java` 三类，这些**确实存在失效引用**，P2 的 `未决` 已部分列出（`tempctrl.c:5`、`ui/*.java` 的 `app.js:NNNN`、`参数定义/*` 引 app.js），本次核实为真且**遗漏了「已进入 `params.json` 产物」这一更严重的性质**。

---

## 10. 版本号唯一来源

**结论：有问题**

### 当前状态（00:21:47 快照）

`module.prop` 已删 ✅，因此**真正写入版本号的地方**：

| # | 位置 | 值 | 性质 |
|---|---|---|---|
| 1 | `lsp模块(apk修复+温控接口)/app/build.gradle.kts:13-14` | `versionCode = 5` / `versionName = "3.0"` | **唯一权威来源** |
| 2 | `CHANGELOG.md:14` | `## v3.0（2026-09-20）` | 手写 |
| 3 | `README.md:13` | `✅ v3.0`（组件表） | **手抄** |

**CI 两处解析（正确做法，非写入）**：`build.yml:208`（`grep versionName` → `apk-version` 输出）、`build.yml:213/227`（产物名 `b6x-EP-LSPosed-v${{ … }}.apk`）。

三处手写值**当前互相一致**（3.0 / v3.0 / v3.0）✅，CI 解析出的产物名亦为 `v3.0`。

### 问题

① **版本号在验收期间被改，且与规则冲突**：`app/build.gradle.kts` 由 `versionCode 4 / versionName "2.6"` 变为 `5 / "3.0"`（我在 00:14 读到旧值、00:21 读到新值，属并发写入）。`CLAUDE.md:47` 明写「**版本号不自动更新**：`build.gradle.kts` versionName、`CHANGELOG.md` 等版本号一律保持现状，不因审查/清理/重构主动修改；需要改版本号由用户明确要求」，`待办.md` 的修改清单也未列版本号变更。**是否有用户明确指令，本 agent 无法核实** → 若无，这是一次规则冲突；若有，请补记为显式授权项。

② **各线进展文档的版本自述已全部过时**：`路线A-线B进展.md`（「versionCode 4 / versionName 2.6 未变」）、`路线A-线C进展.md`（同）、`路线A-线D进展.md`（同）三处均已成**失真陈述**。

③ **`待办.md:295`（R13 行）仍写「真正写入 3 处（`module.prop`、`build.gradle.kts`、`CHANGELOG.md`）」** — `module.prop` 已删，实际写入处为 `build.gradle.kts` + `CHANGELOG.md` + `README.md:13`（手抄）。该行尚未更新。

④ `README.md:13` 的手抄 `✅ v3.0` 仍是**手抄**（R13 的建议是「改为『版本见 …』或由 CI 生成」），本次未采纳；且它现在**恰好正确**，属**靠人工同步维持一致**的状态。

### 关于「是否只剩 `build.gradle.kts`」的直接回答

**不是**。除 `build.gradle.kts` 外还有 2 处手写（`CHANGELOG.md:14`、`README.md:13`）+ CI 2 处解析。`README.md`/`CLAUDE.md` 里**仍有手抄的版本号**（`README.md:13`；`CLAUDE.md` 无手抄值，只有「版本号不自动更新」的规则条目，`:47`）。

---

## 汇总

| 项 | 结论 |
|---|---|
| 1 路径一致性四方闭环 | **通过**（3 条体系外路径已逐个列出，其中 `/cache/` 兜底为有意设计、`/data/local/tmp/tempctrl.lock` 为未标注的遗留清理） |
| 2 status 双文件不动 | **通过**（路径逐字一致、C 端 diff 无 status 相关增删、8 个字段名逐条对上） |
| 3 广播协议两端一致 | **通过**（action 2 个、extra 7 个、auto_launch 1 个全部一致；`--ei` 具名，无顺序错位风险） |
| 4 参数定义与 C 端 | **通过**（EXIT=0、漂移 0；20 个无 clamp 槽位中 9 个有裁定文字、11 个 switch 缺 `rangeNote`；7 个 null-cVar 槽位均有护栏说明） |
| 5 界面调用边界（I5） | **通过**（shell/Runtime.exec/直读 conf/主线程阻塞 四项均 0 处） |
| 6 卸载残留 vs 实际产物 | **有问题**（① service.d 看门狗脚本不被杀，卸载后重建 `tempctrl_service.log`；② `/cache/*.log` 兜底未清；③ `.status.tmp` 未清；④ `rm /data/local/tmp/tempctrl.lock` 无遗留注释） |
| 7 CI 产物形态 | **通过（静态）** — CI 未真跑，未声称已验证 |
| 8 三段清单对账 | **有问题**（删除段 10/10 一致；保留段 `profile.conf` 被改；计划外改了 `gradle.properties`/`待办.md`/版本号；`POST_NOTIFICATIONS` 未加） |
| 9 失效引用 | **有问题**（必须改 5 处：`tempctrl.c:5` + `params.def.json` 4 处且已进 `params.json` 产物；建议改 21 处 `ui/*.java` 的 `app.js:NNNN` + `schema.js` 4 处） |
| 10 版本号唯一来源 | **有问题**（`module.prop` 已删✅，但仍有 3 处手写；版本被改为 3.0/5，与 `CLAUDE.md:47` 规则冲突且各线自述过时；`待办.md:295` 未更新） |

## 与各线自述的冲突点

1. **线 B/C/D 的版本自述**：「versionCode 4 / versionName 2.6 未变」→ 实测现为 **5 / "3.0"**（`app/build.gradle.kts:13-14`）。
2. **线 C 未决 2**：「`params.json` 的 `LOG_FILE` factory 仍是 `/cache/tempctrl.log`」→ 实测 default 与 factory **均为** `/data/data/com.example.waspwingtempctrl/files/tempctrl.log`，该未决已不成立（线 C 的记录过时）。
3. **线 A 的给 P2 提醒**（`profile.conf` 三值待改）→ 已完成 ✅，与线 A 自述一致。
4. **P2「无指向已删文件的失效引用」**→ 在其声明的三份 md 范围内成立；但 `params.json`（产物，含 5 处 `app.js`）、`ui/*.java`（21 处）、`tempctrl.c:5`、`schema.js`（4 处）确有失效引用，P2 的未决列表未点明「已进入产物」这一性质。
5. **P2「删除后无多余增删」**→ 删除段成立；但**新增**了计划外的 `gradle.properties` 改动与 `参考资料/c_historical_sources/tempctrl2.7.c`。
6. **线 C 未决 1（路径护栏）**：自述「已解决、两端字面量一致」→ 本次独立核实为真 ✅。

## 上下文用量

本轮 P3 单 agent 执行，未派 subagent；自查约 130k/1000k tokens。
