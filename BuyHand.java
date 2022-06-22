import java.io.IOException;
import java.util.Scanner;

class BuyHand extends User
{
    Scanner sc = new Scanner(System.in);

    public void buyHandRun() throws IOException
    {
        buyHand();
        goMenu();
    }

    public int printHand()
    {
        int hand;
        do
        {
            System.out.println("\n[1] ������ �ռҵ���   : 1000��");
            System.out.println("[2] ����� �ռҵ���   : 2000��");
            System.out.println("[3] �ڵ����� �ռҵ��� : 3000��");
            System.out.print(">> �޴����� (1~3) : ");
            hand = sc.nextInt();
        }
        while (hand < 1 || hand > 3);
        return hand;
    }

    // ��ٱ��� �߰� or �����ϱ� �޼ҵ�()
    public int printCartBuy()
    {
        int num;
        do
        {
            System.out.println("\n[1] ��ٱ��Ͽ� �߰�");
            System.out.println("[2] �����ϱ�");
            System.out.print(">> �޴����� (1~2) : ");
            num = sc.nextInt();
        }
        while (num < 1 || num > 2);
        return num;
    }

    public void buyHand() throws IOException
    {
        int hand = printHand();
        if(hand == 1) // ������ �ռҵ���
        {
            int num = printCartBuy();
            if(num == 1) // ��ٱ��Ͽ� �߰�
            {
                addCart("������ �ռҵ���", 1000);
            }
            else if(num == 2) // �����ϱ�
            {
                addCart("������ �ռҵ���", 1000);
                buy();
            }
        }
        else if(hand == 2)
        {
            int num = printCartBuy();
            if(num == 1) // ��ٱ��Ͽ� �߰�
            {
                addCart("����� �ռҵ���", 2000);
            }
            else if(num == 2) // �����ϱ�
            {
                addCart("����� �ռҵ���", 2000);
                buy();
            }
        }
        else if(hand == 3)
        {
            int num = printCartBuy();
            if(num == 1) // ��ٱ��Ͽ� �߰�
            {
                addCart("�ڵ����� �ռҵ���", 3000);
            }
            else if(num == 2) // �����ϱ�
            {
                addCart("�ڵ����� �ռҵ���", 3000);
                buy();
            }
        }
    }
}