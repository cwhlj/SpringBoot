# SpringBoot
## Spring Boot+Mybatis+MySql

### 使用idea上传项目到gitHub
####打开终端进行项目根目录下键入以下 命令：
####git remote add origin git@github.com:cwhlj/SpringBoot.git(这里我写的自己的github地址,这里可以改成你自己的github项目)
#### git push -u origin master //将本地仓库的东西提交到地址是origin的地址，master分支下
#### 然后会报错误
#### 这是因为：
#### 远程分支上存在本地分支中不存在的提交，往往是多人协作开发过程中遇到的问题，可以先fetch再merge，也就是pull，把远程分支上的提交合并到本地分支之后再push。
#### 如果你确定远程分支上那些提交都不需要了，那么直接git push origin master -f，强行让本地分支覆盖远程分支.
### [具体参考](https://www.cnblogs.com/codegeekgao/p/9572013.html)