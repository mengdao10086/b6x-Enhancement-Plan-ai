# 路线 A — 线 D：原生界面（进展）

> 在 `.claude/`，不进版本库。**未 git add**。

## 产物（base = `lsp模块(apk修复+温控接口)/app/src/main/`）
**主 agent（外壳 + 设计标尺 + 共享读取层）**
- `res/values/{colors,dimens,bools,themes,strings}.xml` + `res/values-night/{colors,bools}.xml` —— 品牌色 / 语义状态色 / **6 条曲线系列色** / 4 级日志色 / 间距 / 圆角 / 字号；明暗同名覆盖，主题只需一份
- `res/drawable/bg_badge_muted.xml`；`res/layout/{activity_setup,fragment_status}.xml`
- 改 `SetupActivity.java` → 薄外壳（`setTheme` → `super.onCreate` → TabLayout 四页签 `add/hide/show`）；线 C 的部署接线原样搬入 `ui/StatusFragment.java`（**I5 边界未动**）
- 新增 `ui/AppFiles.java` —— 直读层：`Os.stat` 拿真实 errno / `readTail` 丢半截行 / `diagnose` 多行诊断串
**D1 配置表单**：`ui/{ConfigFormFragment,ConfigWriteQueue,ConfigKeyRow,ConfigGroupBinder,ConfigDiagnostics}.java`、`res/layout/{fragment_config,item_config_group,item_config_row,item_config_field}.xml`、`res/values/{strings_config,dimens_config}.xml`
**D3 日志页**：`ui/{LogFragment,LogLine,LogClassifier,LogTailReader,LogListAdapter}.java`、`res/layout/{fragment_log,item_log_line}.xml`、`res/values/strings_log.xml`
**D2 曲线页**：`ui/{ChartFragment（替换占位）,ChartView,ChartAxis,ChartSeries,ChartSample,ChartDataset,ChartWindow,ChartConfig,ChartLoader}.java`、`res/layout/{fragment_chart,item_chart_legend,item_chart_window_button}.xml`、`res/values/{strings_chart,dimens_chart}.xml`
**口径清单**：`.claude/路线A-线D-曲线口径.md`（15 节，逐条带 `app.js`/`tempctrl.c`/`逻辑说明.md` 行号依据）

## 用户已拍板（本轮）
x 轴照现有实现（样本序号等距 + 断联按封顶 dt 补偿；`待办.md` 那句"按真实时长等比"作废）· `chart.windowDefaultSec`=360 · `chart.rollingMaxLines`=720 · 网格线宽=1 · 护栏键 **拒绝落盘 + 行内说明**。

## 集成期由主 agent 做的两处纠正
1. D1 原有调 `ConfigStore.writeFactoryIfAbsent()` 的界面按钮，与 `ConfigStore.java:418`「由 Deployer 调用，界面不要自己调」冲突 → **已删**（连带清孤儿资源与陈旧 `/cache` 断言）。
2. D2 自行给断联处加了 `chart_disconnect` 浅色带（**原实现是纯空白，不在已确认口径内**）→ **已删**该段绘制与 `ChartView` 内的 `bandX0/bandX1/bandPaint/colorDisconnect`，并把 `chart_disconnect` 从 `values/`+`values-night/colors.xml` 移除（无残留、无孤儿）。**要"离线带"的话是 ~6 行的事，需用户点头才加回。**

## 核对结论
- **D1 护栏键已符合本轮裁定**：`ConfigKeyRow.java:391-392` = `daemonAccepts()` 拒绝 → 不落盘 → 行内 `state_error` 说明 + 提示，字段保留用户输入。**无需改动。**
- **D2 两条硬要求已落地**：`onDraw`（`ChartView.java:521+`）内零 File IO、零 `Path` 重建（`new Path` 只在 `buildPaths:354/364`，由 `rebuild()` 触发，且只在数据/窗口/开关/尺寸/主题变化时）；读+解析+滤波全在后台线程；失败态三条路径（`usable=false` / `readTail` 抛 `IOException` / 解析 0 行）都先给具体原因再拼 `AppFiles.diagnose()` 全文（含 errno），不静默。
- 只读清单零改动（按 mtime 核实：线 D 自身写入全部 ≥21:35；`ConfigStore.java` 于 23:51 的变更**是协调方本人所为**，非线 D）。

## 编译验证
- 工具链 `%TEMP%\wwbuild\{sdk,jdk-17.0.2}`。**必须用 `./gradlew`**（git bash 下 `gradlew.bat` 与 `cmd //c` 均报"找不到命令"，MSYS 路径改写）。
- **最终态 `clean assembleDebug assembleRelease`（含 `lintVitalRelease`）BUILD SUCCESSFUL**（73 tasks）。
- 合并后 Manifest：仅 `SetupActivity` 一个组件、权限仅 androidx 自签名项，**线 D 未新增任何用户可见权限**。
- 已知基线问题（非线 D 引入）：`lintDebug` 4 个 error 全在冻结的 `MainHook.java`；`lintVitalRelease` 不拦。

## 未决
1. 断联「离线带」是否加回（现为纯空白，与原实现一致）。
2. 曲线页配置改为「页面重新可见时重读一次」（非每帧）→ 跨页改键最多延迟一次切页生效。
3. 空态文案改居中（原实现是左对齐 −24px 的近似居中，纯观感）。
4. **真机验证**：SELinux 直读 root 创建的 0644 文件能否放行（失败已可诊断）、`service.d` 拉起与幂等。C 端 `PRIVATE_DIR` 与 applicationId **已一致**。
5. `ConfigStore.FieldMeta` 缺字段级 `unitNote`（协调方已转 P0）。

## P3 验收整改：溯源断链（纯注释，已重编）
`app.js` 随路线 A 删除，但 `ui/` 下 **22 处注释（9 个文件）**仍以 `app.js:NNNN` 为口径出处 → 全部改锚到 `magisk模块(智能温控)/逻辑说明.md`：
- 能对上具体小节的逐处指到小节：`ChartAxis`(2)、`ChartConfig`(6，其中 2 处指「可配置参数一览」的 `WEBUI_LABEL_MERGE_PX`)、`ChartDataset`(2)、`ChartSample`(3)、`ChartSeries`(3)、`ChartView`(2)、`ChartWindow`(1) → 分别指到「曲线」一节的〈双纵轴〉/〈断联空白〉/〈滤波关闭语义〉/〈热端与电池曲线滤波〉/〈分段处理〉/〈系列开关〉，以及「状态页数据源（C 每 1s 写数据文件）」一节
- 对不上具体位置的用兜底句式「口径见 `逻辑说明.md` 的『曲线』一节」，未编造行号：`LogClassifier`(1)、`LogTailReader`(2) → 「日志页」一节
- **未删任何出处信息**；`tempctrl.c` 的引用是**活文件**，原样保留未动
- 复核：`grep -rn "app\.js\|webroot" ui/` → 无匹配（退出码 1）

**顺带发现并修掉 1 处用户可见文本引内部文件名**：`res/values/strings_config.xml:10` 的 `config_error_body` 原文写「应用内置的 **params.json**（界面表单的唯一数据源）没有加载成功」→ 改为「应用内置的**参数定义**没有加载成功」。`res/**` 其余用户可见文本经 grep 无同类问题（日志/曲线页展示的是**数据文件绝对路径**，属诊断必需，非内部源码文件名）。

重编：`clean assembleDebug` BUILD SUCCESSFUL。

## 上下文用量
主 agent 约 215k/1000k；子 agent：口径+D2 252k / D3 89k / D1 182k。
