# 面对对象

## 1. java类及类的成员：属性、方法、构造器、代码块、内部类

###  类 class 和 对象 Object

- 类： 对一类事物的描述，是抽象的，概念上的定义
- 对象：是实际存在的该类事物的每个个体，因而也称为实例

面对对象程序设计的重点是类的设计

设计类，就是设计类的成员

#### 属性 = 成员变量 = field

#### 方法 = 函数 = method

#### 类和对象的使用：

```java
package com.atguigu.java;

public class PersonTest {
    public static void main(String[] args) {
        //创建对象，实例化类
        Person p1 = new Person();
        //调用结构：属性、方法
        p1.name = "Tom";
        p1.isMale = true;
        System.out.println(p1.name); //Tom
        p1.eat();          //吃
        p1.sleep();        //睡
        p1.talk("Chinese");//说Chinese
    }

}
class Person {
    //属性
    String name;
    int age = 1;
    boolean isMale;
    //方法
    public void eat(){
        System.out.println("吃");
    }
    public void sleep(){
        System.out.println("睡");
    }
    public void talk(String language){
        System.out.println("说" + language);
    }
}

```

#### 类中属性的使用

属性（成员变量）vs  局部变量

1. 相同点：

   - 定义变量的格式：数据类型  变量名 = 变量值
   - 先声明，后使用
   - 变量都有其对应的组用于

2. 不同点：

   - 在类中声明的位置不同

     - 属性：直接定义在类的一对{}中
     - 局部变量：声明在方法内，方法形参，代码块，构造器形参，构造器内部的变量

   - 关于权限修饰符的不同：

     - 属性：可以在声明属性时，指明其权限，使用权限修饰符

       常用的权限修饰符：private、public、缺省、protected

     - 局部变量：不可以使用权限修饰符

   - 默认初始化值的情况

     - 属性：类的属性，根据其类型，都有默认初始化值

       ​	整型（byte、short、int、long）：0

       ​	浮点型（float、double）：0.0

       ​	字符型（char）：0 或 '\u0000'

       ​	布尔型（boobean）：false

     - 局部变量：没有初始化值

       ​	意味着，我们在调用局部变量之前，一定要显式赋值

       ​	特别地，形参在调用时，赋值。

   - 在内存中加载的位置

     - 属性：加载到堆空间中（非static）
     - 局部变量：加载到栈空间

   ```JAVA
   package com.atguigu.java;
   
   public class UserTest {
   
       public static void main(String[] args) {
           User user = new User();
           System.out.println(user.name);
           System.out.println(user.age);
           System.out.println(user.isMale);
           user.talk("中文");
       }
   }
   class User {
   
       //成员变量（属性）
       String name;
       int age;
       boolean isMale;
   
       void talk(String language) {//局部变量
           System.out.println("用"+ language + "交流");
       }
   }
   ```

#### 类中方法的使用

1. 方法的声明：权限修饰符 返回值类型 方法名(形参列表) {

​								方法体

​						}

​		注意：static、final、abstract来修饰方法

2. 说明：

   1. 权限修饰符

      java规定的四种权限修饰符：private、public、缺省、protected

   2. 返回值类型，有返回值 VS 没有返回值

      如果方法有返回值，则必须在方法声明时，指定返回值的类型。同时，方法中，需要使用return关键字来返回指定类型的变量或常量。

      如果方法没有返回值，则方法声明时，使用void来表示。通常，没有返回值的方法中，就不使用return，但是，如果使用的话，只能用“return;“表示结束此方法的意思。

   3. 方法名：属于标识符，遵循标识符的规则和规范，“见名知意”

   4. 形参列表：方法可以声明0个、1个或多个形参

      格式：数据类型1 形参1，数据类型2 形参2， ...

   5. 方法体：方法功能的体现
   
3.   return关键字的使用：

      1. 使用范围：使用在方法体重
      2. 作用：
         1. 结束方法
         2. 针对有返回值类型的方法，使用“return 数据”方法返回所要的数据
      3. 注意点：return关键字后面不可以声明执行语句

4. 方法的使用中,可以调用当前类中的属性或方法

   特殊的:方法A中又调用了方法A:递归

   方法中,不可以定义方法

#### 方法的重载：

两同一不同：

- 同一个类，相同方法名
- 参数列表不同：参数个数不同，参数类型不同

#### 封装

- 封装性的体现：

  我们将类的属性xxx私有化（private），同时，提供共有的（public）方法来获取（getXxx）和设置（setSxx）

- 封装性的体现，需要权限修饰符来配合

  1. java的4中权限（从小到大）：private、缺省、protected、public

  2. 4中权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类

  3. 具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类

     ​				修饰类的话，只能使用：缺省、public

总结：java提供了4中权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小 

## 2. 面对对象的三大特征：封装、继承、多态

## 3. 其他关键字：this、super、static、final、abstract、interface、package、import

