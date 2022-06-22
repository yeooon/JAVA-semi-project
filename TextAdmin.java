import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

class PhraseMenus
{
    public static final int E_ADD = 1;          //-- ��� �߰�
    public static final int E_DISP = 2;         //-- ��� ���
    public static final int E_FIND = 3;         //-- ��� �˻�
    public static final int E_DEL = 4;          //-- ��� ����
    public static final int E_CHA = 5;          //-- ��� ����
    public static final int E_EXIT = 6;         //-- ����
}

public class TextAdmin
{
    private final HashMap<Integer, String> hm = new HashMap<Integer, String>()
    {{
        put(1, "����ũ�� �� �������ּ���!");
        put(2, "�ڷγ� 19 �Բ� �̰ܳ���~");
        put(3, "�濪��ħ�� �����ּ���!");
        put(4, "�ǰ��ϰ� �غ��ؿ�!");
        put(5, "�츮�� �� �� �ֽ��ϴ�!");
        put(6, "�Ÿ��� �־����� ������ ������");
        put(7, "�ڷγ� 19�� �̱�� ���ο� �ϻ�, �Բ� ������!");
    }};
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int sel = 1;                 //-- ���ð�
    private String con = "Y";                  //-- ��� ����

    public void menuDisp()
    {
        System.out.println("\n\t[�޴� ����]");
        System.out.println("1. ��� �߰�");
        System.out.println("2. ��� ���");
        System.out.println("3. ��� �˻�");
        System.out.println("4. ��� ����");
        System.out.println("5. ��� ����");
        System.out.println("6. ����");

    }

    // �޴� ���� �޼ҵ�
    public void menuSelect() throws IOException, NumberFormatException
    {
        System.out.print(">> �޴� ����(1~6) : ");
        sel = Integer.parseInt(br.readLine());
    }

    // ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
    public void menuRun() throws IOException
    {
        switch (sel)
        {
            case PhraseMenus.E_ADD: addElement(); break;
            case PhraseMenus.E_DISP: dispElement(); break;
            case PhraseMenus.E_FIND: findElement(); break;
            case PhraseMenus.E_DEL: delElement(); break;
            case PhraseMenus.E_CHA: chaElement(); break;
            case PhraseMenus.E_EXIT: exit(); break;
        }
    }

    // �ڷᱸ���� ��� �߰�(�Է�) �޼ҵ�
    public void addElement() throws IOException
    {
        do
        {
            System.out.print("�Է��� ���� ��ȣ �Է� : ");
            int num = Integer.parseInt(br.readLine());

            System.out.printf("%d��° ���� �Է� : ", num);
            hm.put(num, br.readLine());

            System.out.print("��� �Է� ���(Y/N)? : ");
            con = br.readLine();
        }
        while (con.equals("Y") || con.equals("y"));
    }

    // �ڷᱸ�� ��ü ��� ��� �޼ҵ�
    public void dispElement()
    {
        System.out.println("\n\t[��ü ���]");
        for (HashMap.Entry<Integer, String> entrySet : hm.entrySet())
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        System.out.println("��ü ��� �Ϸ�Ǿ����ϴ�.");
    }

    // �ڷᱸ�� �� ��� �˻� �޼ҵ�
    public void findElement() throws IOException
    {
        System.out.print("\n�˻��� ��� ��ȣ �Է� : ");
        int sSearch = Integer.parseInt(br.readLine());

        if(hm.get(sSearch) != null)
        {
            System.out.println("\n\t[�˻� ��� ���]");
            System.out.println(hm.get(sSearch));
        }
        else
        {
            System.out.println("\n\t[�˻� ��� ���]");
            System.out.println("�׸��� �������� �ʽ��ϴ�.");
        }
    }

    // �ڷᱸ�� �� ��� ���� �޼ҵ�
    public void delElement() throws IOException
    {
        System.out.print("\n>> ������ ���� ��ȣ �Է� : ");
        int del = Integer.parseInt(br.readLine());
        System.out.println("\n[���� ���� ���]");

        if(hm.containsKey(del))
        {
            hm.remove(del);
            System.out.println(del + " �� ������ �����Ǿ����ϴ�. ");
        }
        else
            System.out.println("�ش� ���� ��ȣ�� �������� �ʾ� ������ �� �����ϴ�.");
    }

    // �ڷᱸ�� �� ��� ���� �޼ҵ�

    public void chaElement() throws IOException
    {

        System.out.print(">> ������ ���� ��ȣ �Է� : ");
        int cha = Integer.parseInt(br.readLine());
        if (hm.containsKey(cha))
        {
            System.out.print(">> ������ ���� �Է� : ");
            String newM = br.readLine();
            hm.put(cha, newM);
            System.out.println("\n[���� ���� ���]");
            System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
        }
        else
        {
            System.out.println("\n[���� ���� ���]");
            System.out.println("������ ������ �������� �ʽ��ϴ�.");
        }
    }

    // ���� �޼ҵ�
    public void exit()
    {
        System.out.println("\n -= ���� ���� â�� �����ϰ� ������ �޴��� ���ư��ϴ� =- ");
        AdminUI au = new AdminUI();
        au.onSystem();
    }

    public HashMap<Integer, String> getHm()
    {

        return hm;
    }
}