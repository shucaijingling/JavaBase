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

      java规定的四种权限修饰符：private、缺省、protected、public

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

#### 方法的重写：

- 定义：在子类中可以根据需要对从父类中继承来的方法进行改造，也称为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。

- 要求：

  1. 子类重写的方法必须和父类被重写的方法具有相同的方法名称、参数列表

  2. 子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型

  3. 子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限

      子类不能重写父类中声明为private权限的方法

  4. 子类方法抛出的异常不能大于父类被重写方法的异常

- 注意：

  子类与父类中同名同参数的方法必须同时声明为非static的（即为重写），或者同时声明为static的（不是重写）。 因为static方法是属于类的，子类无法覆盖父类的方法。

  ```java
  @Override
      public void eat() {
          super.eat(); //实现父类方法
          System.out.println("重写方法：v2" ); //子类特有方法
      }
  ```

  

#### this关键字

1. this:表示当前对象
2. this()：表示当前对象的构造器
3. 可以调用的结构：
   1. this:属性、方法、构造器
   2. 一般情况下可以省略
   3. 方法的形参和类的属性同名时，不省略，见名知意，
```java
public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }
```

#### java的4个权限修饰符：

1.	private：      同一类下
1.	缺省：           同一包下 
1.	protected： 不同包
1.	public：        同一项目下

补充：同一包下，不能命名同名的接口、类。

​			不同的包下，可以命名同名的接口、类。

#### 构造器

1. 构造器的作用
   1. 创建对象
   1. 初始化对象信息

2. 使用说明：
   1. 如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
   2. 定义构造器的格式：权限修饰符 类名(形参列表) { }
   3. 一个类中定义的多个构造器，彼此构成重载
   4. 一旦我们显式的定义了类的构造器之后，系统就不在提供默认的空参构造器
   5. 一个类中，至少会有一个构造器（不写，就是空参构造）
   6. 构造器的权限修饰符跟类保持一致
```java
public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }
```
#### 类的属性赋值

赋值方式和顺序

1. 默认初始化（比如int 不赋值，默认初始化0）
2. 显式初始化
3. 构造器中初始化
4. set方法

#### 封装性具体的代码体现

1. 将类的属性私有化，提供公共的get和set方法来获取或设置属性的值

   ```java
   private String name;
   
   private int age;
   
   public void setName(String name) {
           this.name = name;
       }
   
   public String getName() {
       return name;
   }
   
   public void setAge(int age) {
       this.age = age;
   }
   
   public int getAge() {
       return age;
   }
   ```

2. 不对外暴露的私有的方法

3. 单例模式（将构造器私有化）

4. 如果不希望类在包外被调用，可以将类设置为缺省的

## 2. 面对对象的三大特征：封装、继承、多态

### 封装

- 封装性的体现：

  我们将类的属性xxx私有化（private），同时，提供共有的（public）方法来获取（getXxx）和设置（setSxx）

- 封装性的体现，需要权限修饰符来配合

  1. java的4中权限（从小到大）：private、缺省、protected、public

  2. 4中权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类

  3. 具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类

     ​				修饰类的话，只能使用：缺省、public

总结：java提供了4中权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小

### 继承（inheritance）

1. 继承的好处：

   1. 减少了代码的冗余，提高了代码的复用性
   2. 便于功能的拓展
   3. 为之后多态性使用，提供了前提

2. 继承的格式： class A extend B

   1. A:子类、派生类、subclass

   2. B:父类、超；类、基类、superclass

- 体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的属性和方法

   ​	特别的：父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构、只是因为封装性的影响，使得子类不能直接调用父类的结构而已。
   
- 子类继承父类以后，还可以声明自己的特有的属性或方法，实现功能的拓展。

​	extends:延展、扩展

3. java中关于继承性的规定：
   1. 一个类可以被多个子类继承
   2. Java中类的单继承：一个类只有能一个父类
   3. 子父类时相对的概念
   4. 子类直接继承的父类，称为:直接父类。间接继承的父类称为：间接父类
   5. 子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法
   
4. Object
   1. 如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类
   2. 所哟的java类（除java.lang.Object类之外）都直接或间接的继承于java.lang.Object类
   3. 意味着，所有的java类具有java.lang.Object类声明的功能
   
5. 重写：

   1. 子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作。

   ```java
   class Circle {
       public double findArea() {} //圆的面积
   }
   
   class Cylinder extends Circle {
       public double findArea() {} //圆柱的表面积
   }
   ```

   2. 应用： 重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法。

   3. 规则：

      方法的声明： 权限修饰符  返回值类型   方法名(参数列表)   throws  异常的类型 {

      ​											//方法体

      ​						}

      约定俗称：子类中的叫重写的方法，父类中的叫被重写的方法

      1. 子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同

      2. 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符

         特殊情况：子类不能重写父类中声明为private权限的方法
         
      3. 返回值类型：

         - 父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
         - 父类被重写的方法的返回值类型是A，则子类重写的方法的返回值类型可以是A或者A的子类
         - 父类被重写的方法的返回值类型是基本数据类型（如：double），则子类重写的方法的返回值类型必须是相同的基本数据类型（必须也是double）
         - 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型

      子类和父类中的同名同参数的方法要么都声明为非static的（考虑重写，要么都声明为static的）

   #### super

   1. super可以理解为：父类的
   2. 可以用来调用的结构：属性、方法、构造器
   3. super调用属性、方法

      1. 我们可以在子类的方法或构造器中。通过使用"super.属性"或"super.方法"的方式，显式的调用

         父类中声明的属性或方法。但是，通常情况下，我们习惯省略"super."

      2. 特殊情况：当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的属性，则必须显式的使用"super.属性"的方式，表明调用的是父类中声明的属性。

      3. 特殊情况：当子类重写了父类中的方法以后，我们想在子类的方法中调用父类中被重写的方法时，则必须显式的使用"super.方法"的方式，表明调用的是父类中被重写的

4. super调用构造器：
   1. 我们可以在子类的构造器中显式的使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
   2. "super(形参列表)"的使用，必须声明在子类构造器的首行
   3. 我们在类的构造器中，针对与"this(形参列表)" 或"super(形参列表)"只能二选一，不能同时 出现
   4. 在构造器的首行，没显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的是父类中空参的构造器：super()
   5. 在类的多个构造器中，至少一个类的构造器中使用了"super(形参列表)",调用父类中的构造器

#### 子类对象实例化全过程

1. 从结果上看：继承性

   - 子类继承父类以后，就获取了父类中声明的属性或方法。

   - 创建子类的对象，在堆空间中，就会加载所有父类中声明的属性。

2. 从过程上看：

   当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，...直到调用了java.lang.Object类中空参的构造器为止。正因为加载过所有的父类的构造，所以才可以看到内存中父类中的结构，子类对象才可以考虑进行调用。

###  多态性

1. 对象的多态性：父类的引用指向子类的对象。

```java
Person p = new Man();
```

2. 虚拟方法调用：调用方法时候，编译时看左边，运行时看右边。
3. 多态的使用前提：
   - 类的继承关系
   - 方法的重写
4. 

#### 问题

1. 一个类可以有几个直接父类：只有一个
2. 一个父类可以有多少个子类：多个
3. 子类能获取直接父类的父类中的结构吗：可以
4. 子类能否获取父类中private权限的属性或方法：可以（getset方法）
5. 方法的重写的具体规则有哪些：
   1. 方法名、形参列表相同
   2. 权限修饰符不小于父类
   3. 返回值小于等于父类
   4. 异常小于等于父类
   
6. super调用构造器，有哪些具体的注意点：
   1. this(形参列表)：本类重载的其他的构造器
   2. super（形参列表）：调用父类中指定的构造器

### 代码块 -329  

1. 代码块的作用：用来初始化类、对象

2. 代码块如果有修饰的话，只能使用static

3. 分类：静态代码块 VS 非静态代码块

   1. 静态代码块：
      1. 内部可以有输出语句
      2. 随着类的加载而执行，而且只执行一次
      3. 作用：初始化类的信息
      4. 如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
      5. 静态代码块的执行要优先于非静态代码块的执行
      6. 静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
   2. 非静态代码块：
      1. 内部可以有输出语句
      2. 随着对象的创建而执行
      3. 每创建一个对象，就执行一次非静态代码块
      4. 作用：可以在创建对象时，对对象的属性等进行初始化
      5. 如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
      6. 非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法

   ```java
   package com.atguigu.block;
   
   public class BlockTest {
   
       public static void main(String[] args) {
           String desc = Person.desc;
           Person p1 = new Person();
           Person p2 = new Person();
           Person p3 = new Person();
           
           //输出：：：：：：
          hello,static block
   	   hello,block
   	   hello,block
   	   hello,block
   
       }
   }
   
   class Person {
       String name;
       int age;
       static String desc = "我是一个人";
   
       public Person() {
       }
   
       public Person(String name, int age) {
           this.name = name;
           this.age = age;
       }
       //静态代码块
       static {
           System.out.println("hello,static block");
       }
       //代码块
       {
           System.out.println("hello,block");
       }
   
       //方法
       public void eat() {
           System.out.println("吃饭");
       }
   
       public static void info() {
           System.out.println("static method info");
       }
   
       @Override
       public String toString() {
           return "Person{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   '}';
       }
   }
   ```

   #### 对属性可以赋值的位置

   1. 默认初始化
   2. 显式初始化
   3. 构造器中初始化
   4. 有了对象以后，可以通过"对象.属性" 或 "对象.方法"的方式，进行赋值
   5. 在代码块中赋值

### 接口

1. 接口是用interface来定义

2. Java中，接口和类是并列的两个结构

3. 如何定义接口：定义接口中的成员

   1. JDK1.7及以前：只能定义全局常量和抽象方法
      - 全局常量：public static final 的, 书写时 可以省略不写
      - 抽象方法：public abstract的
   2. JDK1.8：除了定义全局常量和抽象方法之外，还可以定义静态方法，默认方法

4. 接口中不能定义构造器！！！ 意味着接口不可以实例化

5. Java开发中，接口通过让类去实现（implement）的方式来使用

   如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化

   如果实现类没有覆盖接口中所有的抽象法，则此实现类仍未一个抽象类
   
6. Java类 可以实现多个接口 ---> 弥补了Java单继承性的局限性

   格式：class AA extends BB implement CC,DD,EE

7. 接口与接口之间可以继承，而且可以多继承

8. 接口的具体使用，体现多态性

9. 接口，实际上可以看做是一种规范

#### 接口的使用

1. 接口使用上也满足多态性
2. 接口，实际上就是定义了一种规范
3. 开发中，体会面向接口编程！！！

```java
package com.atguigu.interface2;

public class InterfaceTest2 {
    public static void main(String[] args) {
        Computer c = new Computer();
        //1、创建了接口的非匿名实现类的非匿名对象
        Flash f = new Flash();
        System.out.println(1);
        c.transferData(f);

        //2、创建了接口的非匿名实现类的匿名对象
        System.out.println(2);
        c.transferData(new Printer());

        //3、创建了接口的匿名实现类的非匿名对象
        System.out.println(3);
        USB u = new USB() {
            @Override
            public void start() {
                System.out.println("usb的匿名实现类  start");
            }

            @Override
            public void stop() {
                System.out.println("usb的匿名实现类   stop");
            }
        };
        c.transferData(u);

        //4、创建了接口的匿名实现类的匿名对象
        System.out.println(4);
        c.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("usb的匿名实现类的匿名对象   start");
            }

            @Override
            public void stop() {
                System.out.println("usb的匿名实现类的匿名对象   stop");
            }
        });
    }



}

interface USB {
    void start();
    void stop();
}
class Computer {
    //传输数据
    public void transferData(USB usb) {
        usb.start();
        System.out.println("transfer data on Computer");
        usb.stop();
    }
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("flash start");
    }

    @Override
    public void stop() {
        System.out.println("flash stop");
    }
}

class Printer implements USB {
    @Override
    public void start() {
        System.out.println("printer start");
    }

    @Override
    public void stop() {
        System.out.println("printer stop");
    }
}

```

#### 代理模式

```JAVA
package com.atguigu.proxy;

import sun.nio.ch.Net;

/**
 * 代理模式
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork {
    void browse();
}
/**
 * 被代理类
 */
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("Server browse NetWork");
    }
}

/**
 * 代理类
 */
class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("check before browse");
    }
    @Override
    public void browse() {
        check();
        work.browse();
    }

}
```

####  工厂模式

```java
package com.atguigu.factory;

/**
 * 工厂模式
 */
public class FactoryTest {
    public static void main(String[] args) {
        AudiFactory audiFactory = new AudiFactory();
        Audi audi = audiFactory.getCar();
        audi.run();
        BYDFactory BYDFactory = new BYDFactory();
        BYD byd = BYDFactory.getCar();
        byd.run();
    }
}
//car接口
interface Car {
    void run();
}
//实现car
class Audi implements Car {
    @Override
    public void run() {
        System.out.println(1);
        System.out.println("Audi");
    }
}
class BYD implements Car {
    @Override
    public void run() {
        System.out.println(2);
        System.out.println("BYD");
    }
}
//工厂接口
interface CarFactory {
    Car getCar();
}
//工厂类，实现工厂
//要什么对象就创建什么工厂类去实现工厂接口生产对象
//实现开闭原则
class AudiFactory implements CarFactory {
    @Override
    public Audi getCar() {
        return new Audi();
    }
}

class BYDFactory implements CarFactory {

    @Override
    public BYD getCar() {
        return new BYD();
    }
}
```



#### 面试题：抽象类与接口有哪些异同

### 内部类：类的内部成员

1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类

2. 内部类的分类，成员内部类（静态，非静态） vs  局部内部类（方法内，代码块内，构造器内）

3. 成员内部类：

   一方面，作为外部类的成员

   1. 调用外部类的结构
   2. 可以被static修饰
   3. 可以被4种不同的权限修饰

   另一方面，作为一个类:

   1. 类内可以定义属性，方法，构造器等
   2. 可以被final修饰，表示此类不能被继承。言外之意，不是用final，就可以被继承
   3. 可以被abstract修饰

4. 关注如下的3个问题

   1. 如何实例化成员内部类的对象
   2. 如何在成员内部类中区分调用外部类的结构
   3. 开发中局部内部类的使用

## 3. 其他关键字：this、super、static、final、abstract、interface、package、import

## static关键字

1. 静态的
2. 可以用来修饰：属性、方法、代码块、内部类
3. 修饰：静态变量（或类变量）
   1. 属性按是否使用static修饰，又分为：静态属性  VS  非静态属性（实例变量）
      -  实例连梁：我们创建了类的多个对象，每个对象都是独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值的修改。
      - 静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的。
   2. static修饰属性的其他说明：
      1. 静态变量随着类的加载而加载
      2. 静态变量的加载要早于对象的创建

## final 关键字 -338

1. final可以用来修饰的结构：类、方法、变量

2. final用来修饰一个类：此类不能被其他类所继承。

   ​	比如：String类、System类、StringBuffer类

3. final用来修饰方法：不可以被重写

   比如：Object类中getClass()；
   
4. final 用来修饰变量：此时的"变量"就称为是一个常量

   1. final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化

   2. final修饰局部变量

      ​	尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。

static final  用来修饰属性：全局常量  

#### example1

```JAVA
package com.atguigu.fina11;

public class SomeThing {

    public int addOne(final int x) {
//        return x++;    //编译报错
        return x+1;   //可以实现
    }

    public static void main(String[] args) {
        SomeThing someThing = new SomeThing();
  
```

#### example2

```java
package com.atguigu.fina11;

public class Something2 {
    public static void main(String[] args) {
        Other other = new Other();
        new Something2().addOne(other);
    }
    public void addOne(final Other o){
//        o = new Other(); //编译错误
        o.i++; //o中的属性可以变化
    }
}
class Other {
    public int i;
}
```




# 单例模式

## 懒汉单例

```java
class  Bank {

    //1.构造私有化
    private Bank() {

    }
    //2.内部创建对象
    private static Bank instance = new Bank();

    //3.提供公共方法获取对象
    public static Bank getInstance() {
        return instance;
    }
}
```



## 饿汉单例

```java
class Order {
    //1.私有化构造器
    private Order() {

    }
    //2.创建对象，不进行初始化
    private static Order instance = null;

    //3.创建公共方法获取对象，为空就创建，不为空就返回当前实例
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
```



# JAVA8

## LAMBDA表达式

### Lambda表达式的使用

1. 举例：（o1,o2）-> Integer.compare(o1,o2);
2. 格式：
   1.  ->  ：Lambda操作符 或 箭头操作符
   2. 左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
   3. 右边：lambda体 （其实就是重写的抽象方法的方法体）
3. lambda表达式的使用：分为6种

```java
package com.atguigu.lambda;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest1 {
    //语法格式一： 无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("语法格式一： 无参，无返回值");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("语法格式一： 无参，无返回值");
        r2.run();
    }

    //语法格式二： 需要一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("语法格式二： 需要一个参数，但没有返回值");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("语法格式二： 需要一个参数，但没有返回值");
        //方法引用
        Consumer<String> con3 = System.out::println;
        con3.accept("语法格式二： 需要一个参数，但没有返回值");
    }

    //语法格式三： 数据类型可以省略，因为可由编译器推断得出，称为"类型维护"
    @Test
    public void test3() {
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("语法格式三： 数据类型可以省略，因为可由编译器推断得出，称为\"类型维护\"");
    }

    //语法格式四： lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("语法格式四： lambda若只需要一个参数时，参数的小括号可以省略");
    }
    //语法格式五： lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,33));

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(22,33));;
    }

    //语法格式六：当lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6() {
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(22,33));

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(55,33));
    }
}
```

总结：

- 左边：lambda形参列表的参数类型可以省略（类型推断）：如果lambda形参列表只有一个参数，其一堆（）也可以省略
- 右边：lambda体应该使用一对{}进行包裹，如果lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字

4. lambda表达式的本质：作为接口的实例
5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用@FunctionalInterface注解。这样做可以检查它是否是一个函数式接口。
6. 所以以前用匿名实现类表示的现在都可以用lambda表达式来写。

## java内置的4大核心函数式接口

1. 消费型接口 Consumer<T>	void accept(T t)
2. 供给型接口 Supplier<T>        T get()
3. 函数型接口 Funcrion<T,R>    R  apply(T t)
4. 断定性接口 Predicate<T>      boolean  test(T t)

![image-20220918233512133](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220918233512133.png)

其他接口

![image-20220919000545416](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220919000545416.png)

## 方法引用

方法引用的使用：

1. 使用情境：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
2. 方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例。
3. 使用格式：  类（或对象）::  方法名
4. 具体分为如下的三种情况：
   1.   		对象：：非静态方法
   2. ​              类：：静态方法
   3. ​              类：：非静态方法
5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同



