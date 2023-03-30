package com.shucai.generics_exer;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO();
        dao.save("1001", new User(1,20, "zhangsan"));
        dao.save("1002", new User(2,21, "lisi"));
        User user1 = dao.get("1001");
        User user2 = dao.get("1002");

        System.out.println(user1);
        System.out.println(user2);

        System.out.println(2);

        dao.update("1001", new User(13,19,"qq"));
        dao.update("1003", new User(11,19,"qq"));
        for (User user : dao.list()) {
            System.out.println(user);
        }

        System.out.println(dao.list());
        System.out.println(3);

        dao.delete("1001");
        System.out.println(dao.list());

    }
}
