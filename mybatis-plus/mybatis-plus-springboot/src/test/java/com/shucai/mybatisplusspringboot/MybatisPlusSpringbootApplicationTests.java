package com.shucai.mybatisplusspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shucai.mapper.UserMapper;
import com.shucai.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusSpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void select() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    void insert() {
        User user = new User();
        user.setName("蔬菜精灵");
        user.setAge(19);
        user.setMail("shucai@qq.com");

        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
        //1672158638795415558
        //1672158638795415559
    }

    @Test
    void testInsert2() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            String name = getName();
            String[] split = name.split("-");
            user.setName(split[1]);
            user.setAge(i + 20);
            user.setMail("xxx@test" + i + ".com");
            userMapper.insert(user);
        }
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(9L);
        user.setName("想");

        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    @Test
    void testUpdate2() {

        User user = new User();
        user.setAge(222);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "想");
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    void testUpdate3() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "想").set("age", 22);

        int update = userMapper.update(null, wrapper);
        System.out.println(update);
    }

    @Test
    void testDelete1() {
        int i = userMapper.deleteById(20L);
        System.out.println(i);
    }

    @Test
    void testDelete2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "伤");
        map.put("age", 21);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    void testDelete3() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", "想");

        int delete = userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }

    @Test
    void testDelete4() {
        userMapper.deleteBatchIds(Collections.singletonList(18));
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(15);
        System.out.println(user);
    }

    @Test
    void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(12, 13, 14));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "安昌成");
//        wrapper.gt("age", "20");

        //只能查出一条，返回两条以上就会报错
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void testSelectCount() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age", "20");

        Integer integer = userMapper.selectCount(userQueryWrapper);
        System.out.println(integer);
    }

    @Test
    void testSelectList() {
        QueryWrapper<User> w = new QueryWrapper<>();
        w.gt("age", "20");

        List<User> users = userMapper.selectList(w);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("name", "严固之");
        wrapper.gt("age", 20);

        Page<User> page = new Page<>(1, 2);

        IPage<User> p = userMapper.selectPage(page, wrapper);
        System.out.println(p.getRecords());
        System.out.println("当前页："  + p.getCurrent());
        System.out.println(p.getSize());
        System.out.println("总条数：" + p.getTotal());
        System.out.println("总页数：" +p.getPages());

    }

    @Test
    void testSelect(){
        User user = userMapper.selectById(16L);
        System.out.println(user);
    }

    @Test
    void testAllEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "章伊亚");
        map.put("age", 25);

        wrapper.allEq(map);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 条件查询
     */
    @Test
    public void testWrapper() {
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", "陈勇毅")
                .ge("age", 20)
                .in("email", "xxx@test2.com", "xxx@test3.com");

        User user = userMapper.selectOne(wrapper1);
        System.out.println(user);
    }


    /**
     * 模糊查询
     */
    @Test
    public void testLikeWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "天");

        List<User> users = userMapper.selectList(wrapper);

        //查询为空，mp底层处理结果集时也会创建一个list集合
        for (User user12 : users) {
            System.out.println(user12);
        }

    }

    /**
     * 条件查询
     */
    @Test
    public void testConditionWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }

        //and
        QueryWrapper<User> and = new QueryWrapper<>();
        and.eq("name", "严固之").eq("age", 24);
        List<User> users1 = userMapper.selectList(and);
        for (User user : users1) {
            System.out.println(user);
        }

        //or
        QueryWrapper<User> or = new QueryWrapper<>();
        or.eq("name", "严固之").eq("age", 24);
        List<User> usersOR = userMapper.selectList(or);
        for (User user : usersOR) {
            System.out.println(user);
        }

        //select()
        QueryWrapper<User> select = new QueryWrapper<>();
        select.eq("name", "严固之").eq("age", 24).select("name", "age");
        for (User user : userMapper.selectList(select)) {
            System.out.println(user);
        }


    }

    /**
     * 自定义findAll方法
     */
    @Test
    public void testFindAll() {

        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 随机生成中文名
     *
     * @return
     */
    public static String getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        String name = Surname[index]; //获得一个随机的姓氏
        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
        if (i == 2) {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "女-" + name + girl.substring(j, j + 2);
            } else {
                name = "女-" + name + girl.substring(j, j + 1);
            }

        } else {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "男-" + name + boy.substring(j, j + 2);
            } else {
                name = "男-" + name + boy.substring(j, j + 1);
            }

        }

        return name;
    }
}
