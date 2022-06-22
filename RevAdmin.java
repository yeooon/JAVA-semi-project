import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

// �� ��ǰ ������ Ŭ����
class RevAdmin extends Admin
{
    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String con;
    //Inventory item = new Inventory();

    // �޴� ����
    void select() throws IOException
    {
        do {
            System.out.println("\n<< ���� ���� ��Ȳ >>");
            System.out.println("1. ���� Ȯ��");
            System.out.println("2. ���� ȸ��");
            System.out.println("3. ������ �޴��� �̵�");

            do {
                System.out.print(">> ");
                con = br.readLine();

                if (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 3)
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
            while (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 3);

            switch (con) {
                case "1":
                    show();
                    break;    // ���� Ȯ��
                case "2":
                    delete();
                    break;    // ���� ȸ��
            }
        }
        while (!con.equals("3"));
    }

    // ��� ���� �� ���ͳ� ����
    @Override
    public void show() {
        int rev = re.getMoney();

        System.out.println("\n\n<<��ü ���� ��Ȳ ��ȸ>>\n");
        System.out.println("���� ������ " + rev + "�� �Դϴ�.");
    }

    // ��� ����
    @Override
    public void add() {
    }

    // ��� ����
    @Override
    public void delete() {
        System.out.println("\n[���� ȸ��]");
        try {
            System.out.println("ȸ���� �ݾ��� �Է��ϼ���. ex) 10000");
            System.out.print(">> ");
            int subMoney = sc.nextInt();
            int result = re.removeMoney(subMoney);
            if(result != 1)
            {
                System.out.println("\n���ͺ��� ȸ���� �ݾ��� Ů�ϴ�.");
                delete();
            }
            else
            {
                System.out.println("\nȸ�� �Ϸ�Ǿ����ϴ�.");
            }
        } catch (Exception e) {
            System.out.println("�Է� ������ Ʋ���ϴ�.");
            sc.nextLine();
        }
    }

    @Override
    public void onOff() {
        // ���� ����
    }
}
