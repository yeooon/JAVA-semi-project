

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �� �α���, UI, off ����
class AdminUI
{
    private static ItemAdmin IA = new ItemAdmin();
    //BillAdmin BE = new ItemAdmin();
    private static CoinsAdmin CA = new CoinsAdmin();
    private static TextAdminRun TA = new TextAdminRun();
    private static RevAdmin RA = new RevAdmin();
    //VendingUI vu = new VendingUI();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final String ADMIN_ID = "admin";
    private final String ADMIN_PW = "1234";

    private static int temp; //-- ����ڷκ��� �Է¹��� ��
    private static String sTemp;

    // ������ �޴� ����
    void onSystem()
    {
        while(true) {
            try {
                if (!!login()) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while(true)
        {
            menuDisp();
            try {
                menuSelect();
                menuRun();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // �θ޴� ��� �޼ҵ�
    public void menuDisp()
    {
        System.out.println("\n[������ �޴� ����]");
        System.out.println("1. ���Ǳ� off");
        System.out.println("2. ��ǰ�� ��� Ȯ�� �� ����");
        System.out.println("3. ���� Ȯ�� �� ȸ�� ����");
        System.out.println("4. �ܵ� Ȯ�� �� ���� ");
        System.out.println("5. �������� ����");
        System.out.println("6. �ʱ� ȭ������ ���ư���");
        System.out.print(">> �޴� ����(1~6) : ");
    }

    // �ϸ޴� ���� �޼ҵ�
    public void menuSelect() throws IOException {
        do {
            System.out.print(">> ");
            temp = Integer.parseInt(br.readLine());

            if (!(temp >= 1 && temp <= 6)) {
                System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
        }
        while (!(temp >= 1 && temp <= 6));
        // 1���� ũ�ų� 6���� ���� ���� '�ƴѰ�' ���� ������ �ݺ�
    }

    // �� ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ� �� �ϼ�
    public static void menuRun() throws IOException
    {


        switch (temp)
        {
            case 1 : runElement(); break;      //-- on/off
            case 2 : IA.select(); break;   //-- ��ǰ ��� ���� Ŭ����
            case 3 : RA.select(); break;   //-- ������ ���� ���� Ȯ�� �� ���� Ŭ����(+ ���տ���)
            case 4 : CA.select(); break;   //-- �ܵ� Ȯ�� �� ���� Ŭ����
            case 5 : TA.textAdminRun();  break; //-- ���� Ŭ����(+ ���տ���)
            case 6 : exit(); break;         //-- �ʱ� ȭ������ ���ư��� (+ ���տ���)
        }
    }

    // �ͷα��� �޼ҵ� �� Ȩ�� ����
    //�α��� �Ϸ� �� ������ �������� ���� �� �� ?
    boolean login() throws IOException
    {
        System.out.println();
        System.out.println("<< ������ �α��� >>");

        // ���̵� Ȯ��
        do
        {
            System.out.print("�� ������ ���̵� : ");
            sTemp = br.readLine();

            if (!ADMIN_ID.equals(sTemp))
            {
                System.out.println("���̵� �߸� �Է��ϼ̽��ϴ�.");
            }
        }
        while (!ADMIN_ID.equals(sTemp));

        // ��й�ȣ Ȯ��
        do
        {
            System.out.print("�� ������ ��й�ȣ : ");
            sTemp = br.readLine();

            if (!ADMIN_PW.equals(sTemp))
            {
                System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
            }
        }
        while (!ADMIN_PW.equals(sTemp));

        // �α��� ����
        System.out.println("�����ڷ� �α����Ͽ����ϴ�.");
        return true;
    }
    //���� �޴��� �̵��ϴ� �޼ҵ�
    public static void exit() throws IOException
    {
        System.out.println("\n===Ȩ�޴� ����===");

        VendingUI.printMenu();
        VendingUI.menuSelect();
        VendingUI.menuRun();
    }
    // �� ���Ǳ� on/off
    public static void runElement()
    {
        // ����Ʈ ���� on���� ����, off�� �����ϸ� ���α׷� ����ǵ���.
        System.out.println("\n���Ǳ��� ������ ���ϴ�.");   // ������ �� ��� ���α׷� ����
        System.exit(-1);
    }
}