# University-hospital-management-system
河南交通职业学院校医院管理系统的开发-系统系统

## 姬华凯主要任务

### 	1.用户管理（注册、登录）。

#### 		1.1.短信注册：https://www.cnblogs.com/seeto/p/9765047.html	

```xml
<dependency>
    <groupId>com.zhenzi</groupId>
    <artifactId>sms</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 	2.患者信息管理：包括基本的增、删、改、查等功能。

#### 		2.1.患者信息管理:(CRUD)springboot+mybatis

### 	3.简易电子病历管理：结构化存储，支持病历模板库。可对用户输入的内容进行检查，

​		包括：病历内容的规范性、逻辑性、 数据格式的有效性等。校外医务人员通过计
​		算机网络可以远程存取病人病历。对修改功能权限要严格限制。
​		3.1.输入内容检验使用：前端js正则表达式；权限管理使用：Spring Security

### 	4.医院网站、微信公众号管理。

#### 		4.1.

#### 		4.2.spring mvc 接入微信公众平台 注解方式的写法:https://www.iteye.com/blog/ileson-2070986

​			https://blog.csdn.net/weixin_43122106/article/details/84564557

```xml
<dependency>
    <groupId>com.github.binarywang</groupId>
    <artifactId>weixin-java-common</artifactId>
    <version>2.9.0</version>
</dependency>
<dependency>
    <groupId>com.github.binarywang</groupId>
    <artifactId>weixin-java-mp</artifactId>
    <version>2.9.0</version>
</deendency>
```

### 	5.转院管理：由于医院科室不完整，部分学生患者需要安装学校规定转院就医，主要记录备案信息。

#### 		5.1.springboot+mybatis

### 	6.预约挂号。

#### 		6.1.springboot+mybatis

#### 	7.简易财务报表生成：查询、统计所有单据简单快捷，所有的单据可通过电脑打印

#### 		7.1.EsayPOI https://www.jianshu.com/p/a35adc63956d

​			  

```xml
  <!--引入EasyPOI-->
				<dependency>
					<groupId>cn.afterturn</groupId>
					<artifactId>easypoi-base</artifactId>
					<version>3.0.3</version>
				</dependency>
				<dependency>
					<groupId>cn.afterturn</groupId>
					<artifactId>easypoi-web</artifactId>
					<version>3.0.3</version>
				</dependency>
				<dependency>
					<groupId>cn.afterturn</groupId>
					<artifactId>easypoi-annotation</artifactId>
					<version>3.0.3</version>
				</dependency>
```

#### 		7.2.将查询到的数据生成excel表格https://www.cnblogs.com/lin02/p/11648899.htm

```xml
		<!--        poi实现excel导入导出-->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>3.15</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml-schemas</artifactId>
			<version>3.15</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>3.15</version>
		</dependency>
```
所用技术
	springboot+mybatis+bootstrap