import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Calendar;

import java.util.Scanner;


public class CheckKit extends User
{
    private int age;
    private int birthYear;                  // �¾ ��
    private int birthMonth;                 // �¾ ��
    private int birthDay;                   // �¾ ��
    Calendar now = Calendar.getInstance();

    int y = now.get(Calendar.YEAR);
    int m = now.get(Calendar.MONTH);
    int d = now.get(Calendar.DATE);

    boolean age60 = false;

    void dateOfBirth() throws IOException       // ������� �Է�
    {
        Calendar now = Calendar.getInstance();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean loop = true;
        String str;
        do
        {
            System.out.print("\n��������� �Է��ϼ���(8�ڸ�) : ");
            str = br.readLine();

            if(str.length() == 8)
            {
                birthYear = Integer.parseInt(str.substring(0, 4));
                birthMonth = Integer.parseInt(str.substring(4, 6));
                birthDay = Integer.parseInt(str.substring(6, 8));

                if(birthYear > 1800 && birthYear < now.get(Calendar.YEAR) + 1)
                {
                    if(birthMonth > 0 && birthMonth < 13)
                    {
                        int lastDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
                        if (birthDay > 0 && birthDay < lastDay)
                        {
                            loop = false;
                        }
                    }
                }
            }
        } while (loop);
    }

    void ageCalc()                          // ������ ���
    {
        age = y - birthYear;
        if(age == 60)               // Ȯ���غ���
        {
            if(birthMonth > m+1)
                age = age - 1;
            else if(birthMonth == m+1 && birthDay > d)
                age = age -1;
        }

        if (age >= 60)
        {
            age60 = true;
        }
    }

    void checkSymptoms() throws IOException, NumberFormatException
    {       // �ߺ� üũ ����
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        ageCalc();

        do
        {

            System.out.println("\n�ֱ� 3�� �̳� �߻��� ������ �Է����ּ���.(�ߺ� �Է½� �������� ����) : ");
            System.out.println("[1] ������");
            System.out.println("[2] ��ħ");
            System.out.println("[3] �Ƿΰ�");
            System.out.println("[4] �߿�");
            System.out.println("[5] ȣ�� ��� �Ǵ� �� ����");
            System.out.println("[6] ���� ����");
            System.out.println("[7] �̰� �Ǵ� �İ� ���");
            System.out.print(">> ����(1~7) : ");

            String st1 = sc.nextLine();
            String[] ans = st1.split("\\s");

            for (String st : ans)
            {
                int a = Integer.parseInt(st);

                if(a == 1 && ans.length == 1)
                {
                    textMessageCheck();
                }
                else if(a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7)
                {
                    if (age60 == true)
                    {
                        informationPcr();
                    }
                    else if(age60 == false)
                    {
                        textMessageCheck();
                    }
                }
            }

        }while (check = true);
    }

    void textMessageCheck() throws IOException       //3��
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans;

        do
        {
            System.out.println("\n�ֱ� 7�� �̳� �������˵��� ������ PCR �˻� ��û�� ���������� �����ʴϱ�?");
            System.out.println("[1] �ִ�.");
            System.out.println("[2] ����.");
            System.out.print(">> ����(1~2) : ");
            ans = Integer.parseInt(br.readLine());

        }while (ans < 1 || ans > 2);

        switch (ans)
        {
            case 1:
                informationPcr();
                break;
            case 2:
                System.out.println("\n[2] ���� �� �����ϼ̽��ϴ�. ���� �������� �Ѿ�ϴ�. ");
                checkDocNote();
        }
    }

    void checkDocNote() throws IOException       // 4��
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans;

        do
        {
            System.out.println("\n������ �������ü� �������̰ų� �ֱ� 3���̳� �ڷγ�19 �˻簡 �ʿ��ϴٴ� �ǻ� �Ұ߼��� ���������� �����ʴϱ�?");
            System.out.println("[1] �������ü� ������");
            System.out.println("[2] �ڷγ�19 �˻� �ʿ��ϴٴ� �ǻ� �Ұ߼� ������");
            System.out.println("[3] ����.");
            System.out.print(">> ����(1~3) : ");
            ans = Integer.parseInt(br.readLine());
        } while (ans < 1 || ans > 3);

        switch (ans)
        {
            case 1:
            case 2:
                informationPcr();
                break;
            case 3:
                System.out.println("\n[3] ���� �� �����ϼ̽��ϴ�. ���� �������� �Ѿ�ϴ�. ");
                positiveCheck();
                break;
        }
    }

    int positiveCheck() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res;

        do
        {
            System.out.println("\n�ֱ� 7�� �̳� �����ǿ�(ȣ���Ŭ���� ��) �� ��������ҿ��� ������ �ż��׿��˻� ��� �缺 ����� ���� ���� �ֽ��ϱ�?");
            System.out.println("[1] �ִ�.");
            System.out.println("[2] ����.");
            System.out.print(">> ����(1~2) : ");
            res = Integer.parseInt(br.readLine());
        }
        while (res < 1 || res > 2);

        switch (res)
        {
            case 1:
                System.out.println("�ڰ�����ŰƮ�� �����Ͻ� �� �����ϴ�.  PCR �˻� ����� �ȳ� â���� �����մϴ�.");
                informationPcr();
                break;
            case 2:
                System.out.println("\n[2] ���� �� �����ϼ̽��ϴ�. ���� �������� �Ѿ�ϴ�. ");
                notPcr();
        }
        return res;
    }

    void notPcr() throws IOException
    {
        System.out.println("\nPCR �˻� �켱���� ����ڰ� �ƴմϴ�.");
        buyKit();
    }

    void informationPcr() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char res;

        System.out.println("\n����� �ڷγ�19 �˻�ҿ��� PCR �˻縦 ������ �� �ֽ��ϴ�.");
        System.out.print("�׷��� �ڰ�����ŰƮ�� �����Ͻðڽ��ϱ�?(Y/N) : ");

        res = (char)br.read();

        if(res == 'Y' || res == 'y')
        {
            buyKit();
        } else
        {
            goMenu();
        }
    }

    public int printCartBuy()
    {
        Scanner sc = new Scanner(System.in);

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

    public void buyKit() throws IOException
    {
        System.out.println("�ڰ����� ŰƮ : 10000��");

        int num = printCartBuy();
        if(num == 1)
        {
            addCart("�ڰ����� ŰƮ", 10000);
        }
        else if (num == 2)
        {
            addCart("�ڰ����� ŰƮ", 10000);
            buy();
        }
    }
}