package com.zzxx.Test;
import java.util.Scanner;

public class HotelManagementSystem {
    public String hotelName;
    public int maxSize = 24;   //酒店拥有的房间数
    public int freeRoom = 24;    //酒店空闲的房间数量
    public Room[] rooms = new Room[maxSize];  //创建Room对象数组

    public HotelManagementSystem(String name) {
        this.hotelName = name;
        for (int i = 0; i < maxSize; i++) {                    //初始化
            rooms[i] = new Room();
            rooms[i].roomNum = String.valueOf(100 + i);
            rooms[i].tenantName = null;
        }
    }
    //检查房间号是否存在，若存在则返回对应的房间号，不存在则返回 -1 ，表示不存在这个房间
    private int checkRoomNum(String num) {
        int index = (int)(Integer.valueOf(num) - 100);
        if (rooms[index].tenantName == null) {
            return index;

        } else {
            return -1;
        }
    }
    //简易的清屏
    private void clr() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //页面跳转函数
    public void chooseInterface() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.println("输入[exit]退出系统，输入[return]返回主界面");
        while (flag) {
            switch(scan.nextLine()) {
                case "exit":
                    flag = false;
                    exitSystem();
                    break;
                case "return":
                    flag = false;
                    mainInterface();
                    break;
                default:
                    System.out.println("错误的指令！请重新输入：");
                    break;
            }
        }
    }

    //主界面函数
    public void mainInterface() {
        clr();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.println("******欢迎进入" + hotelName + "管理系统******");
        System.out.println();
        System.out.println("    [show]:查看住房情况");
        System.out.println("    [in]:进入入住登记系统");
        System.out.println("    [out]：进入退房办理系统");
        System.out.println("    [exit]:退出酒店管理系统");
        System.out.println();
        while (flag) {
            switch (scan.nextLine()) {
                case "show":
                    flag = false;
                    show();
                    break;
                case "in":
                    flag = false;
                    in();
                    break;
                case "exit":
                    flag = false;
                    exitSystem();
                    break;
                case "out":
                    flag = false;
                    out();
                    break;
                default:
                    System.out.println("错误的指令！请重新输入指令:");

            }
        }
    }

    //住房登记界面
    public void in() {
        String roomNum = null;
        String name = null;
        Scanner scan = new Scanner(System.in);
        int index = 0;

        clr();
        System.out.println("******欢迎来到入住登记界面！******");
        System.out.println();
        if (freeRoom == 0) {
            System.out.println("不好意思！本店已经住满！");
            chooseInterface();
        }

        System.out.println("请输入房间号和姓名(中间以空格隔开)");
        roomNum = scan.next();
        name = scan.next();
        if ((index = checkRoomNum(roomNum)) != -1) {
            rooms[index].tenantName = name;
            System.out.println("入住成功！你的房间号是" + roomNum);
            System.out.println();
            --freeRoom;
            chooseInterface();
        } else {
            System.out.println("不好意思！该房间已经有人入住！");
            System.out.println();
            chooseInterface();
        }


    }

    //查看入住情况
    public void show() {
        Scanner scan = new Scanner(System.in);
        int index = 0;

        clr();
        System.out.println("******以下是酒店的详细住宿情况：******");
        for (int i = 0; i < (maxSize / 6); i++) {
            for (int j = 0; j < 6 && index + j < maxSize; j++) {
                System.out.printf("%6s", rooms[index + j].roomNum);

            }
            System.out.println();
            for (int j = 0; j < 6 && index + j < maxSize; j++) {
                System.out.printf("%6s", rooms[index + j].tenantName);
            }
            System.out.println();
            index += 6;
            if (index  >= maxSize) {
                break;
            }
        }
        System.out.println();
        chooseInterface();

    }

    //退房办理系统
    public void out() {
        clr();
        String name = null;
        String roomNum = null;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("******欢迎来到退房办理系统！******");
        System.out.println();
        System.out.println("请输入你的房间号和入住人姓名（中间以空格隔开）");

        while (flag) {
            roomNum = scan.next();
            name = scan.next();
            if (checkRoomNum(roomNum) == -1) {
                System.out.println("退房成功！欢迎下次入住！");
                System.out.println();
                rooms[Integer.valueOf(roomNum) - 100].tenantName = null;
                ++freeRoom;
                flag = false;
            } else {
                System.out.println("房间号错误！请重新输入");
                System.out.println();
            }
        }

        chooseInterface();
    }

    //退出系统函数
    public void exitSystem() {
        System.out.println("感谢您使用" + hotelName + "管理系统！");
        System.exit(0);
    }

}
