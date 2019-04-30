# EasyExam易考在线考试系统

* * *

## 1 概述

关键词：免费 开源 在线 网络考试系统 考试系统 培训系统

### 1.1 简介

EasyExam是一款开源免费的在线考试系统，为了减小学员考试交卷时大量并发带来的系统风险，采用了成熟的消息队列框架RabbitMQ来解决这一问题。

###1.2 部署要点

1.  `Management.war`和`Portal.war`需要部署在`同一个目录`下。

2.  要保证RabbitMQ服务状态为`运行状态`。

3.  要保证ScoreMarker状态为`运行状态`，同时ScoreMarker调用服务地址要配置正确。

## 2 应用服务器安装配置

### 2.1 服务器安装部署

#### 2.1.1 服务器配置

*   操作系统：Linux、Windows

*   内存：最低2G，推荐8G

#### 2.1.2 java运行环境

*   Java 8

#### 2.1.3 服务器

*   Tomcat 8

*   RabbitMQ

*   MySql 5.0以上

### 2.2 应用部署

#### 2.2.1 数据库

1.  在MySql中新建一个数据库`db_easyexam`，字符集使用`utf8 -- UTF-8 Unicode`

2.  使用我们提供的`db_easyexam.sql`还原`db_easyexam`

3.  设置好对应的访问权限

#### 2.2.2 RabbitMQ

1.  安装最新版本的RabbitMQ，具体安装方法，在网络上可以找到很多。

2.  配置

#### 2.2.3 应用

1.  将`Management.war`和`Portal.war`放到Tomcat应用程序目录（`webapps`）下。

2.  启动Tomcat，webapps目录下会生成两个文件夹（`Management`和`Portal`）。

3.  分别进入到`Management/WEB-INF/Spring`和`Portal/WEB-INF/Spring`下修改`root-context.xml`文件,将数据库地址、用户名和密码修改成正确的内容。修改完成后重启tomcat服务器。

 *需要修改的内容如下:*

	  <property name="jdbcUrl" value="jdbc:mysql:/*.*.*.*:3306/db_easyexam?useUnicode=true&amp;characterEncoding=UTF-8" />
      <property name="user" value="root" />
      <property name="password" value="***" />

4.  访问`http://localhost:8080/Management`和`http://localhost:8080/Portal`可以进入到管理后台页面和学员页面，并可以正常登陆，则应用配置成功。

 **注意**：*在完成这一步后学员考试交卷无法完成,需要部署`ScoreMarker`。*

5.  部署ScoreMarker

  Linux下 解压scoreMarker到/opt/目录。 确认config/scoremarker.properties文件配置正确。 拷贝scoremarker 执行脚本到init.d目录下并检查脚本中的配置。

  Windows下 解压scoreMarker到任意目录。 确认config/scoremarker.properties文件配置正确。 修改installService.bat中APP_HOME为scoreMarker目录。 运行installService.bat后启动服务ScoreMarkerService服务。

## 3 架构和功能说明

**系统架构**

1.  管理后台独立成一个新项目。

2.  引入RabbitMq，用于接受用户提交的答题卡，通过ScoreMarker从消息队列获取答题卡并交卷，减小大量用户提交导致的服务器故障几率。

3.  试题内容存储格式由xml改为json

4.  增加教师角色，教师用户可以正确地使用自己的权限管理学员、试题、试卷、考试以及培训。

5.  优化系统界面，新的界面看起来更加清爽、专业。

6.  增加了DashBoard，管理界面看起来会更专业。

7.  练习历史专门用一张表记录，使开发相关统计变得更容易。

**考试和练习**

1.  考试分为正式考试和模拟考试两种，正式考试需要教师或管理员审核，而模拟考试不需要审核。正式考试又分为公有和私有两种类型，公有考试是可以申请的考试，私有考试则需要教师或管理员指定学员（这里由管理员指定也被我们认为是审核的一种方式）。

2.  审核功能，教师创建的试卷、考试都需要超级管理员审核。超级管理员自己创建的不需要审核。同时，超级管理员和教师也可以审核学员的考试申请。

3.  人工阅卷功能。包含主观题的考试试卷，教师或超级管理员通过人工阅卷后可以确定最终分数。全部是客观题的试卷不需要阅卷。

4.  考试成绩统计功能，可以查看特定考试下学员的分数，同时可以对分数进行排序。

5.  学习记录查询功能，教师和管理员可以方便地查看学员的练习记录、培训记录和考试记录。

6.  快速考试模式，通过输入准考证号即可直接进入到对应的考试页面。

7.  继续考试功能，学员在考试过程中中断考试后，继续进入考试后，学员的答题记录会恢复到中断前的状态。

**题库管理**

1.  优化试题修改功能，可以正确地修改试题的基本信息。

**其他**

1.  培训功能，教师或超级管理员可以发布培训资料（视频和pdf文档）。学员可以选择自己需要参加的培训进行学习，培训分为视频和pdf格式的文档两种。

2.  虚拟班级功能，教师或管理员可以通过虚拟班组很方便地管理学员。

## 4 系统问题处理

1.  **不能获得数据库连接**
   > Cause:org.springframework.jdbc.CannotGetJdbcConnectionException:Could not get JDBC Connection;nested exception is java.sql.SQLException:Access denied for user 'root'@'localhost'

  请检查数据库连接字符串是否正确，同时检查数据库名、用户名和密码是否设置正确。

2.  **交卷失败**

  > `RabbitMQ`没有启动会导致应用程序连接`RabbitMQ`失败

  请检查`RabbitMQ`服务是否启动。

3.  **学员交卷后，管理界面学员对应的状态没有改变**

  > 交卷成功后，学员考试状态会修改成`已交卷`或者`已阅卷`，如果在提示“交卷成功”后没有发生任何变化，证明ScoreMarker没有正常启动或者ScoreMarker调用接口失败。

  请检查ScoreMarker是否启动。同时请保证ScoreMarker能调用到Management提供的接口，这一点在ScoreMarker部署中已经说明。

4.  **RabbitMQ、MySql、ScoreMarker无法启动或经常被Kill掉**

  > 我们在测试过程中发现，内存不足的情况下（我们使用的是1G内存），RabbitMQ、MySql、ScoreMarker经常被Kill，而且无法启动，查看日志会发现提示内存不够。

  查看下日志，如果是内存不够的原因，那就赶紧加内存吧。为了保证系统正常运行，内存不能低于2G。