import java.io.File

//  KotlinScript
//  脚本形式，需要安装 Kotlin 命令号编译器

println("HelloWorld")

//  当前目录下的所有文件
File(".").list().forEach(::println)