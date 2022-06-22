import java.io.IOException;
import java.util.Scanner;

class BuyMask extends User
{
    Scanner sc = new Scanner(System.in);

    // BuyMaskRun �޼ҵ�
    public void buyMaskRun() throws IOException
    {
        buyMask();
        goMenu();
    }

    // ����ũ ���� ���� �ȳ� �޼ҵ�
    public int printMask()
    {
        int num = 0;
        do
        {
            System.out.println("\n[1] ��ȸ�� ����ũ");
            System.out.println("[2] KF80 ����ũ");
            System.out.println("[3] KF94 ����ũ");
            System.out.print(">> �޴�����(1~3) : ");
            num = sc.nextInt();
        }
        while (num < 1 || num > 3);
        return num;
    }

    // ����ũ ũ�� ���� �ȳ� �޼ҵ�
    public int printMaskSize()
    {
        int num = 0;
        do
        {
            System.out.println("\n[����ũ ũ�� ����]");
            System.out.println("[1] ����: 1000��");
            System.out.println("[2] ����: 2000��");
            System.out.println("[3] ����: 3000��");
            System.out.print(">> �޴�����(1~3) : ");
            num = sc.nextInt();
        }
        while (num < 1 || num > 3);
        return num;
    }

    // ��ٱ��� �߰� or �����ϱ� �ȳ� �޼ҵ�()
    public int printCartBuy()
    {
        int num = 0;
        do
        {
            System.out.println("\n[1] ��ٱ��Ͽ� �߰�");
            System.out.println("[2] �����ϱ�");
            System.out.print(">> �޴�����(1~2) : ");
            num = sc.nextInt();
        }
        while (num < 1 || num > 2);
        return num;
    }

    // ����ũ ���� ��� �޼ҵ�
    public void buyMask() throws IOException
    {
        Cart ca = new Cart();

        int num1 = printMask(); // � ������ ����ũ�� ������ ������
        if(num1 == 1) // ��ȸ�� ����ũ ����
        {
            int num2 = printMaskSize();

            if (num2 == 1) // ���� ��ȸ�� ����ũ ����
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("��ȸ�� ���� ����ũ", 1000);
                }
                else if (num3 == 2)
                {
                    addCart("��ȸ�� ���� ����ũ", 1000);
                    buy();
                }
            } //num2 ���� ��ȸ�븶��ũ
            else if (num2 == 2) // ���� ��ȸ�� ����ũ ����
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("��ȸ�� ���� ����ũ", 2000);
                }
                else if (num3 == 2)
                {
                    addCart("��ȸ�� ���� ����ũ", 2000);
                    buy();
                }
            }//num2 ���� ��ȸ�븶��ũ
            else if(num2 == 3) // ���� ��ȸ�� ����ũ ����
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("��ȸ�� ���� ����ũ", 3000);
                }
                else if (num3 == 2)
                {
                    addCart("��ȸ�� ���� ����ũ", 3000);
                    buy();
                }
            }//num2 ���� ��ȸ�븶��ũ
        }//num1 ��ȸ�� ����ũ ��

        else if(num1==2) //KF80 ����ũ ���� ��
        {
            int num2 = printMaskSize(); // ����ũ ũ�� ����
            if (num2 == 1) // KF80 ���� ����ũ ����
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF80 ���� ����ũ", 1000);
                }
                else if (num3 == 2)
                {
                    addCart("KF80 ���� ����ũ", 1000);
                    buy();
                }
            }//num2 kf80 ����
            else if (num2 == 2)
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF80 ���� ����ũ", 2000);
                }
                else if (num3 == 2)
                {
                    addCart("KF80 ���� ����ũ", 2000);
                    buy();
                }
            }//num2 kf80 ����
            else if(num2 == 3)
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF80 ���� ����ũ", 3000);
                }
                else if (num3 == 2)
                {
                    addCart("KF80 ���� ����ũ", 3000);
                    buy();
                }
            }//num2 kf80 ����
        }//num1 kf80 ��
        else if(num1 == 3)
        {
            int num2 = printMaskSize(); // ����ũ ũ�� ����
            if (num2 == 1) // KF94 ���� ����ũ ����
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF94 ���� ����ũ", 1000);
                }
                else if (num3 == 2)
                {
                    addCart("KF94 ���� ����ũ", 1000);
                    buy();
                }
            }//num2 KF94 ����
            else if (num2 == 2)
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF94 ���� ����ũ", 2000);
                }
                else if (num3 == 2)
                {
                    addCart("KF94 ���� ����ũ", 2000);
                    buy();
                }
            }//num2 KF94 ����
            else if(num2 == 3)
            {
                int num3 = printCartBuy(); // ��ٱ��� or �����ϱ� ���� ���
                if(num3 == 1)
                {
                    addCart("KF94 ���� ����ũ", 3000);
                }
                else if (num3 == 2)
                {
                    addCart("KF94 ���� ����ũ", 3000);
                    buy();
                }
            }//num2 KF94 ����
        }//num1 kf94 ��
    }
}