import java.io.IOException;
import java.util.Scanner;


class VendingUI extends User
{
    private static int sel;
    private static BuyMask bm = new BuyMask();
    private static BuyHand bh = new BuyHand();
    //private static Cart ca = new Cart();
    private static User us = new User();
    private static KitTest kt = new KitTest();
    private static AdminUI ai = new AdminUI();

    //�޴� ��� �޼ҵ�
    public static void printMenu()
    {
        System.out.println("\n[�޴� ����]");
        System.out.println("[1] ����ũ ���� ");
        System.out.println("[2] �ռҵ��� ���� ");
        System.out.println("[3] �ڰ�����ŰƮ ���� ");
        System.out.println("[4] ��ٱ��� Ȯ�� ");
        System.out.println("[5] �����ϱ� ");
        System.out.println("[6] ������ ��� ");
        System.out.print(">> �޴����� (1~6) : ");
    }

    //�޴� ���� �޼ҵ�
    public static void menuSelect()
    {
        //Scanner �ν��Ͻ� ����
        Scanner sc = new Scanner(System.in);

        do
        {
            sel = sc.nextInt();
        }
        while (sel < 1 || sel > 6);
    }

    // �޴��� �̵��ϴ� �޼ҵ�
    public static void menuRun() throws IOException
    {
        switch (sel)
        {
            case 1: bm.buyMaskRun(); break;
            case 2: bh.buyHandRun(); break;
            case 3: kt.KitRun(); break;
            case 4: ca.seeCart(); goMenu(); break;
            case 5: us.buy(); break;
            case 6: ai.onSystem(); break;
        }
    }
}