import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

// �� �� ������ Ŭ����
class CoinsAdmin extends Admin {
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String con;
    //Changes cha = new Changes();

    // �޴� ����
    void select() throws IOException {
        do {
            // ���÷���
            System.out.println("\n<< �ܵ� ���� ��Ȳ >>");
            System.out.println("1. �ܵ� Ȯ��");
            System.out.println("2. �ܵ� ��� �߰�");
            System.out.println("3. �ܵ� ��� ����");
            System.out.println("4. ������ �޴��� �̵�");

            do {
                System.out.print(">> ");
                con = br.readLine();

                if (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4)
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
            while (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4);

            System.out.println();

            switch (con) {
                case "1":
                    show();
                    break;    // �ܵ� Ȯ��
                case "2":
                    add();
                    break;    // �ܵ� �߰�
                case "3":
                    delete();
                    break;    // �ܵ� ����
            }
        }
        while (!con.equals("4"));
    }

    // �� ��� ���� �� ���ͳ� ����
    @Override
    public void show() {
        //Set<Map.Entry<String, Integer>> set = changesNum.entrySet();
        int[] MoneyName = {5000, 1000, 500, 100};
        int[] MoneyNumber = {ch.getChanges(5000),ch.getChanges(1000),ch.getChanges(500),ch.getChanges(100)};
        System.out.println("\n<<��ü �ܵ� ��Ȳ ��ȸ>>");
        for (int i=0;i<MoneyName.length;i++)
        {
            System.out.printf("%d�� %d��",MoneyName[i],MoneyNumber[i]);
        }

    }

    // ��� ����
    @Override
    public void add() {
        System.out.println("\n[�ܵ� ����]");
        try
        {
            System.out.println("�ܵ� ������ ������ �Է��ϼ���. ex) 5000 10 ");
            System.out.print(">> ");
            int name = sc.nextInt();
            int i = sc.nextInt();
            ch.addChanges(name,i);
        }
        catch (InputMismatchException e) {
            System.out.println("�Է� ������ Ʋ���ϴ�.");
            sc.nextLine();
        }
    }

    @Override
    public void delete() {
        System.out.println("\n[�ܵ� ����(����)]");
        try {
            System.out.println("������ �ܵ� ������ ������ �Է��ϼ���. ex) 1000 10");
            System.out.print(">> ");
            int name = sc.nextInt();
            int i = sc.nextInt();
            int result = ch.subChanges(name, i);
            if(result == 0)
            {
                delete();
            }

        } catch (InputMismatchException i) {
            System.out.println("�Է� ������ Ʋ���ϴ�.");
            sc.nextLine();
        }
    }

    @Override
    public void onOff() {
        // ���� ����
    }
}