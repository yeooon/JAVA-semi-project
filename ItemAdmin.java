import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

// �� ��ǰ ������ Ŭ����
class ItemAdmin extends Admin
{
    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String con;
    //Inventory item = new Inventory();

    // �޴� ����
    void select() throws IOException
    {
        do {
            System.out.println("\n<< ��ǰ ���� ��Ȳ >>");
            System.out.println("1. ��ǰ ��� Ȯ��");
            System.out.println("2. ��ǰ ��� �߰�");
            System.out.println("3. ��ǰ ��� ����");
            System.out.println("4. ������ �޴��� �̵�");

            do {
                System.out.print(">> ");
                con = br.readLine();

                if (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4)
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
            while (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4);

            switch (con) {
                case "1":
                    show();
                    break;    // ��� Ȯ��
                case "2":
                    add();
                    break;    // ��� �߰�
                case "3":
                    delete();
                    break;    // ��� ����
            }
        }
        while (!con.equals("4"));
    }

    // ��� ���� �� ���ͳ� ����
    @Override
    public void show() {
        String items = iv.getInvens();

        System.out.println("\n\n<<��ü ��ǰ ��Ȳ ��ȸ>>\n");
        System.out.println(items);
    }

    // ��� ����
    @Override
    public void add() {

        System.out.println("\n< ��ǰ �߰� >");
        try {
            System.out.println("��ǰ �̸��� ������ �Է��ϼ��� ex) ��ȸ�� ���� ����ũ,2");
            String nameNum = sc.nextLine();
            String[] str = nameNum.split(",");
            iv.addInvNum(str[0],Integer.parseInt(str[1]));
            System.out.println("�߰� �Ϸ�Ǿ����ϴ�.");

        } catch (InputMismatchException e) {
            System.out.println("�Է� ������ Ʋ���ϴ�.");
            sc.nextLine();
        }
    }

    // ��� ����
    @Override
    public void delete() {
        System.out.println("\n[��ǰ�� ��� ����(����)]");
        try {
            System.out.println("������ ��ǰ �̸��� ������ �Է��ϼ���. ex) ��ȸ�� ���� ����ũ,3");
            String nameNum = sc.nextLine();
            String[] str = nameNum.split(",");
            iv.sellItems(str[0],Integer.parseInt(str[1]));
            System.out.println("���� �Ϸ�Ǿ����ϴ�.");
        } catch (InputMismatchException e) {
            System.out.println("�Է� ������ Ʋ���ϴ�.");
            sc.nextLine();
        }
    }

    @Override
    public void onOff() {
        // ���� ����
    }
}
